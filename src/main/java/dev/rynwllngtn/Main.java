package dev.rynwllngtn;

import dev.rynwllngtn.db.Db;

import java.sql.Connection;

public class Main {

    static void main() {

        Connection connection = Db.getConnection();
        Db.closeConnection();
    }

}