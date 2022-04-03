package it.prova.dottore.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import it.prova.dottore.model.Dottore;

public class DottoreDTO {
	
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private String codiceDipendente;
	
	private boolean inServizio;
	private boolean inVisita;
	
	public DottoreDTO() {}
	public DottoreDTO(Long id, String nome, String cognome, String codiceDipendente) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}
	public DottoreDTO(Long id, String nome, String cognome, String codiceDipendente, boolean inServizio, boolean inVisita) {
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
	
	
	
	public Dottore buildDottoreModel() {
		Dottore dottore = new Dottore(this.id, this.nome, this.cognome, this.codiceDipendente, this.inServizio, this.inVisita);
		dottore.setInServizio(false);
		dottore.setInVisita(false );
		return dottore;
		
	}

	public static DottoreDTO buildDottoreDTOFromModel(Dottore dottoreModel) {
		DottoreDTO result = new DottoreDTO(
				dottoreModel.getId(), dottoreModel.getNome(), dottoreModel.getCognome(),
				dottoreModel.getCodiceDipendente(), dottoreModel.isInServizio(), dottoreModel.isInVisita());
		
		/*
		if (includeTratte)
			result.setDottore(DottoreDTO.createTrattaDTOSetFromModelSet(pazienteModel.getDottore(), false));
		*/
		return result;
	}

	public static List<DottoreDTO> buildDottoreDTOListFromModelList(List<Dottore> modelListInput) {
		return modelListInput.stream().map(dottoreEntity -> {
			DottoreDTO result = DottoreDTO.buildDottoreDTOFromModel(dottoreEntity);
			
//			if(includeTratte)
//				result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusEntity.getTratte(), false));
			
			return result;
		}).collect(Collectors.toList());
	}
	
	
	@Override
	public String toString() {
		return "DottoreDTO [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceDipendente="
				+ codiceDipendente + "]";
	}
	
	
}
