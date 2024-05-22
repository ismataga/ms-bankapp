package az.ingress.msBankApp.repository;

import az.ingress.msBankApp.entity.Account;
import az.ingress.msBankApp.model.AccountDto;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
//    Optional<Account> findByAccountNumber(String accountNumber);

//    @Query("")
//    List<Account> findByCustom();
//
//    @Query(value = "select a from Account a" +
//            " join users u on u.id=a.user_id" +
//            " join cards c on a.id=c.account_id " +
//            " join card_benefits b on c.id=b.card_id;", nativeQuery = true)
//    List<Account> findByCustom2();

    //    @Query("select new az.ingress.msBankApp.model.AccountDto(a.id, a.accountNumber, a.balance,u.username, u.password," +
//            "c.cardNumber, c.cardType,  c.expirationTime) from Account a join  a.user u join  a.cards c join  c.benefits b")
//    List<AccountDto> findByAccountNumber();

    @EntityGraph(attributePaths = {"user", "cards", "cards.benefits"})
    List<Account> findByAccountNumber(String accountNumber);

    @Query(name = "test")
    List<Account> findAccountBy();

    @Override
//    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Account> findById(Long id);

}
