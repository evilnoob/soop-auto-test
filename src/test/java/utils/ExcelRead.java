package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelRead {

   // @Step("Чтение тестовых данных из файла \"{0}\" листа \"{1}\".")
    public static ArrayList<ArrayList<String>> excelRead(String fileName, String sheetName) {
    //public synchronized static ArrayList<ArrayList<String>> excelRead(String fileName, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            //XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                ArrayList<String> temp = new ArrayList<String>();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Boolean firstColumn=true;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //System.out.print(cell.getCellType()+"  ");
                    if (firstColumn)  {
                        cell = cellIterator.next();
                        firstColumn=false;
                    }
                    //Boolean nullCell=true;
                    //System.out.print(cell.getCellType()+"  ");
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                           // Double d;
                            //d = cell.getNumericCellValue();
                           // temp.add(String.valueOf(d.intValue()));
                            temp.add(String.format("%.0f",cell.getNumericCellValue()));
                            //temp.add(cell.getStringCellValue());
                            //nullCell=false;
                            //System.out.print(cell.getNumericCellValue() + " ");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            temp.add(cell.getStringCellValue());
                            //System.out.println(cell.getStringCellValue() + " ");
                            //nullCell=false;
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            temp.add(String.valueOf(cell.getBooleanCellValue()));
                            //nullCell=false;
                            //System.out.print(cell.getBooleanCellValue() + " ");
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            //System.out.println("");
                            //System.out.println("+++");
                            temp.add(null);
                            break;
                    }
                }
                //System.out.println(temp+"temp");
                data.add(temp);
            }
            file.close();
            //System.out.println(data.get(0)+"data0");
            //System.out.println(data.get(1)+"data1");
            //System.out.println(data+"datafull");
            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //@Step("Поиск тестовых данных для \"{2}\" из файла \"{0}\" листа \"{1}\".")
    public static Integer rowFinder(String fileName,String sheetName,String searchedName) {
    //public synchronized static Integer rowFinder(String fileName,String sheetName,String searchedName) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            //System.out.println(sheet.getSheetName());
            Iterator<Row> rowIterator = sheet.iterator();
            Integer count=0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();
                //System.out.println(cell.toString());
                //System.out.print(" "+searchedName);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        Double d;
                        d = cell.getNumericCellValue();
                        if (String.valueOf(d.intValue()).equals(searchedName)) {
                            return count;
                        }
                        break;
                    case Cell.CELL_TYPE_STRING:
                        if (cell.getStringCellValue().equals(searchedName)) {
                            //System.out.print(count+" ");
                            //System.out.println(cell.getStringCellValue());
                            return count;
                        }
                        break;
                }
                //System.out.println(count);
                count++;
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String extract(ArrayList<String> list) {
    //public synchronized static String extract(ArrayList<String> list) {
        String a;
        a = list.get(0);
        list.remove(0);
        return a;
    }
}