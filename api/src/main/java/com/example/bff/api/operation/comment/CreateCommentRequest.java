package com.example.bff.api.operation.comment;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCommentRequest implements OperationRequest {
    private UUID userId;
    private UUID itemId;
    private String comment;
    private Float rating;
}
