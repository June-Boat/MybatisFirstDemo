package cn.com.mybatis.po;
/*
 * 为不影响数据库中表和User类的映射
 * 其他业务需要的User的添加信息通过继承User类产生新类来完成
 */
public class UserInstance extends User {
	//其他的添加信息
}
