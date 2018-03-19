/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 */
@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero", nullable = false)
	private Integer numero;
	@Column(name = "solde", nullable = false)
	private Double solde;
	@ManyToMany
	@JoinTable(name="REFERENCE",
		joinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID")
	)
	private List<Client> clients = new ArrayList<>();
	@OneToMany(mappedBy="compte")
	private List<Operation> operations = new ArrayList<>();
	
	/**
	 * Constructeur
	 */
	public Compte() {
	}
	
	/**
	 * Constructeur
	 * @param numero
	 * @param solde
	 */
	public Compte(Integer numero, Double solde) {
		this.numero = numero;
		this.solde = solde;
	}



	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
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

	/** Getter
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}

	/** Setter
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}	
}
