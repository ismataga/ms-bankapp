package az.ingress.msBankApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@ToString
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String age;
    private String gender;
}
