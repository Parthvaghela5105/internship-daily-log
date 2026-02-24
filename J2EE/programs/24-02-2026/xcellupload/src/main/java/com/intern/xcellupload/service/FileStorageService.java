package com.intern.xcellupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String uploadFile(MultipartFile eFile);
    byte[] getExcelFile();
    byte[] getExcelFileFormat();
}
