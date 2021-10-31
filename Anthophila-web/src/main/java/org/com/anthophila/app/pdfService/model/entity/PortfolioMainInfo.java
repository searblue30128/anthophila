package org.com.anthophila.app.pdfService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PortfolioMainInfo {

	@ApiModelProperty(example = "1")
	@JsonProperty(value = "ORDER_ID")
	private String orderId;
	
	@ApiModelProperty(example = "20120101001")
	@JsonProperty(value = "PORTFOLIO_ID")
	private String portfolioId;

	@ApiModelProperty(example = "台灣被動元件")
	@JsonProperty(value = "PORTFOLIO_NAME")
	private String portfolioName;

	@ApiModelProperty(example = "20120101001")
	@JsonProperty(value = "PORTFOLIO_TEMPLATE_ID")
	private String portfolioTemplateId;

	@ApiModelProperty(example = "Y")
	@JsonProperty(value = "COMMODITY_STOCK")
	private String portfolioStock;

	@ApiModelProperty(example = "Y")
	@JsonProperty(value = "COMMODITY_ETF")
	private String portfolioEtf;

	@ApiModelProperty(example = "Y")
	@JsonProperty(value = "COMMODITY_FUND")
	private String portfolioFund;

	@ApiModelProperty(example = "RR5")
	@JsonProperty(value = "RISK_LEVEL")
	private String riskLevel;

	@ApiModelProperty(example = "2021-11-17")
	@JsonProperty(value = "RELEASE_DATE")
	private String releaseDate;

	@ApiModelProperty(example = "N")
	@JsonProperty(value = "STOP_CHECK")
	private String stopCheck;

	@ApiModelProperty(example = " ")
	@JsonProperty(value = "STOP_DESC")
	private String stopDesc;

	@ApiModelProperty(example = "2")
	@JsonProperty(value = "ONE_WEEK_PERFORMANCE")
	private Float oneWeekPerformance;
	
	@ApiModelProperty(example = "6.8")
	@JsonProperty(value = "ONE_MONTH_PERFORMANCE")
	private Float oneMonthPerformance;
	
	@ApiModelProperty(example = "14")
	@JsonProperty(value = "THREE_MONTHS_PERFORMANCE")
	private Float threeMonthsPerformance;
	
	@ApiModelProperty(example = "1")
	@JsonProperty(value = "LOG_ID")
	private String logId;

}
