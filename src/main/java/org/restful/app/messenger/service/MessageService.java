package org.restful.app.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calc = Calendar.getInstance();
		
		for(Message message : messages.values()){
			calc.setTime(message.getCreated());
			if(calc.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		
		List<Message> list = new ArrayList<>(messages.values());
		if(start+size > list.size())
			return new ArrayList<>();
		
		return list.subList(start, start+size);
		
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
