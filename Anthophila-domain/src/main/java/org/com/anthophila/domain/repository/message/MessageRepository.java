package org.com.anthophila.domain.repository.message;

import java.util.List;

import org.com.anthophila.domain.model.Message;

public interface MessageRepository {

	List<Message> findByNo(String accountNo);

	void updateMessage(String account, String messageContent);

}
