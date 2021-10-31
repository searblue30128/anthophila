package org.com.anthophila.app.pdfService.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.projecttions.PortfolioMainLogPo;

@Repository
public interface PortfolioMainLogDao extends CrudRepository<PortfolioMainLogPo, String>, JpaRepository<PortfolioMainLogPo, String> {

	PortfolioMainLogPo findByPortfolioId(String portfolioId);

	PortfolioMainLogPo findByPortfolioNameAndStatusCodeIn(String portfolioId, String[] statusCodeArr);

	PortfolioMainLogPo findByPortfolioIdAndStatusCodeIn(String portfolioId, String[] statusCodeArr);
	
	PortfolioMainLogPo findByStatusCodeAndIsEdit(String statusCode, String isEdit);

	List<PortfolioMainLogPo> findByPortfolioIdLike(String portfolioIdDate);
	
	PortfolioMainLogPo findByPortfolioIdAndStatusCodeAndStopCheck(String portfolioId, String statusCode, String stopCheck);
}
