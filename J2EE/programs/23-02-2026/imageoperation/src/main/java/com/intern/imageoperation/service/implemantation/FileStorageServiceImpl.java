package com.intern.imageoperation.service.implemantation;

import com.intern.imageoperation.domain.FileStorage;
import com.intern.imageoperation.proxy.FileStorageProxy;
import com.intern.imageoperation.repository.FileStorageRepo;
import com.intern.imageoperation.service.FileStorageService;
import com.intern.imageoperation.utility.MapperHelper;
import com.intern.imageoperation.utility.StorageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Autowired
    private FileStorageRepo fileStorageRepo;

    @Autowired
    private StorageHelper helper;

    @Autowired
    private MapperHelper mapperHelper;

    @Value("${document.folder}")
    private String documentPath;

    @Override
    public String storeFile(MultipartFile file) {

        if(StorageHelper.isInvalidFile(file))
            return "Please enter valid file";

        try{
            String fileDockId = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            double sizeInKb = size/1024.00;
            String contentType = file.getContentType();


            File f = new File(documentPath);

            if(!f.exists()){
                f.mkdirs();
            }

            String fullPathName=documentPath+File.separator+fileDockId+"_"+originalFilename;

            Files.copy(file.getInputStream() , Path.of(fullPathName) , StandardCopyOption.REPLACE_EXISTING);

            FileStorage fileStorage = FileStorage.builder()
                    .fileName(originalFilename)
                    .contentType(contentType)
                    .fileSize(String.valueOf(sizeInKb))
                    .filePath(fullPathName)
                    .fileData(null)
                    .dockId(fileDockId)
                    .isActive(true)
                    .build();


            fileStorageRepo.save(fileStorage);
            return "Document has been saved in document Id : "+fileDockId;

        }catch(IOException ex){
            ex.printStackTrace();
        }
        return "unable to upload document";
    }

    @Override
    public FileStorageProxy getFile(String dockId) {
        Optional<FileStorage> fileStorageOptional = fileStorageRepo.findByDockId(dockId);
        if(fileStorageOptional.isPresent()){
            return mapperHelper.getFileStorageProxy(fileStorageOptional.get());
        }
        else
            throw new RuntimeException("File is not found with dockId :"+dockId);
    }

    @Override
    public String getFileName(String dockId) {
        return "";
    }
}
