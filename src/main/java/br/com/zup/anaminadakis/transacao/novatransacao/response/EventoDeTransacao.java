package br.com.zup.anaminadakis.transacao.novatransacao.response;

import br.com.zup.anaminadakis.transacao.cartao.model.Cartao;
import br.com.zup.anaminadakis.transacao.cartao.response.CartaoResponse;
import br.com.zup.anaminadakis.transacao.estabelecimento.model.Estabelecimento;
import br.com.zup.anaminadakis.transacao.estabelecimento.response.EstabelecimentoResponse;
import br.com.zup.anaminadakis.transacao.novatransacao.model.Transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    @NotBlank
    private String id;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private EstabelecimentoResponse estabelecimento;

    @NotNull
    private CartaoResponse cartao;

    @NotNull
    private LocalDateTime efetivadaEm;


    public EventoDeTransacao() {
    }

    public EventoDeTransacao(String id,
                             BigDecimal valor,
                             EstabelecimentoResponse estabelecimento,
                             CartaoResponse cartao,
                             LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel() {
        Estabelecimento estabelecimento = this.estabelecimento.toModel();
        Cartao cartao = this.cartao.toModel();
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimentoResponse=" + estabelecimento +
                ", cartaoResponse=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
