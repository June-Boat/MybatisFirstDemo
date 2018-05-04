package cn.com.mybatis.mapper;

import java.util.List;

import cn.com.mybatis.po.BatchInfo;
import cn.com.mybatis.po.BatchItems;
import cn.com.mybatis.po.Customer;

public interface ExerciseMapper {
	public List<BatchInfo> selectOneByOne();
	public List<BatchItems> selectOneByOneByResultMap();
	public List<BatchItems> selectOneByMany();
	public List<Customer> selectManyByMany();
	public List<BatchItems> findBatchUserLazyLoading();
	public Customer findCustomerById(int id);
	
	
}
