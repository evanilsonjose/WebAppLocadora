package br.com.locadora.veiculo.controller;

import br.com.locadora.entity.Veiculo;
import br.com.locadora.veiculo.model.JpaVeiculoDAO;
import br.com.locadora.veiculo.model.VeiculoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/veiculo/listar")
public class ListarVeiculoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Veiculo> listaVeiculos;

        VeiculoDAO veiculoDAO = new JpaVeiculoDAO();
        listaVeiculos = veiculoDAO.listar();

        // configura uma chave para passar a lista de veículos para o formulário
        request.setAttribute("lista", listaVeiculos);
        request.getRequestDispatcher("/WEB-INF/view/veiculo/listar.jsp").forward(request, response);

    }

}
