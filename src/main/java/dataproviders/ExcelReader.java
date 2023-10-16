package dataproviders;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    static XSSFWorkbook workbook;

    public static Object[][] getDataFromSheet(String sheetname) {
        Object[][] array = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(new File("")));
            XSSFSheet sheet = workbook.getSheet(sheetname);
            int row = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();
            array = new Object[row - 1][columns];
            for (int i = 1; i < row; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i - 1][j] = getdatatype(sheetname, i, j);
                }
            }

        } catch (IOException e) {
            System.out.println("Couldn't load the file" + e.getMessage());
        }
        return array;
    }

    public static String getdatatype(String sheetname, int row, int colums) {
        XSSFCell cell = workbook.getSheet(sheetname).getRow(row).getCell(colums);
        String data = "";
        if (cell.getCellType() == CellType.STRING) {
            data = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            Double dataindouble = cell.getNumericCellValue();
            data = String.valueOf(dataindouble);
        } else if (cell.getCellType() == CellType.BLANK) {
            data = "";
        }
        return data;
    }
}

