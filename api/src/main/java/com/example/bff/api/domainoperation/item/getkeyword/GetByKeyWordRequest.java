package com.example.bff.api.domainoperation.item.getkeyword;

import com.example.bff.api.base.OperationRequest;
import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class GetByKeyWordRequest implements OperationRequest {
    private String keyWord;
    private int page;
}
