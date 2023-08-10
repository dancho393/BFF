package com.example.bff.api.operation.comment;

import com.example.bff.api.base.Operation;

public interface CreateCommentOperation extends Operation<CreateCommentRequest,CreateCommentResponse> {
    CreateCommentResponse process(CreateCommentRequest request);
}
