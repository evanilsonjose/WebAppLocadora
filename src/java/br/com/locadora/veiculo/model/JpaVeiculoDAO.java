package br.com.locadora.veiculo.model;

import br.com.locadora.entity.Veiculo;
import br.com.locadora.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaVeiculoDAO implements VeiculoDAO {

    private EntityManager manager;

    public JpaVeiculoDAO() {
        manager = JpaUtil.getManager();
    }

    @Override
    public void adicionar(Veiculo veiculo) {
        manager.getTransaction().begin();
        manager.persist(veiculo);
        manager.getTransaction().commit();
    }

    @Override
    public void modificar(Veiculo veiculo) {
        manager.getTransaction().begin();
        manager.merge(veiculo);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(Veiculo veiculo) {
        manager.getTransaction().begin();
        manager.remove(veiculo);
        manager.getTransaction().commit();
    }

    @Override
    public Veiculo buscar(Long id) {
        return manager.find(Veiculo.class, id);
    }

    @Override
    public List<Veiculo> listar() {
        Query query = manager.createNativeQuery("SELECT * FROM veiculo;", Veiculo.class);
        return query.getResultList();
    }

}
