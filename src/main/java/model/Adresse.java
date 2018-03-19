/**
 * 
 */
package model;

//import
import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * @author GOBERT Guillaume
 */
@Embeddable
public class Adresse {
	@Column(name = "numero", nullable = false)
	private Integer numero;
	@Column(name = "rue", length = 100, nullable = false)
	private String rue;
	@Column(name = "codePostal", nullable = false)
	private Integer codePostal;
	@Column(name = "ville", length = 50, nullable = false)
	private String ville;
	
	/**
	 * Constructeur
	 */
	public Adresse() {
		
	}

	/**
	 * Constructeur
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	/** Getter
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/** Setter
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/** Getter
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}	
}
