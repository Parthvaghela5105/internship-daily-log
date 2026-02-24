package com.intern.imageoperation.service;

import com.intern.imageoperation.domain.FileStorage;
import com.intern.imageoperation.proxy.FileStorageProxy;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String storeFile(MultipartFile file);
    FileStorageProxy getFile(String dockId);
}
