package br.com.suportepoc.entidades;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "data_solicitacao")
	private LocalDateTime dataSolicitacao;

	@Column(name = "data_finalizacao")
	private LocalDateTime dataFinalizacao;

	@Column(name = "data_resolucao")
	private LocalDateTime dataResolucao;

	@Column(name = "data_cancelamento_automatico")
	private LocalDateTime dataCancelamentoAutomatico = LocalDateTime.now().plusDays(5);

	@Column(name = "status_ticket")
	private StatusTicket statusTicket = StatusTicket.SOLICITADO;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public LocalDateTime getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(LocalDateTime dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public LocalDateTime getDataCancelamentoAutomatico() {
		return dataCancelamentoAutomatico;
	}

	public void setDataCancelamentoAutomatico(LocalDateTime dataCancelamentoAutomatico) {
		this.dataCancelamentoAutomatico = dataCancelamentoAutomatico;
	}

	public StatusTicket getStatusTicket() {
		return statusTicket;
	}

	public void setStatusTicket(StatusTicket statusTicket) {
		this.statusTicket = statusTicket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
