package it.prova.dottore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "dottore")
public class Dottore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "codiceDipendente")
	private String codiceDipendente;
	
	@Column(name = "inServizio")
	private boolean inServizio;
	
	@Column(name = "inVisita")
	private boolean inVisita;
	
	
	public Dottore() {}
	public Dottore(Long id, String nome, String cognome, String codiceDipendente, boolean inServizio, boolean inVisita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}
	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodiceDipendente() {
		return codiceDipendente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}
	public boolean isInServizio() {
		return inServizio;
	}
	public boolean isInVisita() {
		return inVisita;
	}
	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}
	public void setInVisita(boolean inVisita) {
		this.inVisita = inVisita;
	}
	
	
	
	@Override
	public String toString() {
		return "Dottore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceDipendente="
				+ codiceDipendente + ", inServizio=" + inServizio + ", inVisita=" + inVisita + "]";
	}
	
	
	
	
	
}
