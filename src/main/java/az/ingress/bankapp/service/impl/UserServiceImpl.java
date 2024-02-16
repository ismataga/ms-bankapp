package az.ingress.bankapp.service.impl;

import az.ingress.bankapp.entity.User;
import az.ingress.bankapp.model.UserDto;
import az.ingress.bankapp.repository.UserRepository;
import az.ingress.bankapp.service.UserService;
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
