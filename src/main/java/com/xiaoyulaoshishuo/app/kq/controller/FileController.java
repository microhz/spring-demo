package com.xiaoyulaoshishuo.app.kq.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoyulaoshishuo.app.kq.model.AccountFile;
import com.xiaoyulaoshishuo.app.kq.support.BaseController;
import com.xiaoyulaoshishuo.app.kq.utils.ErrorMsgEnum;

/**
 * @author mapc 
 * @date 2017年6月13日
 */
@Controller
@RequestMapping("file")
public class FileController extends BaseController {
	
	// 下载查询结果
	@RequestMapping(value = "upload/searchResult",produces = "application/*")
	@ResponseBody
	public String uploadSearch(@RequestParam("file") MultipartFile multipartFile, @RequestParam(value = "fileName", required = false) String fileName, @RequestParam("fileType") Integer type) {
		try {
			InputStream inputStream = multipartFile.getInputStream();
			boolean uploadSuccess = fileService.uploadFile(inputStream, null,multipartFile.getOriginalFilename(), type);
			if (!uploadSuccess) {
				logger.error("上传文件是失败");
				return fail(ErrorMsgEnum.FILE_UPLOAD_ERROR);
			}
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			logger.error("文件上传异常", e);
		}
		return ok("上传完毕");
	}
	
	
	/**
	 * 对账查询下载
	 * @param searchType
	 * @return
	 */
	@RequestMapping("download")
	@ResponseBody
	public ResponseEntity<byte[]> download(@RequestParam("fileId") Integer fileId) {
		try {
			AccountFile accountFile = fileService.getFileById(fileId);
			if (accountFile == null) {
				return null;
			}
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);//fileService.getFileTypeEnumByCode(accountFile.getType()).getName()
			httpHeaders.setContentDispositionFormData("file",new String(fileService.getFileTypeEnumByCode(accountFile.getType()).getName().getBytes("UTF-8"), "ISO-8859-1") + fileService.getFileSuffix(accountFile.getAccountFileName()));
			File file = new File(accountFile.getFileUrl());
			try {
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.ACCEPTED);
			} catch (IOException e) {
				logger.error("download file error , fileId - > " + fileId,e);
				e.printStackTrace();
			}
			
		} catch (Exception ex) {
			logger.error("download file error , fileId - > " + fileId,ex);
		}
		return null;
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam(value = "fileName", required = false) String fileName, @RequestParam("fileType") Integer type) {
		try {
			InputStream inputStream = multipartFile.getInputStream();
			boolean uploadSuccess = fileService.uploadFile(inputStream, fileName, multipartFile.getOriginalFilename(), type, currentOperator().getId());
			if (!uploadSuccess) {
				logger.error("上传文件是失败");
				return fail(ErrorMsgEnum.FILE_UPLOAD_ERROR);
			}
			if (inputStream != null) {
				inputStream.close();
			}
			return ok("上传成功");
		} catch (Exception ex) {
			return fail("上传失败");
		}
	}
	
	/**
	 * 后台帐号excel数据上传
	 */
	@RequestMapping("uploadAccountInfo")
	@ResponseBody
	public String uploadExcel(@RequestParam("file")MultipartFile multipartFile, @RequestParam("fileType") Integer fileType) {
		try {
			if (fileType == null) {
				return fail("类型不正确");
			}
			// 判断登陆
			if (currentOperator() == null) {
				return fail(ErrorMsgEnum.USER_NOT_LOGIN);
			}
			// TODO 判断excel版本
			if (fileService.uploadExcel(multipartFile.getInputStream(), fileType, currentOperator().getId(), false)) {
				return ok();
			}
		} catch (Exception ex) {
			logger.error("excel文件上传异常",ex);
		}
		return fail("文件上传异常");
	}
}











