package controllers;

import db.DBManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStud = req.getParameter("idsHiddenProgress");
        String idTerm = req.getParameter("idTerm");

//        1 - get student by id
//        2 - get all active semesters
//        3 - get selected semester
//        4 - get all grades with disciplines by semester

        Student student = DBManager.getStudentById(idStud);
        ArrayList<Term> terms = DBManager.getAllActiveTerms();


        if(idTerm == null || idTerm.equals("")){
            if(terms.size() !=0){
                idTerm = terms.get(0).getId() + "";
            }else {
                idTerm="-1";
            }

        }

        Term selectedTerm = DBManager.getTermById(idTerm);
        ArrayList<Mark> marks = DBManager.getMarks(idStud, idTerm);


        double summaMarks = 0;


        for(Mark m : marks){
            if (m.getMark() != -1){
                summaMarks = summaMarks + m.getMark();

            }

        }


        if (marks.size() > 0 && summaMarks !=0){
            req.setAttribute("avg", (summaMarks / marks.size()));

        }else {
            req.setAttribute("avg","0.0");
        }


       req.setAttribute("student", student);
       req.setAttribute("terms", terms);
       req.setAttribute("selectedTerm", selectedTerm);
       req.setAttribute("marks", marks);

       req.getRequestDispatcher("WEB-INF/jsp/student-progress.jsp").forward(req, resp);
    }

}
