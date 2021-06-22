package br.com.zupacademy.lincon.transacao.consultatransacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoDeTransacaoRepository extends JpaRepository<EventoDeTransacao, String> {
  Page<EventoDeTransacao> findAllByCartaoId(String id, Pageable pageable);
  List<EventoDeTransacao> findLast10ByCartaoId(String id);
}
