package com.example.ASM1.controller;

import com.example.ASM1.model.Ban;
import com.example.ASM1.repository.BanRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "ServletBan",
        value = {
                "/ban/hien-thi",
                "/ban/update",
                "/ban/remove",
                "/ban/add",
        })
public class ServletBan extends HttpServlet {
    private BanRepository repository = new BanRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/ban/hien-thi")) {
            String ma = request.getParameter("id");
            if (ma == null) {
                request.setAttribute("listFriend", repository.getAll());
                request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
            } else {
                Ban b = repository.getOne(Integer.valueOf(ma));
                request.setAttribute("ban", b);
                request.setAttribute("listFriend", repository.getAll());
                request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
            }
        } else {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Ban b = repository.getOne(id);
            repository.delete(b);
            response.sendRedirect("/ban/hien-thi");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/ban/update")) {
            String code = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String soThich = request.getParameter("soThich");

            boolean isValid = true;


            if (code == null || code.trim().isEmpty()) {
                request.setAttribute("message", "Bạn chưa nhập mã");
                isValid = false;
            }

            if (ten == null || ten.trim().isEmpty()) {
                request.setAttribute("message1", "Bạn chưa nhập tên");
                isValid = false;
            }

            if (soThich == null || soThich.trim().isEmpty()) {
                request.setAttribute("message2", "Bạn chưa nhập sở thích");
                isValid = false;
            }

            if (!isValid) {
                request.setAttribute("listFriend", repository.getAll());
                request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
            } else {
                try {
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    Ban b = repository.getOne(id);
                    BeanUtils.populate(b, request.getParameterMap());
                    repository.update(b);
                    response.sendRedirect("/ban/hien-thi");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi thêm mới.");
                }
            }
        } else {
            String code = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String soThich = request.getParameter("soThich");

            boolean isValid = true;


            if (code == null || code.trim().isEmpty()) {
                request.setAttribute("message", "Bạn chưa nhập mã");
                isValid = false;
            }

            if (ten == null || ten.trim().isEmpty()) {
                request.setAttribute("message1", "Bạn chưa nhập tên");
                isValid = false;
            }

            if (soThich == null || soThich.trim().isEmpty()) {
                request.setAttribute("message2", "Bạn chưa nhập sở thích");
                isValid = false;
            }

            if (!isValid) {
                request.setAttribute("listFriend", repository.getAll());
                request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
            } else {
                try {
                    Ban b = new Ban();
                    BeanUtils.populate(b, request.getParameterMap());
                    repository.add(b);
                    response.sendRedirect("/ban/hien-thi");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi thêm mới.");
                }
            }
        }
    }
}
