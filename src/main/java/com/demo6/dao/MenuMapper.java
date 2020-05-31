package com.demo6.dao;

import com.demo6.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    //查询所有菜单
    List<Menu> selectAllMenu();

    List<Menu>  selectAllMenuByName(String loginName);

    int delMenuByID(List<String> ids);

    List<Menu> selectAll();
}