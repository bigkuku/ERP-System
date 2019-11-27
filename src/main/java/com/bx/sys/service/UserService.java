package com.bx.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bx.sys.domain.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bx
 */
public interface UserService extends IService<User> {

	/**
	 * 保存用户和角色之间的关系
	 * @param uid
	 * @param ids
	 */
	void saveUserRole(Integer uid, Integer[] ids);

}
