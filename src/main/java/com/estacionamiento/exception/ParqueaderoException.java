package com.estacionamiento.exception;

public class ParqueaderoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ParqueaderoException(String error) {
		super(error);
	}

}
