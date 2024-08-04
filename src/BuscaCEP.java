import br.com.buscacep.models.CepSearch;
import br.com.buscacep.models.Endereco;
import br.com.buscacep.models.HTTPConnection;
import br.com.buscacep.models.ValidaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.Scanner;

public class BuscaCEP {
    public static void main(String[] args){
        HTTPConnection client = new HTTPConnection();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CEP para busca: ");
        String busca = scanner.nextLine();

        ValidaCep valida = new ValidaCep();

        try{
            String resposta = client.sendRequest(valida.validaCep(busca));
            CepSearch cepBuscado = gson.fromJson(resposta, CepSearch.class);

            Endereco endereco = new Endereco(cepBuscado);
            System.out.println(endereco);

            FileWriter arquivo = new FileWriter("endereco.json");
            arquivo.write(gson.toJson(endereco));
            arquivo.close();

        }catch (Exception e){
            System.out.println("Erro na consulta!");
            System.out.println(e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}
