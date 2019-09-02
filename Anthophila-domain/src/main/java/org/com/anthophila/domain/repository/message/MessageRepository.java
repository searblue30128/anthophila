package org.com.anthophila.domain.repository.message;

import java.util.List;

import org.com.anthophila.domain.model.Message;

public interface MessageRepository {

	List<Message> findByNo(String messageNo);

	List<Message> find();

}
