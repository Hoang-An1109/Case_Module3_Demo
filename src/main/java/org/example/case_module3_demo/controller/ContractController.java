package org.example.case_module3_demo.controller;

import org.example.case_module3_demo.model.Boarding_House;
import org.example.case_module3_demo.model.Client;
import org.example.case_module3_demo.model.Contract;
import org.example.case_module3_demo.model.DTO.ContractDTO;
import org.example.case_module3_demo.model.Staff;
import org.example.case_module3_demo.service.boarding_House.BoardingHouseDAO;
import org.example.case_module3_demo.service.client.ClientDAO;
import org.example.case_module3_demo.service.contract.ContractDAO;
import org.example.case_module3_demo.service.staff.StaffDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContractDAO contractDAO = new ContractDAO();
    private ClientDAO clientDAO = new ClientDAO();
    private BoardingHouseDAO boardingHouseDAO = new BoardingHouseDAO();
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
            case "contractDTO":
                showAllContractDTO(req, resp);
                break;
            case "findValueDTO":
                showContractDTOFindByValue(req, resp);
                break;
            case "contractDTOOderById":
                showAllContractDTOOderByID(req, resp);
                break;
            case "contractDTOOderByDate":
                showAllContractDTOOderByDate(req, resp);
                break;
            case "contractDTOOderByPrice":
                showAllContractDTOOderByPrice(req, resp);
                break;
            case "contractDTOOderByMoney":
                showAllContractDTOOderByMoney(req, resp);
                break;
            default:
                listContracts(req, resp);
                break;
        }
    }

    private void showContractDTOFindByValue(HttpServletRequest req, HttpServletResponse resp) {
        String value = req.getParameter("value");
        List<ContractDTO> contractDTOS = contractDAO.findByValue(value);
        req.setAttribute("listContractDTO", contractDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/listDTOFindByValue.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllContractDTO(HttpServletRequest req, HttpServletResponse resp) {
        List<ContractDTO> contractDTOS = contractDAO.showAllContractDTO();
        req.setAttribute("listContractDTO", contractDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/listDTO.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showAllContractDTOOderByID(HttpServletRequest req, HttpServletResponse resp) {
        List<ContractDTO> contractDTOS = contractDAO.selectAllContractOderById();
        req.setAttribute("listContractDTO", contractDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/listDTOOderById.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showAllContractDTOOderByDate(HttpServletRequest req, HttpServletResponse resp) {
        List<ContractDTO> contractDTOS = contractDAO.selectAllContractOderByDate();
        req.setAttribute("listContractDTO", contractDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/listDTOOderByDate.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showAllContractDTOOderByPrice(HttpServletRequest req, HttpServletResponse resp) {
        List<ContractDTO> contractDTOS = contractDAO.selectAllContractOderByPrice();
        req.setAttribute("listContractDTO", contractDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/listDTOOderByPrice.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showAllContractDTOOderByMoney(HttpServletRequest req, HttpServletResponse resp) {
        List<ContractDTO> contractDTOS = contractDAO.selectAllContractOderByMoney();
        req.setAttribute("listContractDTO", contractDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/listDTOOderByMoney.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listContracts(HttpServletRequest req, HttpServletResponse resp) {
        List<Contract> contractList = contractDAO.selectAll();
        req.setAttribute("listContract", contractList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("contract/list.jsp");
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
        Contract existingContract = contractDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("contract/delete.jsp");
        req.setAttribute("contract", existingContract);
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
        Contract existingContract = contractDAO.selectById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("contract/edit.jsp");
        req.setAttribute("contract", existingContract);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Boarding_House boardingHouses = boardingHouseDAO.selectById(id);
        List<Client> clients = clientDAO.selectAll();
        List<Staff> staffs = staffDAO.selectAll();
        req.setAttribute("boardingHouse", boardingHouses);
        req.setAttribute("client", clients);
        req.setAttribute("staff", staffs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("contract/create.jsp");

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
                insertContract(req, resp);
                break;
            case "edit":
                updateContract(req, resp);
                break;
            case "delete":
                deleteContract(req, resp);
                break;
            default: {
                break;
            }
        }
    }

    private void deleteContract(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            contractDAO.deleteById(id);
            List<Contract> contractList = contractDAO.selectAll();
            req.setAttribute("listContract", contractList);
            req.setAttribute("message", "Contract information was delete");
            RequestDispatcher dispatcher = req.getRequestDispatcher("contract/list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateContract(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String id_nha = req.getParameter("id_nha");
        String id_kh = req.getParameter("id_kh");
        String id_nv = req.getParameter("id_nv");
        Date ngay_hd = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngay_hd = dateFormat.parse(req.getParameter("ngay_hd"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        double gia_thue = Double.parseDouble(req.getParameter("gia_thue"));
        double tien_dat_coc = Double.parseDouble(req.getParameter("tien_dat_coc"));
        String dieu_khoan = req.getParameter("dieu_khoan");

        Boarding_House boardingHouse = new Boarding_House(id_nha);
        Client client = new Client(id_kh);
        Staff staff = new Staff(id_nv);

        Contract contract = new Contract(id, boardingHouse, client, staff, ngay_hd, gia_thue, tien_dat_coc, dieu_khoan);
        try {
            contractDAO.update(contract);
            req.setAttribute("message", "Contract information was updated");
            RequestDispatcher dispatcher = req.getRequestDispatcher("contract/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertContract(HttpServletRequest req, HttpServletResponse resp) {
        String id_hop_dong = req.getParameter("id_hop_dong");
        String id_nha = req.getParameter("id");
        String id_kh = req.getParameter("id_kh");
        String id_nv = req.getParameter("id_nv");
        Date ngay_hd = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngay_hd = dateFormat.parse(req.getParameter("ngay_hd"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        double gia_thue = Double.parseDouble(req.getParameter("gia_thue"));
        double tien_dat_coc = Double.parseDouble(req.getParameter("tien_dat_coc"));
        String dieu_khoan = req.getParameter("dieu_khoan");

        Boarding_House boardingHouse = new Boarding_House(id_nha);
        Client client = new Client(id_kh);
        Staff staff = new Staff(id_nv);

        Contract contract = new Contract(id_hop_dong, boardingHouse, client, staff, ngay_hd, gia_thue, tien_dat_coc, dieu_khoan);
        try {
            contractDAO.insertInto(contract);
            req.setAttribute("message", "New contract was created");
            RequestDispatcher dispatcher = req.getRequestDispatcher("contract/create.jsp");
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
