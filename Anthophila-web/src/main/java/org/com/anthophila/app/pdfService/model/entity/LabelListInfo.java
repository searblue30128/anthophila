package org.com.anthophila.app.pdfService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LabelListInfo {

	@ApiModelProperty(example = "20210511111")
	@JsonProperty("LABEL_ID")
	private String labelId;

	@ApiModelProperty(example = "N")
	@JsonProperty("LABEL_SWITCH")
	private String labelSwitch;
	
}
