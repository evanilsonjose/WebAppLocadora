package br.com.locadora.cliente.model;

import br.com.locadora.entity.Cliente;
import br.com.locadora.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaClienteDAO implements ClienteDAO {

    private EntityManager manager;

    public JpaClienteDAO() {
        manager = JpaUtil.getManager();
    }

    @Override
    public void adicionar(Cliente cliente) {
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
    }

    @Override
    public void modificar(Cliente cliente) {
        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(Cliente cliente) {
        manager.getTransaction().begin();
        manager.remove(cliente);
        manager.getTransaction().commit();
    }

    @Override
    public Cliente buscar(Long id) {
        return manager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> listar() {
        Query query = manager.createNativeQuery("SELECT * FROM cliente;", Cliente.class);
        return query.getResultList();
    }

}
