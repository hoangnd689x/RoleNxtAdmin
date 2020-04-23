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
import com.orgchart.orgchart.service.CompetencyService;
import com.orgchart.orgchart.service.DomainService;

/**
 * @author YOG1HC
 *
 */
//public class CompetencyServiceImpl implements CompetencyService {
//
//	private static final String FILE_NAME = "data_structure.xlsx";
//	private static String filePath = "";
//
//	public CompetencyServiceImpl() {
//		super();
//		// use this file path because in war file cannot point to resource folder, have
//		// to point to folder class/...
//		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
//	}
//
//	@Override
//	public List<Competency> GetAllCompetencies() {
//		List<Competency> listCompetency = new ArrayList<>();
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//			DomainService dmService = new DomainServiceImpl();
//			List<Domain> listDomain = dmService.getAllDomains();
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				Iterator<Cell> cellIterator = currentRow.iterator();
//				Competency comp = new Competency();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//
//						if (currentRow.getCell(0) != null) {
//							comp.setId((long) currentRow.getCell(0).getNumericCellValue());
//						}
//						if (currentRow.getCell(1) != null) {
//							comp.setName(currentRow.getCell(1).toString());
//						}
//						if (currentRow.getCell(2) != null) {
//							comp.setCategory(currentRow.getCell(2).toString());
//						}
//
//						if (currentRow.getCell(3) != null) {
//							for (Domain dm : listDomain) {
//								if ((long) currentRow.getCell(3).getNumericCellValue() == dm.getId()) {
//									comp.setDmOjb(dm);
//								}
//							}
//						}
//
//						listCompetency.add(comp);
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//
//		return listCompetency;
//	}
//
//	@Override
//	public List<Competency> GetAllPureCompetencies() {
//		List<Competency> listCompetency = new ArrayList<>();
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//			DomainService dmService = new DomainServiceImpl();
//			List<Domain> listDomain = dmService.getAllDomains();
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				Iterator<Cell> cellIterator = currentRow.iterator();
//				Competency comp = new Competency();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(0) != null) {
//							comp.setId((long) currentRow.getCell(0).getNumericCellValue());
//						}
//						if (currentRow.getCell(1) != null) {
//							comp.setName(currentRow.getCell(1).toString());
//						}
//						if (currentRow.getCell(2) != null) {
//							comp.setCategory(currentRow.getCell(2).toString());
//						}
//
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					listCompetency.add(comp);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//
//		return listCompetency;
//	}
//
//	@Override
//	public Competency GetCompById(long id) {
//		Competency comp = new Competency();
//		try {
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//			DomainService dmService = new DomainServiceImpl();
//			List<Domain> listDomain = dmService.getAllDomains();
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
//								comp.setId((long) currentRow.getCell(0).getNumericCellValue());
//							}
//							if (currentRow.getCell(1) != null) {
//								comp.setName(currentRow.getCell(1).toString());
//							}
//							if (currentRow.getCell(2) != null) {
//								comp.setCategory(currentRow.getCell(2).toString());
//							}
//
//							if (currentRow.getCell(3) != null) {
//								for (Domain dm : listDomain) {
//									if ((long) currentRow.getCell(3).getNumericCellValue() == dm.getId()) {
//										comp.setDmOjb(dm);
//									}
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
//		return comp;
//	}
//
//	@Override
//	public boolean DeleteComp(long id) {
//		boolean isDeleted = false;
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
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
//	public boolean UpdateComp(Competency compUpdate) {
//		boolean isUpdated = false;
//		try {
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
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
//						if (row.getCell(0).getNumericCellValue() == compUpdate.getId()) {
//							Cell cell = row.createCell(columnCount);
//							cell.setCellValue(row.getRowNum());
//							cell = row.createCell(0);
//							cell.setCellValue(compUpdate.getId());
//							cell = row.createCell(1);
//							cell.setCellValue(compUpdate.getName());
//							cell = row.createCell(2);
//							cell.setCellValue(compUpdate.getCategory());
//							cell = row.createCell(3);
//							cell.setCellValue(compUpdate.getDm());
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
//	public boolean AddComp(Competency comp) {
//		boolean isUpdated = false;
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
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
//			cell.setCellValue(comp.getName());
//			cell = row.createCell(2);
//			cell.setCellValue(comp.getCategory());
//			cell = row.createCell(3);
//			cell.setCellValue(comp.getDm());
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
//	public List<Competency> GetCompetenciesByDomainId(long id) {
//		List<Competency> listCompetency = new ArrayList<>();
//		try {
//			File file = new File(filePath);
//
//			FileInputStream inputStream = new FileInputStream(file);
//
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			Sheet datatypeSheet = workbook.getSheetAt(3);
//			Iterator<Row> iterator = datatypeSheet.iterator();
//			boolean firstRow = true;
//			DomainService dmService = new DomainServiceImpl();
//			List<Domain> listDomain = dmService.getAllDomains();
//
//			while (iterator.hasNext()) {
//
//				Row currentRow = iterator.next();
//				Iterator<Cell> cellIterator = currentRow.iterator();
//				Competency comp = new Competency();
//
//				if (firstRow) {
//					firstRow = false;
//				} else {
//					try {
//						if (currentRow.getCell(3) != null) {
//							if ((long) currentRow.getCell(3).getNumericCellValue() == id) {
//								if (currentRow.getCell(0) != null) {
//									comp.setId((long) currentRow.getCell(0).getNumericCellValue());
//								}
//								if (currentRow.getCell(1) != null) {
//									comp.setName(currentRow.getCell(1).toString());
//								}
//								if (currentRow.getCell(2) != null) {
//									comp.setCategory(currentRow.getCell(2).toString());
//								}
//								for (Domain dm : listDomain) {
//									if ((long) currentRow.getCell(3).getNumericCellValue() == dm.getId()) {
//										comp.setDmOjb(dm);
//									}
//								}
//								listCompetency.add(comp);
//							}
//						}
//
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return listCompetency;
//	}
//
//}
