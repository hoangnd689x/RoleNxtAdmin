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

import com.orgchart.orgchart.model.Connection;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.service.ConnectionService;
import com.orgchart.orgchart.service.OrganizationService;

/**
 * @author YOG1HC
 *
 */
public class ConnectionServiceImpl implements ConnectionService {

	private static final String FILE_NAME = "data_structure.xlsx";
	private static String filePath = "";

	public ConnectionServiceImpl() {
		super();
		// use this file path because in war file cannot point to resource folder, have
		// to point to folder class/...
		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
	}

	@Override
	public List<Connection> GetAllConnections() {
		List<Connection> listDomain = new ArrayList<>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(7);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Connection con = new Connection();
				OrganizationService orgService = new OrganizationServiceImpl();
				List<Organization> listOrganization = orgService.getAllPureOrgs();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0) != null) {
							con.setId((long) currentRow.getCell(0).getNumericCellValue());
						}
						if (currentRow.getCell(1) != null) {
							con.setSource((long) currentRow.getCell(1).getNumericCellValue());
						}

						if (currentRow.getCell(2) != null) {
							con.setTarget((long) currentRow.getCell(2).getNumericCellValue());
						}

						for (Organization org : listOrganization) {
							if ((long) currentRow.getCell(2).getNumericCellValue() == org.getId()) {
								con.setOrgObj(org);
							}
						}
						listDomain.add(con);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listDomain;
	}

	
@Override
	public boolean AddCon(List<Connection> cons) {
		boolean isUpdated = false;
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(7);
			for (Connection con : cons) {
	            // start loop
	            int rowCount = datatypeSheet.getLastRowNum();

				// get the biggest id and +1 to create a new connection
				Row lastRow = datatypeSheet.getRow(rowCount);
				long biggestId = 0;
				long departmentID = (long)con.getOrgID();
				if(rowCount>0) {
					Cell firstCell = lastRow.getCell(0);
					if(rowCount!=0) {
						if (firstCell != null) {
							biggestId = (long) lastRow.getCell(0).getNumericCellValue();
						} else {
							biggestId = 999;
						}
					}
				}
				
				
				
				// check if a connection is exist --> dont add
				boolean isDuplicate = false;
				List<Connection> listConn = this.GetAllConnectionsByDepartmentID(departmentID);
				if(listConn != null & !listConn.isEmpty()) {
					for (Connection conn : listConn) {
						if(conn.getSource() == con.getSource() && conn.getTarget() == con.getTarget()) {
							isDuplicate = true;
						}
					}
				}
				
				
				if(!isDuplicate) {
					Row row = datatypeSheet.createRow(++rowCount);
					Cell cell = row.createCell(rowCount);
					cell.setCellValue(row.getRowNum());
					cell = row.createCell(0);
					cell.setCellValue(biggestId + 1);
					cell = row.createCell(1);
					cell.setCellValue(con.getSource());
					cell = row.createCell(2);
					cell.setCellValue(con.getTarget());
					cell = row.createCell(3);
					cell.setCellValue(con.getOrgID());
					FileOutputStream out = new FileOutputStream(file);
					workbook.write(out);
					out.close();
					isUpdated = true;	
				}
	            //end loop
	        }
			inputStream.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}
		@Override
		public List<Connection> GetAllConnectionsByDepartmentID(long id) {
			long departmentID=id;
			List<Connection> listConnection = new ArrayList<>();
			try {
				File file = new File(filePath);
	
				FileInputStream inputStream = new FileInputStream(file);
	
				Workbook workbook = new XSSFWorkbook(inputStream);
				Sheet datatypeSheet = workbook.getSheetAt(7);
				Iterator<Row> iterator = datatypeSheet.iterator();
				boolean firstRow = true;
	
				while (iterator.hasNext()) {
	
					Row currentRow = iterator.next();
					Iterator<Cell> cellIterator = currentRow.iterator();
					Connection con = new Connection();
					OrganizationService orgService = new OrganizationServiceImpl();
					List<Organization> listOrganization = orgService.getAllPureOrgs();
	
					if (firstRow) {
						firstRow = false;
					} else {
						try {
							// check if it's needed departmentID
							if ((long) currentRow.getCell(3).getNumericCellValue() != departmentID) {
								continue;
							}
							if (currentRow.getCell(0) != null) {
								con.setId((long) currentRow.getCell(0).getNumericCellValue());
							}
							if (currentRow.getCell(1) != null) {
								con.setSource((long) currentRow.getCell(1).getNumericCellValue());
							}
	
							if (currentRow.getCell(2) != null) {
								con.setTarget((long) currentRow.getCell(2).getNumericCellValue());
							}
	
							for (Organization org : listOrganization) {
								if ((long) currentRow.getCell(3).getNumericCellValue() == org.getId()) {
									con.setOrgObj(org);
								}
							}
							listConnection.add(con);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
	
			} catch (Exception e) {
				e.printStackTrace();
	
			}
	
			return listConnection;
		}
}
