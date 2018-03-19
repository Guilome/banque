/**
 * 
 */
package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation{

	@Column(name="beneficiare")
	private String beneficiare;

	/**
	 * Constructeur
	 */
	public Virement() {
		
	}
	
	/**
	 * Constructeur
	 * @param beneficiare
	 */
	public Virement(LocalDateTime date, Double montant, String motif, String beneficiare) {
		super();
		Virement.this.setDate(date);
		Virement.this.setMontant(montant);
		Virement.this.setMotif(motif);
		this.beneficiare = beneficiare;
	}



	/** Getter
	 * @return the beneficiare
	 */
	public String getBeneficiare() {
		return beneficiare;
	}

	/** Setter
	 * @param beneficiare the beneficiare to set
	 */
	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}
	
	
}
