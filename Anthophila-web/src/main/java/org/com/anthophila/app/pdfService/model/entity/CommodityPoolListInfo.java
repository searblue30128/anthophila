package org.com.anthophila.app.pdfService.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommodityPoolListInfo {
	
	@ApiModelProperty(value = "模板清單", example = "20120101002")
	@JsonProperty("PORTFOLIO_ID")
	private String portfolioId;

	@JsonProperty("COMMODITY_POOL_LIST")
	private List<PortfolioWeightsInfo> commodityPoolList;

}
