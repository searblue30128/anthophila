package org.com.anthophila.app.pdfService.projecttions;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.Data;

/** 投資組合商品池及標的: PORTFOLIO_WEIGHTS */
@IdClass(PortfolioWeightsPk.class)
@Entity
@Data
@Table(name = "portfolio_weights", schema = "tenant_demo001")
public class PortfolioWeightsPo implements Serializable {

	@Id
	@Column(name = "PORTFOLIO_ID")
	private String portfolioId;

	@Id
	@Column(name = "COMMODITY_POOL_ID")
	private String commodityPoolId;

	@Id
	@Column(name = "COMMODITY_ID")
	private String commodityId;

	@Column(name = "COMMODITY_WEIGHT")
	private BigDecimal commodityWeight;

	@Column(name = "LOG_ID")
	private String logId;
}
