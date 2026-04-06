package dev.rynwllngtn.agorasystem.controllers.account;

import dev.rynwllngtn.agorasystem.dtos.account.AccountCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountUpdateRequestDTO;
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
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(accountResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountResponseDTO> update(@PathVariable UUID id, @RequestBody AccountUpdateRequestDTO accountUpdateRequestDTO) {
        AccountResponseDTO accountResponseDTO = accountService.update(id, accountUpdateRequestDTO);
        return ResponseEntity.ok().body(accountResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}