package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.service.PositionService;

@Repository
public class PositionServiceImpl implements PositionService {
	
	private static final String FILE_NAME = "Position.xlsx";
	
	@Override
	public List<Position> getAllPosition(){
		List<Position> listPosition = new ArrayList<>();
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
                    		listPosition.add(pos);
                    	}
                	//}
                }
            }
            
            for (int i = 0; i < listPosition.size(); i++) {
            	System.out.println(listPosition.get(i).getId());
            	System.out.println(listPosition.get(i).getDepartmentID());
            	System.out.println(listPosition.get(i).getName());
			}
            
            
            
        } catch (Exception e) {
        	//System.out.println(listPostion.toString());
            e.printStackTrace();
            
        }
		
		return listPosition;
	}
}
