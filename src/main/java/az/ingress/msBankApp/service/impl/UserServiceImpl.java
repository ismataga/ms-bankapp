package az.ingress.msBankApp.service.impl;

import az.ingress.msBankApp.entity.User;
import az.ingress.msBankApp.model.UserDto;
import az.ingress.msBankApp.repository.UserRepository;
import az.ingress.msBankApp.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
//        user.getAddress();
        return user;

    }
}
