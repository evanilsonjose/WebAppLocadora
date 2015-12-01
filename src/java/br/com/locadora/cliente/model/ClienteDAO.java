package br.com.locadora.cliente.model;

import br.com.locadora.entity.Cliente;
import java.util.List;

public interface ClienteDAO {
    
    public void adicionar(Cliente cliente);

    public void modificar(Cliente cliente);

    public void excluir(Cliente cliente);

    public Cliente buscar(Long id);

    public List<Cliente> listar();
    
}
