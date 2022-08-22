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

@WebServlet(name="TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idTerm = req.getParameter("idTerm");

        ArrayList<Term> terms = DBManager.getAllActiveTerms();
        if (idTerm == null || idTerm.equals("")) {
            if (terms.size() != 0) {
                idTerm = terms.get(0).getId() + "";

            } else {
                idTerm = "-1";
            }

        }

        Term selectedTerm = DBManager.getTermById(idTerm);

        assert selectedTerm != null;
        ArrayList<Discipline> disciplines = DBManager.getAllActiveDisciplinesByTerm(selectedTerm.getId() + " ");

        req.setAttribute("terms", terms);
        req.setAttribute("selectedTerm", selectedTerm);
        req.setAttribute("disciplines", disciplines);

        req.getRequestDispatcher("WEB-INF/jsp/terms.jsp").forward(req, resp);


    }
}
