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

@WebServlet("/cliente/excluir")
public class ExcluirClienteServlet extends HttpServlet {

    List<Cliente> listaClientes;
    ClienteDAO clienteDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");

        // valida se não foi passado nenhum parâmetro de id, recarrega a página listar novamente
        if ((strId == null) || (strId.isEmpty())) {

            clienteDAO = new JpaClienteDAO();
            listaClientes = clienteDAO.listar();

            // configura uma chave para passar a lista de clientes para o formulário
            request.setAttribute("lista", listaClientes);
            request.getRequestDispatcher("/WEB-INF/view/cliente/listar.jsp").forward(request, response);

        } else {

            Long id = Long.parseLong(strId);

            Cliente cliente;
            clienteDAO = new JpaClienteDAO();
            cliente = clienteDAO.buscar(id);

            if (cliente != null) {
                // configura uma chave para passar o objeto cliente para o formulário
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("/WEB-INF/view/cliente/excluir.jsp").forward(request, response);
            } else {
                clienteDAO = new JpaClienteDAO();
                listaClientes = clienteDAO.listar();
                // configura uma chave para passar a lista de clientes para o formulário
                request.setAttribute("lista", listaClientes);
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Cliente não encontrado!");
                request.getRequestDispatcher("/WEB-INF/view/cliente/listar.jsp").forward(request, response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");

        Cliente cliente;

        if (strId != null && !strId.isEmpty()) {

            Long id = Long.parseLong(strId);

            clienteDAO = new JpaClienteDAO();
            cliente = clienteDAO.buscar(id);
            clienteDAO.excluir(cliente);

            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Cliente removido com sucesso!");

            listaClientes = clienteDAO.listar();

            // configura uma chave para passar a lista de clientes para o formulário
            request.setAttribute("lista", listaClientes);
            request.getRequestDispatcher("/WEB-INF/view/cliente/listar.jsp").forward(request, response);

        }
        
    }

}
