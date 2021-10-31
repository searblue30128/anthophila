package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cathay.wmsp.domain.mapper.PortfolioProposalLogDao;
import com.cathay.wmsp.domain.projecttions.PortfolioProposalLogPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioProposalLogRepository {

	@Autowired
	PortfolioProposalLogDao portfolioProposalLogDao;
	
	public void insertportfolioProposalLog(PortfolioProposalLogPo portfolioProposalLogPo) {
		log.debug("PortfolioProposalLogRepository.insertportfolioProposalLog({}).", portfolioProposalLogPo);
		try {
			if (portfolioProposalLogPo != null) {
				portfolioProposalLogDao.save(portfolioProposalLogPo);
				portfolioProposalLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioProposalLogRepository.insertportfolioProposalLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public void deletePortfolioProposalLog(List<PortfolioProposalLogPo> portfolioProposalLogList) {
		log.debug("PortfolioProposalLogRepository.deletePortfolioProposalLog({}).", portfolioProposalLogList);
		try {
			if (!CollectionUtils.isEmpty(portfolioProposalLogList)) {
				portfolioProposalLogDao.deleteAll(portfolioProposalLogList);
				portfolioProposalLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioProposalLogRepository.deletePortfolioProposalLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<PortfolioProposalLogPo> findBylogIdAndPortfolioId(String logId, String portfolioId){
		log.debug("PortfolioProposalLogRepository.findBylogIdAndPortfolioId({}, {}).", logId, portfolioId);
		return portfolioProposalLogDao.findBylogIdAndPortfolioId(logId, portfolioId);
	}
}
