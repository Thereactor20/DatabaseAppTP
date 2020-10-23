/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapp1.UI;

import crudapp1.dao.CourseDAO;
import crudapp1.dao.imp.CourseDAOimp;
import crudapp1.entity.Courses;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author krijan
 */
public class CourseUI extends javax.swing.JFrame {

    private CourseDAO courseDAO = new CourseDAOimp();
    private Courses course = new Courses();

    public CourseUI() {
        initComponents();
        initTable();
    }

    public void initTable() {
        try {
            String[] columns = {"Id", "Name", "Fees", "Added Date", "Status"};
            tblCourse.setModel(new CourseTableModel(courseDAO.getAll(), columns));
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jScrollPane1.setViewportView(tblCourse);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crudapp1/resources/add.png"))); // NOI18N
        addBtn.setText("Add Course");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonClick(evt);
            }
        });

        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crudapp1/resources/remove.png"))); // NOI18N
        removeBtn.setText(" Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveBtnClick(evt);
            }
        });

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crudapp1/resources/edit.png"))); // NOI18N
        editBtn.setText(" Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnClick(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editBtn)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCourseButtonClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonClick
        AddCourseUI addCourseUI = new AddCourseUI(this, true);
        addCourseUI.setVisible(true);
    }//GEN-LAST:event_addCourseButtonClick

    private void RemoveBtnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveBtnClick
        int row = tblCourse.getSelectedRow();
        if (row != -1) {
            int id = (int) tblCourse.getValueAt(row, 0);

            try {
                int result = JOptionPane.showConfirmDialog(null, "Are you really want to delete!!", "Delete confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    courseDAO.delete(id);
                    initTable();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select row!");
        }
    }//GEN-LAST:event_RemoveBtnClick

    private void editBtnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnClick

        int row = tblCourse.getSelectedRow();
        if (row != -1) {
            int cols = tblCourse.getColumnCount();
        //  Object[] values = new Object[ cols ];
     for ( int col = 0; col < cols; col++ ) {
               //values[ col ] = model.getValueAt( row, col );
         System.out.println("Values "+col+" = "+tblCourse.getValueAt( row, col ));
         }
            
            EditCourseUI editCourseUI = new EditCourseUI(this, true);
            editCourseUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please select row!");
        }

    }//GEN-LAST:event_editBtnClick

    public class CourseTableModel extends AbstractTableModel {

        private List<Courses> courseList;
        private String[] columns;

        public CourseTableModel(List<Courses> courseList, String[] columns) {
            this.courseList = courseList;
            this.columns = columns;
        }

        @Override
        public int getRowCount() {
            return courseList.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Courses course = courseList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return course.getId();
                case 1:
                    return course.getName();
                case 2:
                    return course.getFees();
                case 3:
                    return course.getAddedDate();
                case 4:
                    return course.isStatus();
            }
            return null;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton addBtn;
    javax.swing.JButton editBtn;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JButton removeBtn;
    javax.swing.JTable tblCourse;
    // End of variables declaration//GEN-END:variables
}
