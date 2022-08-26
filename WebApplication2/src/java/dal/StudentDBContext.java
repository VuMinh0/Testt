/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Student;

/**
 *
 * @author dttnb
 */
public class StudentDBContext extends DBContext{
    public ArrayList<Student> getStudents(String name) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select * from student where name like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getBoolean("gender"));
                s.setDob(rs.getDate("dob"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public static void main(String[] args) {
        StudentDBContext stu = new StudentDBContext();
        ArrayList<Student> list = stu.getStudents("in");
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
