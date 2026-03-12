package dev.rynwllngtn.daos.account;

import dev.rynwllngtn.entities.account.Account;
import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.exceptions.database.DatabaseException;
import dev.rynwllngtn.utils.AccountUtil;
import dev.rynwllngtn.utils.DatabaseUtil;
import dev.rynwllngtn.utils.UserUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AccountDaoImplementation implements AccountDao {

    private Connection connection;

    public AccountDaoImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Account account) {

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("""
                        INSERT INTO account
                        (Id, Holder, Balance, TransferLimit, TransferLimitCap, AccountType)
                        VALUES
                        (?, ?, ?, ?, ?, ?)
                        """);

            statement.setString(1, account.getId().toString());
            statement.setString(2, account.getHolder().getId().toString());
            statement.setBigDecimal(3, account.getBalance());
            statement.setBigDecimal(4, account.getTransferLimit());
            statement.setBigDecimal(5, account.getTransferLimitCap());
            statement.setString(6, account.getAccountType().name());

            if (statement.executeUpdate() < 1) {
                throw new DatabaseException("ERRO: No row affected!");
            }
        }
        catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        finally {
            DatabaseUtil.closeStatement(statement);
        }
    }

    @Override
    public void update(Account account) {

        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("""
                        UPDATE account SET
                        Balance = ?, TransferLimit = ?, TransferLimitCap = ?
                        WHERE Id = ?
                        """);

            statement.setBigDecimal(1, account.getBalance());
            statement.setBigDecimal(2, account.getTransferLimit());
            statement.setBigDecimal(3, account.getTransferLimitCap());
            statement.setString(4, account.getId().toString());

            if (statement.executeUpdate() < 1) {
                throw new DatabaseException("ERRO: No row affected!");
            }
        }
        catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        finally {
            DatabaseUtil.closeStatement(statement);
        }

    }

    @Override
    public void deleteById(UUID id) {

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("""
                        DELETE FROM account
                        WHERE id = ?;
                        """);

            statement.setString(1, id.toString());

            if (statement.executeUpdate() < 1) {
                throw new DatabaseException("ERRO: No row affected!");
            }
        }
        catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        finally {
            DatabaseUtil.closeStatement(statement);
        }

    }

    @Override
    public Account findById(UUID id) {

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("""
                        SELECT acc.*, us.* FROM account AS acc
                        INNER JOIN user AS us
                        ON acc.Holder = us.Id
                        WHERE acc.Id = ?
                        """);

            statement.setString(1, id.toString());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = UserUtil.instantiateUser(resultSet);
                return AccountUtil.instantiateAccount(resultSet, user);
            }

            return null;
        }
        catch (SQLException e) {
            throw new DatabaseException("ERRO: No row affected!");
        }
        finally {
            DatabaseUtil.closeResultSet(resultSet);
            DatabaseUtil.closeStatement(statement);
        }
    }

    @Override
    public List<Account> findAll() {

        PreparedStatement statement = null;
        ResultSet resultSet = null ;

        try {
            statement = connection.prepareStatement("""
                        SELECT acc.*, us.Id AS UserId, us.Cpf, us.Password, us.Name, us.Email, us.BirthDate, us.IsActive
                        FROM account AS acc
                        INNER JOIN user AS us
                        ON acc.Holder = us.Id
                        """);

            resultSet = statement.executeQuery();

            List<Account> accounts = new ArrayList<>();
            Map<UUID, User> map = new HashMap<>();

            while (resultSet.next()) {
                UUID holderId = UUID.fromString(resultSet.getString("Holder"));
                User user = map.get(holderId);

                if (user == null) {
                    user = UserUtil.instantiateUser(resultSet, "UserId");
                    map.put(user.getId(), user);
                }

                Account account = AccountUtil.instantiateAccount(resultSet, user);
                accounts.add(account);
            }

            return accounts;
        }
        catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        finally {
            DatabaseUtil.closeResultSet(resultSet);
            DatabaseUtil.closeStatement(statement);
        }
    }

}