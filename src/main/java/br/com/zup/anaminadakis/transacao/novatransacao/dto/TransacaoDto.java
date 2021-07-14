package br.com.zup.anaminadakis.transacao.novatransacao.dto;

import br.com.zup.anaminadakis.transacao.cartao.dto.CartaoDto;
import br.com.zup.anaminadakis.transacao.estabelecimento.dto.EstabelecimentoDto;
import br.com.zup.anaminadakis.transacao.novatransacao.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDto estabelecimento;
    private CartaoDto cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoDto(transacao.getEstabelecimento());
        this.cartao = new CartaoDto(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
