package br.com.suportepoc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.suportepoc.servicos.TicketServico;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private TicketServico ticketServico;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();
		List<Integer> numeroSequenciaTickets = ticketServico.buscarNumeroSequenciaTickets();

		numeroSequenciaTickets.stream().forEach(numero -> {
			printWriter.print(numero);
		});
	}

}
