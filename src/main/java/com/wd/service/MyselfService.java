package com.wd.service;

import java.util.Map;

import com.wd.data.ResponseData;

/**
 * MyselfService
 * 
 * @author xwj
 * @version 创建时间：2016年8月18日
*/
public interface MyselfService {
	/**
	 * 用于获取我的悬赏提问分页
	 * @param requestorId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ResponseData getMyQuestion(Long requestorId,int page,int pageSize);
	
	/**
	 * 用于获取我的定向提问分页
	 * @param requestorId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ResponseData getMyDirectionalQuestion(Long requestorId,int page,int pageSize);
	
	/**
	 * 用于保存收听投资人
	 * @param userId
	 * @param investorId
	 * @return
	 */
	public ResponseData saveUserListenInvestor(long userId, long investorId);
	
	/**
	 * 用于保存收听机构
	 * @param userId
	 * @param institutionId
	 * @return
	 */
	public ResponseData saveUserListenInstitution(long userId, long institutionId);
	/**
	 * 用于保存收听的问题
	 * @param userId
	 * @param questionId
	 * @return
	 */
	public ResponseData saveUserListenQuestion(long userId,long questionId);
	/**
	 * 通过条件查询我所听过的
	 * @param map
	 * @return
	 */

	public ResponseData getMyListenByQueryType(Byte queryType,long userId,int page,int pageSize);
}
