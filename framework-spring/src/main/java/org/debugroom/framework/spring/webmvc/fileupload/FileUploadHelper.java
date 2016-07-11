package org.debugroom.framework.spring.webmvc.fileupload;

import org.debugroom.framework.common.exception.BusinessException;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadHelper {

	public String saveFile(MultipartFile multipartFile, String userId) throws BusinessException;
	
}
