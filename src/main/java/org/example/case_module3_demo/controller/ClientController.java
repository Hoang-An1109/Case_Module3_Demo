package org.example.case_module3_demo.controller;

import org.example.case_module3_demo.model.Client;
import org.example.case_module3_demo.service.client.ClientDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClientServlet", urlPatterns = "/client")
public class ClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            default:
                listClients(req, resp);
                break;
        }
    }

    private void listClients(HttpServletRequest req, HttpServletResponse resp) {
        List<Client> clientList = clientDAO.selectAll();
        req.setAttribute("listClient", clientList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("client/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Client existingClient = clientDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/delete.jsp");
        req.setAttribute("client", existingClient);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Client existingClient = clientDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/edit.jsp");
        req.setAttribute("client", existingClient);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertClient(req, resp);
                break;
            case "edit":
                updateClient(req, resp);
                break;
            case "delete":
                deleteClient(req, resp);
                break;
            default: {
                break;
            }
        }
    }

    private void deleteClient(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            clientDAO.deleteById(id);
            List<Client> clientList = clientDAO.selectAll();
            req.setAttribute("listClient", clientList);
            req.setAttribute("message", "Client information was delete");
            RequestDispatcher dispatcher = req.getRequestDispatcher("client/list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateClient(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String ten_kh = req.getParameter("ten_kh");
        int cmt_kh = Integer.parseInt(req.getParameter("cmt_kh"));
        int dien_thoai_kh = Integer.parseInt(req.getParameter("dien_thoai_kh"));
        String dia_chi_lh = req.getParameter("dia_chi_lh");

        Client client = new Client(id, ten_kh, cmt_kh, dien_thoai_kh, dia_chi_lh);
        try {
            clientDAO.update(client);
            req.setAttribute("message", "Client information was updated");
            RequestDispatcher dispatcher = req.getRequestDispatcher("client/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertClient(HttpServletRequest req, HttpServletResponse resp) {
        String id_kh = req.getParameter("id_kh");
        String ten_kh = req.getParameter("ten_kh");
        int cmt_kh = Integer.parseInt(req.getParameter("cmt_kh"));
        int dien_thoai_kh = Integer.parseInt(req.getParameter("dien_thoai_kh"));
        String dia_chi_lh = req.getParameter("dia_chi_lh");
        Client newClient = new Client(id_kh, ten_kh, cmt_kh, dien_thoai_kh, dia_chi_lh);
        try {
            clientDAO.insertInto(newClient);
            req.setAttribute("message", "New client was created");
            RequestDispatcher dispatcher = req.getRequestDispatcher("client/create.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
