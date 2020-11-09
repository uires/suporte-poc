package br.com.suportepoc.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.suportepoc.dao.TicketDAO;
import br.com.suportepoc.entidades.Ticket;

@Stateless
public class TicketServico {

	@Inject
	private TicketDAO dao;

	public List<Ticket> listagemTickets() {
		return this.dao.listagem();
	}

	public void salvar(Ticket ticket) {
		dao.salvar(ticket);
	}

}
