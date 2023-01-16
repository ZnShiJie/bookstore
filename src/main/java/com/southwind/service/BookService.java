package com.southwind.service;

import com.southwind.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    // 查询所有书
    List<Book> queryAllBooks();

    int deleteBookById(int id);

    int addBook(Book book);

    Book queryBookById(int id);

    int updateBook(Book book);

    List<Book> queryBookByName(String bookName);

    int updateBookCounts(int counts, int id);
}
