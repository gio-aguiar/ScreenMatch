package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excessao.ErroDeConversaoAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
//    @SerializedName("Title") - outra forma de serializar. Porém, não é totalmente funcional para todos os casos. A melhor forma é criar um record.
    private String nome;
 //   @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private String sinopse;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int classificacaoEtaria;
    private int duracaoEmMinutos;
    private int totalDeVisualizacoes;

    public Titulo(TituloOMDB filmeOmdb) {
        this.nome = filmeOmdb.title();

        if(filmeOmdb.year().length() > 4) {
            throw new ErroDeConversaoAnoException("Não consegui converter o ano por ter mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(filmeOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(filmeOmdb.runtime().substring(0,3)); // substring é feita por conta dos "min" escritos no json. Estamos dizendo que é para considerar apenas do primeiro ao terceiro caracter.
    }

    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }

    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }

    public Titulo(String nome, int anoDeLancamento) {
        this.setNome(nome);
        this.setAnoDeLancamento(anoDeLancamento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("O nome do filme é: " + nome);
        System.out.println("A duração do filme é: " + duracaoEmMinutos);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes  += nota;
        totalDeAvaliacoes++;
    }

    public double obterMedia() {
        return (int) somaDasAvaliacoes/totalDeAvaliacoes;
    }


    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(Titulo: " + nome + " " +
                "Ano: " + anoDeLancamento + " " + "Duração em minutos:" + duracaoEmMinutos + ")";
    }
}
