/**
 * 
 */
package com.tradeStore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tradeStore.exception.InvalidTradeException;
import com.tradeStore.model.ErrorObject;

/**
 * @author Krunal
 *
 */

@ControllerAdvice
public class TradeStoreControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidTradeException.class)
    public ResponseEntity<ErrorObject> notFoundException(final InvalidTradeException ex) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_ACCEPTABLE);
    }
}