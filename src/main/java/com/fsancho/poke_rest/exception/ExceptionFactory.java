package com.fsancho.poke_rest.exception;

import com.fsancho.poke_rest.exception.enums.ExceptionType;

/**
 * @author Fernando Sancho
 *
 */
public class ExceptionFactory {
//	private static final Logger LOG = LoggerFactory.getLogger(ExceptionFactory.class);

	public static ApplicationSpecificException create(final Throwable cause, final ExceptionType exceptionType, final Object... messageArguments) {
		return new ApplicationSpecificException(exceptionType, cause, messageArguments);
	}

	public static ApplicationSpecificException create(final ExceptionType exceptionType, final Object... messageArguments) {
		return new ApplicationSpecificException(exceptionType, messageArguments);
	}
}
