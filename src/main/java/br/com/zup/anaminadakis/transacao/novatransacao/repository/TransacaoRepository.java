package br.com.zup.anaminadakis.transacao.novatransacao.repository;

import br.com.zup.anaminadakis.transacao.novatransacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String id);
}
