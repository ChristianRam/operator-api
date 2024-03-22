package com.inclusioncloud.operator.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constant with endpoint information.
 *
 * @author <a href="christianram19@hotmail.com">Christian Ramirez</a>
 * @version 1.0.0
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceEndpoint {

    /**
     * Endpoint to operator
     */
    public static final String OPERATOR = "/operator";

    /**
     * Endpoint to maximum
     */
    public static final String MAXIMUM = "/maximum";
}
