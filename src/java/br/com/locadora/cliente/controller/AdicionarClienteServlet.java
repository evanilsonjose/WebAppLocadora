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

@WebServlet("/cliente/adicionar")
public class AdicionarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // redireciona repassando os objetos request/response juntos
        request.getRequestDispatcher("/WEB-INF/view/cliente/adicionar.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cnh = request.getParameter("cnh");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        Cliente cliente = new Cliente();

        if ((nome != null && cnh != null && endereco != null && bairro != null && cidade != null && estado != null)
                && (!nome.isEmpty() && !cnh.isEmpty() && !endereco.isEmpty() && !bairro.isEmpty() && !cidade.isEmpty() && !estado.isEmpty())) {

            cliente.setNome(nome);
            cliente.setCnh(cnh);
            cliente.setEndereco(endereco);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);

            ClienteDAO clienteDAO = new JpaClienteDAO();
            clienteDAO.adicionar(cliente);

            request.setAttribute("msg", "Cliente cadastrado com sucesso!");
            doGet(request, response);

        } else {
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
            doGet(request, response);
        }

    }

}
