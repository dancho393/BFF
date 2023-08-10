package com.example.bff.api.operation.comment;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateCommentResponse implements OperationResponse {
    private String fullName;
    private String comment;
    private Float rating;
    private String itemName;
}
