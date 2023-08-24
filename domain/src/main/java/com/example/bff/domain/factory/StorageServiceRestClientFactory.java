package com.example.bff.domain.factory;

import com.example.storageservice.restexport.StorageServiceRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class StorageServiceRestClientFactory {
    @Value("${storage.url}")
    private String storageUrl;
    @Bean
    StorageServiceRestClient getRestExportClient() {
        final ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(StorageServiceRestClient.class, storageUrl);
    }
}
