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

@WebServlet("/usuario/modificar")
public class ModificarUsuarioServlet extends HttpServlet {

    private List<Usuario> listaUsuarios;
    private UsuarioDAO usuarioDAO;

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
                request.getRequestDispatcher("/WEB-INF/view/usuario/modificar.jsp").forward(request, response);
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
        Long id = Long.parseLong(strId);
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmaSenha = request.getParameter("confirmaSenha");

        Usuario usuario = new Usuario();

        if ((nome != null && email != null && senha != null && confirmaSenha != null)
                && (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !confirmaSenha.isEmpty())) {

            if (senha.equals(confirmaSenha)) {
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(senha);

                usuarioDAO = new JpaUsuarioDAO();
                usuarioDAO.modificar(usuario);

                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Usuário atualizado com sucesso!");

                listaUsuarios = usuarioDAO.listar();

                // configura uma chave para passar a lista de usuários para o formulário
                request.setAttribute("lista", listaUsuarios);
                request.getRequestDispatcher("/WEB-INF/view/usuario/listar.jsp").forward(request, response);
            } else {
                // setar o usuário para envio
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(email);
                // configura uma chave para passar o objeto usuario para o formulário
                request.setAttribute("usuario", usuario);
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "As senhas não conferem!");
                request.getRequestDispatcher("/WEB-INF/view/usuario/modificar.jsp").forward(request, response);
            }
        } else {
            // setar o usuário para envio
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setEmail(email);
            // configura uma chave para passar o objeto usuario para o formulário
            request.setAttribute("usuario", usuario);
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
            request.getRequestDispatcher("/WEB-INF/view/usuario/modificar.jsp").forward(request, response);
        }

    }

}
