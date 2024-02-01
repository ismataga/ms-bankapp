package com.eduwise.eduwise.service.registrationService;

import com.eduwise.eduwise.entity.User;
import com.eduwise.eduwise.mapper.UserMapper;
import com.eduwise.eduwise.model.registrationDto.RegistrationDTO;
import com.eduwise.eduwise.repository.UserRepository;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final MailSender mailSender;

    private boolean isSending = false;

    private Queue<SimpleMailMessage> queue = new ConcurrentLinkedQueue<>();

    @Value("${app.registration.base-path}")
    private String baseUrl;


    public void register(RegistrationDTO dto) {
        User user = Optional.of(dto)
                .map(mapper::toEntity)
                .map(repository::save)
                .orElseThrow();
        sendEmail(dto.getUsername(), user.getUuid());
    }

    private void sendEmail(String email, UUID uuid) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        System.out.println(email);
        message.setFrom("info@good.company");
        message.setSubject("Registration Confirmation");
        message.setText(baseUrl + "/registration/confirmation/" + uuid);
        queue.add(message);

    }


    public void confirm(UUID uuid) {
        repository.findByUuid(uuid)
                .ifPresentOrElse(this::activateUser, () -> {
                    throw new RuntimeException("");
                });

    }

    protected void activateUser(User user) {
        user.setEnabled(true);
        repository.save(user);
    }

    @Scheduled(fixedDelay = 5000)
    public void sendMail() {
//        log.info("starting");
        while (!isSending && !queue.isEmpty()) {
//            log.info("found email");
            isSending = true;
//            log.info("sending");
            mailSender.send(Objects.requireNonNull(queue.poll()));
//            log.info("send 1");
        }
        isSending = false;
//        log.info("finishing");
    }
}
