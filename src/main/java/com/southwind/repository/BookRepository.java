package com.southwind.repository;

import com.southwind.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookRepository {


//    @Select("select * from book")
    List<Book> queryAllBooks();

    //@Delete("delete from book where bookID = #{id}")
    int deleteBookById(int id);

    int addBook(Book book);


    Book QueryBookById(int id);

    @Update("update book set " +
            "bookName = #{bookName}, bookCounts = #{bookCounts}, detail=#{detail}," +
            " price=#{price}, author=#{author},publisher=#{publisher}, bid=#{bookcase.id} " +
            "where bookID = #{bookID}")
    int updateBook(Book book);

    List<Book> queryBookByName(String bookName);

    @Update("update  book set bookCounts = #{counts} where bookID = #{id}")
    int updateBookCounts(@Param("counts") int counts,@Param("id") int id);

}
