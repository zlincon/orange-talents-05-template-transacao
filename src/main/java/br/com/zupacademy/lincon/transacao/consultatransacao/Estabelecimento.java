package br.com.zupacademy.lincon.transacao.consultatransacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @JsonProperty
  private String nome;
  @JsonProperty
  private String cidade;
  @JsonProperty
  private String endereco;

  @Override
  public String toString() {
    return "Estabelecimento{" +
        "nome='" + nome + '\'' +
        ", cidade='" + cidade + '\'' +
        ", endereco='" + endereco + '\'' +
        '}';
  }
}
