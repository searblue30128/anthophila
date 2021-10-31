package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.com.anthophila.app.pdfService.projecttions.PortfolioLabelLogPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cathay.wmsp.domain.mapper.PortfolioLabelLogDao;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import ch.qos.logback.core.status.ErrorStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioLabelLogRepository {

	@Autowired
	PortfolioLabelLogDao portfolioLabelLogDao;
	
	public void insertPortfolioLabelLog(List<PortfolioLabelLogPo> portfolioLabelLogPoList) {
		log.debug("PortfolioLabelLogRepository.insertPortfolioLabelLog({}).", portfolioLabelLogPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioLabelLogPoList)) {
				portfolioLabelLogDao.saveAll(portfolioLabelLogPoList);
				portfolioLabelLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioLabelLogRepository.insertPortfolioLabelLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public void deletePortfolioLabelLog(List<PortfolioLabelLogPo> portfolioLabelLogPoList) {
		log.debug("PortfolioLabelLogRepository.deletePortfolioLabelLog({}).", portfolioLabelLogPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioLabelLogPoList)) {
				portfolioLabelLogDao.deleteAll(portfolioLabelLogPoList);
				portfolioLabelLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioLabelLogRepository.deletePortfolioLabelLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<PortfolioLabelLogPo> findBylogIdAndPortfolioId(String logId, String portfolioId){
		log.debug("PortfolioLabelLogRepository.findBylogIdAndPortfolioId({}, {}).", logId, portfolioId);
		return portfolioLabelLogDao.findBylogIdAndPortfolioId(logId, portfolioId);
	}
}
