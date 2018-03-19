/**
 * 
 */
package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte{
	
	@Column(name="dateFin")
	private LocalDate dateFin;
	@Column(name="taux")
	private Double taux;
	
	/**
	 * Constructeur
	 */
	public AssuranceVie() {
		
	}
	
	/**
	 * Constructeur
	 * @param dateFin
	 * @param taux
	 */
	public AssuranceVie(Integer numero, Double solde, LocalDate dateFin, Double taux) {
		super();
		AssuranceVie.this.setNumero(numero);
		AssuranceVie.this.setSolde(solde);
		AssuranceVie.this.setDateFin(dateFin);
		this.dateFin = dateFin;
		this.taux = taux;
	}



	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
