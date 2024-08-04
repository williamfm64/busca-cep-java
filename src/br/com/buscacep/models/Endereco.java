package br.com.buscacep.models;

public class Endereco {
    private String nomeDaRua = "";
    private String bairro = "";
    private String cidade = "";
    private String estado = "";
    private String cep = "";

    public Endereco(CepSearch busca) {
        this.nomeDaRua = busca.logradouro();
        this.bairro = busca.bairro();
        this.cidade = busca.localidade();
        this.estado = busca.uf();
        this.cep = busca.cep();
    }

    @Override
    public String toString() {
        return "{\n" +
                "nomeDaRua : " + nomeDaRua + "\n" +
                "bairro : " + bairro + "\n" +
                "cidade : " + cidade + "\n" +
                "estado : " + estado + "\n" +
                "cep : " + cep + "\n" +
                '}';
    }
}
