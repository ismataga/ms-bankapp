package com.eduwise.eduwise.service;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.USER_NOT_FOUND;

import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("loadUserByUsername().start " + username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(username, USER_NOT_FOUND));
    }

    public void increaseAttemptCount(String username) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    int attemptAccount = user.getAttemptCount();
                    if (attemptAccount > 2) {
                        user.setAccountNonLocked(false);
                    }
                    user.setAttemptCount(user.getAttemptCount() + 1);
                    userRepository.save(user);
                });
    }

    public void resetAttempts(String username) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    user.setAttemptCount(0);
                    userRepository.save(user);
                });
    }
}
