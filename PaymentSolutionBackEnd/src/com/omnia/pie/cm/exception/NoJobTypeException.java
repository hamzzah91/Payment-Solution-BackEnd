package com.omnia.pie.cm.exception;

public class NoJobTypeException extends Exception {

	private static final long serialVersionUID = -7086745779596169307L;

	public NoJobTypeException(){
		super("No JobType match or returned from the record.");
	}
}
