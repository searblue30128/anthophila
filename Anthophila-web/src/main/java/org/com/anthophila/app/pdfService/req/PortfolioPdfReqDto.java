package org.com.anthophila.app.pdfService.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "取得投資組合PDF")
@Data
public class PortfolioPdfReqDto {

	@ApiModelProperty(value = "投資組合代碼", example = "PI202108100001")
	@NotBlank
	@JsonProperty(value = "PORTFOLIO_ID")
	String portfolioId;
	
	@ApiModelProperty(value = "投資金額", example = "99999")
	@NotNull
	@JsonProperty(value = "INV_AMT")
	Integer invAmt;
	
	@ApiModelProperty(value = "PRICE_DATE", example = "2021-01-01")
	@NotBlank
	@JsonProperty(value = "PRICE_DATE")
	String proceDate;

	@Override
	public String toString() {
		return "PortfolioPdfReqDto [portfolioId=" + portfolioId + ", invAmt=" + invAmt + ", proceDate=" + proceDate + "]";
	}
	
}
