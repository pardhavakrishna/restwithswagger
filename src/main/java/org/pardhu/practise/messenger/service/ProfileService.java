package org.pardhu.practise.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pardhu.practise.messenger.DataAccess;
import org.pardhu.practise.messenger.model.Profile;

public class ProfileService {
	Map<String, Profile> profiles = DataAccess.getAllProfiles();

	public ProfileService() {
		profiles.put("Profile1", new Profile(1, "Profile1", "Pardhu"));
		profiles.put("Profile2", new Profile(2, "Profile2", "Brinda"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public void deleteProfile(String profileName) {
		profiles.remove(profileName);
	}

}
