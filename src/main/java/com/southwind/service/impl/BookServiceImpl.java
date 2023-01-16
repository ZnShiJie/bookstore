package com.southwind.service.impl;

import com.southwind.entity.Book;
import com.southwind.repository.BookRepository;
import com.southwind.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> queryAllBooks() {
        return bookRepository.queryAllBooks();
    }
    @Override
    public int deleteBookById(int id) {
        return bookRepository.deleteBookById(id);
    }
    @Override
    public int addBook(Book book) {
        return bookRepository.addBook(book);
    }
    @Override
    public Book queryBookById(int id) {
        return bookRepository.QueryBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookRepository.updateBook(book);
    }

    @Override
    public List<Book> queryBookByName(String bookName) {
        return bookRepository.queryBookByName(bookName);
    }

    @Override
    public int updateBookCounts(int counts, int id) {
        return bookRepository.updateBookCounts(counts, id);
    }


}
