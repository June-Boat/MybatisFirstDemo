package cn.com.mybatis.po;

import java.util.List;

public class UserQueryInfo {
	
	/*
	 * 包装用户查询信息
	 */
	private UserInstance userInstance;
	public UserInstance getUserInstance(){
		return userInstance;
	}
	public void setUserInstance(UserInstance userInstance){
		this.userInstance=userInstance;
	}
	
	public List<Integer> getIdList() {
		return idList;
	}
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	//包装其他的查询条件，如购物车、商品信息等
	private List<Integer> idList;
	
}
