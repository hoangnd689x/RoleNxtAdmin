package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.orgchart.orgchart.model.Competency;
import com.orgchart.orgchart.model.Domain;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.model.Role;
import com.orgchart.orgchart.service.CompetencyService;
import com.orgchart.orgchart.service.DomainService;
import com.orgchart.orgchart.service.OrganizationService;
import com.orgchart.orgchart.service.PositionService;
import com.orgchart.orgchart.service.RoleService;
import com.orgchart.orgchart.util.Util;

/**
 * @author YOG1HC
 *
 */
public class RoleServiceImpl implements RoleService {

	private static final String FILE_NAME = "data_structure.xlsx";
	private static String filePath = "";

	public RoleServiceImpl() {
		super();
		// use this file path because in war file cannot point to resource folder, have
		// to point to folder class/...
		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
	}

	@Override
	public List<Role> GetAllRoles() {
		List<Role> listRoles = new ArrayList<>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(1);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;
			DomainService dmService = new DomainServiceImpl();
			List<Domain> listDomain = dmService.getAllDomains();
			PositionService posService = new PositionServiceImpl();
			List<Position> listPos = posService.getAllPurePositions();
			CompetencyService compService = new CompetencyServiceImpl();
			List<Competency> listComp = compService.GetAllPureCompetencies();
			
			OrganizationService orgService = new OrganizationServiceImpl();
			List<Organization> listOrg = orgService.getAllPureOrgs();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Role rl = new Role();
				
				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if(currentRow.getCell(0) != null) {
							rl.setId((long) currentRow.getCell(0).getNumericCellValue());
						}
						
						if(currentRow.getCell(1) != null) {
							for(Domain dm: listDomain) {
								if((long) currentRow.getCell(1).getNumericCellValue() == dm.getId()) {
									rl.setDomainObj(dm);
								}
							}
						}
						
						if(currentRow.getCell(2) != null) {
							for(Organization org: listOrg) {
								if((long) currentRow.getCell(1).getNumericCellValue() == org.getId()) {
									rl.setOrgObj(org);
								}
							}
						}
						
						
						if(currentRow.getCell(3) != null) {
							rl.setCareerPath(currentRow.getCell(3).getStringCellValue());
						}
						
						if(currentRow.getCell(4) != null) {
							for(Position pos: listPos) {
								if((long) currentRow.getCell(4).getNumericCellValue() == pos.getId()) {
									rl.setPositionObj(pos);
								}
							}
						}
						
						if(currentRow.getCell(5) != null) {
							rl.setDomainRole(currentRow.getCell(5).getStringCellValue());
						}
						if(currentRow.getCell(6) != null) {
							rl.setCategory(currentRow.getCell(6).getStringCellValue());
						}
						
						if(currentRow.getCell(7) != null && !currentRow.getCell(7).getStringCellValue().equals("")) {
							List<Competency> listCompsByRole = new ArrayList<>();
							Util util = new Util();
							List<Long> listCompIds = util.ListStringToListLong(currentRow.getCell(7).getStringCellValue());
							for(Competency comp: listComp) {
								if(listCompIds.contains(comp.getId())) {
									listCompsByRole.add(comp);
								}
							}
							rl.setCompetencyObj(listCompsByRole);
						}
						
						if(currentRow.getCell(8) != null) {
							rl.setKRA(currentRow.getCell(8).getStringCellValue());
						}
						if(currentRow.getCell(9) != null) {
							rl.setScope(currentRow.getCell(9).getStringCellValue());
						}
						if(currentRow.getCell(10) != null) {
							rl.setResponsibilities(currentRow.getCell(10).getStringCellValue());
						}
						if(currentRow.getCell(11) != null) {
							rl.setIndustrialRle(currentRow.getCell(11).getStringCellValue());
						}
						if(currentRow.getCell(12) != null) {
							rl.setEntryCriteria(currentRow.getCell(12).getStringCellValue());
						}
						
						listRoles.add(rl);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listRoles;
	}

