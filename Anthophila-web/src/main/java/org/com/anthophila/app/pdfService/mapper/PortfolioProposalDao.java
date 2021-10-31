package org.com.anthophila.app.pdfService.mapper;

import com.cathay.wmsp.domain.projecttions.PortfolioProposalPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioProposalDao extends CrudRepository<PortfolioProposalPo, String>, JpaRepository<PortfolioProposalPo, String> {

	PortfolioProposalPo findByPortfolioId(String portfolioId);
}
