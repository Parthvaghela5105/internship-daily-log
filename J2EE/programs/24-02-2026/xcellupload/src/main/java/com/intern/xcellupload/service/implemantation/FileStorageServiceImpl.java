package com.intern.xcellupload.service.implemantation;

import com.intern.xcellupload.domain.Employee;
import com.intern.xcellupload.repository.EmployeeRepository;
import com.intern.xcellupload.service.FileStorageService;
import com.intern.xcellupload.utility.StorageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String uploadFile(MultipartFile eFile) {
        //validate file
        if (StorageHelper.isInValidExcelFile(eFile))
            return "Invalid Excell file";

        List<Employee> employees = StorageHelper.extractEmployeeDataFromExcelFile(eFile);

        employeeRepository.saveAll(employees);

        return "Data Saved Successfully";
    }

    @Override
    public byte[] getExcelFile() {
        List<Employee> employees = employeeRepository.findAll();
        return StorageHelper.downloadExcelFromListOfStudent(employees);
    }

    @Override
    public byte[] getExcelFileFormat() {
        return  StorageHelper.downloadFormatExcelFile();
    }
}