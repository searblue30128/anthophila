package org.com.anthophila.app.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.apache.commons.collections.MapUtils;
import org.com.anthophila.app.pdfService.facde.PdfReportInterface;
//import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

//import com.cathay.wmsp.domain.facade.GateWayQueryInterface;
//import com.cathay.wmsp.domain.facade.PdfReportInterface;
//import com.cathay.wmsp.domain.model.entity.PortfolioMainInfo;
//import com.cathay.wmsp.domain.model.entity.PortfolioWeightsPdfInfo;
//import com.cathay.wmsp.domain.model.jasper.entity.ExampleInfo;
//import com.cathay.wmsp.domain.model.jasper.vo.JasperConst;
//import com.cathay.wmsp.domain.model.vo.PortfolioConst;
//import com.cathay.wmsp.domain.projecttions.PortfolioProposalPo;
//import com.cathay.wmsp.domain.service.entity.CommodityInvAmtListDto;
//import com.cathay.wmsp.domain.service.entity.resp.MarketDataCommodityRespDto;
//import com.cathay.wmsp.domain.service.entity.resp.PortfolioCommodityInvAmtRespDto;
//import com.cathay.wmsp.infrastructure.util.CommonPattern;
//import com.cathay.wmsp.infrastructure.util.DateUtils;
//import com.cathay.wmsp.infrastructure.util.StringUtils;
//import com.cathay.wmsp.interfaces.exceptions.ErrorStatus;
//import com.cathay.wmsp.interfaces.exceptions.PorfolioSearchException;
//import com.cathay.wmsp.interfaces.rest.dto.PortfolioPdfReqDto;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.Image;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Rectangle;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.ColumnText;
//import com.lowagie.text.pdf.PdfContentByte;
//import com.lowagie.text.pdf.PdfGState;
//import com.lowagie.text.pdf.PdfReader;
//import com.lowagie.text.pdf.PdfStamper;

//import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Slf4j
@Repository
public class PdfReportRepositoryImpI implements PdfReportInterface {
	
    @Value("classpath:jasper/ireport/Example.jrxml")
    Resource jrxml;
    
	@Autowired
//	GateWayQueryInterface gateWayQueryInterface;
	
