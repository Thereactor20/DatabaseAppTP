/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapp1.dao;

import crudapp1.entity.Courses;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author krijan
 */
public interface CourseDAO {
    
    int insert(Courses course)throws ClassNotFoundException,SQLException;
    int update(Courses course)throws ClassNotFoundException,SQLException;
    int delete(int id)throws ClassNotFoundException,SQLException;
    Courses getById(int id) throws ClassNotFoundException,SQLException;
    List<Courses> getAll() throws ClassNotFoundException,SQLException;
    
}
