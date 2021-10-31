package org.com.anthophila.app.pdfService.facde;

import java.util.List;

import org.com.anthophila.app.pdfService.model.entity.PortfolioMainInfo;
import org.com.anthophila.app.pdfService.model.entity.PortfolioRorWeightsInfo;
import org.com.anthophila.app.pdfService.model.entity.PortfolioWeightsPdfInfo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioMainLogPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioProposalPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioWeightsLogPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioWeightsPo;
import org.springframework.stereotype.Repository;

@Repository
public interface PorfolioSearchInterface {
	
	List<PortfolioMainInfo> searchPortfolioMainList(String keyWord, String labelId, String orderBy, String stockCheck);
	
	List<PortfolioMainInfo> searchPortfolioMainList(String portfolioId);
	
	List<PortfolioWeightsLogPo> searchPortfolioDraftWeights(String portfolioId, String logId);
	
	List<PortfolioWeightsPo> searchPortfolioWeights (List<String> portfolioIdList);
	
	List<PortfolioRorWeightsInfo> searchPortfolioRorWeights (String portfolioIdList, String logId);
	
	List<PortfolioWeightsPdfInfo> searchPortfolioWeightsList(String portfolioId);
	
	List<PortfolioMainLogPo> searchPortfolioMainLogPoListByPortfolioId(String portfolioId);
	
	List<PortfolioProposalPo> searchPortfolioProposal(List<String> portfolioIdList);
}
