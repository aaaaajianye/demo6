package com.demo6.biz.impl;

import com.demo6.biz.MenuBiz;
import com.demo6.dao.MenuMapper;
import com.demo6.entity.LayUiTree;
import com.demo6.entity.Menu;
import com.demo6.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 宋泽坚
 * @Date: 2020/05/30/17:26
 * @Description:
 */
@Service
public class MenuBizImpl implements MenuBiz {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }
    /**
     * 查询所有的菜单，并组装成tree格式的
     * @return
     */
    @Override
    public List<LayUiTree> selectAllMenu() {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenu();
        //并组装成tree格式的
        return TreeUtils.getChildPerms(menus, 0);
    }

    @Override
    public List<LayUiTree> selectAllMenuByName(String loginName) {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenuByName(loginName);
        //并组装成tree格式的
        return TreeUtils.getChildPerms(menus, 0);
    }

    @Override
    public int delMenuByID(List<String> ids) {
        return menuMapper.delMenuByID(ids);
    }

    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }


}
