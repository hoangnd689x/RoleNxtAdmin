package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orgchart.orgchart.model.CareerPath;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.service.CareerPathService;
import com.orgchart.orgchart.service.OrganizationService;
import com.orgchart.orgchart.service.PositionService;

/**
 * @author YOG1HC
 *
 */
public class PositionServiceImpl implements PositionService {

	private static final String FILE_NAME = "data_structure.xlsx";
	private static String filePath = "";

	public PositionServiceImpl() {
		super();
		// use this file path because in war file cannot point to resource folder, have
		// to point to folder class/...
		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
	}

	@Override
	public List<Position> getAllPositions() {
		List<Position> listPosition = new ArrayList<>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			OrganizationService orgService = new OrganizationServiceImpl();
			List<Organization> listOrgs = orgService.getAllPureOrgs();
			CareerPathService cpService = new CareerPathServiceImpl();
			List<CareerPath> listCPs = cpService.GetAllCareerpaths();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Position pos = new Position();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0) != null) {
							pos.setId((long) currentRow.getCell(0).getNumericCellValue());
						}
						if (currentRow.getCell(1) != null) {
							for (Organization org : listOrgs) {
								if ((long) currentRow.getCell(1).getNumericCellValue() == org.getId()) {
									pos.setOrganizationObj(org);
								}
							}
						}
						if (currentRow.getCell(2) != null) {
							pos.setName(currentRow.getCell(2).toString());
						}
						if (currentRow.getCell(3) != null) {
							for (CareerPath cp : listCPs) {
								if ((long) currentRow.getCell(3).getNumericCellValue() == cp.getId()) {
									pos.setCareerpathObj(cp);
								}
							}
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					listPosition.add(pos);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listPosition;
	}

	@Override
	public List<Position> getAllPurePositions() {
		List<Position> listPosition = new ArrayList<>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Position pos = new Position();

				if (firstRow) {
					firstRow = false;
				} else {
					if (currentRow.getCell(0) != null) {
						pos.setId((long) currentRow.getCell(0).getNumericCellValue());
					}
					if (currentRow.getCell(2) != null) {
						pos.setName(currentRow.getCell(2).toString());
					}
					listPosition.add(pos);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listPosition;
	}

	@Override
	public Position getPosById(long id) {
		Position pos = new Position();
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			OrganizationService orgService = new OrganizationServiceImpl();
			List<Organization> listOrgs = orgService.getAllOrgs();
			CareerPathService cpService = new CareerPathServiceImpl();
			List<CareerPath> listCPs = cpService.GetAllCareerpaths();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0).getNumericCellValue() == id) {
							if (currentRow.getCell(0) != null) {
								pos.setId((long) currentRow.getCell(0).getNumericCellValue());
							}
							if (currentRow.getCell(1) != null) {
								for (Organization org : listOrgs) {
									if ((long) currentRow.getCell(1).getNumericCellValue() == org.getId()) {
										pos.setOrganizationObj(org);
									}
								}
							}
							if (currentRow.getCell(2) != null) {
								pos.setName(currentRow.getCell(2).toString());
							}
							if (currentRow.getCell(3) != null) {
								for (CareerPath cp : listCPs) {
									if ((long) currentRow.getCell(3).getNumericCellValue() == cp.getId()) {
										pos.setCareerpathObj(cp);
									}
								}
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
		return pos;
	}

	@Override
	public boolean deletePos(long id) {
		boolean isDeleted = false;
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);
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
	public boolean UpdatePos(Position posUpdate) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {
				Row row = iterator.next();
				int columnCount = 0;

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (row.getCell(0).getNumericCellValue() == posUpdate.getId()) {
							Cell cell = row.createCell(columnCount);
							cell.setCellValue(row.getRowNum());
							cell = row.createCell(0);
							cell.setCellValue(posUpdate.getId());
							cell = row.createCell(1);
							cell.setCellValue(posUpdate.getOrganization());
							cell = row.createCell(2);
							cell.setCellValue(posUpdate.getName());
							cell = row.createCell(3);
							cell.setCellValue(posUpdate.getCareerPath());
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
	public boolean AddPos(Position posUpdate) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);

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
			cell.setCellValue(posUpdate.getOrganization());
			cell = row.createCell(2);
			cell.setCellValue(posUpdate.getName());
			cell = row.createCell(3);
			cell.setCellValue(posUpdate.getCareerPath());
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
	public List<Position> getPositionsByOrgId(long orgId) {
		List<Position> listPosition = new ArrayList<>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(4);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			OrganizationService orgService = new OrganizationServiceImpl();
			List<Organization> listOrgs = orgService.getAllPureOrgs();
			CareerPathService cpService = new CareerPathServiceImpl();
			List<CareerPath> listCPs = cpService.GetAllCareerpaths();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Position pos = new Position();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(1) != null) {
							if ((long) currentRow.getCell(1).getNumericCellValue() == orgId) {
								if (currentRow.getCell(0) != null) {
									pos.setId((long) currentRow.getCell(0).getNumericCellValue());
								}
								if (currentRow.getCell(1) != null) {
									for (Organization org : listOrgs) {
										if ((long) currentRow.getCell(1).getNumericCellValue() == org.getId()) {
											pos.setOrganizationObj(org);
										}
									}
								}
								if (currentRow.getCell(2) != null) {
									pos.setName(currentRow.getCell(2).toString());
								}
								if (currentRow.getCell(3) != null) {
									for (CareerPath cp : listCPs) {
										if ((long) currentRow.getCell(3).getNumericCellValue() == cp.getId()) {
											pos.setCareerpathObj(cp);
										}
									}
								}
								listPosition.add(pos);
							}
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listPosition;
	}
}
