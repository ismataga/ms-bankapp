package az.ingress.msBankApp.controller;

import az.ingress.msBankApp.model.AccountDto;
import az.ingress.msBankApp.service.AccountService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@OpenAPIDefinition(info = @Info(title = "Bank app ",
        version = "1.0.0",
        description = "Bank app for customer"))


public class AccountController {
    @Autowired
    private final AccountService accountService;

    @PostMapping("/security")
    public String postPublic() {
        return "get public method";

    }

    @GetMapping("/security/1")
    public String getPublic(Principal principal) {
        log.info("User is: {}", principal);
        return "get public method 1";

    }

    @GetMapping("/security/2")
    public String getPublic2() {
        return "get public method 2";

    }


    @GetMapping("/id")
    public AccountDto getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);

    }

    @PutMapping("/id")
    public AccountDto updateAccount(@PathVariable Long id,
                                    @RequestParam Double amount) {
        return accountService.updateAccount(id, amount);

    }

    @PutMapping("/wait/id")
    public AccountDto updateAccountWithWait(@PathVariable Long id,
                                            @RequestParam Double amount) {
        return accountService.updateAccountWithWait(id, amount);

    }

}
