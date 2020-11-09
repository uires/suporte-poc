package br.com.suportepoc.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.suportepoc.entidades.Ticket;
import br.com.suportepoc.servicos.TicketServico;

@Path("ticket")
public class TicketResource {

	@Inject
	private TicketServico ticketServico;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listagem() {
		return Response.ok(ticketServico.listagemTickets()).build();
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response salvar(Ticket ticket) {
		this.ticketServico.salvar(ticket);
		return Response.status(201).build();
	}
}
