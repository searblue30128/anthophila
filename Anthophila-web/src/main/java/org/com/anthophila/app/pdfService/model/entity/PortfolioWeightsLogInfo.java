package org.com.anthophila.app.pdfService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PortfolioWeightsLogInfo {

	@ApiModelProperty(example = "20210511")
	@JsonProperty("COMMODITY_POOL_ID")
	private String commodityPoolId;

	@JsonProperty("COMMODITY_LIST")
	private CommodityListInfo commodityList;
	
}
