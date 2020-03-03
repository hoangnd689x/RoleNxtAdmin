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

import com.orgchart.orgchart.model.PositionDetails;
import com.orgchart.orgchart.service.PositionDetailsService;

/**
 * @author YOG1HC
 *
 */
@Repository
public class PositionDetailServiceImpl implements PositionDetailsService {
	
	private static final String FILE_NAME = "PositionDetails.xlsx";
	
	@Override
	public List<PositionDetails> getAllPositionDetails(){
		List<PositionDetails> listPositionDetail = new ArrayList<>();
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
                PositionDetails poD = new PositionDetails();
                
                
                if(firstRow) {
                	firstRow = false;
                }else {
                	//if(currentRow.getCell(0).getCellTypeEnum()== CellType.STRING || currentRow.getCell(0).getCellTypeEnum()== CellType.NUMERIC) {
                		if(0 != currentRow.getCell(0).getNumericCellValue() || null != currentRow.getCell(0) || null != currentRow.getCell(0)  || null != currentRow.getCell(1)) {
                			poD.setId((long) currentRow.getCell(0).getNumericCellValue());
                			poD.setPositionId((long)currentRow.getCell(1).getNumericCellValue());
                			poD.setRoles(currentRow.getCell(2).getStringCellValue());
                			poD.setProjects(currentRow.getCell(3).getStringCellValue());
                			poD.setResponsibilities(currentRow.getCell(4).getStringCellValue());
                			
                    		listPositionDetail.add(poD);
                    	}
                	//}
                }
            }
            
            
        } catch (Exception e) {
        	//System.out.println(listPostion.toString());
            e.printStackTrace();
        }
		
		return listPositionDetail;
	}
}
