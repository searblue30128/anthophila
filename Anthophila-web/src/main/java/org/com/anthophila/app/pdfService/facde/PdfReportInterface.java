package org.com.anthophila.app.pdfService.facde;

import java.util.List;

import org.com.anthophila.app.pdfService.model.entity.PortfolioMainInfo;
import org.com.anthophila.app.pdfService.model.entity.PortfolioWeightsPdfInfo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioProposalPo;
import org.com.anthophila.app.pdfService.req.PortfolioPdfReqDto;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Repository;

import net.sf.jasperreports.engine.JasperPrint;

@Repository
public interface PdfReportInterface {

	JasperPrint createSamplePdfReport(List<PortfolioMainInfo> portfolioMainInfoList,
			List<PortfolioWeightsPdfInfo> portfolioWeightsPdfInfoList, PortfolioProposalPo portfolioProposalPo,
			PortfolioPdfReqDto portfolioPdf);

	byte[] setDocumentWithWaterMarkAndPieImage(byte[] documentBytes, JFreeChart chart);

}
