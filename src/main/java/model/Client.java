/**
 * 
 */
package model;

//import
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;
	@Column(name = "dateNaissance", nullable = false)
	private LocalDate dateNaissance;
	@ManyToOne
	@JoinColumn(name = "banque")
	private Banque banque;
	@Embedded
	private Adresse adresse;
	@ManyToMany	
	@JoinTable(name="REFERENCE",
		joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID")
	)
	private List<Compte> comptes = new ArrayList<>();
	
	/**
	 * Constructeur
	 */
	public Client() {
		
	}

	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 * @param banque
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
	}



	/**
	 * 	Constructeur
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param banque
	 * @param adresse
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.banque = banque;
		this.adresse = adresse;
	}



	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
