package br.com.zup.anaminadakis.transacao.cartao.dto;

import br.com.zup.anaminadakis.transacao.cartao.model.Cartao;

public class CartaoDto {

    private String id;
    private String email;


    public CartaoDto(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
