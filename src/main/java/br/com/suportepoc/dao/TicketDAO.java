package br.com.suportepoc.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import br.com.suportepoc.entidades.StatusTicket;
import br.com.suportepoc.entidades.Ticket;

@Stateless
public class TicketDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Ticket> listagem() {
		return this.entityManager.createQuery("from Ticket", Ticket.class).getResultList();
	}

	public void salvar(Ticket ticket) {
		this.entityManager.persist(ticket);
	}

	public void alterarStatusTicket(Ticket ticket, StatusTicket statusTicket) {
		ticket.setStatusTicket(statusTicket);
		this.entityManager.merge(ticket);
	}

	public void alteraStatusListaTickets(List<Ticket> tickets, StatusTicket statusTicket) {
		tickets.stream().forEach(ticket -> {
			ticket.setStatusTicket(statusTicket);
		});
		this.entityManager.merge(tickets);
	}

	public List<Ticket> buscarTicketsComDataCancelamentoAutomaticoMaiorDataAtual() {
		return this.entityManager
				.createQuery("SELECT t FROM Ticket t WHERE t.dataCancelamentoAutomatico >= :now", Ticket.class)
				.setParameter("now", LocalDateTime.now().toString()).getResultList();
	}
}
