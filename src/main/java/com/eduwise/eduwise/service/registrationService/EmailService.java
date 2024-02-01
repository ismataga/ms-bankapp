package com.eduwise.eduwise.service.registrationService;

import com.eduwise.eduwise.entity.User;
import com.eduwise.eduwise.mapper.UserMapper;
import com.eduwise.eduwise.model.registrationDto.ResetPasswordDto;
import com.eduwise.eduwise.repository.UserRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final UserRepository userRepository;
    private final MailSender mailSender;
    private final UserMapper mapper;
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 5;



    public void forgotPassword(String email) {

        Optional<User> userOptional = userRepository.findByUsername(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("This email is not registered");
        }

        User user = userOptional.get();
        user.setOtpCode(generateOtp());
        user.setTokenCreationDate(LocalDateTime.now());
        user = userRepository.save(user);

        user.getOtpCode();

        sendEmail(user.getEmail(), user.getOtpCode());

    }
    private void sendEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("ismataga1@gmail.com");
        message.setSubject("Password update");
        message.setText(otp);
        mailSender.send(message);

    }



    public void resetPassword(ResetPasswordDto resetPasswordDto) {
        User user = userRepository.findByUsername(resetPasswordDto.getUsername())
                .orElseThrow(()-> new RuntimeException("This email is not registered"));

        LocalDateTime tokenCreationDate = user.getTokenCreationDate();

        if (isOtpExpired(tokenCreationDate)) {
            throw new RuntimeException( "Otp is expired");
        }

        user.setPassword(resetPasswordDto.getPassword());
        userRepository.save(user);


    }


    private  String generateOtp() {
        Random random = new Random();
        int max = 9999;
        int min = 1000;
        return String.valueOf(random.nextInt(max - min + 1) + min);
    }


    private boolean isOtpExpired(LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
