package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculos.Recomendacao;
import br.com.alura.screenmatch.Principal.principalComListas;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme filme = new Filme("O poderoso chefão",2010);
       // filme.setNome("O poderoso chefão");
       // filme.setAnoDeLancamento(1997);
        filme.setDuracaoEmMinutos(120);
        filme.setIncluidoNoPlano(true);
        filme.exibeFichaTecnica(); //utilizando um metódo da superclasse Titulos.
        filme.avalia(8);
        filme.avalia(10);
        filme.avalia(5);

        //Aprendendo a usar o get.
        System.out.println("Duração do filme: " + filme.getDuracaoEmMinutos());
        System.out.println("Total de avaliações: " + filme.getTotalDeAvaliacoes());

        System.out.println("Média de avaliações: " + filme.obterMedia());

        Filme filme1 = new Filme("Vingadores: Ultimato", 2010);
       // filme1.setNome("Vingadores: Ultimato");
      //  filme1.setAnoDeLancamento(2019);
        filme1.setDuracaoEmMinutos(120);
        filme1.setIncluidoNoPlano(true);

        //Criando uma nova classe série e instanciando um novo objeto nessa classe.
        Serie serie = new Serie("The Office", 2010);
       // serie.setNome("The Office");
       // serie.setAnoDeLancamento(2005);
        serie.setAtiva(false);
        serie.setTemporadas (9);
        serie.setEpisodiosPorTemporada(28);
        serie.setMinutosPorEpisodio(22);

        System.out.println("Duração de The Office: " + serie.getDuracaoEmMinutos());

        //Testando a calculadora de tempo para maratonar titulos:
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(filme1);
        calculadora.inclui(serie);
        System.out.println("Para marotonar esses títulos você precisará de :" + calculadora.getTempoTotal());

        //Testando o filtro de recomendação de um titulo.
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.filtra(filme);

        Episodio episodio = new Episodio();
        episodio.setNome("The Office");
        episodio.setNumero(1);
        episodio.setTotalDeVisualizacoes(400);
        recomendacao.filtra(episodio); //Testando o filtro de recomendação em um episodio, que tem o método diferente.

        Filme filme2 = new Filme("Up - Altas Aventuras!", 2010);
      //  filme2.setNome("Up - Altas aventuras");
      //  filme2.setAnoDeLancamento(2010);
        filme2.setDuracaoEmMinutos(120);
        filme2.setIncluidoNoPlano(true);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
         listaDeFilmes.add(filme);
         listaDeFilmes.add(filme2);
         listaDeFilmes.add(filme1);

        System.out.println("Tamanho da lista de filmes: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println("Lista de filmes: " + listaDeFilmes);
        System.out.println("Lista de filmes" + listaDeFilmes.get(0).toString());


    }
}
