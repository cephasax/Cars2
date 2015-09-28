import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="revendedor")
@SequenceGenerator(name="SEQ_REVENDEDOR", initialValue=1, allocationSize=1, sequenceName="seq_revendedor")
public class Revendedor{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_REVENDEDOR")
	@Column(name="id_revendedor")
	private int id;
	
	private String nome;
	private String endereco;
	private String telefone;
	
	@OneToMany(mappedBy="revendedor")
	private Collection<Veiculo> veiculos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Collection<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Collection<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
