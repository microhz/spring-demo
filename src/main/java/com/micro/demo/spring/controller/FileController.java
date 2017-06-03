package com.micro.demo.spring.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mapc 
 * @date 2017年6月2日
 */
@RestController
public class FileController {

	@RequestMapping(value = "/upload",produces = "application/*")
	@ResponseBody
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
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam("fileId") String fileId) {
		String filePath = "/Users/micro/Downloads/hosts.zip";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		File file = new File(filePath);
		try {
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.ACCEPTED);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
