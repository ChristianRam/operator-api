package com.inclusioncloud.operator.exception;

/**
 * Exception for invalid input data
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class InvalidInputDataException extends RuntimeException {

  private static final long serialVersionUID = -2415917240943295372L;

  public InvalidInputDataException(String message) {
    super(message);
  }
}
