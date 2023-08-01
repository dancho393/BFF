package com.example.bff.api.domainoperation.item.getallbytag;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

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
