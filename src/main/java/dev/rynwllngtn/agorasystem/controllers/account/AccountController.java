package dev.rynwllngtn.agorasystem.controllers.account;

import dev.rynwllngtn.agorasystem.dtos.AccountRequest;
import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> findById(@PathVariable UUID id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping
    public ResponseEntity<Account> insert(@RequestBody AccountRequest accountRequest) {
        Account account = accountRequest.getAccount();
        account = accountService.insert(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Account> update(@PathVariable UUID id, @RequestBody AccountRequest accountRequest) {
        Account account = accountRequest.getAccount();
        account = accountService.update(id, account);
        return ResponseEntity.ok().body(account);
    }

}