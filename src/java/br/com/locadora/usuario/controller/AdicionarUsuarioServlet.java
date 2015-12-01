package br.com.locadora.usuario.controller;

import br.com.locadora.entity.Usuario;
import br.com.locadora.usuario.model.JpaUsuarioDAO;
import br.com.locadora.usuario.model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuario/adicionar")
public class AdicionarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // redireciona repassando os objetos request/response juntos
        request.getRequestDispatcher("/WEB-INF/view/usuario/adicionar.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmaSenha = request.getParameter("confirmaSenha");

        Usuario usuario = new Usuario();

        if ((nome != null && email != null && senha != null && confirmaSenha != null)
                && (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !confirmaSenha.isEmpty())) {

            if (senha.equals(confirmaSenha)) {
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(senha);

                UsuarioDAO usuarioDAO = new JpaUsuarioDAO();
                usuarioDAO.adicionar(usuario);
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Usuário cadastrado com sucesso!");
                doGet(request, response);

            } else {
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "As senhas não conferem!");
                doGet(request, response);
            }
        } else {
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
            doGet(request, response);
        }

    }
}
