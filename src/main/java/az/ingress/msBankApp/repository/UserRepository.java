package az.ingress.msBankApp.repository;

import az.ingress.msBankApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
