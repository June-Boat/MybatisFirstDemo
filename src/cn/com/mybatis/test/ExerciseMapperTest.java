package cn.com.mybatis.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.mapper.ExerciseMapper;
import cn.com.mybatis.po.*;

public class ExerciseMapperTest {
	SqlSession sqlSession;
	@Before
	public void setUp() throws IOException{
		sqlSession=new DataConnection().getSqlSession();
	}
/*	@Test
	public void testSelectOneByOne(){
		ExerciseMapper exerMapper=sqlSession.getMapper(ExerciseMapper.class);
		List<BatchInfo> list=exerMapper.selectOneByOne();
		for (BatchInfo batch : list) {
			System.out.println(batch);
		}
		
	}*/
	/*@Test
	public void testSelectOneByOneByResultMap(){
		ExerciseMapper exerMapper=sqlSession.getMapper(ExerciseMapper.class);
				
		List<BatchItems> bcList=exerMapper.selectOneByOneByResultMap();
	    if(bcList!=null){
	    	BatchItems batchItem = null;
	    	Customer customer = null;
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    	for (int i = 0; i < bcList.size(); i++) {
	    		batchItem = bcList.get(i);//取出批次对象
	    		customer = batchItem.getCustomer();//取出该批次的用户信息
	    		System.out.println("卡号为"+customer.getAcno()+"的名为"
	    				+customer.getUsername()+"的客户:\n于"
	    				+sdf.format(batchItem.getCreatetime())+"采购了批次号为"
	    				+batchItem.getNumber()+"的一批理财产品");
			}
	    }
	}
	
	@Test
	public void testSelectOneByMany(){
		ExerciseMapper exerMapper=sqlSession.getMapper(ExerciseMapper.class);
				
		List<BatchItems> bcList=exerMapper.selectOneByMany();
	    if(bcList!=null){
	    	BatchItems batchItem = null;
	    	Customer customer = null;
	    	List<BatchDetail> batchDetails = null;
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    	for (int i = 0; i < bcList.size(); i++) {
	    		batchItem = bcList.get(i);//取出批次对象
	    		customer = batchItem.getCustomer();//取出该批次的用户信息
	    		batchDetails = batchItem.getBatchdetail();
	    		System.out.println("卡号为"+customer.getAcno()+"的名为"
	    				+customer.getUsername()+"的客户:\n于"
	    				+sdf.format(batchItem.getCreatetime())+"采购了批次号为"
	    				+batchItem.getNumber()+"的一批理财产品，详情如下：");
	    		BatchDetail batchDetail = null;
	    		if(batchDetails!=null){
	    			for (int j = 0; j < batchDetails.size(); j++) {
	    				batchDetail = batchDetails.get(j);
	    				System.out.println("id为"+batchDetail.getProduct_id()
	    						+"的理财产品"+batchDetail.getProduct_num()+"份");
	    			}
	    		}
			}
	    }
	}
	@Test
	public void testSelectManyByMany(){
		ExerciseMapper exerMapper=sqlSession.getMapper(ExerciseMapper.class);
		
		List<Customer> customerList=exerMapper.selectManyByMany();
	    if(customerList!=null){
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	Customer customer = null;
	    	for (int i = 0; i < customerList.size(); i++) {
	    		customer = customerList.get(i);
	    		//1.获取用户基本信息
		    	System.out.println("卡号为"+customer.getAcno()+"的名为"
	    				+customer.getUsername()+"的客户:");
		    	//2.获取用户下的所有批次订单信息
		    	List<Batch> batchList=customer.getBatchList();
		    	Batch batch = null;
		    	for (int j = 0; j < batchList.size(); j++) {
		    		batch = batchList.get(j);
		    		System.out.println("于"
		    				+sdf.format(batch.getCreatetime())+"采购了批次号为"
		    				+batch.getNumber()+"的一批理财产品，详情如下：");
		    		//3.获取一个批次的明细
		    		List<BatchDetail> batchDetails = batch.getBatchDetailList();
		    		BatchDetail batchDetail = null;
		    		FinacialProduct finacialProduct = null;
		    		for (int k = 0; k < batchDetails.size(); k++) {
	    				batchDetail = batchDetails.get(k);
	    				System.out.println("id为"+batchDetail.getProduct_id()
	    						+"的理财产品"+batchDetail.getProduct_num()+"份。");
	    				//4.获取每个批次明细中的理财产品详细信息
	    				finacialProduct = batchDetail.getFinacialProduct();
	    				System.out.println("该理财产品的详细信息为：\n"
	    						+"产品名称:"+finacialProduct.getName()
	    						+"|产品价格:"+finacialProduct.getPrice()
	    						+"|产品简介:"+finacialProduct.getDetail());
		    		}	
		    	}
		    	System.out.println("**************************************");
	    	}
	    	
	    }
	}*/

/*	@Test
	public void testFindBatchUserLazyLoading(){
		ExerciseMapper exerMapper=sqlSession.getMapper(ExerciseMapper.class);
		List<BatchItems> batchItemList=exerMapper.findBatchUserLazyLoading(); 
      	BatchItems batchItem = null;
      	Customer customer = null;
        for (int i = 0; i < batchItemList.size(); i++) {  
        	batchItem = batchItemList.get(i);  
        	System.out.println("订单编号："+batchItem.getNumber());
            //执行getCustomer时才会去查询用户信息，这里实现了延迟加载  
        	customer=batchItem.getCustomer();  
            System.out.println("订购用户姓名:"+customer.getUsername());  
        }  
	}*/
	@Test  
	public void testFindCustomerCache1() throws Exception{  
		ExerciseMapper exerMapper=sqlSession.getMapper(ExerciseMapper.class);
	      
	    //调用userMapper的方法  
	    Customer customer1=exerMapper.findCustomerById(1);
	    System.out.println("用户姓名："+customer1.getUsername());
	    
	    Customer customer2=exerMapper.findCustomerById(1);
	    System.out.println("用户姓名："+customer2.getUsername());
	}
	
	
	
	@After
	public void setDown(){
		sqlSession.close();
	}
}
