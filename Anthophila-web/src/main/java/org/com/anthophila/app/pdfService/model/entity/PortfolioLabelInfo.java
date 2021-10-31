package org.com.anthophila.app.pdfService.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PortfolioLabelInfo {

	@ApiModelProperty(example = "20120101002")
	@JsonProperty("PORTFOLIO_ID")
	private String portfolioId;

	@JsonProperty("LABEL_LIST")
	private List<LabelListInfo> labelList;
	
}
