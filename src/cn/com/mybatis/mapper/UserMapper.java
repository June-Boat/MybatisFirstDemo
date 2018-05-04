package cn.com.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import cn.com.mybatis.po.User;
import cn.com.mybatis.po.UserInstance;
import cn.com.mybatis.po.UserQueryInfo;

public interface UserMapper {
	public User findUserById(int id);
	//模糊查询放回多个结果集，此时的返回类型应为？
	public List<User> findUserByUsername(String value);
	//UserInstance 查询
	public List<UserInstance> findUserList(UserQueryInfo userQueryInfo);
	//HashMap查询
	public List<User> findUserByHashmap(HashMap hashmap);
	//利用resultMap查询
	public List<User> findUserByResultmap(int id);
	//插入
	public void insertUser(User user);
	//删除
	public void deleteUser(int id);
	//更新
	public void updateUserName(User user);
}
