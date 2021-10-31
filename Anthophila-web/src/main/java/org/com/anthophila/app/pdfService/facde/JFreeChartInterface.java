package org.com.anthophila.app.pdfService.facde;

import java.util.List;
import java.util.Map;

import org.com.anthophila.app.pdfService.model.entity.PortfolioWeightsPdfInfo;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Repository;


@Repository
public interface JFreeChartInterface {

	JFreeChart createPiePort(Map<String, Double> dataset);
	
//	void saveAsFile(JFreeChart chart, String outputPath, int weight, int height);
	
//	void deleteFile(String fileName);
	
	Map<String, Double> getDataset(List<PortfolioWeightsPdfInfo> portfolioWeightsPdfInfoList);
}
