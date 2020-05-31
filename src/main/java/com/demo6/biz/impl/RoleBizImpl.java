package com.demo6.biz.impl;

import com.demo6.biz.RoleBiz;
import com.demo6.dao.RoleMapper;
import com.demo6.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 宋泽坚
 * @Date: 2020/05/30/17:26
 * @Description:
 */
@Service
public class RoleBizImpl implements RoleBiz {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return  roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public int delRoleByID(List<String> ids) {
        return roleMapper.delRoleByID(ids);
    }


}
