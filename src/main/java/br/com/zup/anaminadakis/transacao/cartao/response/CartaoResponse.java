package br.com.zup.anaminadakis.transacao.cartao.response;


import br.com.zup.anaminadakis.transacao.cartao.model.Cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoResponse {

    @NotBlank
    private String id;

    @Email
    @NotBlank
    private String email;


    public CartaoResponse() {
    }

    public CartaoResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }

    @Override
    public String toString() {
        return "CartaoResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
