package com.demo6.biz;

import com.demo6.entity.Role;

import java.util.List;

public interface  RoleBiz {
   List<Role> selectAllRole();

   int updateByPrimaryKeySelective(Role record);

   int insertSelective(Role record);

   int delRoleByID(List<String> ids);
}
