package org.com.anthophila.app.utility;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Rectangle;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Random;
//import java.util.Set;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
//import org.jfree.chart.plot.PiePlot;
//import org.jfree.chart.plot.Plot;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.ui.RectangleInsets;
//import org.springframework.stereotype.Repository;
//
//import com.cathay.wmsp.domain.facade.JFreeChartInterface;
//import com.cathay.wmsp.domain.model.entity.PortfolioWeightsPdfInfo;
//import com.cathay.wmsp.domain.model.jasper.vo.JasperConst;
//
//import io.netty.util.internal.StringUtil;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jasperreports.engine.JRDefaultScriptlet;
//
//@Slf4j
//@Repository
//public class PieRepositoryImpl extends JRDefaultScriptlet implements JFreeChartInterface {
//	
//	/** 
//	 * 建立圓餅圖
//	 */
//	@Override
//	public JFreeChart createPiePort(Map<String, Double> dataset) {
//		try {
//			// 圓餅圖資料
//			DefaultPieDataset pds = new DefaultPieDataset();
//			Set<Entry<String, Double>> set = dataset.entrySet();
//			Iterator iterator = (Iterator) set.iterator();
//			Entry entry = null;
//			List<String> sectionPaint = new ArrayList();
//			while (iterator.hasNext()) {
//				entry = (Entry) iterator.next();
//				pds.setValue(entry.getKey().toString(), Double.parseDouble(entry.getValue().toString()));
//				sectionPaint.add(entry.getKey().toString());
//			}
//			// 創建JFreeChart
//			JFreeChart chart = ChartFactory.createPieChart(StringUtil.EMPTY_STRING, pds, false, false, false);
//			// 設置背景透明
//			chart.setBackgroundPaint(null);
//			// 取消背景框限
//			chart.setBackgroundImageAlpha(0.0f);
//			// 設定圓餅圖渲染
//			this.setPieRender((PiePlot) chart.getPlot(), sectionPaint);
//			return chart;
//		} catch (Exception e) {
//			log.error("PieRepositoryImpl createPiePort error! Msg: {}.",e.getMessage());
//			return null;
//		}
//	}
//
//	/**
//	 * 設定圓餅圖渲染
//	 * @param plot
//	 */
//	private void setPieRender(Plot plot, List<String> sectionPaint) {
//        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
//        plot.setOutlinePaint(null);
//        plot.setBackgroundAlpha(0.0f);
//		PiePlot piePlot = (PiePlot) plot;
//		piePlot.setInsets(new RectangleInsets(0, 0, 0, 0));
//		// 圓形
//		piePlot.setCircular(true);
//		// 取得圓餅圖預設填充顏色
//		List<Color> colorList = setRenderColor(sectionPaint.size());
//		
//		for (int i = 0; i < sectionPaint.size() ; i++) {
//			piePlot.setSectionPaint(sectionPaint.get(i), colorList.get(i));
//		}
//
//		// 设置背景透明度
//		piePlot.setBackgroundAlpha(0.0f);
//		piePlot.setLabelFont(new Font(JasperConst.PDF_FONT_MSJHBD_TTF, Font.BOLD, 12));
//
//		// 標籤空隙
//		piePlot.setLabelGap(0.01);
//		piePlot.setInteriorGap(0.05D);
//		piePlot.setBackgroundAlpha(0.0f);
//		// 圖形形狀
//		piePlot.setLegendItemShape(new Rectangle(5, 5));
//		piePlot.setIgnoreNullValues(true);
//		// 去掉背景色
//		piePlot.setLabelBackgroundPaint(null);
//		// 去掉陰影
//		piePlot.setLabelShadowPaint(null);
//		// 去掉邊框
//		piePlot.setLabelOutlinePaint(null);
//		piePlot.setShadowPaint(null);
//		// 0:category 1:value:2 :percentage 標籤數據
//		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}\r\n{2}"));
//	}
//
//	/**
//	 * 取得圓餅圖集合資料
//	 */
//	@Override
//	public Map<String, Double> getDataset(List<PortfolioWeightsPdfInfo> portfolioWeightsPdfInfoList) {
//		Map tempMap = new HashMap();
//		portfolioWeightsPdfInfoList.forEach( temp -> {
//			tempMap.put(temp.getCommodityPoolName().toString(), Double.valueOf(temp.getCommodityWeight()));
//		});
//		return tempMap;
//	}
//
//	/**
//	 * 儲存檔案
//	 * 
//	 * @param chart
//	 * @param outputPath
//	 * @param weight
//	 * @param height
//	 */
////	public void saveAsFile(JFreeChart chart, String outPutPath, int weight, int height) {
////		FileOutputStream out = null;
////		try {
////			this.checkDirectory(JasperConst.TEMP_PIE_IMAGE_PATH);
////			File outFile = new File(outPutPath);
////			out = new FileOutputStream(outFile);
////			// 保存为PNG
////			ChartUtilities.writeChartAsPNG(out, chart, weight, height, null, true, 9);
////			out.flush();
////		} catch (FileNotFoundException e) {
////			log.error("saveAsFile FileNotFoundException! outPutPath: {}.", outPutPath);
////			throw new PorfolioSearchException(e.getMessage(), ErrorStatus.ERROR_9999.code(),
////					HttpStatus.INTERNAL_SERVER_ERROR);
////		} catch (IOException e) {
////			log.error("saveAsFile IOException! outPutPath: {}.", outPutPath);
////			throw new PorfolioSearchException(e.getMessage(), ErrorStatus.ERROR_9999.code(),
////					HttpStatus.INTERNAL_SERVER_ERROR);
////		} finally {
////			if (out != null) {
////				try {
////					out.close();
////				} catch (IOException e) {
////					log.error("saveAsFile IOException!");
////					throw new PorfolioSearchException(e.getMessage(), ErrorStatus.ERROR_9999.code(),
////							HttpStatus.INTERNAL_SERVER_ERROR);
////				}
////			}
////		}
////	}
//	
//	/**
//	 * 刪除檔案
//	 */
////	public void deleteFile(String filePath) {
////		try {
////			File file = new File(filePath);
////			file.delete();
////		} catch (Exception e) {
////			log.error("delete file is field! Msg: {}.", e.getMessage());
////			throw new PorfolioSearchException(ErrorStatus.ERROR_9999.msg(), ErrorStatus.ERROR_9999.code(),
////					HttpStatus.INTERNAL_SERVER_ERROR);
////		}
////	}
//	
////	private void checkDirectory(String filePath) {
////		String paths[] = filePath.split("/"); 
////		String dir = paths[0];
////		for (int i = 0; i < paths.length - 1; i++) {
////			try {
////				dir = dir + "/" + paths[i + 1];
////				File dirFile = new File(dir).getAbsoluteFile();
////				if (!dirFile.exists()) {
////					dirFile.mkdir();
////					log.debug("directory path: {}.", dir);
////				}
////			} catch (Exception err) {
////				log.error("create directory error!");
////			}
////		}
////	}
//	
//	/**
//	 * 取得顏色組
//	 * @param dataSize
//	 * @return
//	 */
//	private List<Color> setRenderColor(int dataSize) {
//		List<Color> colorList = new ArrayList();
//		// FloralWhite
//		colorList.add(new Color(255, 250, 240));
//		// OldLace
//		colorList.add(new Color(253, 245, 230));
//		// Linen
//		colorList.add(new Color(250, 240, 230));
//		// AntiqueWhite
//		colorList.add(new Color(250, 235, 215));
//		// PapayaWhip
//		colorList.add(new Color(255, 239, 213));
//		// BlanchedAlmond
//		colorList.add(new Color(255, 235, 205));
//		// Bisque
//		colorList.add(new Color(255, 228, 196));
//		// PeachPuff
//		colorList.add(new Color(255, 218, 185));
//		// NavajoWhite
//		colorList.add(new Color(255, 222, 173));
//		// Moccasin
//		colorList.add(new Color(255, 228, 181));
//		
//		// 判斷資料量是否大於預設顏色比數, 如果大於則隨機取顏色填充
//		int defaultColorSize = 10;
//		if (dataSize > defaultColorSize) {
//			Random rand = new Random();
//			int colorSize = dataSize - defaultColorSize;
//			for (int s = 0 ; s < colorSize ; s++) {
//				float r = rand.nextFloat();
//				float g = rand.nextFloat();
//				float b = rand.nextFloat();
//				colorList.add(new Color(r, g ,b));
//			}
//		}
//		return colorList;
//	}
//}
