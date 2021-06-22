package br.com.zupacademy.lincon.transacao.consultatransacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class EventoDeTransacao {
  @Id
  @JsonProperty
  private String id;
  @JsonProperty
  private BigDecimal valor;
  @JsonProperty
  @OneToOne(cascade = CascadeType.ALL)
  private Estabelecimento estabelecimento;
  @JsonProperty
  @ManyToOne(cascade = CascadeType.ALL)
  private Cartao cartao;
  @JsonProperty
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime efetivadaEm;

  @Override
  public String toString() {
    return "EventoDeTransacao{" +
        "id=" + id +
        ", valor=" + valor +
        ", estabelecimento=" + estabelecimento +
        ", cartao=" + cartao +
        ", efetivadaEm=" + efetivadaEm +
        '}';
  }
}
