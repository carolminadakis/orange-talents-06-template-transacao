package br.com.zup.anaminadakis.transacao.novatransacao.model;

import br.com.zup.anaminadakis.transacao.cartao.model.Cartao;
import br.com.zup.anaminadakis.transacao.estabelecimento.model.Estabelecimento;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;


    @Deprecated
    public Transacao() {
    }

    public Transacao(String id,
                     BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao,
                     LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}
