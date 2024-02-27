package az.ingress.msBankApp.service;

import az.ingress.msBankApp.entity.User;
import az.ingress.msBankApp.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {


   User getUser(Long id);


}
