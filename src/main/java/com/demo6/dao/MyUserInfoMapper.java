package com.demo6.dao;

import com.demo6.entity.MyUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MyUserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(MyUserInfo record);

    int insertSelective(MyUserInfo record);

    MyUserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(MyUserInfo record);

    int updateByPrimaryKey(MyUserInfo record);

    MyUserInfo selectUserByUsername(String username);

    int delUserByID( @Param("ids") List<String> ids);

    List<MyUserInfo> selectAllUser();
}