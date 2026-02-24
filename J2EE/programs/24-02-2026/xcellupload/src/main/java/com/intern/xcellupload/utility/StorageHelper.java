package com.intern.xcellupload.utility;

import com.intern.xcellupload.domain.Employee;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class StorageHelper {

    public static boolean isInValidExcelFile(MultipartFile eFile){
        if(eFile.isEmpty() || eFile == null)
            return true;

        if(!eFile.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            return true;

        return false;
    }

    public static List<Employee> extractEmployeeDataFromExcelFile(MultipartFile eFile){

        List<Employee> emplList = new ArrayList<>();


        //get input stream
        // create XSSFWorkBook object
        try(XSSFWorkbook workBook = new XSSFWorkbook(eFile.getInputStream())){
            //get sheet
            XSSFSheet sheet = workBook.getSheetAt(0);

            // get total entry in excel
            int lastRowNum = sheet.getLastRowNum();

            //skip header and iterate the excel
            for(int i = 1 ; i <= lastRowNum ;i++){
                XSSFRow row = sheet.getRow(i);

                Employee emp = Employee.builder()
                        .name(row.getCell(1).getStringCellValue())
                        .emailId(row.getCell(2).getStringCellValue())
                        .mobileNo(row.getCell(3).getStringCellValue())
                        .address(row.getCell(4).getStringCellValue())
                        .isActive(row.getCell(6).getBooleanCellValue())
                        .age((int)row.getCell(5).getNumericCellValue())
                        .build();

                emplList.add(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return emplList;
    }

    public static byte[] downloadExcelFromListOfStudent(List<Employee> employees){
        String[] headers = {"ID", "NAME", "EMAIL ID", "MOBILE NO", "AGE", "IS_ACTIVE"};

        try(ByteArrayOutputStream os = new ByteArrayOutputStream();Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Student Data");

            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }
            int i = 1;

            for (Employee emp : employees) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(emp.getId());
                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(emp.getEmailId());
                row.createCell(3).setCellValue(emp.getMobileNo());
                row.createCell(4).setCellValue(emp.getAge());
                row.createCell(5).setCellValue(emp.getIsActive());
                i++;
            }

            for (int j = 0; j < headers.length; j++) {
                sheet.autoSizeColumn(j);
            }

            workbook.write(os);

            return os.toByteArray();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] downloadFormatExcelFile(){
        String[] headers = {"ID", "NAME", "EMAIL ID", "MOBILE NO", "AGE", "IS_ACTIVE"};

        try(ByteArrayOutputStream os = new ByteArrayOutputStream();Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Student Data");

            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }
            for (int j = 0; j < headers.length; j++) {
                sheet.autoSizeColumn(j);
            }

            workbook.write(os);

            return os.toByteArray();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