	/**
	 * 加入浮水印與圓餅圖
	 * 
	 * @param documentBytes
	 * @return
	 * @throws Exception
	 * @throws IOException
	 * @throws DocumentException
	 */
	@Override
	public byte[] setDocumentWithWaterMarkAndPieImage(byte[] documentBytes, JFreeChart chart) {
		log.debug("PdfReportRepositoryImpI setDocumentWithWaterMarkAndPieImage({}, {}).", documentBytes, chart);
		float x, y;
		PdfContentByte over = null;
		Rectangle pagesize;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfGState gs1 = new PdfGState();

		try {
			PdfReader reader = new PdfReader(documentBytes);
			int n = reader.getNumberOfPages();
			PdfStamper stamper = new PdfStamper(reader, outputStream);
			// 樣式設定
			BaseFont base = BaseFont.createFont(JasperConst.FONT_DEAULT_PATH + JasperConst.PDF_FONT_MSJHBD_TTF, JasperConst.PDF_FONT_IDENTITY_H, BaseFont.EMBEDDED);
			Font waterMarkFont = new Font(base, 60);
			// 浮水印: 國泰金控集團內部使用
			Phrase waterMark = new Phrase(JasperConst.WATER_MARK, waterMarkFont);
			// 浮水印: 系統日期
			waterMarkFont.setSize(35);
			Phrase systemDate = new Phrase(DateUtils.getFormatSystemDate(), waterMarkFont);
			// 套明度設定: 淺灰色
			gs1.setFillOpacity(0.06f);
			
			for (int i = 1; i <= n; i++) {
				pagesize = reader.getPageSizeWithRotation(i);
				over = stamper.getOverContent(i);
				over.saveState();
				// 設定樣式
				over.setGState(gs1);
				// 加入文字, 文字置中
				x = (pagesize.getLeft() + pagesize.getRight()) / 2;
				y = (pagesize.getTop() + pagesize.getBottom()) / 2;
				// 文字45度, 置中
				ColumnText.showTextAligned(over, Element.ALIGN_CENTER, waterMark, x, y, 45);
				ColumnText.showTextAligned(over, Element.ALIGN_CENTER, systemDate, x * 1.1f, y * 0.9f, 45);
				over.restoreState();
			}
			// PDF檔案插入圖片
			this.addImage(stamper, reader, chart, over);
			stamper.close();
			reader.close();
		} catch (Exception e) {
			log.error("setDocumentWithWaterMarkAndPieImage error! msg: {}.", e.getMessage());
			throw new PorfolioSearchException(ErrorStatus.ERROR_9999.msg(), ErrorStatus.ERROR_9999.code(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return outputStream.toByteArray();
	}
	
	/**
	 * PDF檔案插入圖片
	 * @param stamper
	 * @param reader
	 * @return
	 */
	 private void addImage(PdfStamper stamper, PdfReader reader, JFreeChart chart, PdfContentByte over) {
		log.debug("PdfReportRepositoryImpI addImage({}, {}, {}).", stamper, reader, chart, over);
		float x, y;
		Rectangle pagesize;
		PdfGState gs1 = new PdfGState();

		try {
			int n = reader.getNumberOfPages();
			// 套明度設定: 淺灰色
			gs1.setFillOpacity(1.0f);
			// Image image = Image.getInstance(imageFileName);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			ImageIO.write(chart.createBufferedImage(300, 300), "PNG", outStream);
			Image image = Image.getInstance(outStream.toByteArray());
			outStream.close();
			pagesize = reader.getPageSizeWithRotation(1);
			over = stamper.getOverContent(1);
			// 設定圖片寬高
			image.scaleToFit(250, 250);
			image.setTransparency(new int[] { 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF});
			over.setGState(gs1);
			x = (pagesize.getLeft() + pagesize.getRight()) / 2;
			y = (pagesize.getTop() + pagesize.getBottom()) / 2;
			// 設定圖片位置
			x = x + 150;
			y = y - 75;
			image.setAbsolutePosition(x , y);// 左邊距、底邊距
			// 圖片
			over.addImage(image);
			over.saveState();
		} catch (Exception e) {
			log.error("addImage error! msg: {}.", e.getMessage());
			throw new PorfolioSearchException(ErrorStatus.ERROR_9999.msg(), ErrorStatus.ERROR_9999.code(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	/**
	 * 產生PDF類別
	 */
	@Override
	public JasperPrint createSamplePdfReport(List<PortfolioMainInfo> portfolioMainInfoList, List<PortfolioWeightsPdfInfo> portfolioWeightsPdfInfoList, 
			PortfolioProposalPo portfolioProposalPo, PortfolioPdfReqDto portfolioPdf, PortfolioCommodityInvAmtRespDto portfolioCommodityInvAmt) {
		log.info("PdfReportRepositoryImpI createSamplePdfReport.");
		Map map = new HashMap<String, Object>();
		List<ExampleInfo> modelList = new ArrayList();

		// 報表TITLE文字設定
		map.put("commodityName", portfolioMainInfoList.get(PortfolioConst.LIST_FIRST_INDEX).getPortfolioName());
		map.put("commodity", this.checkCommodity(portfolioMainInfoList));
		map.put("commodityDate", DateUtils.getFormatDate(DateUtils.parseDate(portfolioMainInfoList.get(PortfolioConst.LIST_FIRST_INDEX).getReleaseDate())));
		map.put("commodityMoney", new DecimalFormat(CommonPattern.DEFAULT_MONEY_FORMAT).format(portfolioPdf.getInvAmt()).toString());
		map.put("riskLeavel", portfolioMainInfoList.get(PortfolioConst.LIST_FIRST_INDEX).getRiskLevel());
		map.put("proposal", portfolioProposalPo != null ? portfolioProposalPo.getProposal() : "");
		
		PieRepositoryImpl pieRepositoryImpl = new PieRepositoryImpl();
		Map<String, CommodityInvAmtListDto> portfolioCommodityMap = new HashMap();
		// 分類10.9 計算投組標的投資金額
		if (!Objects.isNull(portfolioCommodityInvAmt.getCommodityList())) {
			portfolioCommodityInvAmt.getCommodityList().forEach( temp -> {
				portfolioCommodityMap.put(temp.getCommodityId(), temp);
			});
		}
		List<String> stockList = new ArrayList();
		List<String> fundList = new ArrayList();
		List<String> etfList = new ArrayList();
		// 分類
		if (!portfolioWeightsPdfInfoList.isEmpty()) {
			portfolioWeightsPdfInfoList.forEach( temp -> {
				if ("S".equals(temp.getCommodityPoolType())) {
					stockList.add(temp.getCommodityId());
				} else if ("E".equals(temp.getCommodityPoolType())) {
					etfList.add(temp.getCommodityId());
				} else if ("F".equals(temp.getCommodityPoolType())) {
					fundList.add(temp.getCommodityId());
				}
			});
		}
		Map<String, String> marketDataMap = new HashMap();
		//	呼叫15.3查詢商品代碼及名稱
		MarketDataCommodityRespDto marketDataCommodity = gateWayQueryInterface.searchMarketDataCommodity(stockList, etfList, fundList);
		if (!Objects.isNull(marketDataCommodity.getCommodityInfoList())) {
			marketDataCommodity.getCommodityInfoList().forEach( temp -> {
				marketDataMap.put(temp.getCommodityId(), temp.getCommodityName());
			});
		}
		Integer allMoney = new Integer(0);
		// 資料LIST設定
		for (PortfolioWeightsPdfInfo temp : portfolioWeightsPdfInfoList) {
			CommodityInvAmtListDto commodityInvAmtListDto = new CommodityInvAmtListDto();
			if (!portfolioCommodityMap.isEmpty()) {
				commodityInvAmtListDto = portfolioCommodityMap.get(temp.getCommodityId());
			}
			log.info("CommodityInvAmtListDto: {}.", commodityInvAmtListDto);
			boolean bo = Objects.isNull(commodityInvAmtListDto);
//			if (!Objects.isNull(commodityInvAmtListDto.getCommodityId())) {
				ExampleInfo exampleInfo = new ExampleInfo();
				exampleInfo.setCommodityType(this.checkCommodityPoolType(temp.getCommodityPoolType()));
				exampleInfo.setCommodityPool(temp.getCommodityPoolName());
				exampleInfo.setCommodityName(MapUtils.getString(marketDataMap, temp.getCommodityId()));
				exampleInfo.setInvestmentAmount(bo ? "0" : StringUtils.insertComma(StringUtils.replaceNull(commodityInvAmtListDto.getInvAmt()), 0));
				if (!Objects.isNull(commodityInvAmtListDto.getInvAmt())) {
					allMoney = allMoney + commodityInvAmtListDto.getInvAmt();
				}
				exampleInfo.setPrice(bo ? "0" : StringUtils.replaceNull(commodityInvAmtListDto.getPriceOrg()));
				exampleInfo.setRate(bo ? "0" : StringUtils.replaceNull(commodityInvAmtListDto.getExchangeRate()));
				exampleInfo.setUnits(bo ? "0" : StringUtils.replaceNull(commodityInvAmtListDto.getInvUnit()));
				exampleInfo.setCommodityWeight(temp.getCommodityWeight());
				log.info("exampleInfo: {}.", exampleInfo);
				modelList.add(exampleInfo);
//			}
		}
		map.put("allMoney", StringUtils.insertComma(allMoney.toString(), 0));
		try {
			log.info("PdfReportRepositoryImpI JasperFillManager.fillReport({}, {}, {})", jrxml.getURL(), map, modelList);
			JasperDesign design = JRXmlLoader.load(jrxml.getInputStream());
			JasperReport report = JasperCompileManager.compileReport(design);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, new JRBeanCollectionDataSource(modelList));
			return jasperPrint;
		} catch (Exception e) {
			log.error("errorMsg: {}.", e);
			throw new PorfolioSearchException(ErrorStatus.ERROR_9999.msg(), ErrorStatus.ERROR_9999.code(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	/**
	 * 判斷商品種類
	 * 
	 * @param commodityPoolType
	 * @return
	 */
	private String checkCommodityPoolType(String commodityPoolType) {
		log.debug("PdfReportRepositoryImpI checkCommodityPoolType.");
		if (PortfolioConst.COMMODITY_ETF_TYPE.equals(commodityPoolType)) {
			return PortfolioConst.COMMODITY_ETF;
		} else if (PortfolioConst.COMMODITY_FUND_TYPE.equals(commodityPoolType)) {
			return PortfolioConst.COMMODITY_FUND;
		} else if (PortfolioConst.COMMODITY_STOCK_TYPE.equals(commodityPoolType)) {
			return PortfolioConst.COMMODITY_STOCK;
		} else {
			return StringUtil.EMPTY_STRING;
		}
	}

	/**
	 * 判斷商品類型
	 * 
	 * @param portfolioMainInfoList
	 * @return
	 */
	private String checkCommodity(List<PortfolioMainInfo> portfolioMainInfoList) {
		List<String> typeList = new ArrayList();
		portfolioMainInfoList.forEach(temp -> {
			if (!typeList.contains(PortfolioConst.COMMODITY_ETF)
					&& "Y".equals(StringUtils.replaceNull(temp.getPortfolioEtf()))) {
				typeList.add(PortfolioConst.COMMODITY_ETF);
			}
			if (!typeList.contains(PortfolioConst.COMMODITY_STOCK)
					&& "Y".equals(StringUtils.replaceNull(temp.getPortfolioStock()))) {
				typeList.add(PortfolioConst.COMMODITY_STOCK);
			}
			if (!typeList.contains(PortfolioConst.COMMODITY_FUND)
					&& "Y".equals(StringUtils.replaceNull(temp.getPortfolioFund()))) {
				typeList.add(PortfolioConst.COMMODITY_FUND);
			}
		});

		StringBuffer sb = new StringBuffer();
		typeList.forEach(temp -> {
			if (PortfolioConst.COMMODITY_ETF.equals(temp)) {
				this.setComma(sb, PortfolioConst.COMMODITY_ETF);
			} else if (PortfolioConst.COMMODITY_STOCK.equals(temp)) {
				this.setComma(sb, PortfolioConst.COMMODITY_STOCK);
			} else if (PortfolioConst.COMMODITY_FUND.equals(temp)) {
				this.setComma(sb, PortfolioConst.COMMODITY_FUND);
			}
		});

		return sb.toString();
	}

	/**
	 * 設定類型逗點
	 * 
	 * @param sb
	 * @param commodity
	 * @return
	 */
	private StringBuffer setComma(StringBuffer sb, String commodity) {
		if (sb.length() > 0) {
			sb.append(", " + commodity);
		} else {
			sb.append(commodity);
		}
		return sb;
	}
}
