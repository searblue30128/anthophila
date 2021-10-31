package org.com.anthophila.app.pdfService.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.projecttions.PortfolioProposalLogPo;

@Repository
public interface PortfolioProposalLogDao extends CrudRepository<PortfolioProposalLogPo, String>, JpaRepository<PortfolioProposalLogPo, String> {

	List<PortfolioProposalLogPo> findBylogIdAndPortfolioId(String logId, String portfolioId);
}
