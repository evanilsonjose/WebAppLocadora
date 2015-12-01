package br.com.locadora.usuario.model;

import br.com.locadora.entity.Usuario;
import java.util.List;

public interface UsuarioDAO {

    public void adicionar(Usuario usuario);

    public void modificar(Usuario usuario);

    public void excluir(Usuario usuario);

    public Usuario buscar(Long id);

    public List<Usuario> listar();

}
