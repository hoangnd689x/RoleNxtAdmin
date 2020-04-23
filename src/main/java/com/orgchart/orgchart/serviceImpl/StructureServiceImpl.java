//package com.orgchart.orgchart.serviceImpl;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.orgchart.orgchart.model.Connection;
//import com.orgchart.orgchart.model.Domain;
//import com.orgchart.orgchart.model.Organization;
//import com.orgchart.orgchart.model.Position;
//import com.orgchart.orgchart.model.Structure;
//import com.orgchart.orgchart.service.DomainService;
//import com.orgchart.orgchart.service.OrganizationService;
//import com.orgchart.orgchart.service.PositionService;
//import com.orgchart.orgchart.service.StructureService;
//
///**
// * @author YOG1HC
// *
// */
//public class StructureServiceImpl implements StructureService {
//
//	private static final String FILE_NAME = "data_structure.xlsx";
//	private static String filePath = "";
//	
//	public StructureServiceImpl() {
//		super();
//		// use this file path because in war file cannot point to resource folder, have
//				// to point to folder class/...
//		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
//	}
//
//	@Override
//	public List<Structure> GetAllStructures() {
//		List<Structure> listStructure = new ArrayList<>();
//		try {
//			System.out.println(FILE_NAME);
//			InputStream inputStream = getClass()
//					.getClassLoader().getResourceAsStream(FILE_NAME);
//			
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(0);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				Structure str = new Structure();
//				
//				OrganizationService orgService = new OrganizationServiceImpl();
//				List<Organization> listOrgs = orgService.getAllPureOrgs();
//				DomainService dmService = new DomainServiceImpl();
//				List<Domain> listDms = dmService.getAllDomains();
//				PositionService posService = new PositionServiceImpl();
//				List<Position> listPos = posService.getAllPurePositions();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if((long) currentRow.getCell(0).getNumericCellValue() != 0) {
//							str.setId((long) currentRow.getCell(0).getNumericCellValue());
//							for(Organization org: listOrgs) {
//								if(currentRow.getCell(1).getNumericCellValue() == org.getId()) {
//									str.setOrgObj(org);
//								}
//							}
//							
//							for(Domain dm: listDms) {
//								if(currentRow.getCell(2).getNumericCellValue() == dm.getId()) {
//									str.setDmObj(dm);
//								}
//							}
//							
//							for(Position pos: listPos) {
//								if(currentRow.getCell(3).getNumericCellValue() == pos.getId()) {
//									str.setLevel0Obj(pos);
//								}
//								if(currentRow.getCell(4).getNumericCellValue() == pos.getId()) {
//									str.setLevel1Obj(pos);
//								}
//								if(currentRow.getCell(5).getNumericCellValue() == pos.getId()) {
//									str.setLevel2Obj(pos);
//								}
//								if(currentRow.getCell(6).getNumericCellValue() == pos.getId()) {
//									str.setLevel3Obj(pos);
//								}
//								if(currentRow.getCell(7).getNumericCellValue() == pos.getId()) {
//									str.setLevel4Obj(pos);
//								}
//								if(currentRow.getCell(8).getNumericCellValue() == pos.getId()) {
//									str.setLevel5Obj(pos);
//								}
//								if(currentRow.getCell(9).getNumericCellValue() == pos.getId()) {
//									str.setLevel6Obj(pos);
//								}
//								if(currentRow.getCell(10).getNumericCellValue() == pos.getId()) {
//									str.setLevel7Obj(pos);
//								}
//							}
//							
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					listStructure.add(str);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return listStructure;
//	}
//
//	@Override
//	public Structure GetStrById(long id) {
//		Structure str = new Structure();
//		try {
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(0);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				
//				OrganizationService orgService = new OrganizationServiceImpl();
//				List<Organization> listOrgs = orgService.getAllPureOrgs();
//				DomainService dmService = new DomainServiceImpl();
//				List<Domain> listDms = dmService.getAllDomains();
//				PositionService posService = new PositionServiceImpl();
//				List<Position> listPos = posService.getAllPurePositions();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(0).getNumericCellValue() == id) {
//							str.setId(id);
//							for(Organization org: listOrgs) {
//								if(currentRow.getCell(1).getNumericCellValue() == org.getId()) {
//									str.setOrgObj(org);
//								}
//							}
//							
//							for(Domain dm: listDms) {
//								if(currentRow.getCell(2).getNumericCellValue() == dm.getId()) {
//									str.setDmObj(dm);
//								}
//							}
//							
//							for(Position pos: listPos) {
//								if(currentRow.getCell(3).getNumericCellValue() == pos.getId()) {
//									str.setLevel0Obj(pos);
//								}
//								if(currentRow.getCell(4).getNumericCellValue() == pos.getId()) {
//									str.setLevel1Obj(pos);
//								}
//								if(currentRow.getCell(5).getNumericCellValue() == pos.getId()) {
//									str.setLevel2Obj(pos);
//								}
//								if(currentRow.getCell(6).getNumericCellValue() == pos.getId()) {
//									str.setLevel3Obj(pos);
//								}
//								if(currentRow.getCell(7).getNumericCellValue() == pos.getId()) {
//									str.setLevel4Obj(pos);
//								}
//								if(currentRow.getCell(8).getNumericCellValue() == pos.getId()) {
//									str.setLevel5Obj(pos);
//								}
//								if(currentRow.getCell(9).getNumericCellValue() == pos.getId()) {
//									str.setLevel6Obj(pos);
//								}
//								if(currentRow.getCell(10).getNumericCellValue() == pos.getId()) {
//									str.setLevel7Obj(pos);
//								}
//							}
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return str;
//	}
//
//	@Override
//	public boolean DeleteStr(long id) {
//		boolean isDeleted = false;
//		try {
//			File file = new File(filePath);
//			
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(0);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				int rowIndex = currentRow.getRowNum();
//				int lastRowNum = datatypeSheet.getLastRowNum();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(0).getNumericCellValue() == id) {
//							datatypeSheet.removeRow(datatypeSheet.getRow(rowIndex));
//							FileOutputStream out = new FileOutputStream(file);
//							workbook.write(out);
//
//							if (rowIndex > 0 && rowIndex < lastRowNum) {
//								datatypeSheet.shiftRows(rowIndex + 1, lastRowNum, -1);
//							}
//							isDeleted = true;
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return isDeleted;
//	}
//
//	@Override
//	public boolean UpdateStr(Structure strUpdate) {
//		boolean isUpdated = false;
//		try {
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(0);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//				Row row = iterator.next();
//				int columnCount = 0;
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (row.getCell(0).getNumericCellValue() == strUpdate.getId()) {
//							Cell cell = row.createCell(columnCount);
//							cell.setCellValue(row.getRowNum());
//							cell = row.createCell(0);
//							cell.setCellValue(strUpdate.getId());
//							cell = row.createCell(1);
//							cell.setCellValue(strUpdate.getOrg());
//							cell = row.createCell(2);
//							cell.setCellValue(strUpdate.getDm());
//							cell = row.createCell(3);
//							cell.setCellValue(strUpdate.getLevel0());
//							cell = row.createCell(4);
//							cell.setCellValue(strUpdate.getLevel1());
//							cell = row.createCell(5);
//							cell.setCellValue(strUpdate.getLevel2());
//							cell = row.createCell(6);
//							cell.setCellValue(strUpdate.getLevel3());
//							cell = row.createCell(7);
//							cell.setCellValue(strUpdate.getLevel4());
//							cell = row.createCell(8);
//							cell.setCellValue(strUpdate.getLevel5());
//							cell = row.createCell(9);
//							cell.setCellValue(strUpdate.getLevel6());
//							cell = row.createCell(10);
//							cell.setCellValue(strUpdate.getLevel7());
//							inputStream.close();
//							FileOutputStream out = new FileOutputStream(file);
//							workbook.write(out);
//							workbook.close();
//							out.close();
//							isUpdated = true;
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return isUpdated;
//	}
//
//	@Override
//	public boolean AddStr(Structure strUpdate) {
//		boolean isUpdated = false;
//		try {
//			File file = new File(filePath);
//			System.out.println(file.getAbsolutePath());
//			
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(0);
//			
//			int rowCount = datatypeSheet.getLastRowNum();
//			
//			// get the biggest id and +1 to create a new Organization
//			Row lastRow = datatypeSheet.getRow(rowCount);
//			long biggestId = 0;
//			Cell firstCell = lastRow.getCell(0);
//	        if (firstCell != null && firstCell.getCellType() != Cell.CELL_TYPE_BLANK) {
//	        	biggestId = (long)lastRow.getCell(0).getNumericCellValue();
//	        }else {
//	        	biggestId = 999;
//	        }
//			
//			Row row = datatypeSheet.createRow(++rowCount);
//			
//			Cell cell = row.createCell(rowCount);
//			cell.setCellValue(row.getRowNum());
//			cell = row.createCell(0);
//			cell.setCellValue(biggestId + 1);
//			cell = row.createCell(1);
//			cell.setCellValue(strUpdate.getOrg());
//			cell = row.createCell(2);
//			cell.setCellValue(strUpdate.getDm());
//			cell = row.createCell(3);
//			cell.setCellValue(strUpdate.getLevel0());
//			cell = row.createCell(4);
//			cell.setCellValue(strUpdate.getLevel1());
//			cell = row.createCell(5);
//			cell.setCellValue(strUpdate.getLevel2());
//			cell = row.createCell(6);
//			cell.setCellValue(strUpdate.getLevel3());
//			cell = row.createCell(7);
//			cell.setCellValue(strUpdate.getLevel4());
//			cell = row.createCell(8);
//			cell.setCellValue(strUpdate.getLevel5());
//			cell = row.createCell(9);
//			cell.setCellValue(strUpdate.getLevel6());
//			cell = row.createCell(10);
//			cell.setCellValue(strUpdate.getLevel7());
//			FileOutputStream out = new FileOutputStream(file);
//			workbook.write(out);
//			workbook.close();
//			out.close();
//			
//			isUpdated = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return isUpdated;
//	}
//
//}
