package org.debugroom.framework.common.error;

import org.debugroom.framework.common.exception.ExceptionResolver;

public enum ErrorCodeResolver implements ExceptionResolver{

	INSTANCE;

	private static final String BUSINESS_EXCEPTION_CLASS = "org.debugroom.framework.common.exception.BusinessException";
	private static final String SYSTEM_EXCEPTION_CLASS = "org.debugroom.framework.common.exception.SystemException";


    public String getErrorCode(Exception exception){
        String errorCd = null;
        if(null != exception){
            String exceptionName = exception.getClass().getName();
            if(null != exceptionName){
                switch(exceptionName){
                    case BUSINESS_EXCEPTION_CLASS:
                        errorCd = "sample.common.error.0001";
                        break;
                    case SYSTEM_EXCEPTION_CLASS:
                        errorCd = "sample.common.error.0002";
                        break;
                    default :
                        errorCd = "sample.common.error.0000";
                        break;
                }   
            }
        }
        return errorCd; 
    }
	
	
}
