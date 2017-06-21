package com.xiaoyulaoshishuo.app.kq.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xiaoyulaoshishuo.app.kq.model.AccountFile;
import com.xiaoyulaoshishuo.app.kq.model.AccountFileExample;
import com.xiaoyulaoshishuo.app.kq.model.AccountRecord;
import com.xiaoyulaoshishuo.app.kq.service.FileService;
import com.xiaoyulaoshishuo.app.kq.support.BaseService;
import com.xiaoyulaoshishuo.app.kq.support.FileTypeEnum;
import com.xiaoyulaoshishuo.app.kq.utils.DateUtils;

/**
 * @author mapc
 * @date 2017年6月14日
 */
@Service
public class FileServiceImpl extends BaseService implements FileService {

	private String searchDownloadName = "-searchDownload-";

	@Value("${jyxb.kq.filePath}")
	private String filePath;
	
	private DecimalFormat df = new DecimalFormat("0");

	public boolean uploadFile(InputStream inputStream, String fileName, String originName, Integer fileType) {
		return true;
	}

	public FileTypeEnum getFileTypeEnumByCode(Integer type) {
		for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
			if (type.equals(fileTypeEnum.getCode())) {
				return fileTypeEnum;
			}
		}
		return null;
	}

	public String getFileSuffix(String fileName) throws UnsupportedEncodingException {
		fileName = new String(fileName.getBytes(), "UTF-8");
		if (fileName.lastIndexOf(".") == -1) {
			return fileName;
		}
		return fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}

	public List<AccountFile> getFileUrl(Integer fileType, Long accountId) {
		AccountFileExample accountFileExample = new AccountFileExample();
		accountFileExample.or().andAccountidEqualTo(accountId).andTypeEqualTo(fileType);
		return accountFileMapper.selectByExample(accountFileExample);
	}

	public boolean uploadFile(InputStream inputStream, String fileName, String originName, Integer fileType,
			Long accountId) {
		boolean uploadSuccess = false;
		logger.debug("start to file upload, fileName : " + fileName + ", fileType : "
				+ getFileTypeEnumByCode(fileType).getName());
		try {
			if (StringUtils.isEmpty(fileName)) {
				fileName = DateUtils.getFileDateTimeStamps() + searchDownloadName + getFileSuffix(originName);
			}
			byte[] dataByte = new byte[inputStream.available()];
			inputStream.read(dataByte);
			OutputStream outputStream = null;
			String path = null;
			try {
				path = filePath + fileName;
				outputStream = new FileOutputStream(new File(path));
				outputStream.write(dataByte);
			} catch (Exception ex) {
				logger.error("文件上传异常", ex);
				uploadSuccess = false;
			} finally {
				if (outputStream != null) {
					outputStream.close();
				}
			}
			AccountFile accountFile = new AccountFile();
			accountFile.setAccountFileName(originName);
			accountFile.setAccountid(accountId);
			accountFile.setDate(new Date());
			accountFile.setFileUrl(path);
			accountFile.setType(fileType);
			accountFileMapper.insert(accountFile);
			uploadSuccess = true;
		} catch (IOException e) {
			logger.error("文件上传异常", e);
			uploadSuccess = false;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("文件流关闭异常", e);
					e.printStackTrace();
				}
			}
		}
		return uploadSuccess;
	}

	public AccountFile getFileById(Integer fileId) {
		return accountFileMapper.selectByPrimaryKey(fileId);
	}

	public boolean uploadExcel(InputStream inputStream, Integer type, Long accountId, boolean isXSS) throws Exception {
		HSSFWorkbook hssfWorkbook = null;
//		XSSFWorkbook xssfWorkbook = null;
		try {
			if (isXSS) {
				/*try {
					xssfWorkbook = new XSSFWorkbook(inputStream);
					Integer sheetNumber = xssfWorkbook.getNumberOfSheets();
					if (sheetNumber != null && sheetNumber > 0) {
						for (int i = 0; i < sheetNumber; i++) {
							XSSFSheet xssFSheet = null;
							xssFSheet = xssfWorkbook.getSheetAt(i);
							Iterator<Row> iterator = xssFSheet.iterator();
							while (iterator.hasNext()) {
								Row row = iterator.next();
								AccountRecord accountRecord = new AccountRecord();
								accountRecord.setAccountId(accountId);
								int rowIndex = 0;
								for (Cell cell : row) {
									switch (rowIndex) {
									case 1: {
										accountRecord
												.setOperateTime(DateUtils.pageSearchSDF.parse(cell.getStringCellValue()));
									}
									case 2: {
										accountRecord.setBatchId(cell.getStringCellValue());
									}
									}

								}
							}

						}
					}
				} catch (Exception ex) {
					isXSS = true;
				}*/
			}
			if (!isXSS) {
				hssfWorkbook = new HSSFWorkbook(inputStream);
				Integer sheetNumber = hssfWorkbook.getNumberOfSheets();
				if (sheetNumber != null && sheetNumber > 0) {
					for (int i = 0; i < sheetNumber; i++) {
						HSSFSheet hssFSheet = null;
						hssFSheet = hssfWorkbook.getSheetAt(i);
						Iterator<Row> iterator = hssFSheet.iterator();
						int rowIndex = 0;
						while (iterator.hasNext()) {
							Row row = iterator.next();
							if (rowIndex > 0) {
								AccountRecord accountRecord = new AccountRecord();
								accountRecord.setAccountId(accountId);
								int queueIndex = 0;
								for (Cell cell : row) {
									StringBuffer sb = new StringBuffer();
									sb.append("[").append(rowIndex).append("],[").append(queueIndex).append("]");
									System.out.println(sb.toString());
									logger.debug("set excel value : " + sb + " , value : " + getValueToString(cell, queueIndex));
									System.out.println("set excel value : " + sb + " , value : " + getValueToString(cell, queueIndex));
									switch (queueIndex) {
									case 0: 
										accountRecord
												.setOperateTime(DateUtils.pageSearchSDF.parse(getValueToString(cell, 0)));
										break;
									case 1: 
										accountRecord.setBatchId(String.valueOf(getValueToString(cell, 1)));
										break;
									case 2 : 
										accountRecord.setTradeNo(getValueToString(cell, 2));
										break;
									case 3 : 
										accountRecord.setTradeType(getValueToString(cell, 3));
										break;
									case 4 :
										accountRecord.setOderId(getValueToString(cell, 4));
										break;
									case 5 :
										accountRecord.setTargetName(getValueToString(cell, 5));
										break;
									case 6 : 
										accountRecord.setTargetBank(getValueToString(cell, 6));
										break;
									case 7 :
										accountRecord.setTargetBackNo(getValueToString(cell, 7));
										break;
									case 8 : 
										accountRecord.setIncome(Double.valueOf(getValueToString(cell, 8)));
										break;
									case 9 :
										accountRecord.setExpend(Double.valueOf(getValueToString(cell, 9)));
										break;
									case 10 : 
										accountRecord.setBalance(Double.valueOf(getValueToString(cell, 10)));
										break;
									case 11 : 
										accountRecord.setMoneyType(Double.valueOf(getValueToString(cell, 11)).intValue());
										break;
									case 12 : 
										accountRecord.setStartTime(DateUtils.pageSearchSDF.parse(getValueToString(cell, 12)));
										break;
									case 13 :
										accountRecord.setEndTime(DateUtils.pageSearchSDF.parse(getValueToString(cell, 13)));
										break;
									case 14 : 
										accountRecord.setProvince(getValueToString(cell, 14));
										break;
									case 15 : 
										accountRecord.setBankBranchName(getValueToString(cell, 15));
										break;
									case 16 :
										accountRecord.setPaySideName(getValueToString(cell, 16));
										break;
									case 17 :
										accountRecord.setRecieveSideName(getValueToString(cell, 17));
										break;
									case 18 :
										accountRecord.setTargetTel(getValueToString(cell, 18));
										break;
									case 19 :
										accountRecord.setTargetEmail(getValueToString(cell, 19));
										break;
									case 20 : 
										accountRecord.setAmount(Double.valueOf(getValueToString(cell, 20)));
										break;
									case 21 : 
										accountRecord.setCharge(Double.valueOf(getValueToString(cell, 21)));
										break;
									case 22 :
										accountRecord.setRealCharge(Double.valueOf(getValueToString(cell, 22)));
										break;
									case 23 : 
										accountRecord.setStatus(Double.valueOf(getValueToString(cell, 23)).intValue());
										break;
									case 24 : 
										accountRecord.setFailReason(getValueToString(cell, 24));
										break;
									case 25 :
										accountRecord.setRemark(getValueToString(cell, 25));
										break;
									}
									queueIndex ++;
								}
								accountRecordMapper.insert(accountRecord);
							} 
							rowIndex ++;
						}

					}
				}
			}
		} catch (Exception ex) {
			throw ex;

		} finally {
			if (hssfWorkbook != null) {
				hssfWorkbook.close();
			}
		}
		return true;
	}
	
	private String getValueToString(Cell cell, int column) {
		try {
			if (column == 0 || column == 12 || column == 13) {
				Date date = cell.getDateCellValue();
				return DateUtils.pageSearchSDF.format(date);
			} else {
				return cell.getStringCellValue().toString();
			}
		} catch (Exception ex) {
			String realNum = df.format(cell.getNumericCellValue());
			return realNum;
		}
	}

}
