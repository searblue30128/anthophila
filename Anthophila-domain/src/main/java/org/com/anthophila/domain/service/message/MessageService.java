package org.com.anthophila.domain.service.message;

import java.util.List;

import org.com.anthophila.domain.model.Message;

public interface MessageService {

	List<Message> findByNo(String accountNo);

	void updateMessage(String account, String messageContent);

}
