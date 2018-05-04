package cn.com.mybatis.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.po.User;
import cn.com.mybatis.po.UserInstance;
import cn.com.mybatis.po.UserQueryInfo;

public class MyBatisTest {
	public DataConnection dataConn = new DataConnection();
	@Test
	public void TestSelect() throws IOException{
		SqlSession sqlSession = dataConn.getSqlSession();
		//sqlSession.selectOne最终结果与映射文件中所匹配的resultType类型
		User user = sqlSession.selectOne("test.findUserById", 2);
		System.out.println("姓名：" + user.getUsername());
		System.out.println("性别：" + user.getGender());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("生日：" + format.format(user.getBirthday()));
		System.out.println("所在地：" + user.getProvince() + user.getCity());
		sqlSession.close();
	}
	@Test
	public void TestFuzzySearch() throws IOException{
		SqlSession sqlSession = dataConn.getSqlSession();
		List<User> userList = sqlSession.selectList("test.findUserByUsername", "丽");
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
	public void TestInsert() throws IOException, ParseException{
		SqlSession sqlSession=dataConn.getSqlSession();
		User user=new User();
		user.setUsername("孙佳佳");
		user.setGender("男");
		user.setPassword("5555");
		user.setEmail("5555@163.com");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(format.parse("1991-02-16"));
		user.setProvince("湖北省");
		user.setCity("武汉市");
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	@Test
	public void TestDelete() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		sqlSession.delete("test.deleteUser",5);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void TestUpdate() throws IOException{
		SqlSession sqlSession = dataConn.getSqlSession();
		User user=new User();
		user.setId(4);
		user.setUsername("孙丽");
		sqlSession.update("test.updateUserName", user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testFindUserList() throws IOException{
		SqlSession sqlSession =dataConn.getSqlSession();
		//创建包装类，设置查询条件
		UserQueryInfo userQueryInfo=new UserQueryInfo();
		UserInstance userInstance=new UserInstance();
		userInstance.setGender("男");
		userInstance.setUsername("张三");
		userQueryInfo.setUserInstance(userInstance);
		
		//调用userMapper方法
		List<UserInstance> userList=sqlSession.selectList("test.findUserList", userQueryInfo);
		for (UserInstance user : userList) {
			System.out.println(user.getId()+":"+user.getUsername());
		}
		sqlSession.close();
	}
	
	
}
