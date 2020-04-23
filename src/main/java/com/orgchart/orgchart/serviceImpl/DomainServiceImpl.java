//package com.orgchart.orgchart.serviceImpl;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.orgchart.orgchart.model.Domain;
//import com.orgchart.orgchart.model.Organization;
//import com.orgchart.orgchart.service.DomainService;
//
///**
// * @author YOG1HC
// *
// */
//public class DomainServiceImpl implements DomainService {
//
//	private static final String FILE_NAME = "data_structure.xlsx";
//	private static String filePath = "";
//
//	public DomainServiceImpl() {
//		super();
//		// use this file path because in war file cannot point to resource folder, have
//		// to point to folder class/...
//		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
//	}
//
//	@Override
//	public List<Domain> getAllDomains() {
//		List<Domain> listDomain = new ArrayList<>();
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(5);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				Iterator<Cell> cellIterator = currentRow.iterator();
//				Domain dm = new Domain();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(0) != null) {
//							dm.setId((int) currentRow.getCell(0).getNumericCellValue());
//						}
//						if (currentRow.getCell(1) != null) {
//							dm.setName(currentRow.getCell(1).toString());
//						}
//
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					listDomain.add(dm);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//
//		return listDomain;
//	}
//
//	@Override
//	public Domain getDmById(long id) {
//		Domain dm = new Domain();
//		try {
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(5);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(0).getNumericCellValue() == id) {
//							if (currentRow.getCell(0) != null) {
//								dm.setId((int) currentRow.getCell(0).getNumericCellValue());
//							}
//							if (currentRow.getCell(1) != null) {
//								dm.setName(currentRow.getCell(1).toString());
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
//		return dm;
//	}
//
//	@Override
//	public boolean deleteDm(long id) {
//		boolean isDeleted = false;
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(5);
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
//	public boolean UpdateDm(Domain dmUpdate) {
//		boolean isUpdated = false;
//		try {
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(5);
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
//						if (row.getCell(0).getNumericCellValue() == dmUpdate.getId()) {
//							Cell cell = row.createCell(columnCount);
//							cell.setCellValue(row.getRowNum());
//							cell = row.createCell(0);
//							cell.setCellValue(dmUpdate.getId());
//							cell = row.createCell(1);
//							cell.setCellValue(dmUpdate.getName());
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
//	public boolean AddDm(Domain dm) {
//		boolean isUpdated = false;
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(5);
//
//			int rowCount = datatypeSheet.getLastRowNum();
//
//			// get the biggest id and +1 to create a new Organization
//			Row lastRow = datatypeSheet.getRow(rowCount);
//			long biggestId = 0;
//			Cell firstCell = lastRow.getCell(0);
//			if (firstCell != null && firstCell.getCellType() != Cell.CELL_TYPE_BLANK) {
//				biggestId = (long) lastRow.getCell(0).getNumericCellValue();
//			} else {
//				biggestId = 999;
//			}
//
//			Row row = datatypeSheet.createRow(++rowCount);
//
//			Cell cell = row.createCell(rowCount);
//			cell.setCellValue(row.getRowNum());
//			cell = row.createCell(0);
//			cell.setCellValue(biggestId + 1);
//			cell = row.createCell(1);
//			cell.setCellValue(dm.getName());
//			inputStream.close();
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
//	@Override
//	public List<Organization> GetOrgsByDomainId(long id) {
//		List<Organization> listDepartment = new ArrayList<>();
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(2);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				Organization org = new Organization();
//
//				DomainService dmService = new DomainServiceImpl();
//				List<Domain> listDomain = dmService.getAllDomains();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(2) != null) {
//							if ((long) currentRow.getCell(2).getNumericCellValue() == id) {
//								org.setId((long) currentRow.getCell(0).getNumericCellValue());
//								org.setName(currentRow.getCell(1).getStringCellValue());
//
//								for (Domain dm : listDomain) {
//									if ((long) currentRow.getCell(2).getNumericCellValue() == dm.getId()) {
//										org.setDomainObj(dm);
//									}
//								}
//								org.setBusinessSector(currentRow.getCell(3).getStringCellValue());
//								listDepartment.add(org);
//							}
//						}
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listDepartment;
//	}
//
//}
