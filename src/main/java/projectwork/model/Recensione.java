package projectwork.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column(name = "descrizione" , length = 4048, nullable = false)
	private String descrizione;

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
	
}
