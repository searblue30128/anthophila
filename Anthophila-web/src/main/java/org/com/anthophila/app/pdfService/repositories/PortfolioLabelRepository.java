package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cathay.wmsp.domain.mapper.PortfolioLabelDao;
import com.cathay.wmsp.domain.projecttions.PortfolioLabelPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioLabelRepository {

	@Autowired
	PortfolioLabelDao portfolioLabelDao;

	public void deletePortfolioLabel(List<PortfolioLabelPo> portfolioLabelPoList) {
		log.debug("PortfolioLabelRepository.deletePortfolioLabel({}).", portfolioLabelPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioLabelPoList)) {
				portfolioLabelDao.deleteAll(portfolioLabelPoList);
				portfolioLabelDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioLabelRepository.deletePortfolioLabel Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public void insertPortfolioLabel(List<PortfolioLabelPo> portfolioLabelPoList) {
		log.debug("PortfolioLabelRepository.insertPortfolioLabel({}).", portfolioLabelPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioLabelPoList)) {
				portfolioLabelDao.saveAll(portfolioLabelPoList);
				portfolioLabelDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioLabelRepository.insertPortfolioLabel Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public List<PortfolioLabelPo> findByPortfolioId(String portfolioId) {
		log.debug("PortfolioLabelRepository.findByPortfolioId({}).", portfolioId);
		return portfolioLabelDao.findByPortfolioId(portfolioId);
	}
}
