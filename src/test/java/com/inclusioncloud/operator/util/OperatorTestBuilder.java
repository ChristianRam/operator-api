package com.inclusioncloud.operator.util;

import com.inclusioncloud.operator.dto.MaximumDTO;

import java.util.Arrays;
import java.util.List;

/**
 * Util class to create test objects for operator service test
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class OperatorTestBuilder {

  public static final String ERROR_MESSAGE_DIVIDER_LESS =
          "The divider value must be greater than or equal to 2";
  public static final String ERROR_MESSAGE_DIVIDER_GREATER =
          "The divider value must be less than or equal to 1.000.000.000";
  public static final String ERROR_MESSAGE_REMAINDER_LESS =
          "The remainder value must be greater than or equal to 0";
  public static final String ERROR_MESSAGE_REMAINDER_GREATER =
          "The remainder value must be less than %s (divider)";
  public static final String ERROR_MESSAGE_LIMIT_LESS =
          "The limit value must be greater than or equal to %s (remainder)";
  public static final String ERROR_MESSAGE_LIMIT_GREATER =
          "The divider value must be less than or equal to 1.000.000.000";
  public static final Integer BILLION_VALUE = 1000000000;

  public static MaximumDTO buildMaximumDTO() {
    return MaximumDTO.builder().divider(7).remainder(5).limit(12345).build();
  }

  public static List<MaximumDTO> buildMaximumDTOList() {
    MaximumDTO maximumOne = MaximumDTO.builder().divider(7).remainder(5).limit(12345).build();
    MaximumDTO maximumTwo = MaximumDTO.builder().divider(10).remainder(5).limit(15).build();

    return Arrays.asList(maximumOne, maximumTwo);
  }

  public static MaximumDTO buildMaximumDTODividerLessThanTwo() {
    return MaximumDTO.builder().divider(1).remainder(5).limit(12345).build();
  }

  public static MaximumDTO buildMaximumDTODividerGreaterThanBillion() {
    return MaximumDTO.builder().divider(BILLION_VALUE + 1).remainder(5).limit(12345).build();
  }

  public static MaximumDTO buildMaximumDTORemainderLessThanZero() {
    return MaximumDTO.builder().divider(7).remainder(-5).limit(12345).build();
  }

  public static MaximumDTO buildMaximumDTORemainderGreaterThanDivider() {
    return MaximumDTO.builder().divider(7).remainder(8).limit(12345).build();
  }

  public static MaximumDTO buildMaximumDTOLimitLessThanRemainder() {
    return MaximumDTO.builder().divider(7).remainder(5).limit(4).build();
  }

  public static MaximumDTO buildMaximumDTOLimitGreaterThanBillion() {
    return MaximumDTO.builder().divider(7).remainder(5).limit(BILLION_VALUE + 1).build();
  }

}
