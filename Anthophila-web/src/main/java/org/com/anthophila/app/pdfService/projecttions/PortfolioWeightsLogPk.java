package org.com.anthophila.app.pdfService.projecttions;

import java.io.Serializable;

import lombok.Data;

/** 投資組合商品池及標的LOG: PORTFOLIO_WEIGHTS_LOG */
@Data
public class PortfolioWeightsLogPk implements Serializable {

	private String logId;

	private String portfolioId;

	private String commodityPoolId;

	private String commodityId;

}
