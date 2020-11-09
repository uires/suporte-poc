package br.com.suportepoc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.suportepoc.entidades.Ticket;

@Stateless
public class TicketDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Ticket> listagem() {
		return entityManager.createQuery("from Ticket", Ticket.class).getResultList();
	}

	public void salvar(Ticket ticket) {
		entityManager.persist(ticket);
	}

}
