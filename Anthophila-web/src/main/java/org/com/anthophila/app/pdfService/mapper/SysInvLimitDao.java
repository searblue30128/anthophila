package org.com.anthophila.app.pdfService.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.projecttions.SysInvLimitPo;

@Repository
public interface SysInvLimitDao extends CrudRepository<SysInvLimitPo, String>, JpaRepository<SysInvLimitPo, String> {
	
	List<SysInvLimitPo> findBycommodityPoolTypeIn(List<String> commodityPoolTypeList);

}
