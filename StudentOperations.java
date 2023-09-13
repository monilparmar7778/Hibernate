package student_Hibernet;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory e1 = Persistence.createEntityManagerFactory("sinfo");
		
		EntityManager em = e1.createEntityManager();
		
		em.getTransaction().begin();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your roll nmber");
		int rno = sc.nextInt();
		System.out.println("Enter your name");
		String name = sc.next();
		Student s1 = new Student();
		s1.setSid(rno);
		s1.setSname(name);

		em.persist(s1);
		
		System.out.println("dataSaved");
		em.getTransaction().commit();
		
		
		/* delete REcord */
		
		
		em.getTransaction().begin();
		
		Student s=em.find(Student.class, 3);  // will search that record in the table and return to the object
		
		System.out.println(s.getSname());
		em.remove(s);  
		em.getTransaction().commit();

	}

}
