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

@WebServlet("/cliente/modificar")
public class ModificarClienteServlet extends HttpServlet {

    private List<Cliente> listaClientes;
    private ClienteDAO clienteDAO;

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
                request.getRequestDispatcher("/WEB-INF/view/cliente/modificar.jsp").forward(request, response);
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
        Long id = Long.parseLong(strId);
        String nome = request.getParameter("nome");
        String cnh = request.getParameter("cnh");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        Cliente cliente = new Cliente();

        if ((nome != null && cnh != null && endereco != null && bairro != null && cidade != null && estado != null)
                && (!nome.isEmpty() && !cnh.isEmpty() && !endereco.isEmpty() && !bairro.isEmpty() && !cidade.isEmpty() && !estado.isEmpty())) {

            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setCnh(cnh);
            cliente.setEndereco(endereco);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);

            clienteDAO = new JpaClienteDAO();
            clienteDAO.modificar(cliente);

            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Cliente atualizado com sucesso!");

            listaClientes = clienteDAO.listar();

            // configura uma chave para passar a lista de clientes para o formulário
            request.setAttribute("lista", listaClientes);
            request.getRequestDispatcher("/WEB-INF/view/cliente/listar.jsp").forward(request, response);
        } else {
            // setar o cliente para envio
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setCnh(cnh);
            cliente.setEndereco(endereco);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);
            // configura uma chave para passar o objeto cliente para o formulário
            request.setAttribute("cliente", cliente);
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
            request.getRequestDispatcher("/WEB-INF/view/cliente/modificar.jsp").forward(request, response);
        }

    }

}
