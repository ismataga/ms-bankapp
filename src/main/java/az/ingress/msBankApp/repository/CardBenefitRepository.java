package az.ingress.msBankApp.repository;

import az.ingress.msBankApp.entity.CardBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardBenefitRepository extends JpaRepository<CardBenefit, Long> {
}
