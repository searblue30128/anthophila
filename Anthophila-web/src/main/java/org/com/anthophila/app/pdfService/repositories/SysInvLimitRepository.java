package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.mapper.SysInvLimitDao;
import com.cathay.wmsp.domain.projecttions.SysInvLimitPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SysInvLimitRepository {

	@Autowired
	SysInvLimitDao sysInvLimitDao;
	
	public List<SysInvLimitPo> searchSysInvLimit() {
		log.debug("SysInvLimitRepository.searchSysInvLimit().");
		try {
			return sysInvLimitDao.findAll();
		} catch (Exception e) {
			log.error("SysInvLimitRepository.sysInvLimitPoList is not found! errorMsg: {}.", e.getMessage());
			throw new PortfolioException(ErrorStatus.ERROR_9999.msg(), ErrorStatus.ERROR_9999.code(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
