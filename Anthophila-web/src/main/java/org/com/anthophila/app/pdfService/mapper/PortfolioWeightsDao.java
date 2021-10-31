package org.com.anthophila.app.pdfService.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cathay.wmsp.domain.projecttions.PortfolioWeightsPo;

@Repository
public interface PortfolioWeightsDao extends CrudRepository<PortfolioWeightsPo, String>, JpaRepository<PortfolioWeightsPo, String> {

	List<PortfolioWeightsPo> findByPortfolioId(String portfolioId);
	
	@Query(value = "select b.commodity_pool_type as commodity_type, a.commodity_id, a.commodity_weight, a.portfolio_id, a.commodity_pool_id, a.log_id"
			+ " from tenant_demo001.portfolio_weights a"
			+ " left join tenant_demo001.commodity_pool_main b"
			+ "   on a.commodity_pool_id = b.commodity_pool_id"
			+ " where a.portfolio_id=?1", nativeQuery = true)
	List<PortfolioWeightsPo> findPortfolioWeightsByPortfolioId(String portfolioId);
}
