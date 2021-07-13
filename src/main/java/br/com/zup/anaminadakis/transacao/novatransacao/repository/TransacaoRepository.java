package br.com.zup.anaminadakis.transacao.novatransacao.repository;

import br.com.zup.anaminadakis.transacao.novatransacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
