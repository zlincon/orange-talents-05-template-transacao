package br.com.zupacademy.lincon.transacao.consultatransacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class EventoDeTransacao {
  @JsonProperty
  private String id;
  @JsonProperty
  private BigDecimal valor;
  @JsonProperty
  private Estabelecimento estabelecimento;
  @JsonProperty
  private Cartao cartao;

  @Override
  public String toString() {
    return "EventoDeTransacao{" +
        "id='" + id + '\'' +
        ", valor=" + valor +
        ", estabelecimento=" + estabelecimento +
        ", cartao=" + cartao +
        '}';
  }
}
