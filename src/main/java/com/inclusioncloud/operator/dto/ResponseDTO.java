package com.inclusioncloud.operator.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * General response object
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
public class ResponseDTO<T> implements Serializable {
  private T data;

  private NotificationDTO notification;

  public ResponseDTO(NotificationDTO notification) {
    Objects.requireNonNull(notification, "Notification must not be null");

    this.notification = notification;
  }

  public ResponseDTO(T data, NotificationDTO notification) {
    Objects.requireNonNull(data, "Data must not be null");
    Objects.requireNonNull(notification, "Notification must not be null");

    this.data = data;
    this.notification = notification;
  }

  private static final long serialVersionUID = -7457650946067129740L;
}
