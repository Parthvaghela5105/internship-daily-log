package com.intern.imageoperation.controller;


import com.intern.imageoperation.proxy.FileStorageProxy;
import com.intern.imageoperation.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/v1/file")
public class FileStorageController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam  MultipartFile file){
        String msg = fileStorageService.storeFile(file);
        return ResponseEntity.ok(msg);
    }

//    @GetMapping("/download/{dockId}")
//    public ResponseEntity<?> downaloadFile(@PathVariable String dockId){
//        FileStorage file = fileStorageService.getFile(dockId);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION , "attachment;filename="+dockId)
//                .contentType(MediaType.parseMediaType(file.getContentType()))
//                .body(file.getFileData());
//    }

    @GetMapping("/download/{dockId}")
    public ResponseEntity<?> downaloadFile(@PathVariable String dockId) throws IOException {
        FileStorageProxy file = fileStorageService.getFile(dockId);

        String filePath = file.getFilePath();
        System.err.println("this is file path: "+filePath);
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(bytes);
    }
}
