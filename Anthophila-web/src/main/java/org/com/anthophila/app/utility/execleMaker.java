package org.com.anthophila.app.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class execleMaker {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	private static int rowNum = 4;
	private static final List<String> dateList = new ArrayList();

	public static void main(String[] args) {
		try {

			File file = new File("D:\\交通費精算書_2019.05.xls");
			setListDate();
			Workbook workbook = getWorkbook(file);
			parse_excel(workbook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Judging the version of Excel
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbook(File file) throws IOException {
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if (file.getName().endsWith(EXCEL_XLS)) { //Excel 2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	/**
	 * Read Excel test, compatible with Excel 2003/2007/2010
	 * @throws Exception
	 */
	public static void parse_excel(Workbook workbook) {
		try {
			Sheet sheet = workbook.getSheetAt(0); // 第一个工作表

			int firstRowIndex = sheet.getFirstRowNum() + 1; // 得到第一行的下标
			int lastRowIndex = sheet.getLastRowNum(); // 得到最后一行的下标

			boolean tackFlg = false;

			for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
				Row row = sheet.getRow(rIndex);
				if (row != null) {
					int firstCellIndex = row.getFirstCellNum(); // 得到第一列
					int lastCellIndex = row.getLastCellNum(); // 得到最后一列

					for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
						Cell cell = row.getCell(cIndex);

						if (cell != null && !cell.toString().equals((""))) {
							String cellStr = cell.toString().replace(".0", "");
							if (dateList.contains(cellStr) || rowNum == 4) {
								rowNum = 0;
								System.out.println(cell.toString().replace(".0", "") + "日 ");
							} else {
								rowNum++;
								if (rowNum < 4)
									System.out.print(cell + "  ");
								else
									System.out.println(cell + "  ");
							}

						} else {
							continue;
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setListDate() {
		for (int i = 1; i < 32; i++) {
			dateList.add(String.valueOf(i));
		}
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
