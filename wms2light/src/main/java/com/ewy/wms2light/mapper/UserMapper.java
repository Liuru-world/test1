package com.ewy.wms2light.mapper;

import com.ewy.wms2light.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM W_USER WHERE id = #{id}")
    public User findById(Integer id);

    @Select("SELECT * FROM W_USER")
    public List<User> findUsers();

    @Insert("INSERT INTO W_USER VALUES(wuser_seq.nextval,#{name},#{password},#{warehouseno},#{phonenumber},#{role})")
    public Integer insertUser(User user);
}
