package com.tang.system.entity.dict;

import com.tang.commons.core.base.entity.BaseEntity;

/**
 * 字典类型表 sys_dict_type 实体类
 *
 * @author Tang
 * @since 2023-02-23 21:05:28
 */
public class SysDictType extends BaseEntity {

    @java.io.Serial
    private static final long serialVersionUID = 8710678917971210246L;

    /**
     * 类型ID
     */
    private Long typeId;

    /**
     * 字典名称
     */
    private String typeName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 状态{0=正常, 1=停用}
     */
    private String status;


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
