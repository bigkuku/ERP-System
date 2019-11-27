package com.bx.sys.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bx.sys.domain.Permission;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bx
 */
public interface PermissionMapper extends BaseMapper<Permission> {

	/**
	 * /根据权限或菜单ID删除权限表各和角色的关系表里面的数据
	 * @param id
	 */
	void deleteRolePermissionByPid(@Param("id")Serializable id);

}
