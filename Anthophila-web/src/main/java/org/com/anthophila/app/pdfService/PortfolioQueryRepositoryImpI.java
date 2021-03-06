package org.com.anthophila.app.pdfService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.com.anthophila.app.pdfService.facde.PorfolioSearchInterface;
import org.com.anthophila.app.pdfService.model.entity.PortfolioMainInfo;
import org.com.anthophila.app.pdfService.model.entity.PortfolioRorWeightsInfo;
import org.com.anthophila.app.pdfService.model.entity.PortfolioWeightsPdfInfo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioLabelLogPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioLabelPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioMainLogPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioProposalLogPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioProposalPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioWeightsLogPo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioWeightsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.model.vo.PortfolioConst;
import com.cathay.wmsp.infrastructure.repositories.PortfolioLabelLogRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioLabelRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioMainLogRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioMainRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioProposalLogRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioProposalRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioWeightsLogRepository;
import com.cathay.wmsp.infrastructure.repositories.PortfolioWeightsRepository;
import com.cathay.wmsp.interfaces.exceptions.PorfolioSearchException;

import ch.qos.logback.core.status.ErrorStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PortfolioQueryRepositoryImpI implements PorfolioSearchInterface {

	@Autowired
	PortfolioMainLogRepository portfolioMainLogRepository;
	
	@Autowired
	PortfolioWeightsLogRepository portfolioWeightsLogRepository;
	
	@Autowired
	PortfolioMainRepository portfolioMainRepository;
	
	@Autowired
	PortfolioLabelRepository portfolioLabelRepository;
	
	@Autowired
	PortfolioWeightsRepository portfolioWeightsRepository;
	
	/** ???????????????????????????????????? */
	@Override
	public List<PortfolioMainLogPo> searchPortfolioDraftMainList(String keyWord, String status, String portfolioId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioDraftMainList({}, {}, {}).", keyWord, status, portfolioId);
		List<PortfolioMainLogPo> portfolioMainLogPoList = new ArrayList();
		portfolioMainLogPoList
				.addAll(portfolioMainLogRepository.searchPortfolioMainLogList(StringUtils.replaceNull(keyWord),
						StringUtils.replaceNull(status), StringUtils.replaceNull(portfolioId)));
		return portfolioMainLogPoList;
	}
	
	/** ?????????????????????????????? */
	@Override
	public List<PortfolioMainInfo> searchPortfolioMainList(String keyWord, String labelId, String orderBy, String stockCheck) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioMainList({}, {}, {}, {}).", keyWord, labelId, orderBy, stockCheck);
		List<PortfolioLabelPo> portfolioLabelPoList = portfolioLabelRepository.searchPortfolioLabel(labelId, PortfolioConst.LABEL_SWITCH_Y);
		if (portfolioLabelPoList.isEmpty() && labelId != null) {
			log.error("portfolioLabelPoList is not defined!");
			throw new PorfolioSearchException(ErrorStatus.ERROR_0005.msg(), ErrorStatus.ERROR_0005.code(), HttpStatus.BAD_REQUEST);
		}
		return portfolioMainRepository.searchPortfolioMainList(keyWord, stockCheck, orderBy, portfolioLabelPoList, labelId);
	}
	
	/** ??????????????????_??????PDF */
	@Override
	public List<PortfolioMainInfo> searchPortfolioMainList(String portfolioId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioMainList({}).", portfolioId);
		return portfolioMainRepository.searchPortfolioMainList(portfolioId);
	}
	
	/** ??????????????????_??????PDF */
	@Override
	public List<PortfolioWeightsPdfInfo> searchPortfolioWeightsList(String portfolioId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioWeightsList({}).", portfolioId);
		return portfolioWeightsRepository.searchPortfolioWeights(portfolioId);
	}
	
	/** ???????????????????????? */
	@Override
	public List<PortfolioLabelPo> searchPortfolioLabels(List<String> portfolioIdList) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioLabels({}).", portfolioIdList);
		return portfolioLabelRepository.searchPortfolioLabel(portfolioIdList);
	}
	
	/** ?????????????????????????????? */
	@Override
	public List<PortfolioLabelLogPo> searchPortfolioDraftLabels(String portfolioId, String logId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioDraftLabels({}, {}).", portfolioId, logId);
		List<PortfolioLabelLogPo> PortfolioLabelLogPoList = portfolioLabelLogRepository.searchPortfolioLabelLog(portfolioId, logId);
		// ???????????????, ?????????????????????: 0005:????????????
		if (PortfolioLabelLogPoList.isEmpty()) {
			log.error("PortfolioLabelLogPo is not defined!");
			throw new PorfolioSearchException(ErrorStatus.ERROR_0005.msg(), ErrorStatus.ERROR_0005.code(), HttpStatus.BAD_REQUEST);
		}
		return PortfolioLabelLogPoList;
	}
	
	/** ????????????????????????????????? */
	@Override
	public PortfolioProposalLogPo searchPortfolioDraftProposal(String portfolioId, String logId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioDraftProposal({}, {}).", portfolioId, logId);
		PortfolioProposalLogPo portfolioProposalLogPo = portfolioProposalLogRepository.searchPortfolioProposalLog(portfolioId, logId);
		// ???????????????, ?????????????????????: 0005:????????????
		if (portfolioProposalLogPo == null) {
			log.error("portfolioProposalLogPo is not defined!");
			throw new PorfolioSearchException(ErrorStatus.ERROR_0005.msg(), ErrorStatus.ERROR_0005.code(), HttpStatus.BAD_REQUEST);
		}
		return portfolioProposalLogPo;
	}
	
	/** ?????????????????????????????? */
	@Override
	public List<PortfolioWeightsLogPo> searchPortfolioDraftWeights(String portfolioId, String logId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioDraftWeights({}, {}).", portfolioId, logId);
		List<PortfolioWeightsLogPo> portfolioWeightsLogPoList = portfolioWeightsLogRepository.searchPortfolioLabelLog(portfolioId, logId);
		// ???????????????, ?????????????????????: 0005:????????????
		if (portfolioWeightsLogPoList.isEmpty()) {
			log.error("PortfolioWeightsLogPo is not defined!");
			throw new PorfolioSearchException(ErrorStatus.ERROR_0005.msg(), ErrorStatus.ERROR_0005.code(), HttpStatus.BAD_REQUEST);
		}
		return portfolioWeightsLogRepository.searchPortfolioLabelLog(portfolioId, logId);
	}
	
	/** ???????????????????????? */
	@Override
	public List<PortfolioWeightsPo> searchPortfolioWeights (List<String> portfolioIdList) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioWeights({}).", portfolioIdList);
		return portfolioWeightsRepository.searchPortfolioWeights(portfolioIdList);
	}
	
	/** ??????????????????????????? */
	@Override
	public List<PortfolioProposalPo> searchPortfolioProposal(List<String> portfolioIdList) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioProposal({}).", portfolioIdList);
		return portfolioProposalRepository.searchPortfolioProposal(portfolioIdList);
	}
	
	/** ??????: PortfolioMainLogPo */
	@Override
	public List<PortfolioMainLogPo> searchPortfolioMainLogPoListByPortfolioId(String portfolioId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioMainLogPoListByPortfolioId({}).", portfolioId);
		List<PortfolioMainLogPo> portfolioMainLogPoList = new ArrayList();
		String[] statusCode0And1 = { PortfolioConst.STATUS_CODE_DEFAULT, PortfolioConst.STATUS_CODE_SEND_REVIEW };
		portfolioMainLogPoList.addAll(portfolioMainLogRepository.searchPortfolioMainLogListByPortfolioIdAndStatusCode(portfolioId, statusCode0And1));
		portfolioMainLogPoList.addAll(portfolioMainLogRepository.searchPortfolioMainLogListByStatusCodeAndIsEditAndPortfolioId(
				PortfolioConst.STATUS_CODE_REVIEW, PortfolioConst.IS_EDIT_N, portfolioId));
		return portfolioMainLogPoList;
	}
	
	/** ??????: PortfolioRorWeights */
	@Override
	public List<PortfolioRorWeightsInfo> searchPortfolioRorWeights(String portfolioId, String logId) {
		log.debug("PortfolioQueryRepositoryImpI searchPortfolioRorWeights({}, {}).", portfolioId, logId);
		return portfolioWeightsRepository.searchPortfolioRorWeightsByPortfolioId(portfolioId, logId);
	}
	
}
