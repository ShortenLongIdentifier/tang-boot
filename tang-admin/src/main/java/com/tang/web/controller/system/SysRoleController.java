package com.tang.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tang.commons.utils.AjaxResult;
import com.tang.system.entity.SysRole;
import com.tang.system.service.SysRoleService;

/**
 * 角色表 SysRole 表控制层
 *
 * @author Tang
 */
@RestController
@RequestMapping("/system/role")
public class SysRoleController {

    /**
     * 服务对象
     */
    @Autowired
    private SysRoleService roleService;

    /**
     * 获取角色列表
     *
     * @param role 角色对象
     * @return 角色列表
     */
    @GetMapping("/list")
    public AjaxResult list(SysRole role){
        var list = roleService.selectRoleList(role);
        return AjaxResult.success(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param roleId 主键
     * @return 角色对象
     */
    @GetMapping("/{roleId}")
    public AjaxResult selectRoleByRoleId(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(roleService.selectRoleByRoleId(roleId));
    }

    /**
     * 新增角色
     *
     * @param role 角色对象
     * @return 影响行数
     */
    @PostMapping
    public AjaxResult add(SysRole role) {
        return AjaxResult.success(roleService.insertRole(role));
    }

    /**
     * 修改角色信息
     *
     * @param role 角色对象
     * @return 影响行数
     */
    @PutMapping
    public AjaxResult edit(SysRole role) {
        return AjaxResult.success(roleService.updateRoleByRoleId(role));
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    @DeleteMapping("/{roleId}")
    public AjaxResult deleteById(@PathVariable Long roleId) {
        return AjaxResult.success(roleService.deleteRoleByRoleId(roleId));
    }

}