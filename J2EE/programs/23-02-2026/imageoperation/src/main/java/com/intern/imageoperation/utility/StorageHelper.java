package com.intern.imageoperation.utility;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class StorageHelper{
    public static Boolean isInvalidFile(MultipartFile file){
//        if(file == null || file.isEmpty())
//            return false;
//        return true;
        return (file == null || file.isEmpty()) ? Boolean.TRUE : Boolean.FALSE;
    }
}
