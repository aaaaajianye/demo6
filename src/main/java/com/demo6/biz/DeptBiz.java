package com.demo6.biz;

import com.demo6.entity.Dept;

import java.util.List;


public interface DeptBiz {
   List<Dept> selectAllDept();

   int updateByPrimaryKeySelective(Dept record);

   int insertSelective(Dept record);

   int delDeptByID(List<String> ids);
}
