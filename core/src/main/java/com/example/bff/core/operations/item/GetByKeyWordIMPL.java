package com.example.bff.core.operations.item;

import com.example.bff.api.domainoperation.item.getkeyword.GetByKeyWordOperation;
import com.example.bff.api.domainoperation.item.getkeyword.GetByKeyWordRequest;
import com.example.bff.api.domainoperation.item.getkeyword.GetByKeyWordResponse;
import com.example.zoostore.api.operations.item.findbyregex.FindByRegexRequest;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetByKeyWordIMPL implements GetByKeyWordOperation {
    private final ZooStoreRestClient zooStoreRestClient;

    @Override
    public GetByKeyWordResponse process(GetByKeyWordRequest request) {
        List items= zooStoreRestClient.findByRegex(request.getKeyWord(), request.getPage()).getItems();
        return GetByKeyWordResponse.builder()
                .keyWord(request.getKeyWord())
                .items(items)
                .build();
    }
}
