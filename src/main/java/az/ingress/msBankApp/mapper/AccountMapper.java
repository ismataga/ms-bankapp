package az.ingress.msBankApp.mapper;

import az.ingress.msBankApp.entity.Account;
import az.ingress.msBankApp.entity.Card;
import az.ingress.msBankApp.model.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {


    @Mapping(target = "username",source = "user.username")
    @Mapping(target = "password",source = "user.password")
    @Mapping(target = "cardNumber", source="cards", qualifiedByName ="setCardNumber")
    @Mapping(target = "cardType", source="cards", qualifiedByName ="setCardType")
    @Mapping(target = "expirationTime", source="cards", qualifiedByName ="setCardDate")
    AccountDto entityToDto(Account account) ;


    @Named("setCardNumber")
    default String setCardNumber(Set<Card> cards){
        return cards.stream().findFirst().get().getCardNumber();
    }
    @Named("setCardType")
    default String setCardType(Set<Card> cards){
        return cards.stream().findFirst().get().getCardType();
    }
    @Named("setCardDate")
    default String setCardDate(Set<Card> cards){
        return cards.stream().findFirst().get().getExpirationTime();
    }
}
