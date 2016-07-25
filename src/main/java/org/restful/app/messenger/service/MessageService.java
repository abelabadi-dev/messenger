package org.restful.app.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restful.app.messenger.database.DatabaseClass;
import org.restful.app.messenger.model.Message;

public class MessageService {

	Map<Long,Message> messages = DatabaseClass.getMessages();
	public MessageService(){
		
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public void removeMessage(long id){
		 messages.remove(id);
	}
}
