package org.com.anthophila.app.pdfService.projecttions;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/** sys_inv_limit */
@Entity
@Data
@Table(name = "sys_inv_limit", schema = "tenant_demo001")
public class SysInvLimitPo implements Serializable {

	@Id
	@Column(name = "commodity_pool_type")
	private String commodityPoolType;

	@Column(name = "inv_limit")
	private Integer invLimit;

}
