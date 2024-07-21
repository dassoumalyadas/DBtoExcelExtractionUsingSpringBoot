package com.soumalya.DBtoExcelExtractor;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private CourseRepository courseRepository;

    @SneakyThrows
    public void generateExcel(HttpServletResponse response) {
        List<Course> course = courseRepository.findAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Course Info");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Price");
        int dataRowIndex = 1;
        for (Course course1 : course) {
            HSSFRow datarow = sheet.createRow(dataRowIndex);
            datarow.createCell(0).setCellValue(course1.getCi());
            datarow.createCell(1).setCellValue(course1.getName());
            datarow.createCell(2).setCellValue(course1.getPrice());
            dataRowIndex++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
    }
}
