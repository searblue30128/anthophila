package org.com.anthophila.domain.repository.message;

import java.util.List;

import org.com.anthophila.domain.model.Message;

public interface TransportationInfoRepository {

	List<TransportationInfo> findByNo(String accountNo);

	void insterTransportationInfo(TransportationInfo transportationInfo);

	void updateTransportationInfo(TransportationInfo transportationInfo);

}
