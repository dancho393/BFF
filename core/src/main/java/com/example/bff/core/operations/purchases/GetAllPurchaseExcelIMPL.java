package com.example.bff.core.operations.purchases;

import com.example.bff.api.operation.purchases.getallexcel.GetAllExcelOperation;
import com.example.bff.api.operation.purchases.getallexcel.GetAllExcelRequest;
import com.example.bff.api.operation.purchases.getallexcel.GetAllExcelResponse;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllPurchase;
import com.example.storageservice.api.api.operations.purchase.getAll.GetAllResponse;
import com.example.storageservice.restexport.StorageServiceRestClient;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@AllArgsConstructor
@Service
public class GetAllPurchaseExcelIMPL implements GetAllExcelOperation {
    private final StorageServiceRestClient storageServiceRestClient;

    @Override
    public GetAllExcelResponse process(GetAllExcelRequest request) throws IOException {
        GetAllResponse response = storageServiceRestClient.getAllPurchase(0);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Purchases");

        List<GetAllPurchase> purchaseList = response.getPurchaseList();
        int rowNum = 0;

// Create header row
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Successful");
        headerRow.createCell(2).setCellValue("Purchase Date");
        headerRow.createCell(3).setCellValue("Items");
        headerRow.createCell(4).setCellValue("Total Price");
        headerRow.createCell(5).setCellValue("User ID");

// Populate rows with purchase data
        for (GetAllPurchase purchase : purchaseList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(purchase.getId().toString());
            row.createCell(1).setCellValue(purchase.getSuccessful());
            row.createCell(2).setCellValue(purchase.getPurchaseDate().toString());

            // Assuming the items are stored as a Map<String, Integer>
            StringBuilder itemsString = new StringBuilder();
            for (Map.Entry<String, Integer> entry : purchase.getItems().entrySet()) {
                itemsString.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
            row.createCell(3).setCellValue(itemsString.toString());

            row.createCell(4).setCellValue(purchase.getTotalPrice());
            row.createCell(5).setCellValue(purchase.getUserId().toString());
        }


        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            byte[] excelBytes = outputStream.toByteArray();


            return GetAllExcelResponse.builder()
                    .bytes(outputStream.toByteArray())
                    .build();
        }
    }
}
