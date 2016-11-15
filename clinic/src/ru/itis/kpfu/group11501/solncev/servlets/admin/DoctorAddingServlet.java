package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Doctor;
import ru.itis.kpfu.group11501.solncev.serviceImpl.DoctorServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "DoctorAddingServlet")
public class DoctorAddingServlet extends HttpServlet {
    DoctorService doctorService = new DoctorServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Doctor doctor = new Doctor(Long.parseLong(request.getParameter("id")), request.getParameter("surname"), request.getParameter("name"),
                request.getParameter("patronymic"), request.getParameter("staff"), request.getParameter("speciality"), request.getParameter("photo"),
                request.getParameter("education"), request.getParameter("achievements"), Integer.parseInt(request.getParameter("experience")), request.getParameter("certificate"));
        doctorService.addDoctor(doctor);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
