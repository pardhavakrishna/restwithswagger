package org.pardhu.practise.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {
	@XmlElement(name = "id")
	public long id;
	@XmlElement(name = "profileName")
	public String profileName;
	@XmlElement(name = "created")
	public Date created;
	@XmlElement(name = "author")
	public String author;

	public Profile() {
		super();
	}

	public Profile(long id, String profileName, String author) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.author = author;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
