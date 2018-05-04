package cn.com.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.po.User;
import cn.com.mybatis.po.UserInstance;
import cn.com.mybatis.po.UserQueryInfo;

public class UserMapperTest {
	private DataConnection dataConn=new DataConnection();

/*	@Test
	public void testFindUserById() throws IOException {
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.findUserById(2);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testFindUserByUsername() throws IOException {
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

		List<User> userList = userMapper.findUserByUsername("丽");
		for (User user : userList) {
			System.out.println("姓名：" + user.getUsername());
			System.out.println("性别：" + user.getGender());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("生日：" + format.format(user.getBirthday()));
			System.out.println("所在地：" + user.getProvince() + user.getCity());
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindUserList() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		UserQueryInfo userQueryInfo=new UserQueryInfo();
		//添加信息
//		UserInstance userInstance =new UserInstance();
//		userQueryInfo.setUserInstance(userInstance);
//		userInstance.setGender("男");
//		userInstance.setUsername("李");
		List<Integer> idList=new ArrayList<>();
		userQueryInfo.setIdList(idList);
		for (int i = 0; i < 5; i++) {
			idList.add(i);
		}
		List<? extends User> userList=userMapper.findUserList(userQueryInfo);
		
		for (User user : userList) {
			System.out.println("姓名：" + user.getUsername());
			System.out.println("性别：" + user.getGender());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("生日：" + format.format(user.getBirthday()));
			System.out.println("所在地：" + user.getProvince() + user.getCity());
		}
		sqlSession.close();
	}
	
	@Test
	public void findUserByResultmap() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<? extends User> userList=userMapper.findUserByResultmap(1);
		for (User user : userList) {
			System.out.println("id : " +user.getId());
			System.out.println("姓名：" + user.getUsername());
			System.out.println("性别：" + user.getGender());
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindUserByHashmap() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		//查询信息参数
		HashMap<String,String> hashmap=new HashMap<>();
		hashmap.put("id", "2");
		 
		 * 当传递的map中的key和sql查询语句解析的key不一致时
		 * 例如sql查询中有username，而传入的map没有username这个key
		 * 测试结果没有报错，sql中对应的key的value值为空。
		 * hashmap.put("username", "李");
		 
		
		List<User> userList=userMapper.findUserByHashmap(hashmap);
		
		for (User user : userList) {
			System.out.println("姓名：" + user.getUsername());
			System.out.println("性别：" + user.getGender());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("生日：" + format.format(user.getBirthday()));
			System.out.println("所在地：" + user.getProvince() + user.getCity());
		}
		sqlSession.close();
	}

	@Test
	public void testInsertUser() throws IOException, ParseException {
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user= new User();
		//设置user信息
		user.setUsername("孙佳佳");
		user.setGender("男");
		user.setPassword("5555");
		user.setEmail("5555@163.com");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(format.parse("1991-02-16"));
		user.setProvince("湖北省");
		user.setCity("武汉市");
		userMapper.insertUser(user);
//		sqlSession.commit();
		System.out.println(user.getId());
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() throws IOException {
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(4);
		sqlSession.close();
	}

	@Test
	public void testUpdateUserName() throws IOException {
		SqlSession sqlSession=dataConn.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setId(4);
		user.setUsername("孙丽");
		userMapper.updateUserName(user);
		sqlSession.commit();
		sqlSession.close();
	}*/

	@Test
	/*
	 * 测试二级缓存
	 */
	public void testTwoLevelCache() throws Exception {
		// 创建UserMapper对象
	/*	SqlSession sqlSession1 = dataConn.getSqlSession();
		SqlSession sqlSession2 = dataConn.getSqlSession();
		//SqlSession sqlSession3 = dataConn.getSqlSession();
*/		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();


		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		//UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);

		// 第一次查询
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		// 在close的时候，才会将数据写入到二级缓存中
		sqlSession1.close();

	//	 执行添加用户操作
	//	 mapper3.insertUser(user1);
	//	 执行commit时，将一级缓存清空
	//	 sqlSession3.commit();

		// 第二次查询
		User user2 = mapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();

		// 关闭资源
	//	sqlSession3.close();
	}
}
