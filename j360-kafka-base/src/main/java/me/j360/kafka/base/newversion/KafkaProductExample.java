package me.j360.kafka.base.newversion;

import me.j360.kafka.base.Contants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Package: me.j360.kafka.base.newversion
 * User: min_xu
 * Date: 16/8/2 下午5:51
 * 说明：
 */
public class KafkaProductExample {

    public static void main(String args[]){
        Properties props = new Properties();
        props.put("bootstrap.servers", Contants.kafkaUrl);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String sss = "In Kafka the communication between the clients and the servers is done with a simple, high-performance, language agnostic TCP protocol. This protocol is versioned and maintains backwards compatibility with older version. We provide a Java client for Kafka, but clients are available in many languages.";
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for(int i = 0; i < 1000; i++)
            producer.send(new ProducerRecord<String, String>(Contants.TOPIC.Send, Integer.toString(0), sss));

        producer.close();
    }
}
