package org.com.anthophila.app.pdfService.mapper;

import java.util.List;

import org.com.anthophila.app.pdfService.projecttions.PortfolioLabelPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioLabelDao extends CrudRepository<PortfolioLabelPo, String>, JpaRepository<PortfolioLabelPo, String> {

	List<PortfolioLabelPo> findByPortfolioId(String portfolioId);
}
