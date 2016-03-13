package org.debugroom.framework.common.exception;

/**
 * 
 * @author org.debugroom
 *
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1224708518547488375L;

	private String code;
	private Object[] args;
    
    public SystemException(){
        super();
    }

    public SystemException(String code, String message, Object[] args, Throwable cause){
    	super(message, cause);
    	this.code = code;
    	this.setArgs(args);
    }

    public SystemException(String code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }
    
    public SystemException(String code, String message){
        super(message);
        this.code = code;
    }
    
    public SystemException(String code, Object[] args, Throwable cause){
        super(cause);
        this.code = code;
        this.setArgs(args);
    }

    public SystemException(String code, Throwable cause){
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
    
}
