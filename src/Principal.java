import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Conexao con = new Conexao();
		
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		Veiculo v1 = new Veiculo();
		v1.setPlaca("KZM-2435");
		v1.setModelo("Monza");
		v1.setAno(1999);
		v1.setCor("preto");
		v1.setDataFabricacao(sdf.parse("15/03/1998"));
		
		Veiculo v2 = new Veiculo();
		v2.setPlaca("KZM-0000");
		v2.setModelo("Astra");
		v2.setAno(2011);
		v2.setCor("prata");
		v2.setDataFabricacao(sdf.parse("15/03/2000"));
		
		Veiculo v3 = new Veiculo();
		v3.setPlaca("KZM-0001");
		v3.setModelo("Siena");
		v3.setAno(2005);
		v3.setCor("vermelho");
		v3.setDataFabricacao(sdf.parse("15/03/2005"));
		
		Veiculo v4 = new Veiculo();
		v4.setPlaca("KZM-0002");
		v4.setModelo("Hilux");
		v4.setAno(2011);
		v4.setCor("prata");
		v4.setDataFabricacao(sdf.parse("15/03/2010"));
		
		Veiculo v5 = new Veiculo();
		v5.setPlaca("KZM-0002");
		v5.setModelo("Ferrari");
		v5.setAno(2015);
		v5.setCor("Amarelo");
		v5.setDataFabricacao(sdf.parse("15/03/2015"));
		
		Revendedor r1 = new Revendedor();
		r1.setNome("Jose Chico");
		r1.setTelefone("88880001");
		r1.setEndereco("Rua dos desocupados, 25, Natal");
		
		Revendedor r2 = new Revendedor();
		r2.setNome("Mario");
		r2.setTelefone("88880002");
		r2.setEndereco("Rua dos desocupados, 26, Natal");
		
		Revendedor r3 = new Revendedor();
		r3.setNome("Ricardo");
		r3.setTelefone("88880003");
		r3.setEndereco("Rua dos desocupados, 27, Natal");
		
		Revendedor r4 = new Revendedor();
		r4.setNome("Napoleao");
		r4.setTelefone("88880004");
		r4.setEndereco("Rua dos desocupados, 28, Natal");
		
		Manutencao m1 = new Manutencao();
		m1.setData(sdf.parse("20/05/2015"));
		m1.setDescricao("troca do ar-condicionado");
		
		Manutencao m2 = new Manutencao();
		m2.setData(sdf.parse("20/06/2015"));
		m2.setDescricao("troca do ar-condicionado e da junta do motor");
		
		Manutencao m3 = new Manutencao();
		m3.setData(sdf.parse("20/07/2015"));
		m3.setDescricao("pneu furado");
		
		Manutencao m4 = new Manutencao();
		m4.setData(sdf.parse("20/08/2015"));
		m4.setDescricao("troca do painel central");
		
		Manutencao m5 = new Manutencao();
		m5.setData(sdf.parse("20/09/2015"));
		m5.setDescricao("alinhamento e balanceamento");
		
		Manutencao m6 = new Manutencao();
		m6.setData(sdf.parse("19/09/2015"));
		m6.setDescricao("torou o volante e trocamos");
		
		v1.setManutencoes(new ArrayList<Manutencao>());
		v2.setManutencoes(new ArrayList<Manutencao>());
		v3.setManutencoes(new ArrayList<Manutencao>());
		v4.setManutencoes(new ArrayList<Manutencao>());
		v5.setManutencoes(new ArrayList<Manutencao>());

		r1.setVeiculos(new ArrayList<Veiculo>());
		r2.setVeiculos(new ArrayList<Veiculo>());
		r3.setVeiculos(new ArrayList<Veiculo>());
		r4.setVeiculos(new ArrayList<Veiculo>());
		
		r1.getVeiculos().add(v1);
		r1.getVeiculos().add(v2);
		
		r2.getVeiculos().add(v3);
		
		r3.getVeiculos().add(v4);
		
		r4.getVeiculos().add(v5);
		
		
		v1.setRevendedor(r1);
		v2.setRevendedor(r1);
		
		v3.setRevendedor(r2);
		
		v4.setRevendedor(r3);
		
		v5.setRevendedor(r4);
		
		v1.getManutencoes().add(m1);
		
		v2.getManutencoes().add(m2);
		v2.getManutencoes().add(m3);
		
		v3.getManutencoes().add(m4);
		
		v4.getManutencoes().add(m5);
		
		v5.getManutencoes().add(m6);

		m1.setVeiculo(v1);
		
		m2.setVeiculo(v2);
		m3.setVeiculo(v3);
		
		m4.setVeiculo(v3);
		
		m5.setVeiculo(v4);
		
		m6.setVeiculo(v5);
		
		con.persistirObjeto(v1);
		con.persistirObjeto(v2);
		con.persistirObjeto(v3);
		con.persistirObjeto(v4);
		con.persistirObjeto(v5);
		
		con.persistirObjeto(m1);
		con.persistirObjeto(m2);
		con.persistirObjeto(m3);
		con.persistirObjeto(m4);
		con.persistirObjeto(m5);
		con.persistirObjeto(m6);

		con.persistirObjeto(r1);
		con.persistirObjeto(r2);
		con.persistirObjeto(r3);
		con.persistirObjeto(r4);

		//Todos os veiculos ASTRA
		Query query = con.getEm().createQuery("SELECT e FROM Veiculo e "
												+ "WHERE e.ano = '2011' and e.cor='prata'");
		List<Veiculo> todosVeiculos = (List<Veiculo>)query.getResultList();
		
		
		//Todos os revendedores de astra
		query = con.getEm().createQuery(	"SELECT r FROM Revendedor r "
											+ "JOIN r.veiculos v "
											+ "WHERE v.modelo = 'Astra'");
		List<Revendedor> todosRevendedoresAstra = (List<Revendedor>)query.getResultList();
		
		
		//Todos os veiculos com troca de ar condicionado
		query = con.getEm().createQuery(	"SELECT v FROM Veiculo v "
											+ "JOIN v.manutencoes m "
											+ "WHERE m.descricao LIKE 'troca do ar-condicionado%' ");
		
		List<Veiculo> veiculoArCondicionado = (List<Veiculo>)query.getResultList();
		
		con.encerrrarConexao();
		
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Todos os veiculos 2011 de cor prata");
		System.out.println("------------------------");

		for(Veiculo veiculo: todosVeiculos){
			System.out.println(veiculo.getAno());
			System.out.println(veiculo.getCor());
			System.out.println(veiculo.getModelo());
			System.out.println(veiculo.getDataFabricacao());
			System.out.println(veiculo.getPlaca());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Todos os Revendedores de Astra");
		System.out.println("------------------------");

		for(Revendedor revend: todosRevendedoresAstra){
			System.out.println(revend.getNome());
			System.out.println(revend.getTelefone());
			System.out.println(revend.getEndereco());
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Todos os veiculos com manutencao de ar condicionado");
		System.out.println("------------------------");

		for(Veiculo veiculo: veiculoArCondicionado){
			System.out.println(veiculo.getAno());
			System.out.println(veiculo.getCor());
			System.out.println(veiculo.getModelo());
			System.out.println(veiculo.getDataFabricacao());
			System.out.println(veiculo.getPlaca());
			System.out.println();

		}
		
		
	}

}
