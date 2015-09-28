import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public Conexao(){
		this.emf = Persistence.createEntityManagerFactory("Cars");
		this.em = emf.createEntityManager();
		System.out.println("Conexao com o banco feita");
		abrirConexao();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void abrirConexao(){
		this.em.getTransaction().begin();
	}
	
	public void persistirObjeto(Object objeto){
		this.em.persist(objeto);
	}
	
	public void encerrrarConexao(){
		this.em.getTransaction().commit();
		this.em.close();
	}
	
}
