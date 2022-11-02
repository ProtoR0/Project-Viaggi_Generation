package projectwork.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class AnagraficaAccount {
	
	@Column(name = "nome", length = 50, nullable = false)
	@Pattern(regexp = "[a-zA-Z]{3,50}", message = "error.nome")
	private String nome;
	
	@Column(name = "cognome", length = 50, nullable = false)
	@Pattern(regexp = "[a-zA-Z]{3,50}", message = "error.cognome")
	private String cognome;
	
	@Column(name = "email", length = 70, nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,3}$", message = "error.email")
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
