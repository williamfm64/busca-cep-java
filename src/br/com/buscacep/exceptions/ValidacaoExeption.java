package br.com.buscacep.exceptions;

public class ValidacaoExeption extends RuntimeException {
    private String message;

    public ValidacaoExeption(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
