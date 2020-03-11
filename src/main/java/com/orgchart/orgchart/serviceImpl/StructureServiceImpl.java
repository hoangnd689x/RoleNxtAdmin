package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orgchart.orgchart.model.Structure;
import com.orgchart.orgchart.service.StructureService;

/**
 * @author YOG1HC
 *
 */
@Repository
public class StructureServiceImpl implements StructureService {

	private static final String FILE_NAME = "data_structure.xlsx";

	@Override
	public List<Structure> getAllStructures() {
		List<Structure> listStructure = new ArrayList<>();
		try {
			System.out.println(FILE_NAME);
			InputStream inputStream = getClass()
					.getClassLoader().getResourceAsStream(FILE_NAME);
			
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Structure str = new Structure();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						str.setId((long) currentRow.getCell(0).getNumericCellValue());
						str.setDepartmentName(currentRow.getCell(1).getStringCellValue());
						str.setDomain(currentRow.getCell(2).getStringCellValue());
						str.setLevel0(currentRow.getCell(3).getStringCellValue());
						str.setLevel1(currentRow.getCell(4).getStringCellValue());
						str.setLevel2(currentRow.getCell(5).getStringCellValue());
						str.setLevel3(currentRow.getCell(6).getStringCellValue());
						str.setLevel4(currentRow.getCell(7).getStringCellValue());
						str.setLevel5(currentRow.getCell(8).getStringCellValue());
						str.setLevel6(currentRow.getCell(9).getStringCellValue());
						str.setLevel7(currentRow.getCell(10).getStringCellValue());
						listStructure.add(str);
					} catch (Exception e) {
						e.printStackTrace();
						listStructure.add(str);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listStructure;
	}
}
