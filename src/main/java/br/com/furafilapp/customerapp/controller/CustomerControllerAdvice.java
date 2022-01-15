package br.com.furafilapp.customerapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.furafilapp.customerapp.response.ErrorResponse;

@RestControllerAdvice
public class CustomerControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CustomerControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> handleException(Exception ex) {
		logger.error(ex.getMessage(), ex);

		return ResponseEntity.internalServerError().build();

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException maEx) {

		String defaultMessage = maEx.getBindingResult().getFieldError().getDefaultMessage();
		logger.error(defaultMessage, maEx.getBindingResult().getFieldError());

		return ResponseEntity.badRequest().body(new ErrorResponse(defaultMessage));
	}

}
