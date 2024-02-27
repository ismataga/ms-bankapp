package az.ingress.msBankApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@EqualsAndHashCode
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String city;
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private User user;
}
