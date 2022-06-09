package com.carros;


class NotFoundException extends RuntimeException {

	  NotFoundException(Long id) {
	    super("Could not find car " + id);
	  }
	}