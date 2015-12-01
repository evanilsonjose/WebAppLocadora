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

@WebServlet("/veiculo/buscar")
public class BuscarVeiculoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("id") == null) {
            request.getRequestDispatcher("/WEB-INF/view/veiculo/buscar.jsp").forward(request, response);
        } else {
            String strId = request.getParameter("id");
            Long id;

            Veiculo veiculo;

            if (strId != null && !strId.isEmpty()) {

                id = Long.parseLong(strId);

                VeiculoDAO veiculoDAO = new JpaVeiculoDAO();
                veiculo = veiculoDAO.buscar(id);

                if (veiculo != null) {
                    // configura uma chave para passar o objeto veículo para o formulário
                    request.setAttribute("veiculo", veiculo);
                    request.getRequestDispatcher("/WEB-INF/view/veiculo/buscar.jsp").forward(request, response);
                } else {
                    // configura uma mensagem para passar para o formulário
                    request.setAttribute("msg", "Veículo não encontrado!");
                    request.getRequestDispatcher("/WEB-INF/view/veiculo/buscar.jsp").forward(request, response);
                }

            } else {
                // configura uma mensagem para passar para o formulário
                request.setAttribute("msg", "Os dados não podem ser nulos, e nem vazios!");
                request.getRequestDispatcher("/WEB-INF/view/veiculo/buscar.jsp").forward(request, response);
            }
        }
    }
}
