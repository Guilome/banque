package console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Adresse;
import model.AssuranceVie;
import model.Banque;
import model.Client;
import model.Compte;
import model.LivretA;
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
		LivretA livretA2 = new LivretA(519615, 5000.55, 2.00);

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
		
		em.close();
		entityManagerFactory.close();
	}
}