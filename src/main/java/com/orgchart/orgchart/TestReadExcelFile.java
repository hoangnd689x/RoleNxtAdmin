package com.orgchart.orgchart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.orgchart.orgchart.model.Position;

public class TestReadExcelFile {

	private static final String FILE_NAME = "Position.xlsx";
	
    public static void main(String[] args) {
    	List<Position> listPostion = new ArrayList<>();
        try {
        	System.out.println(FILE_NAME);
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            boolean firstRow = true;
            
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                Position pos = new Position();
                
                if(firstRow) {
                	firstRow = false;
                }else {
                	//if(currentRow.getCell(0).getCellTypeEnum()== CellType.STRING || currentRow.getCell(0).getCellTypeEnum()== CellType.NUMERIC) {
                		if(0 != currentRow.getCell(0).getNumericCellValue() || null != currentRow.getCell(0) || null != currentRow.getCell(0)  || null != currentRow.getCell(1)) {
                    		pos.setId((long) currentRow.getCell(0).getNumericCellValue());
                    		pos.setDepartmentID((long) currentRow.getCell(1).getNumericCellValue());
                    		pos.setName(currentRow.getCell(2).toString());
                    		listPostion.add(pos);
                    	}
                	//}
                }
            }
            
            for (int i = 0; i < listPostion.size(); i++) {
            	System.out.println(listPostion.get(i).getId());
            	System.out.println(listPostion.get(i).getDepartmentID());
            	System.out.println(listPostion.get(i).getName());
			}
            
            
            
        } catch (Exception e) {
        	//System.out.println(listPostion.toString());
            e.printStackTrace();
            
        }

    }
	
}
