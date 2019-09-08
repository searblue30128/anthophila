package org.com.anthophila.domain.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message implements Serializable {

	private String accountNo;

	private String messageNo;

	private String messageContent;

	private String messageSendFlg;

	private String messageLevel;

	private Date messageCreateTime;

	private Date messageSendTime;

	private String messageCreateNo;

}
