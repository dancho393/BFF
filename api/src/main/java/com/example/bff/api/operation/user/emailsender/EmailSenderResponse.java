package com.example.bff.api.operation.user.emailsender;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
@Setter
public class EmailSenderResponse implements OperationResponse {
    private String message;
}
