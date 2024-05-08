package org.example.case_module3_demo.controller;

import org.example.case_module3_demo.model.Staff;
import org.example.case_module3_demo.service.staff.StaffDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", urlPatterns = "/staff")
public class StaffController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StaffDAO staffDAO = new StaffDAO();

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
                listStaffs(req, resp);
                break;
        }
    }

    private void listStaffs(HttpServletRequest req, HttpServletResponse resp) {
        List<Staff> staffList = staffDAO.selectAll();
        req.setAttribute("listStaff", staffList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("staff/list.jsp");
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
        Staff existingStaff = staffDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/delete.jsp");
        req.setAttribute("staff", existingStaff);
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
        Staff existingStaff = staffDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/edit.jsp");
        req.setAttribute("staff", existingStaff);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/create.jsp");
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
                insertStaff(req, resp);
                break;
            case "edit":
                updateStaff(req, resp);
                break;
            case "delete":
                deleteStaff(req, resp);
                break;
            default: {
                break;
            }
        }
    }

    private void deleteStaff(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            staffDAO.deleteById(id);
            List<Staff> staffList = staffDAO.selectAll();
            req.setAttribute("listStaff", staffList);
            req.setAttribute("message", "Staff information was delete");
            RequestDispatcher dispatcher = req.getRequestDispatcher("staff/list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateStaff(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String ten_nv = req.getParameter("ten_nv");
        String vai_tro = req.getParameter("vai_tro");
        int cmt_nv = Integer.parseInt(req.getParameter("cmt_nv"));
        int dien_thoai_nv = Integer.parseInt(req.getParameter("dien_thoai_nv"));


        Staff staff = new Staff(id, ten_nv, vai_tro, cmt_nv, dien_thoai_nv);
        try {
            staffDAO.update(staff);
            req.setAttribute("message", "Staff information was updated");
            RequestDispatcher dispatcher = req.getRequestDispatcher("staff/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertStaff(HttpServletRequest req, HttpServletResponse resp) {
        String id_nv = req.getParameter("id_nv");
        String ten_nv = req.getParameter("ten_nv");
        String vai_tro = req.getParameter("vai_tro");
        int cmt_nv = Integer.parseInt(req.getParameter("cmt_nv"));
        int dien_thoai_nv = Integer.parseInt(req.getParameter("dien_thoai_nv"));

        Staff newStaff = new Staff(id_nv, ten_nv, vai_tro, cmt_nv, dien_thoai_nv);
        try {
            staffDAO.insertInto(newStaff);
            req.setAttribute("message", "New staff was created");
            RequestDispatcher dispatcher = req.getRequestDispatcher("staff/create.jsp");
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
