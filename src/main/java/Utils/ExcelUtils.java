package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

    public static Object[][] readExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int totalRows = sheet.getLastRowNum();  // last non-empty row index
            int totalCols = sheet.getRow(0).getLastCellNum(); // total columns

            data = new Object[totalRows][totalCols]; // Initialize properly

            for (int i = 1; i <= totalRows; i++) {  // Note: i <= totalRows
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalCols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case BLANK:
                            data[i - 1][j] = "";
                            break;
                        default:
                            data[i - 1][j] = cell.toString();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
    	String fileName=ConfigReader.getProperty("filepath");
        String sheetName = ConfigReader.getProperty("sheetname");
        return readExcelData(fileName, sheetName);
    }
}
