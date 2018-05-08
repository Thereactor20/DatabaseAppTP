/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapp1.dao.imp;

import crudapp1.dao.CourseDAO;
import crudapp1.dbUtil.dbConnection;
import crudapp1.entity.Courses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krijan
 */
public class CourseDAOimp implements CourseDAO{
    private dbConnection db = new dbConnection();
    
    @Override
    public int insert(Courses course) throws ClassNotFoundException, SQLException {
        String sql="INSERT into courses(name,fees,status)"
                + " values(?,?,?)";
        db.connect();
        PreparedStatement stmt = db.iniStatement(sql);
        stmt.setString(1,course.getName());
        stmt.setInt(2, course.getFees());
        stmt.setBoolean(3, course.isStatus());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Courses course) throws ClassNotFoundException, SQLException {
        String sql="UPDATE courses SET name=?,fees=?,status=? where id=?";
        db.connect();
        PreparedStatement stmt = db.iniStatement(sql);
        stmt.setString(1,course.getName());
        stmt.setInt(2, course.getFees());
        stmt.setBoolean(3, course.isStatus());
        stmt.setInt(4, course.getId());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql="DELETE from courses where id =?";
        db.connect();
        PreparedStatement stmt = db.iniStatement(sql);
        stmt.setInt(1,id);
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public Courses getById(int id) throws ClassNotFoundException, SQLException {
        Courses course = null;
        String sql="SELECT *from courses where id=?";
        db.connect();
        PreparedStatement stmt = db.iniStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if(rs.next()){
            course= new Courses();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("name"));
            course.setFees(rs.getInt("fees"));
            course.setAddedDate(rs.getDate("AddedDate"));
            course.setStatus(rs.getBoolean("status"));
        }
        db.close();
        return course;
    }

    @Override
    public List<Courses> getAll() throws ClassNotFoundException, SQLException {
        List<Courses> courseList = new ArrayList<>();
        String sql="SELECT *from courses";
        db.connect();
        db.iniStatement(sql);
        ResultSet rs = db.executeQuery();
        while(rs.next()){
            Courses course= new Courses();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("name"));
            course.setFees(rs.getInt("fees"));
            course.setAddedDate(rs.getDate("added_date"));
            course.setStatus(rs.getBoolean("status"));
            courseList.add(course);
        }
        db.close();
        return courseList;
    }
    
}
