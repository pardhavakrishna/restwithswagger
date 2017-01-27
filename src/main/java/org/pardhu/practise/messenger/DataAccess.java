package org.pardhu.practise.messenger;

import java.util.HashMap;
import java.util.Map;

import org.pardhu.practise.messenger.model.Message;
import org.pardhu.practise.messenger.model.Profile;

public class DataAccess {

	public static Map<Long, Message> messages = new HashMap<Long, Message>();
	public static Map<String, Profile> profiles = new HashMap<String, Profile>();

	public static Map<Long, Message> getAllMessages() {
		return messages;
	}

	public static Map<String, Profile> getAllProfiles() {
		return profiles;
	}
}
