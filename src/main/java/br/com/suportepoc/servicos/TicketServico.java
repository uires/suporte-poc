package br.com.suportepoc.servicos;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.suportepoc.dao.TicketDAO;
import br.com.suportepoc.entidades.StatusTicket;
import br.com.suportepoc.entidades.Ticket;

@Stateless
public class TicketServico {

	private static final Logger LOGGER = Logger.getLogger(TicketServico.class.getName());

	@Inject
	private TicketDAO dao;

	public List<Ticket> listagemTickets() {
		return this.dao.listagem();
	}

	public void salvar(Ticket ticket) {
		dao.salvar(ticket);
	}

	public void alterarStatus(Ticket ticket, StatusTicket statusTicket) {
		LOGGER.info("O TICKET DE NÚMERO " + ticket.getId() + " , FOI ALTERADO PARA O STATUS " + statusTicket.name());
		this.dao.alterarStatusTicket(ticket, statusTicket);
	}

	public List<Ticket> listaTicketDataCancelamentoMaiorDataAtual() {
		return this.dao.buscarTicketsComDataCancelamentoAutomaticoMaiorDataAtual();
	}
}
