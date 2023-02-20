package excel;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public Map<String,String> getRowData(String fileName,String sheetName,int row) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/testData/"+fileName+".xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int lastColNum = sheet.getRow(0).getLastCellNum();
        Map<String,String>data=new HashMap<>();

        for (int i=0;i< lastColNum;i++){
            String key = sheet.getRow(0).getCell(i).getStringCellValue();
            String value = sheet.getRow(row).getCell(i).getStringCellValue();
            data.put(key,value);
        }
        return data;


        }
}
