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

@WebServlet("/veiculo/excluir")
public class ExcluirVeiculoServlet extends HttpServlet {

    List<Veiculo> listaVeiculos;
    VeiculoDAO veiculoDAO;

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
            request.getRequestDispatcher("/WEB-INF/view/cliente/listar.jsp").forward(request, response);

        } else {

            Long id = Long.parseLong(strId);

            Veiculo veiculo;
            veiculoDAO = new JpaVeiculoDAO();
            veiculo = veiculoDAO.buscar(id);

            if (veiculo != null) {
                // configura uma chave para passar o objeto veículo para o formulário
                request.setAttribute("veiculo", veiculo);
                request.getRequestDispatcher("/WEB-INF/view/veiculo/excluir.jsp").forward(request, response);
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

        Veiculo veiculo;

        if (strId != null && !strId.isEmpty()) {

            Long id = Long.parseLong(strId);

            veiculoDAO = new JpaVeiculoDAO();
            veiculo = veiculoDAO.buscar(id);
            veiculoDAO.excluir(veiculo);

            // configura uma mensagem para passar para o formulário
            request.setAttribute("msg", "Veículo removido com sucesso!");

            listaVeiculos = veiculoDAO.listar();

            // configura uma chave para passar a lista de veículos para o formulário
            request.setAttribute("lista", listaVeiculos);
            request.getRequestDispatcher("/WEB-INF/view/veiculo/listar.jsp").forward(request, response);

        }
        
    }

}
