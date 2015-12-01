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

@WebServlet("/veiculo/modificar")
public class ModificarVeiculoServlet extends HttpServlet {

    private List<Veiculo> listaVeiculos;
    private VeiculoDAO veiculoDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");

        // valida se não foi passado nenhum parâmetro de id, recarrega a página listar novamente
        if ((strId == null) || (strId.isEmpty())) {

            veiculoDAO = new JpaVeiculoDAO();
            listaVeiculos = veiculoDAO.listar();

            // configura uma chave para passar a lista de veículos para o formulário
            request.setAttribute("lista", listaVeiculos);
            request.getRequestDispatcher("/WEB-INF/view/veiculo/listar.jsp").forward(request, response);

        } else {

            Long id = Long.parseLong(strId);

            Veiculo veiculo;
            veiculoDAO = new JpaVeiculoDAO();
            veiculo = veiculoDAO.buscar(id);

            if (veiculo != null) {
                // configura uma chave para passar o objeto veículo para o formulário
                request.setAttribute("veiculo", veiculo);
                request.getRequestDispatcher("/WEB-INF/view/veiculo/modificar.jsp").forward(request, response);
            } else {
                veiculoDAO = new JpaVeiculoDAO();
                listaVeiculos = veiculoDAO.listar();
                // configura uma chave para passar a lista de veículos para o formulário
                request.setAttribute("lista", listaVeiculos);
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Veículo não encontrado!");
                request.getRequestDispatcher("/WEB-INF/view/veiculo/listar.jsp").forward(request, response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strId = request.getParameter("id");
        Long id = Long.parseLong(strId);
        String placa = request.getParameter("placa");
        String fabricante = request.getParameter("fabricante");
        String modelo = request.getParameter("modelo");
        String strValorAluguel = request.getParameter("valorAluguel");

        Veiculo veiculo = new Veiculo();

        if ((placa != null && fabricante != null && modelo != null && strValorAluguel != null) && (!placa.isEmpty()
                && !fabricante.isEmpty() && !modelo.isEmpty() && !strValorAluguel.isEmpty())) {

            double valorAluguel = Double.parseDouble(strValorAluguel);

            veiculo.setId(id);
            veiculo.setPlaca(placa);
            veiculo.setFabricante(fabricante);
            veiculo.setModelo(modelo);
            veiculo.setValorAluguel(valorAluguel);

            veiculoDAO = new JpaVeiculoDAO();
            veiculoDAO.modificar(veiculo);

            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Veículo atualizado com sucesso!");

            listaVeiculos = veiculoDAO.listar();

            // configura uma chave para passar a lista de veículos para o formulário
            request.setAttribute("lista", listaVeiculos);
            request.getRequestDispatcher("/WEB-INF/view/veiculo/listar.jsp").forward(request, response);
        } else {
            double valorAluguel = Double.parseDouble(strValorAluguel);
            // setar o veículo para envio
            veiculo.setId(id);
            veiculo.setPlaca(placa);
            veiculo.setFabricante(fabricante);
            veiculo.setModelo(modelo);
            veiculo.setValorAluguel(valorAluguel);
            // configura uma chave para passar o objeto veículo para o formulário
            request.setAttribute("veiculo", veiculo);
            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
            request.getRequestDispatcher("/WEB-INF/view/veiculo/modificar.jsp").forward(request, response);
        }

    }

}
