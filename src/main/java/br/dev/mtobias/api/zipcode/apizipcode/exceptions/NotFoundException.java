package br.dev.mtobias.api.zipcode.apizipcode.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
