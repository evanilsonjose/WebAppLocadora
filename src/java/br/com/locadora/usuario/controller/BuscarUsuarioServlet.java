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

@WebServlet("/usuario/buscar")
public class BuscarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("id") == null) {
            request.getRequestDispatcher("/WEB-INF/view/usuario/buscar.jsp").forward(request, response);
        } else {
            String strId = request.getParameter("id");
            Long id;

            Usuario usuario;

            if (strId != null && !strId.isEmpty()) {

                id = Long.parseLong(strId);

                UsuarioDAO usuarioDAO = new JpaUsuarioDAO();
                usuario = usuarioDAO.buscar(id);

                if (usuario != null) {
                    // configura uma chave para passar o objeto usuario para o formulário
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("/WEB-INF/view/usuario/buscar.jsp").forward(request, response);
                } else {
                    // configura uma mensagem para passar para o formulário
                    request.setAttribute("msg", "Usuário não encontrado!");
                    request.getRequestDispatcher("/WEB-INF/view/usuario/buscar.jsp").forward(request, response);
                }

            } else {
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
                request.getRequestDispatcher("/WEB-INF/view/usuario/buscar.jsp").forward(request, response);
            }
        }
    }
}
