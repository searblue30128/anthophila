package org.com.anthophila.domain.service.message;

import javax.inject.Inject;

import org.com.anthophila.domain.model.Message;
import org.com.anthophila.domain.repository.message.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MessageServicelmpl implements MessageService {

	@Inject
	MessageRepository messageRepository;

	@Override
	public Message findByNo(String messageNo) {
		return messageRepository.findByNo(messageNo);
	}

}
