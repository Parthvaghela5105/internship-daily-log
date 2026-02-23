package com.intern.imageoperation.proxy;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileStorageProxy {
    private Long id;
    private String fileName;
    private String filePath;
    private String contentType;
    private String fileSize;
    private String dockId;
    private byte[] fileData;
    private Boolean isActive;
}
