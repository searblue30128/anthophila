package org.com.anthophila.domain.repository.message;

import org.com.anthophila.domain.model.Message;

public interface MessageRepository {

	Message findByNo(String messageNo);

	Message find();

}
