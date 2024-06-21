package br.com.alura.screenmatch.excessao;

public class ErroDeConversaoAnoException extends RuntimeException { //Normalmente ele já cria com um ThrowException, porém, preferimos usar o runTime nesse caso para nao haver obrigacao de usar o trycatch
    private String mensagem;

    public ErroDeConversaoAnoException(String mensagem) {
        this.mensagem = mensagem;
    } // criando o construtor para esse erro ja receber a mensagem dentro dele, ao chamar o metódo

    @Override
    public String getMessage() {
        return this.mensagem;
    } // Vamos reescrever o getMessage, para quando nas excessoes formos avisar a excessao que é, podermos apenas chamar o getMessage para avisar.
}
