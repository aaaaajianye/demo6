package com.demo6.controller;

import com.demo6.biz.MenuBiz;
import com.demo6.entity.LayUiTree;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: 宋泽坚
 * @Date: 2020/05/30/17:56
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    private MenuBiz menuBizImpl;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        //获取shiro的主体
        Subject subject = SecurityUtils.getSubject();
        //构建用户登录令牌
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e){
            model.addAttribute("message", "用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
            return "login";
        }
        //保存用户名数据到model
        model.addAttribute("loginName",username);
        //放入所有的菜单，根据当前登录的用户
        List<LayUiTree> menus = menuBizImpl.selectAllMenuByName(username);
        model.addAttribute("menus",menus);
        return "index";
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
