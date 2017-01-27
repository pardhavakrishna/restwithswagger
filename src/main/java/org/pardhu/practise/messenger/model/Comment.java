package org.pardhu.practise.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	
	public long id;
	public String messageString;
	public Date created;
	public String author;

	public Comment() {
		super();
	}

	public Comment(long id, String messageString, String author) {
		super();
		this.id = id;
		this.messageString = messageString;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
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
