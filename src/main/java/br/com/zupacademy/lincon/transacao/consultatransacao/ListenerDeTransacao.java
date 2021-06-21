package br.com.zupacademy.lincon.transacao.consultatransacao;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ListenerDeTransacao implements ConsumerSeekAware {

  @KafkaListener(topics = "${spring.kafka.topic.transactions}",
      topicPartitions = @TopicPartition(topic = "transacoes", partitionOffsets =
      @PartitionOffset(partition = "0", initialOffset = "0")))
  public void ouvir(EventoDeTransacao eventoDeTransacao) {
    System.out.println(eventoDeTransacao.toString());
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
