package az.ingress.msBankApp.repository;

import az.ingress.msBankApp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository <Card,Long>  {
}
