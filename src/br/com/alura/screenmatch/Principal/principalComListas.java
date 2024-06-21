package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class principalComListas {
    public static void main(String[] args) {
        Filme filme = new Filme("O poderoso chefão",2010);
        Filme filme1 = new Filme("Vingadores: Ultimato", 2010);
        Filme filme2 = new Filme("Up - Altas Aventuras!", 2010);
        Serie serie = new Serie("The Office", 2009);

        //Avaliando
        filme.avalia(10);
        filme1.avalia(9);
        filme2.avalia(10);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme);
        lista.add(filme1);
        lista.add(filme2);
        lista.add(serie);


        for (Titulo item: lista)
        {
            if (item instanceof Filme itemFilme && filme.getClassificacao() > 4) {
                System.out.println(itemFilme.getNome() + ": nota " + itemFilme.getClassificacao());
            }

        }

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Standler");
        buscaPorArtista.add("Will Smith");
        buscaPorArtista.add("Jennifer Lopez");

        Collections.sort(buscaPorArtista); // Collections.sort está na classe java util e faz ordenar por ordem alfabética.

        System.out.println(buscaPorArtista);

        Collections.sort(lista); //Ordena
        System.out.println(lista); // Imprime ordenado.
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento)); // o sort desse está comparando o ano de lançamento. Agora a lista está ordenada por ano, e é só imprimir para ver.
        System.out.println(lista);



    }
}
