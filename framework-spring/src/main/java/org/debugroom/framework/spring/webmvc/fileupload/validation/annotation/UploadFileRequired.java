package org.debugroom.framework.spring.webmvc.fileupload.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.debugroom.framework.spring.webmvc.fileupload.validation.UploadFileRequiredValidator;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UploadFileRequiredValidator.class)
public @interface UploadFileRequired {
	String message() default "org.debugroom.framework.spring.webmvc.fileupload.validation.annotation.UploadFileRequired.message";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List{
		UploadFileRequired[] value();
	}

}
