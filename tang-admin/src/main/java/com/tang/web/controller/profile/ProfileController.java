package com.tang.web.controller.profile;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tang.commons.core.model.SysUserModel;
import com.tang.commons.core.vo.PasswordVo;
import com.tang.commons.utils.AjaxResult;
import com.tang.commons.utils.SecurityUtils;
import com.tang.commons.utils.page.PageUtils;
import com.tang.commons.utils.page.TableDataResult;
import com.tang.framework.web.service.TokenService;
import com.tang.system.entity.SysUser;
import com.tang.system.entity.log.SysLogLogin;
import com.tang.system.service.SysUserService;
import com.tang.system.service.log.SysLogLoginService;

/**
 * 个人中心逻辑控制层
 *
 * @author Tang
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final SysUserService userService;

    private final TokenService tokenService;

    private final SysLogLoginService logLoginService;

    public ProfileController(SysUserService userService, TokenService tokenService, SysLogLoginService logLoginService) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.logLoginService = logLoginService;
    }

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:user:edit')")
    @PutMapping("/edit-info")
    public AjaxResult editInfo(@RequestBody SysUser user) {
        var userModel = SecurityUtils.getUserModel();
        var sysUserModel = new SysUserModel();
        BeanUtils.copyProperties(user, sysUserModel);
        userModel.setUser(sysUserModel);
        tokenService.set(userModel);
        return AjaxResult.success(userService.updateUserByUserId(user));
    }

    /**
     * 修改用户密码
     *
     * @param passwordVo 密码对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:user:edit')")
    @PutMapping("/edit-password")
    public AjaxResult editPassword(@RequestBody PasswordVo passwordVo) {
        return AjaxResult.success(userService.updatePasswordByUserId(passwordVo));
    }

    /**
     * 获取用户登录日志列表
     *
     * @param logLogin 登陆日志对象
     * @return 用户登陆日志列表
     */
    @PreAuthorize("@auth.hasPermission('system:log:login:list')")
    @GetMapping("/login-log")
    public TableDataResult userLoginList(SysLogLogin logLogin) {
        PageUtils.startPage();
        var list = logLoginService.selectSysLogLoginListByUser(logLogin);
        return PageUtils.getDataTable(list);
    }

}
