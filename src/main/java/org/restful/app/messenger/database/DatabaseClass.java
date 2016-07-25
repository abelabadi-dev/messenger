package org.restful.app.messenger.database;
import java.util.HashMap;
import java.util.Map;

import org.restful.app.messenger.model.Message;
import org.restful.app.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	
	static{
		messages.put(1L, new Message(1L,"Hello REST.","AB."));
		messages.put(2L, new Message(2L,"Hello Jersey.","AB."));
		
		profiles.put("abel", new Profile(1L, "abel", "abel", "abadi"));
		profiles.put("jeff", new Profile(2L, "jeff", "way", "jeff"));
	}
	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	
}
