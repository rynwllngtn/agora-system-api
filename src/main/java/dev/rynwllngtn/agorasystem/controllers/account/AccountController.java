package dev.rynwllngtn.agorasystem.controllers.account;

import dev.rynwllngtn.agorasystem.dtos.account.AccountCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.account.DepositRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.account.WithdrawalRequestDTO;
import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountResponseDTO> findById(@PathVariable UUID id) {
        AccountResponseDTO accountResponseDTO = accountService.findResponseById(id);
        return ResponseEntity.ok().body(accountResponseDTO);
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> insert(@RequestBody AccountCreateRequestDTO accountCreateRequestDTO) {
        Account account = accountService.insert(accountCreateRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountResponseDTO(account));
    }

    @PostMapping(value = "/{id}/deposit")
    public ResponseEntity<AccountResponseDTO> deposit(@PathVariable UUID id, @RequestBody DepositRequestDTO depositRequestDTO) {
        Account account = accountService.deposit(id,depositRequestDTO);
        return ResponseEntity.ok().body(new AccountResponseDTO(account));
    }

    @PostMapping(value = "/{id}/withdrawal")
    public ResponseEntity<AccountResponseDTO> withdrawal(@PathVariable UUID id, @RequestBody WithdrawalRequestDTO withdrawalRequestDTO) {
        Account account = accountService.withdrawal(id,withdrawalRequestDTO);
        return ResponseEntity.ok().body(new AccountResponseDTO(account));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}