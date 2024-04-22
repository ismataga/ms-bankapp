package az.ingress.msBankApp.service.impl;

import az.ingress.msBankApp.entity.Account;
import az.ingress.msBankApp.mapper.AccountMapper;
import az.ingress.msBankApp.model.AccountDto;
import az.ingress.msBankApp.repository.AccountRepository;
import az.ingress.msBankApp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        return accountMapper.entityToDto(account);
    }

    @Override
    public AccountDto updateAccount(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        account.setBalance(account.getBalance() - amount);
        AccountDto accountDto = accountMapper.entityToDto(account);
        accountRepository.save(account);
        return accountDto;
    }

    @Override
    @SneakyThrows
    public AccountDto updateAccountWithWait(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        account.setBalance(account.getBalance() - amount);
        Thread.sleep(5000);
        AccountDto accountDto = accountMapper.entityToDto(account);
        accountRepository.save(account);
        return accountDto;
    }
}
