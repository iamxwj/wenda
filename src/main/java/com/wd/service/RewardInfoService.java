package com.wd.service;

import com.wd.data.ResponseData;
import com.wd.domain.Question;

/**
 * RewardInfoService
 * 
 * @author xwj
 * @version 创建时间：2016年8月16日
*/
public interface RewardInfoService {
	/**
	 * 发布悬赏
	 * @param questionEntity
	 * @return
	 */
	public ResponseData rewardQuestion(Question question);
}
