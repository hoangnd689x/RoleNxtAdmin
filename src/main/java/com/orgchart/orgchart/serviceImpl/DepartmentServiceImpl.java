package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	private static final String FILE_NAME = "data_structure.xlsx";

	@Override
	public List<Department> getAllDepartments() {
		List<Department> listDepartment = new ArrayList<>();
		try {
			System.out.println(FILE_NAME);
//			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			InputStream inputStream = getClass()
					.getClassLoader().getResourceAsStream(FILE_NAME);
			
			Workbook workbook = new XSSFWorkbook(inputStream);
			///
			
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Department dm = new Department();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						dm.setId((long) currentRow.getCell(0).getNumericCellValue());
						dm.setName(currentRow.getCell(1).getStringCellValue());
						dm.setDomain(currentRow.getCell(2).getStringCellValue());
						dm.setBusinessSector(currentRow.getCell(3).getStringCellValue());
						listDepartment.add(dm);
					} catch (Exception e) {
						e.printStackTrace();
						listDepartment.add(dm);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listDepartment;
	}
}
