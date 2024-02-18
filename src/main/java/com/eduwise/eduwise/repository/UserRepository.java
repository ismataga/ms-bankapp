package com.eduwise.eduwise.repository;


import com.eduwise.eduwise.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String email);

    Optional<User> findByUuid(UUID uuid);
}
