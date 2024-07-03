package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProducto;
import model.TblProductocl3;

public class ClassProductoImp implements IProducto{

	public void RegistrarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_RamosRojasAnthony");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		em.persist(producto);
		System.out.println("Producto registrado");
		em.getTransaction().commit();
		em.close();
		
	}

	public void ActualizarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		em.merge(producto);
		em.getTransaction().commit();
		em.close();
		
	}

	public void EliminarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblProductocl3 elim = em.merge(producto);
		em.remove(elim);
		System.out.println("Producto eliminado");
		em.getTransaction().commit();
		em.close();
		
	}

	public List<TblProductocl3> ListadoProducto() {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl3> listadoproductos = em.createQuery("select c from TblProductocl3 c", TblProductocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listadoproductos;
	}

}
