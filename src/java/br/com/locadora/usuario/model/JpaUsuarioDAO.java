package br.com.locadora.usuario.model;

import br.com.locadora.entity.Usuario;
import br.com.locadora.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaUsuarioDAO implements UsuarioDAO {

    private EntityManager manager;

    public JpaUsuarioDAO() {
        manager = JpaUtil.getManager();
    }

    @Override
    public void adicionar(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
    }

    @Override
    public void modificar(Usuario usuario) {
        manager.getTransaction().begin();
        manager.merge(usuario);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(Usuario usuario) {
        manager.getTransaction().begin();
        manager.remove(usuario);
        manager.getTransaction().commit();
    }

    @Override
    public Usuario buscar(Long id) {
        return manager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> listar() {
        Query query = manager.createNativeQuery("SELECT * FROM usuario;", Usuario.class);
        return query.getResultList();
    }

}
