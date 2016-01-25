package org.debugroom.framework.spring.webmvc.fileupload.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import org.debugroom.framework.spring.webmvc.fileupload.validation.annotation.UploadFileRequired;

public class UploadFileRequiredValidator 
				implements ConstraintValidator<UploadFileRequired, MultipartFile>{

	@Override
	public void initialize(UploadFileRequired arg0) {
	}

	@Override
	public boolean isValid(MultipartFile multiPartFile, 
			ConstraintValidatorContext context) {
		return multiPartFile != null &&
			StringUtils.hasLength(multiPartFile.getOriginalFilename());
	}

}
