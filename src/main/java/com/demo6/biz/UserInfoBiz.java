package com.demo6.biz;

import com.demo6.entity.MyUserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UserInfoBiz {

    PageInfo<MyUserInfo> selectAllUser(int page, int limit);
    MyUserInfo selectUserByUsername(String username);
    int insertSelective(MyUserInfo record);
    int delUserByID(List<String> ids);
    int updateByPrimaryKeySelective(MyUserInfo record);
}
