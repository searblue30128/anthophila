package org.com.anthophila.app.pdfService.projecttions;

import java.io.Serializable;

import lombok.Data;

/** 投資組合商品池及標的: PORTFOLIO_WEIGHTS */
@Data
public class PortfolioWeightsPk implements Serializable {

	private String portfolioId;

	private String commodityPoolId;

	private String commodityId;

}
