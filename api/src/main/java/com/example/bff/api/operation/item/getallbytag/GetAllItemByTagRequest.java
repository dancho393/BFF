package com.example.bff.api.operation.item.getallbytag;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

import java.awt.print.Pageable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllItemByTagRequest implements OperationRequest {
    private UUID tagId;
    private int page;

}
