package org.com.anthophila.app.pdfService.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.mapper.PortfolioMainDao;
import com.cathay.wmsp.domain.projecttions.PortfolioMainPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioMainRepository {

	@Autowired
	PortfolioMainDao portfolioMainDao;

	public void insertPortfolioMain(PortfolioMainPo portfolioMainPo) {
		log.debug("PortfolioMainRepository.insertPortfolioMain({}).", portfolioMainPo);
		try {
			if (portfolioMainPo != null) {
				portfolioMainDao.save(portfolioMainPo);
				portfolioMainDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioMainRepository.insertPortfolioMain Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public void deletePortfolioMain(PortfolioMainPo portfolioMainPo) {
		log.debug("PortfolioMainRepository.deletePortfolioMain({}).", portfolioMainPo);
		try {
			if (portfolioMainPo != null) {
				portfolioMainDao.delete(portfolioMainPo);
				portfolioMainDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioMainRepository.deletePortfolioMain Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public PortfolioMainPo findByPortfolioId(String portfolioId) {
		log.debug("PortfolioMainRepository.findByPortfolioId({}).", portfolioId);
		return portfolioMainDao.findByPortfolioId(portfolioId);
	}
	
}
