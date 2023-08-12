package com.example.KafkaDemo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {
    private String bookName;
    private String isbn;
}
