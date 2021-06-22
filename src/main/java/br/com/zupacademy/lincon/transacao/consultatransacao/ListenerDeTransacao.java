package br.com.zupacademy.lincon.transacao.consultatransacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao implements ConsumerSeekAware {

  private static final Logger LOG = LoggerFactory.getLogger(ListenerDeTransacao.class);
  @Autowired
  private EventoDeTransacaoRepository repository;

  @KafkaListener(topics = "${spring.kafka.topic.transactions}",
      topicPartitions = @TopicPartition(topic = "transacoes", partitionOffsets =
      @PartitionOffset(partition = "0", initialOffset = "0"))
  )

  public void ouvir(EventoDeTransacao eventoDeTransacao) {
    repository.save(eventoDeTransacao);
    LOG.info("received data='{}'", eventoDeTransacao);
  }

//  @Override
//  public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
//    String topic=
//        Optional.ofNullable(System.getProperty()).orElseThrow(()->new RuntimeException("topicName needs to be set"));
//    assignments.keySet().stream().filter(partition->topic.equals(partition.topic()))
//        .forEach(partition -> callback.seekToBeginning(topic, partition.partition()));
//  }
//
//  @Override
//  public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {}
//
//  @Override
//  public void registerSeekCallback(ConsumerSeekCallback callback) {}
}
