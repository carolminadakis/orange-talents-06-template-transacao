package br.com.zup.anaminadakis.transacao.cartao.repository;

import br.com.zup.anaminadakis.transacao.cartao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
