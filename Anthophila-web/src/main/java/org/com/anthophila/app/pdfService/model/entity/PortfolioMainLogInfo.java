package org.com.anthophila.app.pdfService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PortfolioMainLogInfo {

	@ApiModelProperty(example = "0001")
	@JsonProperty("LOG_ID")
	private String logId;

	@ApiModelProperty(example = "20120101001")
	@JsonProperty("PORTFOLIO_ID")
	private String portfolioId;

	@ApiModelProperty(example = "台灣被動元件")
	@JsonProperty("PORTFOLIO_NAME")
	private String portfolioName;

	@ApiModelProperty(example = "20120101001")
	@JsonProperty("PORTFOLIO_TEMPLATE_ID")
	private String portfolioTemplateId;

	@ApiModelProperty(example = "Y")
	@JsonProperty("COMMODITY_STOCK")
	private String portfolioStock;

	@ApiModelProperty(example = "Y")
	@JsonProperty("COMMODITY_ETF")
	private String portfolioEtf;

	@ApiModelProperty(example = "Y")
	@JsonProperty("COMMODITY_FUND")
	private String portfolioFund;

	@ApiModelProperty(example = "RR5")
	@JsonProperty("RISK_LEVEL")
	private String riskLevel;

	@ApiModelProperty(example = "2021-11-17")
	@JsonProperty("RELEASE_DATE")
	private String releaseDate;

	@ApiModelProperty(example = "N")
	@JsonProperty("STOP_CHECK")
	private String stopCheck;

	@ApiModelProperty(example = "")
	@JsonProperty("STOP_DEST")
	private String stopDest;
	
	@ApiModelProperty(example = "")
	@JsonProperty("STOP_DATE")
	private String stopDate;

	@ApiModelProperty(example = "9")
	@JsonProperty("STATUS_CODE")
	private String statusCode;

	@ApiModelProperty(example = "EMP001")
	@JsonProperty("CHANGE_ID")
	private String changeId;

	@ApiModelProperty(example = "2021-02-03 09:00:01")
	@JsonProperty("CHANGE_DATETIME")
	private String changeDateTime;

	@ApiModelProperty(example = "EMP001")
	@JsonProperty("SEND_REVIEW_ID")
	private String sendReviewId;

	@ApiModelProperty(example = "2021-02-03 10:00:01")
	@JsonProperty("SEND_REVIEW_DATETIME")
	private String sendReviewDateTime;

	@ApiModelProperty(example = "EMP002")
	@JsonProperty("REVIEW_ID")
	private String reviewId;

	@ApiModelProperty(example = "2021-02-03 13:10:01")
	@JsonProperty("REVIEW_DATETIME")
	private String reviewDateTime;
	
	@ApiModelProperty(example = "30000")
	@JsonProperty("INVESTMENT_AMOUNT")
	private Integer investmentAmount;
}
