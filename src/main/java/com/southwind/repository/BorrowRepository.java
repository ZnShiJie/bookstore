package com.southwind.repository;

import com.southwind.entity.Borrow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowRepository {

    @Insert("insert into borrow value (#{orderNumber}, #{bookName},  #{borrowDate},#{readerId}, #{returnDate}, #{bookID})")
    int addBorrow(Borrow borrow);

    @Select("select * from borrow where readerId = #{readerId} and bookName = #{bookName}")
    Borrow queryRecord(@Param("bookName") String bookName, @Param("readerId") int readerId);

    @Select("select * from borrow where readerId = #{readerId};")
    List<Borrow> queryRecordsByReaderId(int readerId);

    @Select("select  * from borrow where orderNumber = #{orderNum}")
    Borrow queryRecordByOrderNum(String orderNum);

    @Delete("delete  from borrow where orderNumber = #{orderNum}")
    int deleteByOrderNum(String orderNum);
}
