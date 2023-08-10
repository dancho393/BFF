package com.example.bff.api.domainoperation.item.getkeyword;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class GetByKeyWordResponse implements OperationResponse {
    private String keyWord;

    private List items;

}
