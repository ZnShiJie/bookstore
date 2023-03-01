package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookID; // book id
    private String bookName;
    private Integer bookCounts;
    private String detail;
    private String publisher; //teset
    private String author;
    private Double price;
    private Bookcase bookcase ;
}
