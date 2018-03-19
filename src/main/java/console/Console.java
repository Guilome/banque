package console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Adresse;
import model.AssuranceVie;
import model.Banque;
import model.Client;
import model.Compte;
import model.LivretA;
import model.Operation;
import model.Virement;

/**
 * @author GOBERT Guillaume
 *
 */
public class Console {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		// Ajout de Banque
		Banque banque = new Banque("YOLO Banque");
		Banque banque2 = new Banque("POUR NARNIA Banque");

		// Creation Adresse
		Adresse adresse = new Adresse(1, "rue de la patate chaude", 99999, "TrucMuche");
		Adresse adresse2 = new Adresse(2, "rue de la patate froide", 99998, "MucheTruc");

		// Ajout de Client
		Client client = new Client("Paul", "Jack", LocalDate.of(1999, 12, 12), adresse, banque);
		Client client2 = new Client("Paul", "Marie", LocalDate.of(1999, 12, 13), adresse, banque);
		Client client3 = new Client("Jack", "Paul", LocalDate.of(1999, 2, 2), adresse2, banque2);

		// Ajout de compte
		LivretA livretA = new LivretA(519615, 999999.99, 10.50);
		AssuranceVie assuranceVie = new AssuranceVie(519600, 0.99, LocalDate.of(3000, 12, 12), 0.2);
		LivretA livretA2 = new LivretA(519614, 5000.55, 2.00);

		// Ajout d'Operation
		Virement virement = new Virement(LocalDateTime.of(2010, 10, 10, 10, 10, 10), 30.00, "Arrrrrgent",
				"Jean-Charles");
		Virement virement2 = new Virement(LocalDateTime.of(2012, 12, 12, 12, 12, 12), 3.00, "Caaaafé", "Moi");

		client.getComptes().add(livretA);
		livretA.getClients().add(client2);
		client3.getComptes().add(assuranceVie);
		client3.getComptes().add(livretA2);

		livretA.getOperations().add(virement);
		assuranceVie.getOperations().add(virement2);
		livretA2.getOperations().add(virement);
		livretA2.getOperations().add(virement2);
		virement.setCompte(livretA);
		virement2.setCompte(assuranceVie);
		virement.setCompte(livretA2);
		virement2.setCompte(livretA2);

		em.persist(banque);
		em.persist(banque2);
		em.persist(client);
		em.persist(client2);
		em.persist(client3);
		em.persist(livretA);
		em.persist(livretA2);
		em.persist(assuranceVie);
		em.persist(virement);
		em.persist(virement2);

		et.commit();

		System.out.println(
				"____________________________________________________________________________________________________");
		System.out.println("Affichage des comptes d'un client");
		Client client4 = null;
		TypedQuery<Client> clientQuery = em.createQuery("select c from Client c where c.id=:clientID", Client.class);
		clientQuery.setParameter("clientID", client3.getId());

		if (clientQuery.getMaxResults() > 1) {
			client4 = clientQuery.getResultList().get(0);
		}
		client4 = clientQuery.getSingleResult();

		List<Compte> lesComptes = client4.getComptes();

		for (Compte compte : lesComptes) {
			System.out.println(compte.getNumero());
		}

		System.out.println(
				"____________________________________________________________________________________________________");
		System.out.println("Affichage des comptes d'une banque");
		Compte compte = null;

		TypedQuery<Compte> compteQuery = em.createQuery(
				"select c from Compte c INNER JOIN c.clients cli where cli.banque.id=:BanqueID", Compte.class);

		compteQuery.setParameter("BanqueID", banque.getId());

		if (compteQuery.getMaxResults() > 1) {
			List<Compte> comptes = compteQuery.getResultList();
			for (Compte compte2 : comptes) {
				System.out.println(compte2.getNumero());
			}
		} else {
			compte = compteQuery.getSingleResult();
			System.out.println(compte.getNumero());
		}

		System.out.println(
				"____________________________________________________________________________________________________");
		System.out.println("Affichage des comptes avec une opération de plus de 1000€");

		TypedQuery<Compte> compteQuery2 = em.createQuery(
				"select c from Compte c INNER JOIN c.operations op where op.montant>:montant", Compte.class);
		compteQuery2.setParameter("montant", 1000.00);

		if (compteQuery2.getMaxResults() > 1) {
			for (Compte compte3 : compteQuery2.getResultList()) {
				System.out.println(compte3.getNumero());
			}
		} else {
			System.out.println(compteQuery2.getSingleResult());
		}

		System.out.println(
				"____________________________________________________________________________________________________");
		System.out.println("Affichage des comptes avec au moins 1 opération");

		TypedQuery<Compte> compteQuery3 = em.createQuery(
				"select c from Compte c where exists(Select o from Operation o where o.compte = c )", Compte.class);

		if (compteQuery3.getMaxResults() > 1) {
			for (Compte compte4 : compteQuery3.getResultList()) {
				System.out.println(compte4.getNumero());
			}
		} else {
			System.out.println(compteQuery3.getSingleResult());
		}
		
		em.close();
		entityManagerFactory.close();
	}
}