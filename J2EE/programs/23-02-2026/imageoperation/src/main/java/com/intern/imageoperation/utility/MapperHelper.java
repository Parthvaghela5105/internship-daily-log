package com.intern.imageoperation.utility;

import com.intern.imageoperation.domain.FileStorage;
import com.intern.imageoperation.proxy.FileStorageProxy;
import com.intern.imageoperation.proxy.StudentProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {

    @Autowired
    private ModelMapper mapper;

    public FileStorage getFileStorage(FileStorageProxy fileStorageProxy){
        return mapper.map(fileStorageProxy , FileStorage.class);
    }

    public FileStorageProxy getFileStorageProxy(FileStorage fileStorage){
        return mapper.map(fileStorage , FileStorageProxy.class);
    }
}
