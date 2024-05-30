import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculos.Recomendacao;

public class Principal {
    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setNome("O poderoso chefão");
        filme.setAnoDeLancamento(1997);
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

        Filme filme1 = new Filme();
        filme1.setNome("Vingadores: Ultimato");
        filme1.setAnoDeLancamento(2019);
        filme1.setDuracaoEmMinutos(120);
        filme1.setIncluidoNoPlano(true);

        //Criando uma nova classe série e instanciando um novo objeto nessa classe.
        Serie serie = new Serie();
        serie.setNome("The Office");
        serie.setAnoDeLancamento(2005);
        serie.setAtiva(false);
        serie.setTemporadas(9);
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
    }
}
