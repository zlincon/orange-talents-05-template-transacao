package br.com.zupacademy.lincon.transacao.consultatransacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ConsultaTransacoesController {

  @Autowired
  private EventoDeTransacaoRepository repository;

  @GetMapping("/api/transacoes/{id}")
  public ResponseEntity<List<EventoDeTransacao>> consultaTransacoes(@PathVariable String id){
    Pageable page = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC,
        "efetivadaEm"));
    Page<EventoDeTransacao> all =
        repository.findAllByCartaoId(id, page);
    if(all.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
//    List<EventoDeTransacao> all = repository.findLast10ByCartaoId(id);
    return ResponseEntity.ok(all.getContent());
  }

}
