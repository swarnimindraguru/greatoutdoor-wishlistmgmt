package org.cap.wishlistmanagementsystem.exception;

@SuppressWarnings("serial")
public class UserNotExistException extends RuntimeException{
	public UserNotExistException(String msg) {
		super(msg);
	}
}
