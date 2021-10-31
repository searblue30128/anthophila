package org.com.anthophila.app.pdfService.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cathay.wmsp.domain.mapper.PortfolioProposalDao;
import com.cathay.wmsp.domain.projecttions.PortfolioProposalPo;
import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
import com.cathay.wmsp.interfaces.exceptions.PortfolioException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioProposalRepository {

	@Autowired
	PortfolioProposalDao portfolioProposalDao;

	public void deletePortfolioProposal(PortfolioProposalPo portfolioProposalPo) {
		log.debug("PortfolioProposalRepository.deletePortfolioProposal({}).", portfolioProposalPo);
		try {
			if (portfolioProposalPo != null) {
				portfolioProposalDao.delete(portfolioProposalPo);
				portfolioProposalDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioProposalRepository.deletePortfolioProposal Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0004.msg(), ErrorStatus.ERROR_0004.code(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public void insertPortfolioProposal(List<PortfolioProposalPo> PortfolioProposalList) {
		log.debug("PortfolioProposalRepository.insertPortfolioProposal({}).", PortfolioProposalList);
		try {
			if (!CollectionUtils.isEmpty(PortfolioProposalList)) {
				portfolioProposalDao.saveAll(PortfolioProposalList);
				portfolioProposalDao.flush();
			}
		} catch (Exception e) {
			log.error("PortfolioProposalRepository.insertPortfolioProposal Error. ErrorMessage: {}.", e);
			throw new PortfolioException(ErrorStatus.ERROR_0002.msg(), ErrorStatus.ERROR_0002.code(), HttpStatus.BAD_REQUEST);
		}
	}

	public PortfolioProposalPo findByPortfolioId(String portfolioId) {
		log.debug("PortfolioProposalRepository.findByPortfolioId({}).", portfolioId);
		return portfolioProposalDao.findByPortfolioId(portfolioId);
	}
}
