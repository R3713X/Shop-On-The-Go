package com.shoponthego;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
 
public class RestErrorHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);
	 
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleOfferNotFoundException(NotFoundException ex) {
        LOGGER.debug("handling 404 error on a todo entry");
    }
}
