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

import com.orgchart.orgchart.model.Structure;
import com.orgchart.orgchart.service.StructureService;

/**
 * @author YOG1HC
 *
 */
@Repository
public class StructureServiceImpl implements StructureService {
	
	private static final String FILE_NAME = "Structure.xlsx";
	
	@Override
	public List<Structure> getAllStructures(){
		List<Structure> listStructure = new ArrayList<>();
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
                Structure str = new Structure();
                
                
                if(firstRow) {
                	firstRow = false;
                }else {
                	//if(currentRow.getCell(0).getCellTypeEnum()== CellType.STRING || currentRow.getCell(0).getCellTypeEnum()== CellType.NUMERIC) {
                		if(0 != currentRow.getCell(0).getNumericCellValue() || null != currentRow.getCell(0) || null != currentRow.getCell(0)  || null != currentRow.getCell(1)) {
                			str.setId((long) currentRow.getCell(0).getNumericCellValue());
                			str.setPath(currentRow.getCell(1).getStringCellValue());
                    		listStructure.add(str);
                    	}
                	//}
                }
            }
            
            for (int i = 0; i < listStructure.size(); i++) {
            	System.out.println(listStructure.get(i).getId());
            	System.out.println(listStructure.get(i).getPath());
			}
            
        } catch (Exception e) {
        	//System.out.println(listPostion.toString());
            e.printStackTrace();
        }
		
		return listStructure;
	}
}
