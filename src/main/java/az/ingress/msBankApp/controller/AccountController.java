package az.ingress.msBankApp.controller;

import az.ingress.msBankApp.model.AccountDto;
import az.ingress.msBankApp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class AccountController {
    @Autowired
    private final AccountService accountService;
    @GetMapping("/id")
    public AccountDto getAccount(@PathVariable Long id) {
     return    accountService.getAccount(id);

    }

    @PutMapping("/id")
    public AccountDto updateAccount(@PathVariable Long id,
                                    @RequestParam Double amount) {
        return    accountService.updateAccount(id, amount);

    }

    @PutMapping("/wait/id")
    public AccountDto updateAccountWithWait(@PathVariable Long id,
                                    @RequestParam Double amount) {
        return    accountService.updateAccountWithWait(id, amount);

    }

}
