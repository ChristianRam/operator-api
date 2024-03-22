package com.inclusioncloud.operator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Request object to get maximum
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class MaximumDTO implements Serializable {

  @NotNull private Integer divider;

  @NotNull private Integer remainder;

  @NotNull private Integer limit;

  private static final long serialVersionUID = 3213733001917187168L;
}
