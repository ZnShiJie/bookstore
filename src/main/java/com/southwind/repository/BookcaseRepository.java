package com.southwind.repository;

import com.southwind.entity.Bookcase;
import org.apache.ibatis.annotations.Select;

public interface BookcaseRepository {

    @Select("select * from bookcase where id = #{id}")
    Bookcase queryById(int id);

}
