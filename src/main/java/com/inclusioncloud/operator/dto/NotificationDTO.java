package com.inclusioncloud.operator.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Contains additional information about response object
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
public class NotificationDTO implements Serializable {

  private String description;

  private Integer code;

  @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
  private LocalDateTime timestamp;

  public NotificationDTO(String description, Integer code) {
    timestamp = LocalDateTime.now();
    this.description = description;
    this.code = code;
  }

  private static final long serialVersionUID = 1644462345291551707L;
}
