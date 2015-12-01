package br.com.locadora.veiculo.controller;

import br.com.locadora.entity.Veiculo;
import br.com.locadora.veiculo.model.JpaVeiculoDAO;
import br.com.locadora.veiculo.model.VeiculoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/veiculo/adicionar")
public class AdicionarVeiculoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // redireciona repassando os objetos request/response juntos
        request.getRequestDispatcher("/WEB-INF/view/veiculo/adicionar.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String placa = request.getParameter("placa");
        String fabricante = request.getParameter("fabricante");
        String modelo = request.getParameter("modelo");
        String strValorAluguel = request.getParameter("valorAluguel");

        Veiculo veiculo = new Veiculo();

        if ((placa != null && fabricante != null && modelo != null && strValorAluguel != null) && (!placa.isEmpty()
                && !fabricante.isEmpty() && !modelo.isEmpty() && !strValorAluguel.isEmpty())) {

            double valorAluguel = Double.parseDouble(strValorAluguel);

            veiculo.setPlaca(placa);
            veiculo.setFabricante(fabricante);
            veiculo.setModelo(modelo);
            veiculo.setValorAluguel(valorAluguel);

            VeiculoDAO veiculoDAO = new JpaVeiculoDAO();
            veiculoDAO.adicionar(veiculo);
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Veículo cadastrado com sucesso!");
            doGet(request, response);
        } else {
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
            doGet(request, response);
        }

    }

}
