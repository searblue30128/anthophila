package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cathay.wmsp.domain.mapper.PortfolioWeightsDao;
import com.cathay.wmsp.domain.projecttions.PortfolioWeightsPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioWeightsRepository {

	@Autowired
	PortfolioWeightsDao portfolioWeightsDao;

	public void deletePortfolioWeights(List<PortfolioWeightsPo> portfolioWeightsPoList) {
		log.debug("PortfolioWeightsRepository.deletePortfolioWeights({}).", portfolioWeightsPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioWeightsPoList)) {
				portfolioWeightsDao.deleteAll(portfolioWeightsPoList);
				portfolioWeightsDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioWeightsRepository.deletePortfolioWeights Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public void insertPortfolioWeights(List<PortfolioWeightsPo> portfolioWeightsPoList) {
		log.debug("PortfolioWeightsRepository.insertPortfolioWeights({}).", portfolioWeightsPoList);
		try {
			if (!CollectionUtils.isEmpty(portfolioWeightsPoList)) {
				portfolioWeightsDao.saveAll(portfolioWeightsPoList);
				portfolioWeightsDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioWeightsRepository.insertPortfolioWeights Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public List<PortfolioWeightsPo> findByPortfolioId(String portfolioId) {
		log.debug("PortfolioWeightsRepository.findByPortfolioId({}).", portfolioId);
		return portfolioWeightsDao.findByPortfolioId(portfolioId);
	}
	
	public List<PortfolioWeightsPo> findPortfolioWeightsByPortfolioId(String portfolioId){
		log.debug("PortfolioWeightsRepository.searchPortfolioWeightsByPortfolioId({}).", portfolioId);
		return portfolioWeightsDao.findPortfolioWeightsByPortfolioId(portfolioId);
	}
}
