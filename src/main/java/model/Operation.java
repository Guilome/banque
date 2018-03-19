/**
 * 
 */
package model;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 */
@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="date", nullable = false)
	private LocalDateTime date;
	@Column(name = "montant", nullable = false)
	private Double montant;
	@Column(name = "motif", length = 100, nullable = false)
	private String motif;
	@ManyToOne	
	@JoinColumn(name="idCompte")
	private Compte compte;
	
	/**
	 * Constructeur
	 */
	public Operation() {
		
	}
	
	/**
	 * Constructeur
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Operation(LocalDateTime date, Double montant, String motif) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}



	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/** Setter
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/** Getter
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}	
}
