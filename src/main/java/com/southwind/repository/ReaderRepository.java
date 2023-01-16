package com.southwind.repository;

import com.southwind.entity.Reader;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ReaderRepository {

    @Select("select * from reader where password=#{password} and username=#{username}")
    Reader getReader(@Param("password") String password,@Param("username") String username);

}
