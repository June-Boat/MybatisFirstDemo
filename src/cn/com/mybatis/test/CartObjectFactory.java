package cn.com.mybatis.test;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import cn.com.mybatis.po.ShoppingCart;

public class CartObjectFactory extends DefaultObjectFactory{

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		T ret=super.create(type, constructorArgTypes, constructorArgs);
		if(ShoppingCart.class.isAssignableFrom(type)){
			ShoppingCart entity=(ShoppingCart)ret;
			entity.init();
		}
		return ret; 
	}

	@Override
	public <T> T create(Class<T> type) {
		return super.create(type);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return super.isCollection(type);
	}

	@Override
	protected Class<?> resolveInterface(Class<?> arg0) {
		return super.resolveInterface(arg0);
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}
	
}
