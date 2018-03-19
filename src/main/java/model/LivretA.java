/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte{

	@Column(name="taux")
	private Double taux;

	/**
	 * Constructeur
	 */
	public LivretA() {
		
	}
	
	/**
	 * Constructeur
	 * @param taux
	 */
	public LivretA(Integer numero, Double solde, Double taux) {
		super();
		LivretA.this.setNumero(numero);
		LivretA.this.setSolde(solde);
		this.taux = taux;
	}


	/** Getter
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
}
