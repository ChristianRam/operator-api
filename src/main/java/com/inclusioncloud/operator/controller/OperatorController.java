package com.inclusioncloud.operator.controller;

import com.inclusioncloud.operator.constants.ResourceEndpoint;
import com.inclusioncloud.operator.dto.MaximumDTO;
import com.inclusioncloud.operator.dto.NotificationDTO;
import com.inclusioncloud.operator.dto.ResponseDTO;
import com.inclusioncloud.operator.service.OperatorService;
import com.inclusioncloud.operator.service.impl.OperatorServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller to get operations
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping(ResourceEndpoint.OPERATOR)
//TODO cross origin
public class OperatorController {

  private static final String MESSAGE_INCOMING_REQUEST =
      "Incoming request getMaximum() method with values divider: {}, remainder: {}, limit: {}";
  public static final String OPERATION_SUCCESSFUL = "Operation Successful";
  public static final String BAD_REQUEST = "Bad request";

  public final OperatorService operatorService;

  /**
   * Constructor for inject dependencies
   *
   * @param operatorService implementation instance of {@link OperatorServiceImpl} object
   */
  public OperatorController(OperatorService operatorService) {
    this.operatorService = operatorService;
  }


  /**
   * Consume service for get maximum
   *
   * @param divider divider value
   * @param remainder remainder value
   * @param limit limit value
   * @return object {@link ResponseDTO} with the result
   */
  @ApiOperation("Calculate maximum")
  @ApiResponses(value = {
          @ApiResponse(
                  code = 200,
                  message = OPERATION_SUCCESSFUL,
                  response = ResponseDTO.class
          ),
          @ApiResponse(
                  code = 400,
                  message = BAD_REQUEST,
                  response = ResponseDTO.class
          )
  })
  @GetMapping(ResourceEndpoint.MAXIMUM)
  public ResponseEntity<ResponseDTO<Integer>> getMaximum(
      @RequestParam Integer divider, @RequestParam Integer remainder, @RequestParam Integer limit) {
    log.info(MESSAGE_INCOMING_REQUEST, divider, remainder, limit);
    return ResponseEntity.ok(
        new ResponseDTO<>(
            operatorService.calculateMaximum(divider, remainder, limit),
            new NotificationDTO(OPERATION_SUCCESSFUL, HttpStatus.OK.value())));
  }

  /**
   * Consume service for get maximum
   *
   * @param maximumDTO request object
   * @return object {@link ResponseDTO} with the result
   */
  @ApiOperation("Calculate maximum")
  @ApiResponses(value = {
          @ApiResponse(
                  code = 200,
                  message = OPERATION_SUCCESSFUL,
                  response = ResponseDTO.class
          ),
          @ApiResponse(
                  code = 400,
                  message = BAD_REQUEST,
                  response = ResponseDTO.class
          )
  })
  @PostMapping(ResourceEndpoint.MAXIMUM)
  public ResponseEntity<ResponseDTO<Integer>> getMaximumPost(
          @Valid @RequestBody MaximumDTO maximumDTO) {
    log.info(
        MESSAGE_INCOMING_REQUEST,
        maximumDTO.getDivider(),
        maximumDTO.getRemainder(),
        maximumDTO.getLimit());

    return ResponseEntity.ok(
        new ResponseDTO<>(
            operatorService.calculateMaximum(
                maximumDTO.getDivider(), maximumDTO.getRemainder(), maximumDTO.getLimit()),
            new NotificationDTO(OPERATION_SUCCESSFUL, HttpStatus.OK.value())));
  }
}
