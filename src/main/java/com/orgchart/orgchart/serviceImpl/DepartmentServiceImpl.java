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

import com.orgchart.orgchart.model.Department;
import com.orgchart.orgchart.model.Structure;
import com.orgchart.orgchart.service.DepartmentService;
import com.orgchart.orgchart.service.StructureService;

/**
 * @author YOG1HC
 *
 */
@Repository
public class DepartmentServiceImpl implements DepartmentService {
	
	private static final String FILE_NAME = "Department.xlsx";
	
	@Override
	public List<Department> getAllDepartments(){
		List<Department> listDepartment = new ArrayList<>();
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
                Department dm = new Department();
                
                
                if(firstRow) {
                	firstRow = false;
                }else {
                	//if(currentRow.getCell(0).getCellTypeEnum()== CellType.STRING || currentRow.getCell(0).getCellTypeEnum()== CellType.NUMERIC) {
                		if(0 != currentRow.getCell(0).getNumericCellValue() || null != currentRow.getCell(0) || null != currentRow.getCell(0)  || null != currentRow.getCell(1)) {
                			dm.setId((long) currentRow.getCell(0).getNumericCellValue());
                			dm.setName(currentRow.getCell(1).getStringCellValue());
                			listDepartment.add(dm);
                    	}
                	//}
                }
            }
            
            for (int i = 0; i < listDepartment.size(); i++) {
            	System.out.println(listDepartment.get(i).getId());
            	System.out.println(listDepartment.get(i).getName());
			}
            
        } catch (Exception e) {
        	//System.out.println(listPostion.toString());
            e.printStackTrace();
        }
		
		return listDepartment;
	}
}
