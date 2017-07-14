package com.xiaoyulaoshishuo.app.kq.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.xiaoyulaoshishuo.app.kq.model.AccountFile;
import com.xiaoyulaoshishuo.app.kq.support.FileTypeEnum;


/**
 * @author mapc 
 * @date 2017年6月14日
 */
public interface FileService {

	boolean uploadFile(InputStream inputStream,String fileName, String originName, Integer fileTypeEnum);
	
	boolean uploadFile(InputStream inputStream,String fileName, String originName, Integer fileTypeEnum, Long accountId);
	
	public List<AccountFile> getFileUrl(Integer fileTypeEnum, Long accountId);
	
	AccountFile getFileById(Integer fileId);
	
	FileTypeEnum getFileTypeEnumByCode(Integer type);
	
	String getFileSuffix(String fileName) throws UnsupportedEncodingException;
	
	public boolean uploadExcel(InputStream inputStream, Integer type, Long accountId, boolean isXSS) throws Exception;
}
