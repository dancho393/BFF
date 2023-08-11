package com.example.bff.api.operation.user.emailsender;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
@Setter
public class EmailSenderRequest implements OperationRequest {
    private String toEmail;
    private String subject;
    private String body;

}
