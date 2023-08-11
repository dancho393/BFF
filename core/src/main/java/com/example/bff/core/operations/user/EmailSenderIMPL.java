package com.example.bff.core.operations.user;

import com.example.bff.api.operation.user.emailsender.EmailSenderOperation;
import com.example.bff.api.operation.user.emailsender.EmailSenderRequest;
import com.example.bff.api.operation.user.emailsender.EmailSenderResponse;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailSenderIMPL implements EmailSenderOperation {
    private JavaMailSender javaMailSender;


    @Override
    public EmailSenderResponse process(EmailSenderRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("danez7000@gmail.com");
        message.setTo(request.getToEmail());
        message.setText(request.getBody());
        message.setSubject(request.getSubject());

        javaMailSender.send(message);
        return EmailSenderResponse.builder()
                .message("Verification Email Send")
                .build();
    }
}
