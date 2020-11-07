package br.com.suportepoc.servicos;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class TicketServico {
	public List<Integer> buscarNumeroSequenciaTickets() {
		return List.of(1, 2);
	}
}
