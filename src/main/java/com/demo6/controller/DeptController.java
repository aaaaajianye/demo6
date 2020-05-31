package com.demo6.controller;

import com.alibaba.fastjson.JSON;
import com.demo6.biz.DeptBiz;
import com.demo6.entity.Dept;
import com.demo6.entity.LayUiTable;
import com.demo6.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 宋泽坚
 * @Date: 2020/05/30/17:56
 * @Description:
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptBiz deptBizImpl;

    @RequestMapping("/toShowDept")
    public String toShowDept(){
        return "dept/showDept";
    }

    @RequestMapping("/showDept")
    @ResponseBody
    public LayUiTable showDept(){
        List<Dept> deptList = deptBizImpl.selectAllDept();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(deptList);
        return layUiTable;
    }

    @RequestMapping("/saveDept")
    @ResponseBody
    public Object saveUser(Dept dept){
        int i = deptBizImpl.insertSelective(dept);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }

    @RequestMapping("/editDept")
    @ResponseBody
    public Object editUser(Dept dept){
        int i = deptBizImpl.updateByPrimaryKeySelective(dept);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping("/delDept")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i = deptBizImpl.delDeptByID(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }
}
