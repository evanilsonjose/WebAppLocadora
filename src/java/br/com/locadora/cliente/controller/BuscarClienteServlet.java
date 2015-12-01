package br.com.locadora.cliente.controller;

import br.com.locadora.cliente.model.ClienteDAO;
import br.com.locadora.cliente.model.JpaClienteDAO;
import br.com.locadora.entity.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cliente/buscar")
public class BuscarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("id") == null) {
            request.getRequestDispatcher("/WEB-INF/view/cliente/buscar.jsp").forward(request, response);
        } else {
            String strId = request.getParameter("id");
            Long id;

            Cliente cliente;

            if (strId != null && !strId.isEmpty()) {

                id = Long.parseLong(strId);

                ClienteDAO clienteDAO = new JpaClienteDAO();
                cliente = clienteDAO.buscar(id);

                if (cliente != null) {
                    // configura uma chave para passar o objeto cliente para o formulário
                    request.setAttribute("cliente", cliente);
                    request.getRequestDispatcher("/WEB-INF/view/cliente/buscar.jsp").forward(request, response);
                } else {
                    // configura uma mensagem para passar para o formulário
                    request.setAttribute("msg", "Cliente não encontrado!");
                    request.getRequestDispatcher("/WEB-INF/view/cliente/buscar.jsp").forward(request, response);
                }

            } else {
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
                request.getRequestDispatcher("/WEB-INF/view/cliente/buscar.jsp").forward(request, response);
            }
        }
    }
}
