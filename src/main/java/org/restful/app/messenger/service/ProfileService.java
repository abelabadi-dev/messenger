package org.restful.app.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restful.app.messenger.database.DatabaseClass;
import org.restful.app.messenger.model.Profile;

public class ProfileService {
	
	Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void removeProfile(String profileName){
		profiles.remove(profileName);
	}
}
