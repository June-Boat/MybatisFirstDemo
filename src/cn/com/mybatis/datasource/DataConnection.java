package cn.com.mybatis.datasource;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataConnection {
	private String resource="SqlMapConfig.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	public SqlSession getSqlSession() throws IOException {
		InputStream inputStream= Resources.getResourceAsStream(resource);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
		
		
		/*
		 * 资源加载器加载资源，inputStream
		 * 工厂建造者通过信息，生成工厂
		 * 会话工厂打开一个会话。
		 
		InputStream input= Resources.getResourceAsStream(resource);
		SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(input);
		SqlSession ss=sf.openSession();
		return ss;
		*/
	}
	
}
