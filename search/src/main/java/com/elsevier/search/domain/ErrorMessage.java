package com.elsevier.search.domain;

public class ErrorMessage {

    private String status;

    private String errorMessage;

    public ErrorMessage() {
    }

    public ErrorMessage(String statusFromOutside, String errorMessageFromOutside) {
        this.status = statusFromOutside;
        this.errorMessage = errorMessageFromOutside;
    }

    /**
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * @return the errorMessage
     */
    public final String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param status
     *            the status to set
     */
    public final void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public final void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
