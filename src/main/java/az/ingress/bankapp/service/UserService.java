package az.ingress.bankapp.service;

import az.ingress.bankapp.entity.User;
import az.ingress.bankapp.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {


   User getUser(Long id);


}
