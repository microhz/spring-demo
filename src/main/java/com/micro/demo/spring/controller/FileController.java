package com.micro.demo.spring.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mapc 
 * @date 2017年6月2日
 */
@RestController
public class FileController {

	@RequestMapping(value = "/upload",produces = "application/*")
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		try {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());
			Iterator<Sheet> iterator = hssfWorkbook.iterator();
			List<ArrayList<Object>> contentList = new ArrayList<ArrayList<Object>>();
			
			int rowIndex = 0;
			while (iterator.hasNext()) {
				Sheet sheet = iterator.next();
				if (sheet instanceof HSSFSheet) {
					HSSFSheet hssfSheet = (HSSFSheet) sheet;
					Iterator<Row> rowIterator = hssfSheet.iterator();
					while (rowIterator.hasNext()) {
						int quenIndex = 0;
						rowIndex ++;
						Row row = rowIterator.next();
						if (row instanceof HSSFRow) {
							HSSFRow hssfRow = (HSSFRow) row;
							int columns = hssfRow.getLastCellNum();
							if (columns > 0) {
								ArrayList<Object> rowList = new ArrayList<Object>();
								for (int i = 0;i < columns;i ++) {
									System.out.println("add the content row => " + rowIndex + ", quenIndex => " + quenIndex);
									try {
										rowList.add(hssfRow.getCell(i).getStringCellValue());
									} catch (Exception ex) {
										// is a numeric
										rowList.add(hssfRow.getCell(i).getNumericCellValue());
									}
									
									quenIndex ++;
								}
								System.out.println(rowList);
								contentList.add(rowList);
							}
						}
					}
				}
				System.out.println("---");
			}
			hssfWorkbook.close();
			
			System.out.println(contentList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
