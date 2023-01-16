package com.southwind.repository;

import com.southwind.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserRepository {

    @Select("select * from user where username = #{username} and password=#{password}")
    User queryOne(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username}")
    User queryUserByUsername(String username);

    @Insert("insert into user value (#{username}, #{password})")
    int addUser(User user);
}
