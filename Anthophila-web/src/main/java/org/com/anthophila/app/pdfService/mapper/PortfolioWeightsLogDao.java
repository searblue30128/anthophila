package org.com.anthophila.app.pdfService.mapper;

import com.cathay.wmsp.domain.projecttions.PortfolioWeightsLogPo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioWeightsLogDao extends CrudRepository<PortfolioWeightsLogPo, String>, JpaRepository<PortfolioWeightsLogPo, String> {

	List<PortfolioWeightsLogPo> findBylogIdAndPortfolioId(String logId, String portfolioId);
}
