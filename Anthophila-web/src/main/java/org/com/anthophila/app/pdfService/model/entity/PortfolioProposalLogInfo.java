package org.com.anthophila.app.pdfService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PortfolioProposalLogInfo {

	@JsonProperty("LABEL_ID")
	private String labelId;

	@JsonProperty("LABEL_SWITCH")
	private String labelSwitch;
	
}
