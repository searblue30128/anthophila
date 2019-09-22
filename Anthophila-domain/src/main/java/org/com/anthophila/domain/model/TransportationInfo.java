package org.com.anthophila.domain.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransportationInfo implements Serializable {

	/*員工編號*/
	private String accountNo;

	/*交通費金額*/
	private String transportFare;

	/*上傳月份*/
	private String transportMonth;

	/*上傳日期 YYYY/MM/DD*/
	private Date transportInsterDate;

	/*更新日期 YYYY/MM/DD*/
	private String transportUpdateDate;

	/*0:審核中 1:審核通過 2:審核不可*/
	private String transportPur;

	/*交通費照片*/
	private byte[] transportationImg;

}
