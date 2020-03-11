package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	private static final String FILE_NAME = "data_structure.xlsx";

	@Override
	public List<PositionDetails> getAllPositionDetails() {
		List<PositionDetails> listPositionDetail = new ArrayList<>();
		try {
			System.out.println(FILE_NAME);
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			// Get sheet 1 - Roles
			Sheet datatypeSheet = workbook.getSheetAt(1);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				PositionDetails poD = new PositionDetails();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						poD.setDomain(currentRow.getCell(0).getStringCellValue());
						poD.setCareerPath(currentRow.getCell(1).getStringCellValue());
						poD.setPosition(currentRow.getCell(2).getStringCellValue());
						poD.setDomainRoles(currentRow.getCell(3).getStringCellValue());
						poD.setProjectCategory(currentRow.getCell(4).getStringCellValue());
						poD.setCompetencyRequires(currentRow.getCell(5).getStringCellValue());
						poD.setKRA(currentRow.getCell(6).getStringCellValue());
						poD.setScope(currentRow.getCell(7).getStringCellValue());
						poD.setResponsibilities(currentRow.getCell(8).getStringCellValue());
						poD.setIndustrialRole(currentRow.getCell(9).getStringCellValue());
						poD.setEntryCriteria(currentRow.getCell(10).getStringCellValue());

						listPositionDetail.add(poD);
					} catch (Exception e) {
						e.printStackTrace();
						listPositionDetail.add(poD);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPositionDetail;
	}
}
