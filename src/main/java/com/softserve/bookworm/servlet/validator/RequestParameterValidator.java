package com.softserve.bookworm.servlet.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Predicate;


/**
 * This class checks if requested url query parameter
 * is valid (i.e. check if parameter does't exist or is empty)
 * you must call {@link #isDataValid()} after every 'check' method
 */
public class RequestParameterValidator implements Validator {
    private static final String INVALID_PARAM_MSG = "Parameter is empty or does not exist";
    private static final String INVALID_INTEGER_PARAM = "Invalid integer param";
    private static final String NO_SUCH_PARAM_MSG = "Parameter does not exist";

    private Predicate<String> predicate;
    private String extractedParam;
    private ErrorResponse error;
    private String errorMsg;

    public void checkIntegerParam(String paramName, HttpServletRequest request) {
        extractedParam = request.getParameter(paramName);
        predicate = Validator.notNullOrEmpty();
        try {
            Integer.parseInt(paramName);
        } catch (NumberFormatException e) {
//                TODO must be logged
            errorMsg = INVALID_INTEGER_PARAM;
        }
    }

    public void checkStringParam(String paramName, HttpServletRequest request) {
        extractedParam = request.getParameter(paramName);
        predicate = Validator.notNullOrEmpty();
        errorMsg = INVALID_PARAM_MSG;
    }

    public void checkStringParamForNullability(String paramName, HttpServletRequest request) {
        extractedParam = request.getParameter(paramName);
        predicate = Validator.notNull();
        errorMsg = NO_SUCH_PARAM_MSG;
    }

    public ErrorResponse getError() {
        return error;
    }

    @Override
    public boolean isDataValid() {
        boolean checkPassed = predicate.test(extractedParam);
        if (!checkPassed) {
            error = new ErrorResponse(HttpServletResponse.SC_BAD_REQUEST, errorMsg);
            return false;
        }
        return true;
    }
}
