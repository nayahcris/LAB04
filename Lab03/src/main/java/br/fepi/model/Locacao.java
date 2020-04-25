package br.fepi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long idLocacao;	
	private Date dataLocacao;	
	private Date dataDevolucao;
	
	private Cliente cliente;	
	private Carro carro;
	
	public Locacao(Cliente cliente, Carro carro, Date dataLocacao, Date dataDevolucao) {
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.cliente = cliente;
		this.carro = carro;
	}
	
	public Locacao() {
		
	}

	@Id
	@GeneratedValue
	public Long getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}

	@Column(name = "data_locacao", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDataLocacao() {
		return dataLocacao;
	}	

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	@Column(name = "data_devolucao", nullable = true)
	@Temporal(TemporalType.DATE)
	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@OneToOne
	@JoinColumn(name = "carro_id")
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLocacao == null) ? 0 : idLocacao.hashCode());
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
		Locacao other = (Locacao) obj;
		if (idLocacao == null) {
			if (other.idLocacao != null)
				return false;
		} else if (!idLocacao.equals(other.idLocacao))
			return false;
		return true;
	}	

}
