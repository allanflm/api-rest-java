package br.com.allanflm.screenmatch.exceptions;

public class YearConversationErrorException extends RuntimeException {

    private String message;

    public YearConversationErrorException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return this.message;
    }
}
