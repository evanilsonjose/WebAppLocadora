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

@WebServlet("/usuario/excluir")
public class ExcluirUsuarioServlet extends HttpServlet {

    List<Usuario> listaUsuarios;
    UsuarioDAO usuarioDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");

        // valida se não foi passado nenhum parâmetro de id, recarrega a página listar novamente
        if ((strId == null) || (strId.isEmpty())) {

            usuarioDAO = new JpaUsuarioDAO();
            listaUsuarios = usuarioDAO.listar();

            // configura uma chave para passar a lista de usuários para o formulário
            request.setAttribute("lista", listaUsuarios);
            request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);

        } else {

            Long id = Long.parseLong(strId);

            Usuario usuario;
            usuarioDAO = new JpaUsuarioDAO();
            usuario = usuarioDAO.buscar(id);

            if (usuario != null) {
                // configura uma chave para passar o objeto usuario para o formulário
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/WEB-INF/view/usuario/excluir.jsp").forward(request, response);
            } else {
                usuarioDAO = new JpaUsuarioDAO();
                listaUsuarios = usuarioDAO.listar();
                // configura uma chave para passar a lista de usuários para o formulário
                request.setAttribute("lista", listaUsuarios);
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Usuário não encontrado!");
                request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");

        Usuario usuario;

        if (strId != null && !strId.isEmpty()) {

            Long id = Long.parseLong(strId);

            usuarioDAO = new JpaUsuarioDAO();
            usuario = usuarioDAO.buscar(id);
            usuarioDAO.excluir(usuario);

            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Usuário removido com sucesso!");

            listaUsuarios = usuarioDAO.listar();

            // configura uma chave para passar a lista de usuários para o formulário
            request.setAttribute("lista", listaUsuarios);
            request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);

        }

    }

    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");

        List<Usuario> listaUsuarios;
        UsuarioDAO usuarioDAO;

        // valida se não foi passado nenhum parâmetro de id, recarrega a página listar novamente
        if ((strId == null) || (strId.isEmpty())) {

            usuarioDAO = new JpaUsuarioDAO();
            listaUsuarios = usuarioDAO.listar();

            // configura uma chave para passar a lista de usuários para o formulário
            request.setAttribute("lista", listaUsuarios);
            request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);

        } else {

            Long id = Long.parseLong(strId);

            Usuario usuario;
            usuarioDAO = new JpaUsuarioDAO();
            usuario = usuarioDAO.buscar(id);
            usuarioDAO.excluir(usuario);

            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Usuário excluído com sucesso!");

            listaUsuarios = usuarioDAO.listar();

            // configura uma chave para passar a lista de usuários para o formulário
            request.setAttribute("lista", listaUsuarios);
            request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);

        }
    }*/
}
