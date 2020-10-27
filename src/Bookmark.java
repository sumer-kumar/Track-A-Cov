
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class Bookmark extends javax.swing.JFrame {
    private boolean repeate;
    private DefaultTableModel model;
    private List <File>list;
    private File dir;
    public Bookmark() {
        repeate = false;
        initComponents();
        dir = new File("news");
        pnlHome.grabFocus();
        model = (DefaultTableModel)tblList.getModel();
//        showInTable();
        
    }
    public boolean getRepeate(){return this.repeate;}
    
    public void showInTable(){
        dir.mkdir();
        list = new LinkedList<File>();
        for(int i=0;i<dir.listFiles().length;i++){list.add(dir.listFiles()[i]);}
        Object [] rowData = new Object [1];
        for(int i=0;i<list.size();i++){
            rowData[0] = list.get(i).getName().replaceAll(".txt","");
            model.addRow(rowData);
        }
    }
    public void seeNews(){
        if(tblList.getSelectedRow()!=-1){
            try {
        BufferedReader bw = new BufferedReader(
                  new FileReader(
                        new File(dir,tblList.getValueAt(tblList.getSelectedRow(), 0).toString()+".txt")));
        String s = "";
        String line;
        while((line = bw.readLine())!=null)
        {
            s+=line;
        }
        bw.close();
        Gson gson = new Gson();
        Saved saved = gson.fromJson(s, Saved.class);
        new NewsJframe(saved).setVisible(true);
            } catch (Exception ex) {
                ex.getStackTrace();
                
            }
        }
        else{JOptionPane.showMessageDialog(this,"Select a row");
        }
    }
    public void deleteNews(){
        if(
           tblList.getSelectedRow()!=-1){
            try {  
                   int i = tblList.getSelectedRow();
                   list.get(i).delete();
                   list.remove(i);
                   model.removeRow(i);                   
            } catch (Exception ex) {
                ex.getStackTrace();
                System.out.println(ex.getMessage());
            }
        }
        else{JOptionPane.showMessageDialog(this,"Select a row");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        btnSee = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bookmarked News");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setToolTipText("");

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblList);

        btnSee.setText("See");
        btnSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnSee, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnDelete)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHomeLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSee)
                    .addComponent(btnDelete))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeActionPerformed
       seeNews();
    }//GEN-LAST:event_btnSeeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      deleteNews();  
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       model.setRowCount(0);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSee;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables
}