	@Override
	public Role GetRoleById(long id) {
		Role rl = new Role();
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(1);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;
			DomainService dmService = new DomainServiceImpl();
			List<Domain> listDomain = dmService.getAllDomains();
			PositionService posService = new PositionServiceImpl();
			List<Position> listPos = posService.getAllPurePositions();
			CompetencyService compService = new CompetencyServiceImpl();
			List<Competency> listComp = compService.GetAllCompetencies();
			OrganizationService orgService = new OrganizationServiceImpl();
			List<Organization> listOrg = orgService.getAllPureOrgs();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0).getNumericCellValue() == id) {
							if(currentRow.getCell(0) != null) {
								rl.setId((long) currentRow.getCell(0).getNumericCellValue());
							}
							
							if(currentRow.getCell(1) != null) {
								for(Domain dm: listDomain) {
									if((long) currentRow.getCell(1).getNumericCellValue() == dm.getId()) {
										rl.setDomainObj(dm);
									}
								}
							}
							
							if(currentRow.getCell(2) != null) {
								for(Organization org: listOrg) {
									if((long) currentRow.getCell(1).getNumericCellValue() == org.getId()) {
										rl.setOrgObj(org);
									}
								}
							}
							
							
							if(currentRow.getCell(3) != null) {
								rl.setCareerPath(currentRow.getCell(3).getStringCellValue());
							}
							
							if(currentRow.getCell(4) != null) {
								for(Position pos: listPos) {
									if((long) currentRow.getCell(4).getNumericCellValue() == pos.getId()) {
										rl.setPositionObj(pos);
									}
								}
							}
							
							if(currentRow.getCell(5) != null) {
								rl.setDomainRole(currentRow.getCell(5).getStringCellValue());
							}
							if(currentRow.getCell(6) != null) {
								rl.setCategory(currentRow.getCell(6).getStringCellValue());
							}
							
							if(currentRow.getCell(7) != null && !currentRow.getCell(7).getStringCellValue().equals("")) {
								List<Competency> listCompsByRole = new ArrayList<>();
								Util util = new Util();
								List<Long> listCompIds = util.ListStringToListLong(currentRow.getCell(7).getStringCellValue());
								for(Competency comp: listComp) {
									if(listCompIds.contains(comp.getId())) {
										listCompsByRole.add(comp);
									}
								}
								rl.setCompetencyObj(listCompsByRole);
							}
							
							if(currentRow.getCell(8) != null) {
								rl.setKRA(currentRow.getCell(8).getStringCellValue());
							}
							if(currentRow.getCell(9) != null) {
								rl.setScope(currentRow.getCell(9).getStringCellValue());
							}
							if(currentRow.getCell(10) != null) {
								rl.setResponsibilities(currentRow.getCell(10).getStringCellValue());
							}
							if(currentRow.getCell(11) != null) {
								rl.setIndustrialRle(currentRow.getCell(11).getStringCellValue());
							}
							if(currentRow.getCell(12) != null) {
								rl.setEntryCriteria(currentRow.getCell(12).getStringCellValue());
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rl;
	}

	@Override
	public boolean DeleteRole(long id) {
		boolean isDeleted = false;
		try {
			File file = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(1);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				int rowIndex = currentRow.getRowNum();
				int lastRowNum = datatypeSheet.getLastRowNum();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if(currentRow.getCell(0) != null) {
							if (currentRow.getCell(0).getNumericCellValue() == id) {
								datatypeSheet.removeRow(datatypeSheet.getRow(rowIndex));
								FileOutputStream out = new FileOutputStream(file);
								workbook.write(out);

								if (rowIndex > 0 && rowIndex < lastRowNum) {
									datatypeSheet.shiftRows(rowIndex + 1, lastRowNum, -1);
								}
								isDeleted = true;
							}
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

	@Override
	public boolean UpdateRole(Role rl) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(1);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {
				Row row = iterator.next();
				int columnCount = 0;

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (row.getCell(0).getNumericCellValue() == rl.getId()) {
							Cell cell = row.createCell(columnCount);
							cell.setCellValue(row.getRowNum());
							cell = row.createCell(0);
							cell.setCellValue(rl.getId());
							cell = row.createCell(1);
							cell.setCellValue(rl.getDomain());
							cell = row.createCell(2);
							cell.setCellValue(rl.getCareerPath());
							cell = row.createCell(3);
							cell.setCellValue(rl.getPosition());
							cell = row.createCell(4);
							cell.setCellValue(rl.getDomainRole());
							cell = row.createCell(5);
							cell.setCellValue(rl.getCategory());
							cell = row.createCell(6);
							cell.setCellValue(rl.getCompetency());
							cell = row.createCell(7);
							cell.setCellValue(rl.getKRA());
							cell = row.createCell(8);
							cell.setCellValue(rl.getScope());
							cell = row.createCell(9);
							cell.setCellValue(rl.getResponsibilities());
							cell = row.createCell(10);
							cell.setCellValue(rl.getIndustrialRle());
							cell = row.createCell(11);
							cell.setCellValue(rl.getEntryCriteria());
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
	public boolean AddRole(Role rl) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(1);
			
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
			cell.setCellValue(rl.getDomain());
			cell = row.createCell(2);
			cell.setCellValue(rl.getCareerPath());
			cell = row.createCell(3);
			cell.setCellValue(rl.getPosition());
			cell = row.createCell(4);
			cell.setCellValue(rl.getDomainRole());
			cell = row.createCell(5);
			cell.setCellValue(rl.getCategory());
			cell = row.createCell(6);
			cell.setCellValue(rl.getCompetency());
			cell = row.createCell(7);
			cell.setCellValue(rl.getKRA());
			cell = row.createCell(8);
			cell.setCellValue(rl.getScope());
			cell = row.createCell(9);
			cell.setCellValue(rl.getResponsibilities());
			cell = row.createCell(10);
			cell.setCellValue(rl.getIndustrialRle());
			cell = row.createCell(11);
			cell.setCellValue(rl.getEntryCriteria());
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

}
