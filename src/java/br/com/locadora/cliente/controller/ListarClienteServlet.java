package br.com.locadora.cliente.controller;

import br.com.locadora.cliente.model.ClienteDAO;
import br.com.locadora.cliente.model.JpaClienteDAO;
import br.com.locadora.entity.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cliente/listar")
public class ListarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> listaClientes;

        ClienteDAO clienteDAO = new JpaClienteDAO();
        listaClientes = clienteDAO.listar();

        // configura uma chave para passar a lista de clientes para o formulário
        request.setAttribute("lista", listaClientes);
        request.getRequestDispatcher("/WEB-INF/view/cliente/listar.jsp").forward(request, response);

    }

}
