package org.com.anthophila.domain.repository.transportationInfo;

import java.util.Optional;

import org.com.anthophila.domain.model.TransportationInfo;

public interface TransportationInfoRepository {

	Optional<TransportationInfo> findByNo(String accountNo);

	void insert(TransportationInfo transportationInfo);

	void update(TransportationInfo transportationInfo);

}
