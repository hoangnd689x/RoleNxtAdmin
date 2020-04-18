package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Domain;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.service.DomainService;
import com.orgchart.orgchart.service.OrganizationService;

/**
 * @author YOG1HC
 *
 */
public class OrganizationServiceImpl implements OrganizationService {

	private static final String FILE_NAME = "data_structure.xlsx";
	private static String filePath = "";

	public OrganizationServiceImpl() {
		super();
		// use this file path because in war file cannot point to resource folder, have to point to folder class/...
		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
	}

	@Override
	public List<Organization> getAllOrgs() {
		List<Organization> listDepartment = new ArrayList<>();
		try {
			File file = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Organization org = new Organization();

				DomainService dmService = new DomainServiceImpl();
				List<Domain> listDomain = dmService.getAllDomains();
				
				if (firstRow) {
					firstRow = false;
				} else {
					try {
						org.setId((long) currentRow.getCell(0).getNumericCellValue());
						org.setName(currentRow.getCell(1).getStringCellValue());
						
						for(Domain dm: listDomain) {
							if((long) currentRow.getCell(2).getNumericCellValue() == dm.getId()) {
								org.setDomainObj(dm);
							}
						}
						
						org.setBusinessSector(currentRow.getCell(3).getStringCellValue());
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					listDepartment.add(org);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	@Override
	public List<Organization> getAllPureOrgs() {
		List<Organization> listDepartment = new ArrayList<>();
		try {
			File file = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Organization org = new Organization();
				
				if (firstRow) {
					firstRow = false;
				} else {
					try {
						org.setId((long) currentRow.getCell(0).getNumericCellValue());
						org.setName(currentRow.getCell(1).getStringCellValue());
						org.setBusinessSector(currentRow.getCell(3).getStringCellValue());
						listDepartment.add(org);
					} catch (Exception e) {
						e.printStackTrace();
						listDepartment.add(org);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDepartment;
	}

	@Override
	public Organization getOrgById(long id) {
		Organization org = new Organization();
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				
				DomainService dmService = new DomainServiceImpl();
				List<Domain> listDomain = dmService.getAllDomains();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0).getNumericCellValue() == id) {
							org.setId((long) currentRow.getCell(0).getNumericCellValue());
							org.setName(currentRow.getCell(1).getStringCellValue());
							
							for(Domain dm: listDomain) {
								if((long) currentRow.getCell(2).getNumericCellValue() == dm.getId()) {
									org.setDomainObj(dm);
								}
							}
							org.setBusinessSector(currentRow.getCell(3).getStringCellValue());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return org;
	}

	@Override
	public boolean UpdateOrg(Organization orgUpdate) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row row = iterator.next();
				int columnCount = 0;

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (row.getCell(0).getNumericCellValue() == orgUpdate.getId()) {
							Cell cell = row.createCell(columnCount);
							cell.setCellValue(row.getRowNum());
							cell = row.createCell(0);
							cell.setCellValue(orgUpdate.getId());
							cell = row.createCell(1);
							cell.setCellValue(orgUpdate.getName());
							cell = row.createCell(2);
							cell.setCellValue(orgUpdate.getDomain());
							cell = row.createCell(3);
							cell.setCellValue(orgUpdate.getBusinessSector());
							inputStream.close();
							FileOutputStream out = new FileOutputStream(file);
							workbook.write(out);
							workbook.close();
							out.close();
							isUpdated = true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean AddOrg(Organization orgUpdate) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			
			int rowCount = datatypeSheet.getLastRowNum();
			
			// get the biggest id and +1 to create a new Organization
			Row lastRow = datatypeSheet.getRow(rowCount);
			long biggestId = 0;
			Cell firstCell = lastRow.getCell(0);
	        if (firstCell != null && firstCell.getCellType() != Cell.CELL_TYPE_BLANK) {
	        	biggestId = (long)lastRow.getCell(0).getNumericCellValue();
	        }else {
	        	biggestId = 999;
	        }
			
			Row row = datatypeSheet.createRow(++rowCount);
			
			Cell cell = row.createCell(rowCount);
			cell.setCellValue(row.getRowNum());
			cell = row.createCell(0);
			cell.setCellValue(biggestId + 1);
			cell = row.createCell(1);
			cell.setCellValue(orgUpdate.getName());
			cell = row.createCell(2);
			cell.setCellValue(orgUpdate.getDomain());
			cell = row.createCell(3);
			cell.setCellValue(orgUpdate.getBusinessSector());
			
			inputStream.close();
		
			
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			workbook.close();
			out.close();
			
			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteOrg(long id) {
		boolean isDeleted = false;
		try {
			File file = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				System.out.println(currentRow);
				int rowIndex = currentRow.getRowNum();
				System.out.println("row index:" + rowIndex);
				int lastRowNum = datatypeSheet.getLastRowNum();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0).getNumericCellValue() == id) {
							datatypeSheet.removeRow(datatypeSheet.getRow(rowIndex));
							FileOutputStream out = new FileOutputStream(file);
							workbook.write(out);

							if (rowIndex > 0 && rowIndex < lastRowNum) {
								datatypeSheet.shiftRows(rowIndex + 1, lastRowNum, -1);
							}
							isDeleted = true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDeleted;
	}
}
