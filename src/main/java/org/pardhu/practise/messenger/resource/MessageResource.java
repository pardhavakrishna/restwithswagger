package org.pardhu.practise.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.pardhu.practise.messenger.model.Link;
import org.pardhu.practise.messenger.model.Message;
import org.pardhu.practise.messenger.resource.beans.MessageFilterBean;
import org.pardhu.practise.messenger.service.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(description="REST API For Messenger Application")
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	@ApiOperation(notes="Gets all Messages", value = "getAllMessage")
	public List<Message> getAllMessage(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getMessagesInYear(filterBean.getYear());
		}
		if (filterBean.getStart() > 0 && filterBean.getEnd() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getEnd());
		}

		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message newMessage = messageService.getMessage(id);
		Link linkToProfile = getLinkToProfile(uriInfo, newMessage);
		newMessage.addLink(linkToProfile);

		Link linkToComments = getLinkToComments(uriInfo, newMessage);
		newMessage.addLink(linkToComments);

		return newMessage;
	}

	private Link getLinkToComments(UriInfo uriInfo, Message newMessage) {
		String linkPath = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource").path(CommentResource.class)
				.resolveTemplate("messageId", newMessage.getId()).build().toString();
		String rel = "comments";
		Link link = new Link();
		link.setLink(linkPath);
		link.setRel(rel);
		return link;
	}

	private Link getLinkToProfile(UriInfo uriInfo, Message newMessage) {
		String linkPath = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(newMessage.getAuthor()).build()
				.toString();
		String rel = "profile";
		Link link = new Link();
		link.setLink(linkPath);
		link.setRel(rel);
		return link;
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(message.getId() + "").build()).entity(newMessage)
				.build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.deleteMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
