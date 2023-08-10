package com.example.bff.api.domainoperation.item.getallbytag;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllItemsByTagResponse implements OperationResponse {
    private String tagName;
    private List items;



}
