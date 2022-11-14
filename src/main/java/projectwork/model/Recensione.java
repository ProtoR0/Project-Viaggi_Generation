package projectwork.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "recensioni")
public class Recensione implements Serializable{

	private static final long serialVersionUID = 3163140512569871504L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "destinazione", length = 25)
	private String destinazione;
	
	@Column(name = "titolo", length = 50, nullable = false)
	@Pattern(regexp = "[a-zA-Z\\s'-_]{5,50}", message = "{error.titolo}")
	private String titolo;
	
	@Column(name = "descrizione", length = 4048, nullable = false)
	private String descrizione;
	
	@Column(name = "pubblicato", length = 1, nullable = false)
	private int pubblicato;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_account", referencedColumnName = "id")
	private Account account;
	
	@Column(name = "data_inizio", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInizio;
	
	@Column(name = "data_fine", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFine;
	
	@Transient
	private long durata;
	
	@Transient
	private boolean image;

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

	public int getPubblicato() {
		return pubblicato;
	}

	public void setPubblicato(int pubblicato) {
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

	public long getDurata() {
		return durata;
	}

	public void setDurata(long durata) {
		this.durata = durata;
	}
	
	public void setDurata() {
		this.durata = dataInizio.until(dataFine, ChronoUnit.DAYS);
		durata++;
	}

	public boolean isImage() {
		return image;
	}

	public void setImage(boolean image) {
		this.image = image;
	}

}
