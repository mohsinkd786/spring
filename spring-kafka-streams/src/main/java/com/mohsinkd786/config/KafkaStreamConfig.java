package com.mohsinkd786.config;

import com.mohsinkd786.Data;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.HashMap;
import java.util.Map;

@EnableKafkaStreams
@EnableKafka
@Configuration
public class KafkaStreamConfig {

    @Value("${kafka.streams.bootstrapserver}")
    private String bootstrapServer;

    @Bean(name= KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public StreamsConfig kStreamsConfig(){
        Map<String,Object> configs=new HashMap<>();

        configs.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        configs.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        configs.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        configs.put(StreamsConfig.APPLICATION_ID_CONFIG,"kafka-demo-stream");
        configs.put(JsonDeserializer.KEY_DEFAULT_TYPE,String.class);
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE,Data.class);

        return  new StreamsConfig(configs);
    }

    @Bean
    public KStream<String, Data>  kStreamJson(StreamsBuilder builder){
        KStream<String,Data> stream = builder
                .stream("kafka-demo", Consumed.with(Serdes.String(),new JsonSerde<>(Data.class)));

        KTable<String,Long> combinedDataDocs = stream
                .map(new DataKVMapper())
                .groupByKey().count();
        return stream;
    }

    public static class DataKVMapper implements KeyValueMapper<String,Data, KeyValue<String,Data>>{
        @Override
        public KeyValue<String, Data> apply(String s, Data data) {
            return new KeyValue<>(data.getKey(),data);
        }
    }
}
