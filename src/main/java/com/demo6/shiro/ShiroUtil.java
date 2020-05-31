package com.demo6.shiro;

import com.demo6.util.MyConstants;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Auther: 宋泽坚
 * @Date: 2020/05/30/17:09
 * @Description:
 */
public class ShiroUtil {
    /**
     * 加盐加密
     * @param salt
     * @param message
     * @return
     */
    public static String encryptionBySalt(String salt, String message){
        //String algorithmName 加密算法,
        // Object source 明文, Object salt 盐值, int hashIterations 加密次数
        String algorithmName= MyConstants.algorithmName;
        int hashIterations=MyConstants.hashIterations;
        SimpleHash simpleHash=new SimpleHash(algorithmName,message,salt,hashIterations);
        return simpleHash.toString();
    }
}
