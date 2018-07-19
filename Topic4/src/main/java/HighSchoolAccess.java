import java.nio.file.FileSystemAlreadyExistsException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HighSchoolAccess {

    public void connectBD (){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/high-school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root","n8kiabelle");

        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getCourse (String course){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/high-school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root","n8kiabelle");
            Statement stmt = connection.createStatement();
            String query1 = "Select * from Course where name = '" + course + "'";
            ResultSet rs = stmt.executeQuery(query1);
            String course_id = null;
            String AssignedTeacher = null;
            boolean exists = false;
            while (rs.next()){
                String name = rs.getString("name");
                AssignedTeacher = rs.getString("AssignedTeacher");
                System.out.println("Course: " + name);
                course_id = rs.getString("courseid");
                exists = true;
            }

            if (exists){
                query1 = "Select * from Teacher where TeacherId = '" + AssignedTeacher + "'";
                rs = stmt.executeQuery(query1);
                while (rs.next()){
                    String Last_name = rs.getString("Last_name");
                    String First_name = rs.getString("First_name");
                    System.out.println("Teacher: " + Last_name + ", " + First_name);
                }
                query1 = "Select * from student \n" +
                        "where student.StudentId in (\n" +
                        "\tselect a.student_StudentId from student_has_schedule as a\n" +
                        "\twhere a.schedule_ScheduleId in  (\n" +
                        "\t\tselect s.ScheduleId from schedule as s\n" +
                        "        where s.AssignedCourse = '"+ course_id+ "'\n" +
                        "\t)\n" +
                        ") ORDER BY student.Last_name ";
                rs = stmt.executeQuery(query1);
                System.out.println("Students: ");
                while (rs.next()){
                    String Last_name = rs.getString("Last_name");
                    String First_name = rs.getString("First_name");
                    System.out.println("\t" + Last_name + ", " + First_name);
                }
            }

        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPassedFailed (String course){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/high-school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root","n8kiabelle");
            Statement stmt = connection.createStatement();
            String query1 = "Select * from Course where name = '" + course + "'";
            ResultSet rs = stmt.executeQuery(query1);
            String course_id = null;
            String AssignedTeacher = null;
            boolean exists = false;
            while (rs.next()){
                String name = rs.getString("name");
                AssignedTeacher = rs.getString("AssignedTeacher");
                System.out.println("Course: " + name);
                course_id = rs.getString("courseid");
                exists = true;
            }

            if (exists){
                query1 = "Select * from Teacher where TeacherId = '" + AssignedTeacher + "'";
                rs = stmt.executeQuery(query1);
                while (rs.next()){
                    String Last_name = rs.getString("Last_name");
                    String First_name = rs.getString("First_name");
                    System.out.println("Teacher: " + Last_name + ", " + First_name);
                }
                query1 = "Select s.Last_name, s.First_name, note.Final_Note from student as s, note\n" +
                        "where note.AssignedCourse = '"+ course_id +"'\n" +
                        "and s.StudentId = note.AssignedStudent";
                rs = stmt.executeQuery(query1);
                System.out.println("Students: ");
                while (rs.next()){
                    String Last_name = rs.getString("Last_name");
                    String First_name = rs.getString("First_name");
                    int finalnote = rs.getInt("Final_Note");
                    if (finalnote >= 6) {
                        System.out.println("\t" + Last_name + ", " + First_name + "\t\tPASSED");
                    }
                    else {
                        System.out.println("\t" + Last_name + ", " + First_name + "\t\tFAILED");
                    }
                }

                query1 = "Select count(student.StudentId)*100/(\n" +
                        "Select count(student.StudentId) from student\n" +
                        "where student.StudentId in (\n" +
                        "\tselect note.AssignedStudent from note\n" +
                        "    where note.AssignedCourse = '"+course_id+"')) as percent from student\n" +
                        "where student.StudentId in (\n" +
                        "\tselect note.AssignedStudent from note\n" +
                        "    where note.AssignedCourse = '"+course_id+"'\n" +
                        "    and note.Final_Note>=6)";
                rs = stmt.executeQuery(query1);
                while (rs.next()) {
                    String percent = rs.getString("percent");
                    System.out.println("\nPercentage of students that Passed: %" + percent);
                }
                query1 = "Select count(student.StudentId)*100/(\n" +
                        "Select count(student.StudentId) from student\n" +
                        "where student.StudentId in (\n" +
                        "\tselect note.AssignedStudent from note\n" +
                        "    where note.AssignedCourse = '"+course_id+"')) as percent from student\n" +
                        "where student.StudentId in (\n" +
                        "\tselect note.AssignedStudent from note\n" +
                        "    where note.AssignedCourse = '"+course_id+"'\n" +
                        "    and note.Final_Note<6)";
                rs = stmt.executeQuery(query1);
                while (rs.next()) {
                    String percent = rs.getString("percent");
                    System.out.println("\nPercentage of students that Failed: %" + percent);
                }

            }

        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getTimeline (String name, String lastname){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/high-school?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, "root","n8kiabelle");
            Statement stmt = connection.createStatement();
            String query1 = "select * from teacher\n" +
                    "where teacher.First_name = '"+name+"'\n" +
                    "and teacher.Last_name = '"+lastname+"'";
            ResultSet rs = stmt.executeQuery(query1);
            int teacher_id = 0;
            boolean exists = false;
            while (rs.next()){
                String teacher = rs.getString("Last_name") + " " + rs.getString("First_name");
                System.out.println("Teacher: " + teacher);
                teacher_id = rs.getInt("TeacherId");
                exists = true;
            }

            if (exists){
                query1 = "select s.Day_Name, s.StartTime, s.EndTime, c.Name from schedule as s, course as c\n" +
                        "where s.AssignedCourse in (\n" +
                        "select co.courseid from course as co\n" +
                        "where co.AssignedTeacher = '"+teacher_id+"'\n" +
                        ") and c.courseid in (\n" +
                        "select co.courseid from course as co\n" +
                        "where co.AssignedTeacher = '"+teacher_id+"'\n" +
                        ")";
                rs = stmt.executeQuery(query1);
                System.out.println("Schedule:");
                while (rs.next()){
                    String dayname = rs.getString("Day_Name");
                    String start = rs.getString("StartTime");
                    String end = rs.getString("EndTime");
                    String coursename = rs.getString("Name");
                    System.out.println("\t" + dayname + " " + start + " - " + end + " : " + coursename);
                }
            }

        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex){
            Logger.getLogger(HighSchoolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
