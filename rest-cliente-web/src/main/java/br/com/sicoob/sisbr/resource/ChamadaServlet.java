package br.com.sicoob.sisbr.resource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sicoob.sisbr.cliente.SicoobRestServico;

public class ChamadaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        String message = "teste";
        try {
            SicoobRestServico servico = new SicoobRestServico();
            MeuNome nome = new MeuNome();
            nome.setNome("Rogerio");
            message = servico.consumir(nome);
        } catch (Exception excecao) {
            Logger.getLogger(ChamadaServlet.class.getName()).log(Level.SEVERE, "Erro ao consumir o servico");
            message = excecao.getMessage();
        }

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

}
