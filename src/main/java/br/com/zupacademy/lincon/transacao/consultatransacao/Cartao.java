package br.com.zupacademy.lincon.transacao.consultatransacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Cartao {
  @Id
  @JsonProperty
  private String id;
  @JsonProperty
  private String email;
  @OneToMany(mappedBy = "cartao")
  private List<EventoDeTransacao> transacoes;


  @Override
  public String toString() {
    return "Cartao{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", transacoes=" + transacoes +
        '}';
  }
}
