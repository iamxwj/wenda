/*
 * @(#)InstitutionService.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service;

import com.wd.data.*;
import com.wd.data.institution.InstitutionBasicInfo;

/**
 * InstitutionService
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public interface InstitutionService {
    /**
     * 通过机构ID获取机构信息
     * @param institutionId
     * @return
     */
    public ResponseData getInstitutionById(Long institutionId);



    public ResponseData getInstitutionIdNameList(String nameLike);

    /**
     * 上传机构基本信息
     * @param form
     * @return
     */
    public ResponseData uploadInstitutionBasicInfo(InstitutionBasicInfo form);



//    public ResponseData uploadInsitutionPhoto(Long institutionId, List<String> url);


    public ResponseData getAllInstitutionList();

//    public ResponseData getInstitutionListByTypeAndPhase(String investType, String phase);
//
//    public ResponseData getInstitutionListByType(String investType);
//
//    public ResponseData getInstitutionListByTag(String tag);

    public ResponseData getListByNameList(String name);

//    public ResponseData getFullSearch(String institutionName, String institutionMember, int page, int size);

    public ResponseData getFirstField(String firstField, int page, int size);

    public ResponseData getInstitutionLevel(Long institutionId);
    
    /**      
	* 方法描述：分页查找机构信息
	* 备注：
	*/
    public ResponseData findPageAll(int page, int pagesize);
}
