package com.example.bff.api.operation.item.getallbytag;

import com.example.bff.api.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllItemsByTagResponse implements OperationResponse {
    private List items;



}
