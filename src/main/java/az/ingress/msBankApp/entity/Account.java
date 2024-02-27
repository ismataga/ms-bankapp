package az.ingress.msBankApp.entity;

import jakarta.persistence.*;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "accounts")
@NamedEntityGraph(name = "account-user", attributeNodes = {
        @NamedAttributeNode("user"),
        @NamedAttributeNode("cards"),
        @NamedAttributeNode(value = "cards", subgraph = "cards-subgraph")
},
        subgraphs = @NamedSubgraph(name = "cards-subgraph", attributeNodes = {
                @NamedAttributeNode(value = "benefits")
        }))

@NamedQuery(name = "test", query = "select a from Account a join fetch a.user u join fetch a.cards c join fetch c.benefits b ")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private double balance;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Card> cards;

}
