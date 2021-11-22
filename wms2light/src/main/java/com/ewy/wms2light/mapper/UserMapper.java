package com.ewy.wms2light.mapper;

import com.ewy.wms2light.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
//    注释掉了注解开发方式
//    @Select("SELECT * FROM W_USER WHERE id = #{id}")
    public User findById(Integer id);

//    @Select("SELECT * FROM W_USER")
    public List<User> findUsers();

//    @Insert("INSERT INTO W_USER VALUES(wuser_seq.nextval,#{name},#{password},#{warehouseno},#{phonenumber},#{roleno})")
    public Integer insertUser(User user);

//    @Update("UPDATE W_USER SET name = #{name},password = #{password},warehouseno = #{warehouseno}," +
//            "phonenumber = #{phonenumber},roleno = #{roleno} WHERE id = #{id}")
    public Integer updateUser(User user);

//    @Delete("DELETE FROM W_USER WHERE id = #{id}")
    public Integer deleteUserById(Integer id);

}
