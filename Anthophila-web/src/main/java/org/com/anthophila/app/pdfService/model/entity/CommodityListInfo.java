package org.com.anthophila.app.pdfService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommodityListInfo {

	@ApiModelProperty(example = "2330")
	@JsonProperty("COMMODITY_ID")
	private String commodityId;

	@ApiModelProperty(example = "3.05")
	@JsonProperty("COMMODITY_WEIGHTS")
	private String commodityWeights;

}
