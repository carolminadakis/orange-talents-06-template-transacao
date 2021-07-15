package br.com.zup.anaminadakis.transacao.compra.controller;

import br.com.zup.anaminadakis.transacao.cartao.model.Cartao;
import br.com.zup.anaminadakis.transacao.cartao.repository.CartaoRepository;
import br.com.zup.anaminadakis.transacao.novatransacao.dto.TransacaoDto;
import br.com.zup.anaminadakis.transacao.novatransacao.model.Transacao;
import br.com.zup.anaminadakis.transacao.novatransacao.repository.TransacaoRepository;
import br.com.zup.anaminadakis.transacao.validacao.TratamentoDeErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cartoes")
public class CompraController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    TransacaoRepository transacaoRepository;


    @GetMapping("/{id}")
    public ResponseEntity<?> buscaUtlimasCompras(@PathVariable String id) {

        Optional<Cartao> cartaoVerificado = cartaoRepository.findById(id);
        if (cartaoVerificado.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new TratamentoDeErro("Cartao id", "ID do cartão inválido."));
        }
        List<Transacao> ultimasCompras = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(id);
        return ResponseEntity.ok(ultimasCompras.stream().map(TransacaoDto::new));
    }
}
