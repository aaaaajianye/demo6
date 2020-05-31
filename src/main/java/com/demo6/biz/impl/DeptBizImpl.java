package com.demo6.biz.impl;

import com.demo6.biz.DeptBiz;
import com.demo6.dao.DeptMapper;
import com.demo6.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 宋泽坚
 * @Date: 2020/05/30/17:26
 * @Description:
 */
@Service
public class DeptBizImpl implements DeptBiz {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }

    @Override
    public int delDeptByID(List<String> ids) {
        return deptMapper.delDeptByID(ids);
    }
}
