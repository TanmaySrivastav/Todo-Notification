package com.todo.notification.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author Rishikesh
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException  {
	
	/**
	 * default serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
        super();
    }
    /**
     * @param message
     * @param cause
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
    /**
     * @param cause
     */
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
