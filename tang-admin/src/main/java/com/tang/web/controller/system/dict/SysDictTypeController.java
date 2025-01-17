package com.tang.web.controller.system.dict;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tang.commons.utils.AjaxResult;
import com.tang.commons.utils.page.PageUtils;
import com.tang.commons.utils.page.TableDataResult;
import com.tang.system.entity.dict.SysDictType;
import com.tang.system.service.dict.SysDictTypeService;

/**
 * 字典类型逻辑控制层
 *
 * @author Tang
 */
@RestController
@RequestMapping("/system/dict/type")
public class SysDictTypeController {

    private final SysDictTypeService dictTypeService;

    public SysDictTypeController(SysDictTypeService dictTypeService) {
        this.dictTypeService = dictTypeService;
    }

    /**
     * 获取字典类型列表
     *
     * @param dictType 字典类型对象
     * @return 字典类型列表
     */
    @PreAuthorize("@auth.hasPermission('system:dict:list')")
    @GetMapping("/list")
    public TableDataResult list(SysDictType dictType) {
        PageUtils.startPage();
        var list = dictTypeService.selectDictTypeList(dictType);
        return PageUtils.getDataTable(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param typeId 字典类型主键
     * @return 字典类型对象
     */
    @PreAuthorize("@auth.hasPermission('system:dict:list')")
    @GetMapping("/{typeId}")
    public AjaxResult selectDictTypeByTypeId(@PathVariable Long typeId) {
        return AjaxResult.success(dictTypeService.selectDictTypeByTypeId(typeId));
    }

    /**
     * 新增字典类型信息
     *
     * @param dictType 字典类型对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dict:add')")
    @PostMapping
    public AjaxResult add(@RequestBody SysDictType dictType) {
        return AjaxResult.success(dictTypeService.insertDictType(dictType));
    }

    /**
     * 修改字典类型信息
     *
     * @param dictType 字典类型对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dict:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody SysDictType dictType) {
        return AjaxResult.success(dictTypeService.updateDictTypeByTypeId(dictType));
    }

    /**
     * 通过主键删除字典类型数据
     *
     * @param typeId 字典类型主键
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dict:delete')")
    @DeleteMapping("/{typeId}")
    public AjaxResult delete(@PathVariable Long typeId) {
        return AjaxResult.success(dictTypeService.deleteDictTypeByTypeId(typeId));
    }

    /**
     * 通过主键数组批量删除字典类型数据
     *
     * @param typeIds 字典类型主键数组
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dict:delete')")
    @DeleteMapping
    public AjaxResult deletes(@RequestBody Long[] typeIds) {
        return AjaxResult.success(dictTypeService.deleteDictTypeByTypeIds(typeIds));
    }

}
