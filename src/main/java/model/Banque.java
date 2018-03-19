/**
 * 
 */
package model;

import java.util.ArrayList;
//import
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String nom;
	@OneToMany(mappedBy="banque")
	private List<Client> clients = new ArrayList<>();
	
	
	/**
	 * Constructeur
	 */
	public Banque() {
		
	}
	
	/**
	 * Constructeur
	 * @param nom
	 */
	public Banque(String nom) {
		this.nom = nom;
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
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/** Setter
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
}
