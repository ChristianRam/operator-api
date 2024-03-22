package com.inclusioncloud.operator.exception.handler;

import com.inclusioncloud.operator.dto.NotificationDTO;
import com.inclusioncloud.operator.dto.ResponseDTO;
import com.inclusioncloud.operator.exception.InvalidInputDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidInputDataException.class)
  public ResponseEntity<Object> handleInvalidInputDataException(InvalidInputDataException ex) {
    log.error(ex.getMessage(), ex);

    HttpStatus status = HttpStatus.BAD_REQUEST;

    return ResponseEntity.status(status)
        .body(new ResponseDTO<>(new NotificationDTO(ex.getMessage(), status.value())));
  }
}
