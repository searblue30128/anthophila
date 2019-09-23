package org.com.anthophila.domain.service.transportationInfo;

import java.util.Optional;

import org.com.anthophila.domain.model.TransportationInfo;

public interface transportationInfoService {

    Optional<TransportationInfo> findByNo(String accountNo);

    void update(TransportationInfo transportationInfo);

    void insert(TransportationInfo transportationInfo);
}
