import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="veiculo")
@SequenceGenerator(name="SEQ_VEICULO", initialValue=1, allocationSize=1, sequenceName="seq_veiculo")

public class Veiculo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_VEICULO")
	@Column(name="id_veiculo")
	private int id;
	
	private String placa;
	private String modelo;
	private int ano;
	private String cor;
	
	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;
	
	@ManyToOne
	@JoinColumn(name="id_revendedor")
	private Revendedor revendedor;
	
	@OneToMany(mappedBy="veiculo")
	private Collection<Manutencao> manutencoes;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	
	public Revendedor getRevendedor() {
		return revendedor;
	}

	
	public void setRevendedor(Revendedor revendedor) {
		this.revendedor = revendedor;
	}

	
	public Collection<Manutencao> getManutencoes() {
		return manutencoes;
	}

	
	public void setManutencoes(Collection<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}
	
}
