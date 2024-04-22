package az.ingress.msBankApp.service;

import az.ingress.msBankApp.model.AccountDto;

public interface AccountService {
    AccountDto getAccount(Long id);

    AccountDto updateAccount(Long id, Double amount);

    AccountDto updateAccountWithWait(Long id, Double amount);
}
