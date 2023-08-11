package com.example.bff.api.operation.user.emailsender;

import com.example.bff.api.base.Operation;

public interface EmailSenderOperation extends Operation<EmailSenderRequest,EmailSenderResponse> {
    public EmailSenderResponse process(EmailSenderRequest request);
}
