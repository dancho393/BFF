package com.example.bff.api.domainoperation.item.getallbytag;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private String itemTitle;
    private String itemDescription;
    private int quantity;
    private Float price;
}
