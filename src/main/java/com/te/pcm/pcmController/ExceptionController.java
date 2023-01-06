package com.te.pcm.pcmcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.te.pcm.exception.InvalidId;
import com.te.pcm.pcmdto.AppResponse;

@ControllerAdvice
public class ExceptionController {
	@Autowired
	AppResponse response;
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<AppResponse> exception(InvalidId exception){
		response.setData(null);
		response.setMessage(exception.getMessage());
		return new ResponseEntity<AppResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
