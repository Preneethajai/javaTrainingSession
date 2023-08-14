package com.maveric.unobank.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.maveric.unobank.exceptions.InvalidException;
import com.maveric.unobank.exceptions.NotFoundException;
import com.maveric.unobank.model.ErrorResponse;


@RestControllerAdvice
public class AduitTrailExceptionsController {
	
	@Autowired
	private ErrorResponse response;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<ErrorResponse> invalidExceptionHandler(InvalidException ex) {
		response.setSuccess(false);
		response.setMessage(ex.getMessage());
		response.setError_code(400);
		response.setData(new HttpHeaders());
	    return new ResponseEntity<>(response,HttpStatus.OK);
	  }
	
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(NotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleProductNotFoundException(NotFoundException e){
		   response.setSuccess(false);
			response.setMessage(e.getMessage());
			response.setError_code(404);
			response.setData(new HttpHeaders()); 
		   return new ResponseEntity<>(response,HttpStatus.OK);
	    }
}
