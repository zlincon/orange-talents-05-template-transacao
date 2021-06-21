package br.com.zupacademy.lincon.transacao.consultatransacao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estabelecimento {
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
