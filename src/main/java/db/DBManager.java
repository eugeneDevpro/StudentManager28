package db;

import constants.Constants;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Student> getAllActiveStudent() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select s.id, s.surname, s.name, s.id_group, g.group, s.date from student as s\n" +
                    "left join groupe as g on s.id_group = g.id\n" +
                    "where status = '1' ");

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));

                Group group = new Group();
                group.setId(rs.getInt("id_group"));
                group.setGroup(rs.getString("group"));

                student.setGroup(group);
                student.setDate(rs.getDate("date"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public static int getGroupId(String group) {
/**
 *  Проверяет есть ли уже такая группа в базе. Если есть - отдает ее id.
 *  Если нет - записываем новую группу в таблицу, и вохвращаем ее id
 */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM groupe as g where g.group = \""+group+"\"");

            while (rs.next()) {
                return rs.getInt("id");
            }

            // здесь код отработает только если в базе НЕТ такой группы
            // вносим в таблицу группа информацию о новой группе
            stmt.execute("INSERT INTO `groupe` (`group`) VALUES ('"+group+"');");
            // достаем id новой созданной группы и возвращаем его
            rs = stmt.executeQuery("SELECT * FROM groupe ORDER BY id DESC LIMIT 1");
            while (rs.next()){
                return rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }


    public static void createStudent(String surname, String name, int idGroup, String date) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `id_group`, `date`) VALUES ('"+surname+"', '"+name+"', '"+idGroup+"', '"+date+"');");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyStudent(String id, String surname, String name, int idGroup, String date) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '"+surname+"', `name` = '"+name+"', `id_group` = '"+idGroup+"', `date` = '"+date+"' WHERE (`id` = '"+id+"');\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students_28_29`.`student` SET `status` = '0' WHERE (`id` = '"+id+"');\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select s.id, s.surname, s.name, s.id_group, g.group, s.date from student as s\n" +
                    "left join groupe as g on s.id_group = g.id\n" +
                    "where status = '1' AND s.id =" + id);

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));

                Group group = new Group();
                group.setId(rs.getInt("id_group"));
                group.setGroup(rs.getString("group"));

                student.setGroup(group);
                student.setDate(rs.getDate("date"));

                return student;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Discipline> getAllActiveDiscipline() {
        ArrayList<Discipline> disciplines = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline FROM discipline as d\nwhere status = '1' ");

            while(rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                disciplines.add(discipline);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return disciplines;
    }

    public static void createDiscipline(String discipline) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + discipline + "');");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteDiscipline(String id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void modifyDiscipline(String id, String discipline) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = '" + discipline + "' WHERE (`id` = '" + id + "');\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Discipline getDisciplineById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline FROM discipline as d\nwhere status = '1' AND d.id = " + id);

            if (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));


                return discipline;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
