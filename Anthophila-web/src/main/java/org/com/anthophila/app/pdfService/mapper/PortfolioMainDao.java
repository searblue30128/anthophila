package org.com.anthophila.app.pdfService.mapper;

import com.cathay.wmsp.domain.projecttions.PortfolioMainPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioMainDao extends CrudRepository<PortfolioMainPo, String>, JpaRepository<PortfolioMainPo, String> {

	PortfolioMainPo findByPortfolioId(String portfolioId);
}
