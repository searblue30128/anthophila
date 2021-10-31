package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cathay.wmsp.domain.mapper.PortfolioWeightsLogDao;
import com.cathay.wmsp.domain.projecttions.PortfolioWeightsLogPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioWeightsLogRepository {

	@Autowired
	PortfolioWeightsLogDao portfolioWeightsLogDao;

	public void deletePortfolioWeightsLog(List<PortfolioWeightsLogPo> portfolioWeightsLogList) {
		log.debug("PortfolioWeightsLogRepository.deletePortfolioWeightsLog({}).", portfolioWeightsLogList);
		try {
			if (!CollectionUtils.isEmpty(portfolioWeightsLogList)) {
				portfolioWeightsLogDao.deleteAll(portfolioWeightsLogList);
				portfolioWeightsLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioWeightsLogRepository.deletePortfolioWeightsLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public void insertPortfolioWeightsLog(List<PortfolioWeightsLogPo> portfolioWeightsLogPoList) {
		log.debug("PortfolioWeightsLogRepository.insertPortfolioWeightsLog({}).", portfolioWeightsLogPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioWeightsLogPoList)) {
				portfolioWeightsLogDao.saveAll(portfolioWeightsLogPoList);
				portfolioWeightsLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioWeightsLogRepository.insertPortfolioWeightsLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public List<PortfolioWeightsLogPo> findBylogIdAndPortfolioId(String logId, String portfolioId) {
		log.debug("PortfolioWeightsLogRepository.findBylogIdAndPortfolioId({}, {}).", logId, portfolioId);
		return portfolioWeightsLogDao.findBylogIdAndPortfolioId(logId, portfolioId);
	}
}
