package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private Integer id; //tetst
    private String username;
    private String password;
//    private List<Borrow> borrows;
}
