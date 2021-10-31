package org.com.anthophila.app.pdfService.model.entity;

import lombok.Data;

@Data
public class PortfolioWeightsPdfInfo {
	
	private String portfolioId;
	
	private String commodityPoolId;
	
	private String commodityPoolName;
	
	private String commodityPoolType;
	
	private String commodityId;
	
	private String commodityWeight;

}
