package org.pardhu.practise.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.pardhu.practise.messenger.DataAccess;
import org.pardhu.practise.messenger.model.Message;

public class MessageService {

	Map<Long, Message> messages = DataAccess.getAllMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Message 1", "Pardhu"));
		messages.put(2L, new Message(2, "Message 2", "Brinda"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		messages.put(message.getId(), message);
		return message;
	}

	public void deleteMessage(long id) {
		messages.remove(id);
	}

	public List<Message> getMessagesInYear(int year) {
		List<Message> messagesInYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesInYear.add(message);
			}
		}
		return messagesInYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int end) {
		List<Message> messagesPaginated = new ArrayList<Message>(messages.values());
		if (start + end > messagesPaginated.size())
			return new ArrayList<Message>();
		return messagesPaginated.subList(start, end);

	}
}
