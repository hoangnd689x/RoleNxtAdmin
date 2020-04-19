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

import com.orgchart.orgchart.model.CareerPath;
import com.orgchart.orgchart.service.CareerPathService;

/**
 * @author YOG1HC
 *
 */
public class CareerPathServiceImpl implements CareerPathService {

	private static final String FILE_NAME = "data_structure.xlsx";
	private static String filePath = "";

	public CareerPathServiceImpl() {
		super();
		// use this file path because in war file cannot point to resource folder, have
		// to point to folder class/...
		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
	}

	@Override
	public List<CareerPath> GetAllCareerpaths() {
		List<CareerPath> listCareerPath = new ArrayList<>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(6);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				CareerPath cp = new CareerPath();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0) != null) {
							cp.setId((long) currentRow.getCell(0).getNumericCellValue());
						}
						if (currentRow.getCell(1) != null) {
							cp.setName(currentRow.getCell(1).toString());
						}
						if (currentRow.getCell(2) != null) {
							cp.setColor(currentRow.getCell(2).toString());
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					listCareerPath.add(cp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listCareerPath;
	}

	@Override
	public CareerPath GetCPById(long id) {
		CareerPath cp = new CareerPath();
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(6);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0).getNumericCellValue() == id) {
							if (currentRow.getCell(0) != null) {
								cp.setId((long) currentRow.getCell(0).getNumericCellValue());
							}
							if (currentRow.getCell(1) != null) {
								cp.setName(currentRow.getCell(1).toString());
							}
							if (currentRow.getCell(2) != null) {
								cp.setColor(currentRow.getCell(2).toString());
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
		return cp;
	}

	@Override
	public boolean DeleteCP(long id) {
		boolean isDeleted = false;
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(6);
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

	@Override
	public boolean UpdateCP(CareerPath cpUpdate) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(6);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {
				Row row = iterator.next();
				int columnCount = 0;

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (row.getCell(0).getNumericCellValue() == cpUpdate.getId()) {
							Cell cell = row.createCell(columnCount);
							cell.setCellValue(row.getRowNum());
							cell = row.createCell(0);
							cell.setCellValue(cpUpdate.getId());
							cell = row.createCell(1);
							cell.setCellValue(cpUpdate.getName());
							cell = row.createCell(2);
							cell.setCellValue(cpUpdate.getColor());
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
	public boolean AddCP(CareerPath cp) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(6);

			int rowCount = datatypeSheet.getLastRowNum();

			// get the biggest id and +1 to create a new Organization
			Row lastRow = datatypeSheet.getRow(rowCount);
			long biggestId = 0;
			Cell firstCell = lastRow.getCell(0);
			if (firstCell != null && firstCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				biggestId = (long) lastRow.getCell(0).getNumericCellValue();
			} else {
				biggestId = 999;
			}

			Row row = datatypeSheet.createRow(++rowCount);

			Cell cell = row.createCell(rowCount);
			cell.setCellValue(row.getRowNum());
			cell = row.createCell(0);
			cell.setCellValue(biggestId + 1);
			cell = row.createCell(1);
			cell.setCellValue(cp.getName());
			cell = row.createCell(2);
			cell.setCellValue(cp.getColor());
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

}
