package com.tyza66.toforum.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class SaConfig implements StpInterface {

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        switch ((String) loginId) {
            case "0":
                list.add("super-admin");
                break;
            case "1":
                list.add("admin");
                break;
            case "2":
                list.add("user");
                break;
            case "3":
                list.add("ban");
                break;
        }
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<String>();
        switch ((String) loginId) {
            case "0":
                list.add("super-admin");
                break;
            case "1":
                list.add("admin");
                break;
            case "2":
                list.add("user");
                break;
            case "3":
                list.add("ban");
                break;
        }
        return list;
    }

}
