package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
    private String publisher;
    private String author;
    private Double price;
    private Bookcase bookcase ;
}
