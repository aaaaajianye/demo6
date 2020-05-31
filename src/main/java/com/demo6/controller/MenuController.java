package com.demo6.controller;

import com.alibaba.fastjson.JSON;
import com.demo6.biz.MenuBiz;
import com.demo6.entity.LayUiTable;
import com.demo6.entity.LayUiTree;
import com.demo6.entity.Menu;
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
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuBiz menuBizImpl;
    @RequestMapping("/toShowMenu")
    public String toShowMenu() {
        return "menu/showMenu";
    }

    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public List<LayUiTree> selectAllMenu(){
        List<LayUiTree> layUiTrees = menuBizImpl.selectAllMenu();
        return layUiTrees;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(){
        List<Menu> menus = menuBizImpl.selectAll();
        LayUiTable msJson = new LayUiTable();
        msJson.setCode(0);
        msJson.setMsg("");
        msJson.setCount(menus.size());
        msJson.setData(menus);
        return msJson;
    }


    @RequestMapping("/saveMenu")
    @ResponseBody
    public Object saveUser(Menu menu){
        int i = menuBizImpl.insertSelective(menu);
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

    @RequestMapping("/editMenu")
    @ResponseBody
    public Object editUser(Menu menu){
        int i = menuBizImpl.updateByPrimaryKeySelective(menu);
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

    @RequestMapping("/delMenu")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i = menuBizImpl.delMenuByID(list);
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
