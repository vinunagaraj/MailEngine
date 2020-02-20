package com.geekyants.mailengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geekyants.mailengine.entity.TemplateDetail;

@Repository
public interface TemplateDetailRepository extends CrudRepository<TemplateDetail, Long>{

	public TemplateDetail findByTemplateName(String purpose);

}
