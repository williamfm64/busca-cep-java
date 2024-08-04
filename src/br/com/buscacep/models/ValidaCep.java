package br.com.buscacep.models;

import br.com.buscacep.exceptions.ValidacaoExeption;

public class ValidaCep {

    public String validaCep(String busca){
       if (busca.length() != 8){
           throw new ValidacaoExeption("O Cep digitado é inválido, deve ter 8 números");
       } else if (!busca.matches("\\d+")) {
           throw new ValidacaoExeption("O Cep digitado é inválido, deve conter apenas números");
       }
        return busca;
   }
}
