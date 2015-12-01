package br.com.locadora.veiculo.model;

import br.com.locadora.entity.Veiculo;
import java.util.List;

public interface VeiculoDAO {

    public void adicionar(Veiculo veiculo);

    public void modificar(Veiculo veiculo);

    public void excluir(Veiculo veiculo);

    public Veiculo buscar(Long id);

    public List<Veiculo> listar();

}
