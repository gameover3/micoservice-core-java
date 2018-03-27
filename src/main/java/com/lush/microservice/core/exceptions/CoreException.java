package com.lush.microservice.core.exceptions;

import com.lush.microservice.core.enums.ExceptionType;
import com.lush.microservice.core.enums.ResponseStatusType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Core Exception(Common)
 *
 * @author Jelly
 * @author Is
 */
@Component
public class CoreException extends RuntimeException {

  /**
   * Create default serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Exceptoin status
   */
  private final String status;

  /**
   * Exceptoin code
   */
  private final Integer code;

  /**
   * Exceptoin message
   */
  private final String message;

  /**
   * The default creator. (using default code and message)
   */
  public CoreException() {
    this.status = ResponseStatusType.FAIL.getStatus();
    this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    this.message = "Internal server exception";
  }

  /**
   * The default creator. (User Created)
   *
   * @param code
   * @param handlerMessage
   */
  public CoreException(Integer code, String handlerMessage) {
    this.status = ResponseStatusType.FAIL.getStatus();
    this.code = code;
    this.message = handlerMessage;
  }

  /**
   * Set common exception.
   *
   * @param exceptionType
   * @return CoreException
   */
  public CoreException setCommonExceptoin(ExceptionType exceptionType) {
    CoreException coreException = new CoreException(exceptionType.getCode(), exceptionType.getMassage());
    return coreException;
  }

  public String getStatus() {
    return status;
  }

  public Integer getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}