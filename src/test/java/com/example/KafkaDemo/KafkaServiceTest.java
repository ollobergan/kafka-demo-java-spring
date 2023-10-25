package com.example.KafkaDemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@Import(KafkaConfig.class)
@TestPropertySource(locations="classpath:test.properties")
@Disabled
public class KafkaServiceTest {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private KafkaService22 kafkaService2;

    @Test
    @Disabled
    void simepleMessagePublish(){

        Book book = new Book();
        book.setBookName("Book 1");
        book.setIsbn("isbn");

        kafkaService.publish(book);
    }

    @Test
    @Disabled
    void MessagePublishWithKey(){
        String key = "Key1";
        Book book = new Book();
        book.setBookName("Book 1");
        book.setIsbn("isbn");

        kafkaService.publish(book, key);
    }

    @Test
    @Disabled
    void MessagePublishWithKeyPartition(){
        String key = "Key1";
        Integer partition = 0;
        Book book = new Book();
        book.setBookName("Book 1");
        book.setIsbn("isbn");

        kafkaService.publish(book, key, partition);
    }

    @Test
    @Disabled
    void testKafkaPublish(){

        KafkaTest test = new KafkaTest();
        test.setTin("200523221");
        test.setSana("2023-08-23");
        test.setYil(2023);
        test.setOy(8);

        kafkaService2.publish(test);
    }
}
