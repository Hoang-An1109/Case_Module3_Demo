package org.example.case_module3_demo.controller;

import org.example.case_module3_demo.model.Boarding_House;
import org.example.case_module3_demo.service.boarding_House.BoardingHouseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BoardingHouseServlet", urlPatterns = "/boardingHouse")
public class BoardingHouseController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BoardingHouseDAO boardingHouseDAO = new BoardingHouseDAO();

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
                listBoardingHouses(req, resp);
                break;
        }
    }

    private void listBoardingHouses(HttpServletRequest req, HttpServletResponse resp) {
        List<Boarding_House> boardingHouses = boardingHouseDAO.selectAll();
        req.setAttribute("listBoardingHouse", boardingHouses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("boardingHouse/list.jsp");
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
        Boarding_House existingBoardingHouse = boardingHouseDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("boardingHouse/delete.jsp");
        req.setAttribute("boardingHouse", existingBoardingHouse);
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
        Boarding_House existingBoardingHouse = boardingHouseDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("boardingHouse/edit.jsp");
        req.setAttribute("boardingHouse", existingBoardingHouse);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("boardingHouse/create.jsp");
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
                insertBoardingHouse(req, resp);
                break;
            case "edit":
                updateBoardingHouse(req, resp);
                break;
            case "delete":
                deleteBoardingHouse(req, resp);
                break;
            default: {
                break;
            }
        }
    }

    private void deleteBoardingHouse(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            boardingHouseDAO.deleteById(id);
            List<Boarding_House> boardingHouseList = boardingHouseDAO.selectAll();
            req.setAttribute("listBoardingHouse", boardingHouseList);
            req.setAttribute("message", "Boarding House information was delete");
            RequestDispatcher dispatcher = req.getRequestDispatcher("boardingHouse/list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBoardingHouse(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String dia_chi = req.getParameter("dia_chi");
        double dien_tich = Double.parseDouble(req.getParameter("dien_tich"));
        double don_gia = Double.parseDouble(req.getParameter("don_gia"));
        String trang_thai = req.getParameter("trang_thai");

        Boarding_House boardingHouse = new Boarding_House(id, dia_chi, dien_tich, don_gia, trang_thai);
        try {
            boardingHouseDAO.update(boardingHouse);
            req.setAttribute("message", "Boarding House information was updated");
            RequestDispatcher dispatcher = req.getRequestDispatcher("boardingHouse/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertBoardingHouse(HttpServletRequest req, HttpServletResponse resp) {
        String id_nha = req.getParameter("id_nha");
        String dia_chi = req.getParameter("dia_chi");
        double dien_tich = Double.parseDouble(req.getParameter("dien_tich"));
        double don_gia = Double.parseDouble(req.getParameter("don_gia"));
        String trang_thai = req.getParameter("trang_thai");

        Boarding_House boardingHouse = new Boarding_House(id_nha, dia_chi, dien_tich, don_gia, trang_thai);
        try {
            boardingHouseDAO.insertInto(boardingHouse);
            req.setAttribute("message", "New boarding house was created");
            RequestDispatcher dispatcher = req.getRequestDispatcher("boardingHouse/create.jsp");
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

