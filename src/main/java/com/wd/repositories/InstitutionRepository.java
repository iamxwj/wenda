package com.wd.repositories;

import com.wd.domain.es.InstitutionDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Zhipeng
 * @date 2016/6/13.
 */
public interface InstitutionRepository extends ElasticsearchRepository<InstitutionDocument, Long> {
	
    Page<InstitutionDocument> findByInstitutionNameAndInstitutionMemberNames(String institutionName, String institutionMemberNames, Pageable pageable);

}
