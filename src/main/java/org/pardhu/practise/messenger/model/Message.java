package org.pardhu.practise.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
	@XmlElement(name = "id")
	public long id;
	@XmlElement(name = "messageString")
	public String messageString;
	@XmlElement(name = "created")
	public Date created;
	@XmlElement(name = "author")
	public String author;
	public Map<Long, Comment> comments = new HashMap<Long, Comment>();
	List<Link> links = new ArrayList<Link>();

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public Message() {
		super();
	}

	public Message(long id, String messageString, String author) {
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

	public String getMessage() {
		return messageString;
	}

	public void setMessage(String messageString) {
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

	public void addLink(Link link) {
		links.add(link);
	}
}
