package com.example.bff.rest.controllers;

import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageOperation;
import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageRequest;
import com.example.bff.api.domainoperation.fullitemstorage.get.GetFullItemStorageResponse;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemByTagRequest;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemsByTagOperation;
import com.example.bff.api.domainoperation.item.getallbytag.GetAllItemsByTagResponse;
import com.example.bff.api.domainoperation.item.getkeyword.GetByKeyWordOperation;
import com.example.bff.api.domainoperation.item.getkeyword.GetByKeyWordRequest;
import com.example.bff.api.domainoperation.item.getkeyword.GetByKeyWordResponse;
import com.example.bff.api.domainoperation.item.recommend.RecommendItemsOperation;
import com.example.bff.api.domainoperation.item.recommend.RecommendItemsRequest;
import com.example.bff.api.domainoperation.item.recommend.RecommendItemsResponse;
import com.example.bff.api.operation.comment.CreateCommentOperation;
import com.example.bff.api.operation.comment.CreateCommentRequest;
import com.example.bff.api.operation.comment.CreateCommentResponse;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesOperation;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesRequest;
import com.example.bff.api.operation.purchases.getall.GetAllPurchasesResponse;
import com.example.bff.api.operation.purchases.getallexcel.GetAllExcelRequest;
import com.example.bff.api.operation.purchases.getallexcel.GetAllExcelResponse;
import com.example.bff.api.operation.shipment.arrival.ShipmentArrivalOperation;
import com.example.bff.api.operation.shipment.arrival.ShipmentArrivalRequest;
import com.example.bff.api.operation.shipment.arrival.ShipmentArrivalResponse;
import com.example.bff.api.operation.shipment.getforpurchase.ShipmentStatusOperation;
import com.example.bff.api.operation.shipment.getforpurchase.ShipmentStatusRequest;
import com.example.bff.api.operation.shipment.getforpurchase.ShipmentStatusResponse;
import com.example.bff.api.operation.shipment.take.TakeShipmentOperation;
import com.example.bff.api.operation.shipment.take.TakeShipmentRequest;
import com.example.bff.api.operation.shipment.take.TakeShipmentResponse;
import com.example.bff.core.operations.purchases.GetAllPurchaseExcelIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bff")
public class BFFController {

    private final GetFullItemStorageOperation getFullItemStorage;
    private final GetAllItemsByTagOperation getAllItemsByTagOperation;
    private final GetAllPurchasesOperation getAllPurchases;
    private final CreateCommentOperation createComment;
    private final GetByKeyWordOperation getByKeyWord;
    private final RecommendItemsOperation recommendItems;
    private final ShipmentStatusOperation shipmentStatus;
    private final ShipmentArrivalOperation shipmentArrival;
    private final TakeShipmentOperation takeShipment;
    private final GetAllPurchaseExcelIMPL getAllPurchaseExcel;

    @GetMapping("/{id}")
    public ResponseEntity<GetFullItemStorageResponse> get(@PathVariable String id){


        return ResponseEntity.ok(getFullItemStorage.process(GetFullItemStorageRequest.builder()
                .itemStorageId(UUID.fromString(id))
                .build()));
    }
    @GetMapping(value = "/FullItembyTag")
    public ResponseEntity<GetAllItemsByTagResponse> getByTag(@RequestBody GetAllItemByTagRequest tag){
        return ResponseEntity.ok(getAllItemsByTagOperation.process(tag));
    }
    @GetMapping("/purchases")
    public ResponseEntity<GetAllPurchasesResponse> allPurchases(@RequestBody GetAllPurchasesRequest request){
        return ResponseEntity.ok(getAllPurchases.process(request));
    }
    @PostMapping("/comment")
    public ResponseEntity<CreateCommentResponse> createComment(@RequestBody CreateCommentRequest request){
        return ResponseEntity.ok(createComment.process(request));
    }
    @GetMapping("/keyword")
    public ResponseEntity<GetByKeyWordResponse> getByKeyWord(@RequestBody GetByKeyWordRequest request){
        return ResponseEntity.ok(getByKeyWord.process(request));
    }
    @GetMapping("/reccomended")
    public ResponseEntity<RecommendItemsResponse> recommendedItems(
            @RequestBody RecommendItemsRequest request){
        return ResponseEntity.ok(recommendItems.process(request));
    }
    @PostMapping("/shipment-status")
    public ResponseEntity<ShipmentStatusResponse> status(@RequestBody ShipmentStatusRequest request){
        return ResponseEntity.ok(shipmentStatus.process(request));
    }
    @PostMapping("/shipment-arrive")
    public ResponseEntity<ShipmentArrivalResponse> arrive(@RequestBody ShipmentArrivalRequest request){
        return ResponseEntity.ok(shipmentArrival.process(request));
    }
    @PostMapping("/shipment-take")
    public ResponseEntity<TakeShipmentResponse> take(@RequestBody TakeShipmentRequest request){
        return ResponseEntity.ok(takeShipment.process(request));
    }
    @PostMapping("/excel-purchase")
    public ResponseEntity toExcel() throws IOException {
        GetAllExcelResponse excelResponse = getAllPurchaseExcel
                .process(new GetAllExcelRequest()); // Call your existing process method

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "purchases.xlsx"); // Set the filename

        return new ResponseEntity<>(excelResponse.getBytes(), headers, HttpStatus.OK);
    }

}
