package br.com.zup.anaminadakis.transacao.estabelecimento.response;

import br.com.zup.anaminadakis.transacao.estabelecimento.model.Estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoResponse {

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;


    public EstabelecimentoResponse() {
    }

    public EstabelecimentoResponse(String nome,
                                   String cidade,
                                   String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

    @Override
    public String toString() {
        return "EstabelecimentoResponse{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
