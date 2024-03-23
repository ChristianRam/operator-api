package com.inclusioncloud.operator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.inclusioncloud.operator.util.OperatorTestBuilder.*;

import com.inclusioncloud.operator.dto.MaximumDTO;
import com.inclusioncloud.operator.exception.InvalidInputDataException;
import com.inclusioncloud.operator.service.OperatorService;
import org.junit.jupiter.api.Test;
import java.util.List;


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
    void givenCorrectMaximumDTO_WhenCallGetMaximum_ThenReturnSuccessObjectResult() {

        MaximumDTO result = operatorService.getMaximum(buildMaximumDTO());

        assertEquals(12339, result.getResult());
    }

    @Test
    void givenCorrectMaximumDTOList_WhenCallGetMaximum_ThenReturnSuccessObjectResult() {

        List<MaximumDTO> result = operatorService.getMaximumList(buildMaximumDTOList());

        assertThat(result).isNotEmpty().hasSize(2);
        assertEquals(12339, result.get(0).getResult());
        assertEquals(15, result.get(1).getResult());
    }


    @Test
    void givenDividerLessThanTwo_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .getMaximum(buildMaximumDTODividerLessThanTwo()));

        assertEquals(ERROR_MESSAGE_DIVIDER_LESS, exception.getMessage());
    }

    @Test
    void givenDividerGreaterThanBillion_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .getMaximum(buildMaximumDTODividerGreaterThanBillion()));

        assertEquals(ERROR_MESSAGE_DIVIDER_GREATER, exception.getMessage());
    }

    @Test
    void givenRemainderLessThanZero_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .getMaximum(buildMaximumDTORemainderLessThanZero()));

        assertEquals(ERROR_MESSAGE_REMAINDER_LESS, exception.getMessage());
    }

    @Test
    void givenRemainderGreaterThanDivider_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .getMaximum(buildMaximumDTORemainderGreaterThanDivider()));

        assertEquals(String.format(ERROR_MESSAGE_REMAINDER_GREATER, 7), exception.getMessage());
    }

    @Test
    void givenLimitLessThanRemainder_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .getMaximum(buildMaximumDTOLimitLessThanRemainder()));

        assertEquals(String.format(ERROR_MESSAGE_LIMIT_LESS, 5), exception.getMessage());
    }

    @Test
    void givenLimitGreaterThanBillion_WhenCallCalculateMaximum_ThenReturnInvalidDataException() {

        InvalidInputDataException exception = assertThrows(InvalidInputDataException.class, () -> operatorService
                .getMaximum(buildMaximumDTOLimitGreaterThanBillion()));

        assertEquals(ERROR_MESSAGE_LIMIT_GREATER, exception.getMessage());
    }

}