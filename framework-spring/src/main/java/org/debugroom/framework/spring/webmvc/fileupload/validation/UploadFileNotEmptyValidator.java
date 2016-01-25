package org.debugroom.framework.spring.webmvc.fileupload.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import org.debugroom.framework.spring.webmvc.fileupload.validation.annotation.UploadFileNotEmpty;

public class UploadFileNotEmptyValidator 
				implements ConstraintValidator<UploadFileNotEmpty, MultipartFile>{

	@Override
	public void initialize(UploadFileNotEmpty arg0) {
	}

	@Override
	public boolean isValid(MultipartFile multipartFile, 
			ConstraintValidatorContext context) {
		if (multipartFile == null || !StringUtils.hasLength(multipartFile.getOriginalFilename())){
			return false;
		}
		return !multipartFile.isEmpty();
	}

}
