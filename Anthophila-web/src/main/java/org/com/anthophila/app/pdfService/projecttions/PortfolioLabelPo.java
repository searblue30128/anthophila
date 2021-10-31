package org.com.anthophila.app.pdfService.projecttions;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

/** 投資組合貼標: PORTFOLIO_LABEL */
@IdClass(PortfolioLabelPo.class)
@Entity
@Data
@Table(name = "portfolio_label", schema = "tenant_demo001")
public class PortfolioLabelPo implements Serializable {

	@Id
	@Column(name = "PORTFOLIO_ID")
	private String portfolioId;

	@Id
	@Column(name = "LABEL_ID")
	private String labelId;

	@Column(name = "LABEL_SWITCH")
	private String labelSwitch;

	@Column(name = "LOG_ID")
	private String logId;
}
