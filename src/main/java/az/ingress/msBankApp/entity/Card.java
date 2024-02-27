package az.ingress.msBankApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Data
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private String cardType;
    private String expirationTime;


    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Account account;

    @OneToMany(mappedBy = "card")
    private Set<CardBenefit> benefits = new HashSet<CardBenefit>();

}
