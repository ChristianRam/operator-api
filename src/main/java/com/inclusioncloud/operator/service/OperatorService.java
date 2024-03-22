package com.inclusioncloud.operator.service;

/**
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OperatorService {

  /**
   * Calculate maximum possible integer from 0 to limit that has the remainder modulo divider
   *
   * @param divider divider value
   * @param remainder remainder value
   * @param limit limit value
   * @return maximum
   */
  Integer calculateMaximum(Integer divider, Integer remainder, Integer limit);
}
