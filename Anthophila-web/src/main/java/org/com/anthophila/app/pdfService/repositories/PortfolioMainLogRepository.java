package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.mapper.PortfolioMainLogDao;
import com.cathay.wmsp.domain.projecttions.PortfolioMainLogPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioMainLogRepository {

	@Autowired
	PortfolioMainLogDao portfolioMainLogDao;

	public void insertPortfolioMainLog(PortfolioMainLogPo portfolioMainLogPo) {
		log.debug("PortfolioMainLogRepository.insertPortfolioMainLog({}).", portfolioMainLogPo);
		try {
			if (portfolioMainLogPo != null) {
				portfolioMainLogDao.save(portfolioMainLogPo);
				portfolioMainLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioMainLogRepository.insertPortfolioMainLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public void updatePortfolioMainLog(PortfolioMainLogPo portfolioMainLogPo) {
		log.debug("PortfolioMainLogRepository.updatePortfolioMainLog({}).", portfolioMainLogPo);
		try {
			if (portfolioMainLogPo != null) {
				portfolioMainLogDao.save(portfolioMainLogPo);
				portfolioMainLogDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioMainLogRepository.updatePortfolioMainLog Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0003.msg(), ErrorStatus.ERROR_0003.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public PortfolioMainLogPo findByPortfolioId(String portfolioId) {
		log.debug("PortfolioMainLogRepository.findByPortfolioId({}).", portfolioId);
		return portfolioMainLogDao.findByPortfolioId(portfolioId);
	}

	public PortfolioMainLogPo findByPortfolioNameAndStatusCodeIn(String portfolioId, String[] statusCodeArr) {
		log.debug("PortfolioMainLogRepository.findByPortfolioNameAndStatusCodeIn({}, {}).", portfolioId, statusCodeArr);
		return portfolioMainLogDao.findByPortfolioNameAndStatusCodeIn(portfolioId, statusCodeArr);
	}

	public PortfolioMainLogPo findByPortfolioIdAndStatusCodeIn(String portfolioId, String[] statusCode) {
		log.debug("PortfolioMainLogRepository.findByPortfolioIdAndStatusCode({}, {}).", portfolioId, statusCode);
		return portfolioMainLogDao.findByPortfolioIdAndStatusCodeIn(portfolioId, statusCode);
	}
	
	public PortfolioMainLogPo findByStatusCodeAndIsEdit(String statusCode, String isEdit) {
		log.debug("PortfolioMainLogRepository.findByStatusCodeAndIsEdit({}, {}).", statusCode, isEdit);
		return portfolioMainLogDao.findByStatusCodeAndIsEdit(statusCode, isEdit);
	}

	public List<PortfolioMainLogPo> findByPortfolioIdLike(String portfolioIdDate) {
		log.debug("PortfolioMainLogRepository.portfolioIdDate().");
		return portfolioMainLogDao.findByPortfolioIdLike(portfolioIdDate);
	}
	
	public PortfolioMainLogPo findByPortfolioIdAndStatusCodeAndStopCheck(String portfolioId, String statusCode, String stopCheck) {
		log.debug("PortfolioMainLogRepository.findByPortfolioIdAndStatusCodeAndStopCheck({}, {}, {}).", portfolioId, statusCode, stopCheck);
		return portfolioMainLogDao.findByPortfolioIdAndStatusCodeAndStopCheck(portfolioId, statusCode, stopCheck);
	}
}
