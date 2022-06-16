package controllers;

import db.DBManager;
import entity.Discipline;
import entity.Term;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(
        name = "TermsController",
        urlPatterns = {"/terms"}
)
public class TermsController extends HttpServlet {
    public TermsController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Discipline> terms = DBManager.getAllActiveDiscipline();


        req.setAttribute("terms", terms);
        req.getRequestDispatcher("WEB-INF/jsp/terms.jsp").forward(req, resp);
    }
}
