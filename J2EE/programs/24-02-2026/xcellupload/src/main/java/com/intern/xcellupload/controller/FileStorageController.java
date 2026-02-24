package com.intern.xcellupload.controller;

import com.intern.xcellupload.service.FileStorageService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController()
@RequestMapping(value = "/v1/file")
public class FileStorageController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(value = "/upload/excel" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadExcelFile(@RequestParam MultipartFile excelFile){
        String s = fileStorageService.uploadFile(excelFile);
        return new ResponseEntity<>(s , HttpStatus.CREATED);
    }

    @GetMapping(value = "/download/excel")
    public ResponseEntity<byte[]> downloadExcelFile(){
        byte[] bytes = fileStorageService.getExcelFile();
        String filename = "Employee_"+ UUID.randomUUID().toString()+".xlsx";
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION , "attachment;filename="+filename)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);

    }

    @GetMapping(value = "download/format-excel")
    public ResponseEntity<byte[]> downloadExcelFormatFile(){
        byte[] bytes = fileStorageService.getExcelFileFormat();
        String filename = "Employee_"+ UUID.randomUUID().toString()+".xlsx";
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION , "attachment;filename="+filename)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);
    }

}
