package org.cap.wishlistmanagementsystem.ControlleAdvice;

import org.cap.wishlistmanagementsystem.exception.IncorrectProductException;
import org.cap.wishlistmanagementsystem.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WishlistControllerAdvice {

@ExceptionHandler()
public ResponseEntity<String> invalidUserId(UserNotExistException exception) {
return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
		

@ExceptionHandler()
public ResponseEntity<String> invalidProductId(IncorrectProductException exception) {
return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		}
}


