package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import interfaces.IUsuario;
import model.TblUsuariocl3;

public class ClassUsuarioImp implements IUsuario{
	public void RegistrarUsuario(TblUsuariocl3 usuario) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		System.out.println("Usuario registrado");
		em.getTransaction().commit();
		em.close();
		
	}
	public TblUsuariocl3 AutenticarUsuario(String usuario, String password) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblUsuariocl3 user = null;
		
		try {
			
			TypedQuery<TblUsuariocl3> query = em.createQuery(
		            "SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :usuario AND u.passwordcl3 = :password",
		            TblUsuariocl3.class
		        );
			query.setParameter("usuario", usuario);
			query.setParameter("password", password);
			user = query.getSingleResult();
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	        em.close();
	    }
		
		return user;
		
	}

}
