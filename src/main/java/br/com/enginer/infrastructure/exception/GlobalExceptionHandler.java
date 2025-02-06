package br.com.enginer.infrastructure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.com.enginer.domain.exception.CheckedException;
import br.com.enginer.domain.exception.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(CheckedException.class)
	public ResponseEntity<ErrorResponse> handleCustomCheckedException(CheckedException ccex) {
		ErrorResponse errorResponse = new ErrorResponse(ccex.getMessage(), ccex.getCustomMessage(), HttpStatus.BAD_REQUEST);
	    if (LOGGER.isErrorEnabled()) {
	        LOGGER.error(String.format("Failed code: '%s'", HttpStatus.BAD_REQUEST), ccex);
	    }
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFound(NoResourceFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	    if (LOGGER.isErrorEnabled()) {
	        LOGGER.error(String.format("Failed code: '%s'", HttpStatus.NOT_FOUND), ex);
	    }
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
    	ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	if (LOGGER.isErrorEnabled()) {
    		LOGGER.error(String.format("Failed code: '%s'", HttpStatus.INTERNAL_SERVER_ERROR), ex);
    	}
    	return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
