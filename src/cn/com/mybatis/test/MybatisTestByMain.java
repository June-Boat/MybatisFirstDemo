package cn.com.mybatis.test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;

import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.po.User;

public class MybatisTestByMain {
	public DataConnection dataConn = new DataConnection();
	public static void main(String[] args) throws IOException {
		MybatisTestByMain mt=new MybatisTestByMain();
		SqlSession sqlSession = mt.dataConn.getSqlSession();
		//sqlSession.selectOne最终结果与映射文件中所匹配的resultType类型
		User user = sqlSession.selectOne("test.findUserById", 2);
		System.out.println("姓名：" + user.getUsername());
		System.out.println("性别：" + user.getGender());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("生日：" + format.format(user.getBirthday()));
		System.out.println("所在地：" + user.getProvince() + user.getCity());
		sqlSession.close();
	}
}
