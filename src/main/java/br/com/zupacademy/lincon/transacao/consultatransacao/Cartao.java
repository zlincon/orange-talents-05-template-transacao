package br.com.zupacademy.lincon.transacao.consultatransacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Cartao {
  @JsonProperty
  private String id;
  @JsonProperty
  private String email;
  @JsonProperty("EfetivadaEm")
  private String efetivadaEm;

  @Override
  public String toString() {
    return "Cartao{" +
        "id='" + id + '\'' +
        ", email='" + email + '\'' +
        ", efetivadaEm='" + efetivadaEm + '\'' +
        '}';
  }
}
