package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.excessao.ErroDeConversaoAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create(); //Gson é a API que estamos utilizando para renomear o json.

        while(!busca.equalsIgnoreCase("sair")){

        System.out.println("Digite o filme que você deseja buscar");
        busca = leitura.nextLine();

        if (busca.equalsIgnoreCase("sair"))
        {
            break;
        }
        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=61a2a123";
        //Essa é a busca da api. Finalizeremos o endereço do site com o valor que o usuario colocar.

        //Agora nosso try passa a ser executado aqui
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString()); //Http que irá ler o json.

            System.out.println(response.body()); //Mostra para o usuario o json que ele capturou.
            String jsonCorpo = response.body(); // da o nome de jsoncorpo para o corpo do json, apenas para facilitar o cód

            TituloOMDB filmeOmdb = gson.fromJson(jsonCorpo, TituloOMDB.class);
            System.out.println(filmeOmdb.toString());
            //  try {
            Titulo filme1 = new Titulo(filmeOmdb); //Convertemos o filmeOmdb que instanciamos para filme1, já na classe titulo normal.
            System.out.println("Titulo já convertido: ");
            System.out.println(filme1);

            titulos.add(filme1);

            System.out.println("Duração em minutos: " + filme1.getDuracaoEmMinutos()); //Apenas para entender como chamar apenas um atributo.
        } //tentamos capturar o filme e devolver o resultado para o usuario.

        catch (NumberFormatException ex)
        {
            System.out.println("Aconteceu um erro: ");
            System.out.println(ex.getMessage());

        } // caso de erro no try, cairemos no catch. Que avisará o NumberFormatException, ou seja, o numero do erro que está dando, para podermos resolver.
        catch(IllegalArgumentException ex) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço de entrada");
        }
        catch (ErroDeConversaoAnoException ex) {
            System.out.println(ex.getMessage());
        }
        catch(Exception e){
            System.out.println("Deu algum erro genérico");
        }

        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("O programa finalizou corretamente."); //Tendo o try catch, caso caia no catch, ele vai exibir o erro, porém, não interromperá o programa por completo.
    }
}
