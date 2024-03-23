package com.inclusioncloud.operator.service.impl;

import com.inclusioncloud.operator.dto.MaximumDTO;
import com.inclusioncloud.operator.exception.InvalidInputDataException;
import com.inclusioncloud.operator.service.OperatorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Operator service
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class OperatorServiceImpl implements OperatorService {

  private static final String ERROR_MESSAGE_DIVIDER_LESS =
      "The divider value must be greater than or equal to 2";
  private static final String ERROR_MESSAGE_DIVIDER_GREATER =
      "The divider value must be less than or equal to 1.000.000.000";
  private static final String ERROR_MESSAGE_REMAINDER_LESS =
      "The remainder value must be greater than or equal to 0";
  private static final String ERROR_MESSAGE_REMAINDER_GREATER =
      "The remainder value must be less than %s (divider)";
  private static final String ERROR_MESSAGE_LIMIT_LESS =
      "The limit value must be greater than or equal to %s (remainder)";
  private static final String ERROR_MESSAGE_LIMIT_GREATER =
      "The divider value must be less than or equal to 1.000.000.000";
  private static final Integer BILLION_VALUE = 1000000000;

  /** {@inheritDoc} */
  @Override
  public MaximumDTO getMaximum(MaximumDTO maximum) {
    maximum.setResult(
        calculateMaximum(maximum.getDivider(), maximum.getRemainder(), maximum.getLimit()));

    return maximum;
  }

  /** {@inheritDoc} */
  @Override
  public List<MaximumDTO> getMaximumList(List<MaximumDTO> maximumList) {
    maximumList.forEach(
        maximum ->
            maximum.setResult(
                calculateMaximum(
                    maximum.getDivider(), maximum.getRemainder(), maximum.getLimit())));

    return maximumList;
  }

  /**
   * Calculate maximum possible integer from 0 to limit that has the remainder modulo divider
   *
   * @param divider divider value
   * @param remainder remainder value
   * @param limit limit value
   * @return maximum
   */
  private Integer calculateMaximum(Integer divider, Integer remainder, Integer limit) {
    verifyDivider(divider);
    verifyRemainder(remainder, divider);
    verifyLimit(limit, remainder);

    int result = limit - (limit % divider) + remainder;

    if (result > limit) {
      result -= divider;
    }

    return result;
  }

  /**
   * Verifies divider value
   *
   * @param divider divider value
   */
  private void verifyDivider(Integer divider) {
    if (divider < 2) throw new InvalidInputDataException(ERROR_MESSAGE_DIVIDER_LESS);

    if (divider > BILLION_VALUE) throw new InvalidInputDataException(ERROR_MESSAGE_DIVIDER_GREATER);
  }

  /**
   * Verifies remainder value
   *
   * @param remainder remainder value
   * @param divider divider value
   */
  private void verifyRemainder(Integer remainder, Integer divider) {
    if (remainder < 0) throw new InvalidInputDataException(ERROR_MESSAGE_REMAINDER_LESS);

    if (remainder >= divider)
      throw new InvalidInputDataException(String.format(ERROR_MESSAGE_REMAINDER_GREATER, divider));
  }

  /**
   * Verifies limit value
   *
   * @param limit limit value
   * @param remainder remainder value
   */
  private void verifyLimit(Integer limit, Integer remainder) {
    if (limit < remainder)
      throw new InvalidInputDataException(String.format(ERROR_MESSAGE_LIMIT_LESS, remainder));

    if (limit > BILLION_VALUE) throw new InvalidInputDataException(ERROR_MESSAGE_LIMIT_GREATER);
  }
}
