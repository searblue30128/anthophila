package org.com.anthophila.app.pdfService.projecttions;

import java.io.Serializable;

import lombok.Data;

/** 投資組合貼標LOG: PORTFOLIO_LABEL_LOG */
@Data
public class PortfolioLabelLogPk implements Serializable {

	private String logId;

	private String portfolioId;

	private String labelId;

}
