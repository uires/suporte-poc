package br.com.suportepoc.job;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.suportepoc.entidades.StatusTicket;
import br.com.suportepoc.servicos.TicketServico;

@Stateless
public class TicketsFinalizacaoJob {

	private static final Logger LOGGER = Logger.getLogger(TicketsFinalizacaoJob.class.getName());

	@Inject
	private TicketServico ticketServico;

	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void mudarStatusTicketsDataCancelamentoSuperiorDataAtual() {

		this.ticketServico.listaTicketDataCancelamentoMaiorDataAtual().stream().forEach(ticket -> {
			LOGGER.info("TICKET DE NÚMERO " + ticket.getId() + " FOI CANCELADO AUTOMATICAMENTE EM "
					+ LocalDateTime.now() + "\n SYSTEM CURRENT TIME:  " + System.currentTimeMillis());
			this.ticketServico.alterarStatus(ticket, StatusTicket.CANCELADO_AUTOMATICAMENTE);
		});
		LOGGER.info("--------------------------------------------------------------------------");
		LOGGER.info("FINALIZAÇÃO JOB: " + this.getClass().getName());
	}
}
