package cn.com.mybatis.test;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.po.ShoppingCart;

public class ObjectFactoryTest {
	public static DataConnection dataConn=new DataConnection();
	public static void main(String[] args) throws IOException {
		SqlSession sqlSession=dataConn.getSqlSession();
		CartObjectFactory e=new CartObjectFactory();
		
		ArrayList constructorArgTypes=new ArrayList();
		constructorArgTypes.add(int.class);
		constructorArgTypes.add(String.class);
		constructorArgTypes.add(int.class);
		constructorArgTypes.add(double.class);
		constructorArgTypes.add(double.class);
		ArrayList constructorArgs=new ArrayList();
		constructorArgs.add(1);
		constructorArgs.add("牙刷");
		constructorArgs.add(12);
		constructorArgs.add(5.0);
		constructorArgs.add(0.0);
		ShoppingCart sCart=(ShoppingCart)e.create(ShoppingCart.class, constructorArgTypes, constructorArgs);
		System.out.println(sCart.getTotalAmount());
		sqlSession.close();
	}
}
