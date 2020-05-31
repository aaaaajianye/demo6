package com.demo6.biz;

import com.demo6.entity.LayUiTree;
import com.demo6.entity.Menu;

import java.util.List;

public interface MenuBiz {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);
    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<LayUiTree>  selectAllMenu();
    //根据用户登录名查询对应的所有菜单
    List<LayUiTree>  selectAllMenuByName(String loginName);

    int delMenuByID(List<String> ids);

    List<Menu> selectAll();
}