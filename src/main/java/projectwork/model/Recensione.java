package projectwork.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "recensioni")
public class Recensione implements Serializable{

	private static final long serialVersionUID = 3163140512569871504L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "destinazione", length = 25)
	private String destinazione;
	
	@Column(name = "titolo", length = 50, nullable = false)
	@Pattern(regexp = "[a-zA-Z\\s]{5,50}", message = "error.titolo")
	private String titolo;
	
	@Column(name = "descrizione", length = 4048, nullable = false)
	private String descrizione;
	
	@Column(name = "pubblicato", nullable = false)
	private boolean pubblicato;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_account", referencedColumnName = "id")
	private Account account;
	
	@Column(name = "data_inizio", nullable = false)
	private LocalDate dataInizio;
	
	@Column(name = "data_fine", nullable = false)
	private LocalDate dataFine;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public boolean isPubblicato() {
		return pubblicato;
	}

	public void setPubblicato(boolean pubblicato) {
		this.pubblicato = pubblicato;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	
}
