package az.ingress.msBankApp.service.impl;

import az.ingress.msBankApp.entity.User;
import az.ingress.msBankApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     User user = (User) userRepository.findByUsername(username);
////      UserDetails userDetails  = org.springframework.security.core.userdetails.User
////              .builder()
////              .username("a")
////              .password("a")
////
//    }

        return null;
    }
}



