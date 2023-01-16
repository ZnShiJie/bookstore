package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    private String orderNumber;
    private String bookName;
    private Integer readerId;
    private Integer bookID;
    private String borrowDate;
    private String returnDate;
}
