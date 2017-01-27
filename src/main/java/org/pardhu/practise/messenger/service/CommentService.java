package org.pardhu.practise.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pardhu.practise.messenger.DataAccess;
import org.pardhu.practise.messenger.model.Comment;
import org.pardhu.practise.messenger.model.Message;

public class CommentService {

	Map<Long, Message> messages = DataAccess.getAllMessages();

	public List<Comment> getAllComments(long messageId) {
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}

	public Comment getComment(long messageId, long commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		comment.setId(messages.size() + 1);
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;
	}

	public void deleteComment(long messageId, long commentId) {
		messages.get(messageId).getComments().remove(commentId);
	}
}
