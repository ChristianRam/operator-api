package com.inclusioncloud.operator.service.impl;

import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.ERROR_MESSAGE_DIVIDER_LESS;
import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.ERROR_MESSAGE_DIVIDER_GREATER;
import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.ERROR_MESSAGE_REMAINDER_LESS;
import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.ERROR_MESSAGE_REMAINDER_GREATER;
import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.ERROR_MESSAGE_LIMIT_LESS;
import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.ERROR_MESSAGE_LIMIT_GREATER;
import static com.inclusioncloud.operator.service.impl.OperatorServiceImpl.BILLION_VALUE;


import com.inclusioncloud.operator.exception.InvalidInputDataException;
import com.inclusioncloud.operator.service.OperatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for Operator service
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
class OperatorServiceImplTest {

    private final OperatorService operatorService = new OperatorServiceImpl();


    @Test
    void givenCorrectParam_WhenCallCalculateMaximum_ThenReturnMaximumValue() {

        Integer maximum = operatorService.calculateMaximum(7, 5, 12345);
        assertEquals(12339, maximum);
    }

    @Test
    void givenDividerLessThanTwo_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .calculateMaximum(1, 5, 12345));

        assertEquals(ERROR_MESSAGE_DIVIDER_LESS, exception.getMessage());
    }

    @Test
    void givenDividerGreaterThanBillion_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .calculateMaximum(BILLION_VALUE + 1, 5, 12345));

        assertEquals(ERROR_MESSAGE_DIVIDER_GREATER, exception.getMessage());
    }

    @Test
    void givenRemainderLessThanZero_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .calculateMaximum(7, -5, 12345));

        assertEquals(ERROR_MESSAGE_REMAINDER_LESS, exception.getMessage());
    }

    @Test
    void givenRemainderGreaterThanDivider_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .calculateMaximum(7, 8, 12345));

        assertEquals(String.format(ERROR_MESSAGE_REMAINDER_GREATER, 7), exception.getMessage());
    }

    @Test
    void givenLimitLessThanRemainder_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .calculateMaximum(7, 5, 4));

        assertEquals(String.format(ERROR_MESSAGE_LIMIT_LESS, 5), exception.getMessage());
    }

    @Test
    void givenLimitGreaterThanBillion_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .calculateMaximum(7, 5, BILLION_VALUE + 1));

        assertEquals(ERROR_MESSAGE_LIMIT_GREATER, exception.getMessage());
    }

}