package com.tang.web.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tang.commons.core.model.LoginModel;
import com.tang.commons.utils.AjaxResult;
import com.tang.commons.utils.SecurityUtils;
import com.tang.framework.web.service.LoginService;
import com.tang.system.service.SysMenuService;

/**
 * 登陆验证逻辑控制层
 *
 * @author Tang
 */
@RestController
public class LoginController {

    private final LoginService loginService;

    private final SysMenuService menuService;

    public LoginController(LoginService loginService, SysMenuService menuService) {
        this.loginService = loginService;
        this.menuService = menuService;
    }

    /**
     * 登陆
     *
     * @param loginModel 登陆模型
     * @return 令牌
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginModel loginModel) {
        var token = loginService.login(loginModel);
        return AjaxResult.success(Map.of("token", token));
    }

    /**
     * 获取用户信息
     *
     * @return 信息
     */
    @GetMapping("/getInfo")
    public AjaxResult getInfo() {
        var user = SecurityUtils.getUser();
        var roles = SecurityUtils.getRoles();
        var permissions = SecurityUtils.getPermissions();
        return AjaxResult.success(Map.of("user", user, "roles", roles, "permissions", permissions));
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRoutes")
    public AjaxResult getRoutes() {
        var user = SecurityUtils.getUser();
        var menuList = menuService.selectMenuListTreeByUserId(user.getUserId());
        return AjaxResult.success(menuList);
    }

}
