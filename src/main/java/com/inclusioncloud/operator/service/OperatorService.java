package com.inclusioncloud.operator.service;

import com.inclusioncloud.operator.dto.MaximumDTO;

import java.util.List;

/**
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OperatorService {

  /**
   * Calls calculateMaximum() and get result
   *
   * @param maximum with data for operation maximum
   * @return maximum object with the result
   */
  MaximumDTO getMaximum(MaximumDTO maximum);

  /**
   * Calls calculateMaximum() and get result for each element object in the list
   *
   * @param maximumList object list with data for operation maximum
   * @return list of maximum object with the results
   */
  List<MaximumDTO> getMaximumList(List<MaximumDTO> maximumList);
}
