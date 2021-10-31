package org.com.anthophila.app.pdfService;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.com.anthophila.app.pdfService.facde.JFreeChartInterface;
import org.com.anthophila.app.pdfService.facde.PdfReportInterface;
import org.com.anthophila.app.pdfService.facde.PorfolioSearchInterface;
import org.com.anthophila.app.pdfService.model.entity.PortfolioMainInfo;
import org.com.anthophila.app.pdfService.model.entity.PortfolioWeightsPdfInfo;
import org.com.anthophila.app.pdfService.projecttions.PortfolioProposalPo;
import org.com.anthophila.app.pdfService.req.PortfolioPdfReqDto;
import org.jfree.chart.JFreeChart;
//import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.status.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@RestController
@Slf4j
@Service
public class PdfReportService {

	@Autowired
	PdfReportInterface pdfReportInterface;

	@Autowired
	PorfolioSearchInterface porfolioSearchInterface;
	
	@Autowired
	JFreeChartInterface jFreeChartInterface;
	
	public void createJasperReport(PortfolioPdfReqDto portfolioPdf, HttpServletResponse response) {
		log.info("PdfReportService createJasperReport start!");
		// 查詢PDF表頭資料
		List<PortfolioMainInfo> portfolioMainInfoList = porfolioSearchInterface.searchPortfolioMainList(portfolioPdf.getPortfolioId());
		if (portfolioMainInfoList.isEmpty()) {
			log.error("createJasperReport searchPortfolioMainList portfolioMainInfoList is not defined!");
//			throw new PorfolioSearchException(ErrorStatus.ERROR_0005.msg(), ErrorStatus.ERROR_0005.code(), HttpStatus.BAD_REQUEST);
		}
		// 查詢PDF明細資料
		List<PortfolioWeightsPdfInfo> portfolioWeightsPdfInfoList = porfolioSearchInterface.searchPortfolioWeightsList(portfolioPdf.getPortfolioId());
		if (portfolioWeightsPdfInfoList.isEmpty()) {
			log.error("createJasperReport searchPortfolioWeightsList portfolioWeightsPdfInfoList is not defined!");
//			throw new PorfolioSearchException(ErrorStatus.ERROR_0005.msg(), ErrorStatus.ERROR_0005.code(), HttpStatus.BAD_REQUEST);
		} 
		
		List<String> pdfPortfolioPdf = new ArrayList();
		pdfPortfolioPdf.add(portfolioPdf.getPortfolioId());
		PortfolioProposalPo portfolioProposalPo = porfolioSearchInterface.searchPortfolioProposal(pdfPortfolioPdf).get(0);
		byte[] bytes = null;
		try {
			// 產生PDF資料
			JasperPrint jasperPrint = pdfReportInterface.createSamplePdfReport(portfolioMainInfoList, portfolioWeightsPdfInfoList, portfolioProposalPo, portfolioPdf);
			// 產生圓餅圖資料
			Map<String, Double> dataSetData = jFreeChartInterface.getDataset(portfolioWeightsPdfInfoList);
			// 產生暫存圓餅圖路徑與檔案名稱
			// String pieName = UUID.randomUUID().toString();
			// String tempImagePath = JasperConst.TEMP_PIE_IMAGE_PATH + pieName + JasperConst.PNG_EXTENSION;
			JFreeChart chart = jFreeChartInterface.createPiePort(dataSetData);
			// 儲存檔案
			// jFreeChartInterface.saveAsFile(chart, tempImagePath, JasperConst.IMAGE_DEFAULT_WEIGHT, JasperConst.IMAGE_DEFAULT_HEIGHT);
			JRPdfExporter exporter = new JRPdfExporter();
			ByteArrayOutputStream oStream = new ByteArrayOutputStream();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, oStream);
			exporter.exportReport();
			log.info("PdfReportService setDocumentWithWaterMarkAndPieImage.");
			// 加入浮水印 & 圓餅圖
			bytes = pdfReportInterface.setDocumentWithWaterMarkAndPieImage(oStream.toByteArray(), chart);
			response.setHeader("Content-Disposition", "attachment; filename=JasperReportExample.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
			log.info("PdfReportService createJasperReport end!");
			// 刪除檔案
			// jFreeChartInterface.deleteFile(tempImagePath);
		} catch (Exception e) {
			log.error("createPdfReport error! errorMsg: {}.", e);
//			throw new PorfolioSearchException(ErrorStatus.ERROR_9999.msg(), ErrorStatus.ERROR_9999.code(),
//					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
