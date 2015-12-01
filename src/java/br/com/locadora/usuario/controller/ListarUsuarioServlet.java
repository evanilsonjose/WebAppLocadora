package br.com.locadora.usuario.controller;

import br.com.locadora.entity.Usuario;
import br.com.locadora.usuario.model.JpaUsuarioDAO;
import br.com.locadora.usuario.model.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuario/listar")
public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuarios;
        
        UsuarioDAO usuarioDAO = new JpaUsuarioDAO();
        listaUsuarios = usuarioDAO.listar();

        // configura uma chave para passar a lista de usuários para o formulário
        request.setAttribute("lista", listaUsuarios);
        request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);
    }

}
