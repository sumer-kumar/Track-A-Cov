
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class HomePage extends javax.swing.JFrame {
   private DataFetch dataFetch;
   private LocalDateTime dateTime;
   private String formatDateTime; 
   private DistrictJframe df;
   private DefaultTableModel model;

   public HomePage() {
        initComponents();
        dataFetch = new DataFetch();
        time();
       try {
           dataFetch.refresh();
           lblLastRefreshed.setText(formatDateTime );
           lblLastUpdated.setText("Last Updated:");
        
       } catch (Exception ex) {
           this.setVisible(true);
        JOptionPane.showMessageDialog(this,"No Internet Connection\n"
                +"Connect to Internet to See Latest Data");
        System.out.println("ünsuccessful");
       }
       dataFetch.fetchData();
       displayIndiaData();
       this.setVisible(true);
       
       model = (DefaultTableModel)tblStateWise.getModel();
       showInTable();
       df = new DistrictJframe(dataFetch);
    }
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHome = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        lblRecovered = new javax.swing.JLabel();
        lblDeaths = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblLastUpdated = new javax.swing.JLabel();
        lblLastRefreshed = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStateWise = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDistrict = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Track A Cov");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.setBackground(new java.awt.Color(33, 32, 54));
        lblHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setForeground(new java.awt.Color(220, 248, 252));
        lblDate.setText("Date/Time");
        lblHome.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 30));

        jPanel1.setBackground(new java.awt.Color(33, 32, 54));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(33, 32, 54));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL");
        jPanel1.add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(33, 32, 54));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ACTIVE");
        jPanel1.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(33, 32, 54));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RECOVERED");
        jPanel1.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(33, 32, 54));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DEATHS");
        jPanel1.add(jLabel4);

        lblHome.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 360, 70));

        lblCountry.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(220, 248, 252));
        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountry.setText("INDIA");
        lblHome.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 150, 50));

        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 140));
        lblHome.getAccessibleContext().setAccessibleParent(lblHome);

        jPanel2.setBackground(new java.awt.Color(33, 32, 54));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        jPanel2.add(lblTotal);

        lblActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblActive.setForeground(new java.awt.Color(51, 51, 255));
        lblActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActive.setText("0");
        jPanel2.add(lblActive);

        lblRecovered.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRecovered.setForeground(new java.awt.Color(0, 204, 51));
        lblRecovered.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecovered.setText("0");
        jPanel2.add(lblRecovered);

        lblDeaths.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDeaths.setForeground(new java.awt.Color(153, 153, 153));
        lblDeaths.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeaths.setText("0");
        jPanel2.add(lblDeaths);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 131, 370, 50));

        jPanel3.setBackground(new java.awt.Color(33, 32, 54));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 204, 204));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setText("Covid Analyzer");
        jPanel4.add(jButton3);

        jButton1.setText("Important Links");
        jPanel4.add(jButton1);

        jButton4.setText("News");
        jPanel4.add(jButton4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 370, 270));

        jPanel5.setBackground(new java.awt.Color(33, 32, 54));
        jPanel5.setForeground(new java.awt.Color(33, 32, 54));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLastUpdated.setForeground(new java.awt.Color(220, 248, 252));
        jPanel5.add(lblLastUpdated, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 90, 30));
        lblLastUpdated.getAccessibleContext().setAccessibleParent(jPanel5);

        lblLastRefreshed.setForeground(new java.awt.Color(220, 248, 252));
        jPanel5.add(lblLastRefreshed, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 140, 30));
        lblLastRefreshed.getAccessibleContext().setAccessibleParent(jPanel5);

        tblStateWise.setAutoCreateRowSorter(true);
        tblStateWise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Region", "Total ", "Active", "Recovered", "Deaths"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStateWise.getTableHeader().setReorderingAllowed(false);
        tblStateWise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStateWiseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStateWise);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 530, 350));

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });
        jPanel5.add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 220, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 248, 252));
        jLabel5.setText("Search");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 60, 20));

        btnDistrict.setText("District");
        btnDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistrictActionPerformed(evt);
            }
        });
        jPanel5.add(btnDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 530, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
           dataFetch.refresh();
            lblLastRefreshed.setText(formatDateTime );
            lblLastUpdated.setText("Last Updated:");
       } catch (Exception ex) {
           this.setVisible(true);
        JOptionPane.showMessageDialog(this,"No Internet Connection\n"
                +"Connect to Internet to See Latest Data");
       }
        
       dataFetch.fetchData();
       displayIndiaData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
            jPanel3.grabFocus();
            tblStateWise.clearSelection();
              
    }//GEN-LAST:event_jPanel3MouseClicked

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        String search = tfSearch.getText().toUpperCase();
        TableRowSorter<DefaultTableModel> ts = new TableRowSorter<DefaultTableModel>(model);
        tblStateWise.setRowSorter(ts);
        ts.setRowFilter(RowFilter.regexFilter(search));
        
    }//GEN-LAST:event_tfSearchKeyReleased

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        tblStateWise.clearSelection();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void tblStateWiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStateWiseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStateWiseMouseClicked

    private void btnDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistrictActionPerformed
    
        df.setState((String)model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),0));
        df.setVisible(true);    
        df.showInTable();
        
    }//GEN-LAST:event_btnDistrictActionPerformed
        
    public void time(){
        
        Thread t = new Thread(){
            public void run(){
                String am_pm;
               int hr ;
                while(true)
                { 
                    dateTime = LocalDateTime.now(); 
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");  
                    formatDateTime = dateTime.format(format);
                    lblDate.setText(formatDateTime);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                } 
            }
        };
        t.start();
    }
    public void displayIndiaData(){
        lblTotal.setText(""+dataFetch.getStateWise().data.summary.total);
        
        lblActive.setText(""+(dataFetch.getStateWise().data.summary.total-dataFetch.getStateWise().data.summary.deaths
                -dataFetch.getStateWise().data.summary.discharged));
        
        lblRecovered.setText(""+dataFetch.getStateWise().data.summary.discharged);
        
        lblDeaths.setText(""+dataFetch.getStateWise().data.summary.deaths);
        
        }
     public void showInTable(){
       Object[] rowData = new Object[6];
       
       for(int i=0;i<dataFetch.getStateWise().data.regional.size();i++){
          rowData[0] = dataFetch.getStateWise().data.regional.get(i).loc.toUpperCase();
          rowData[1] = dataFetch.getStateWise().data.regional.get(i).confirmedCasesIndian;
          
          rowData[2]=    (dataFetch.getStateWise().data.regional.get(i).confirmedCasesIndian
                         -dataFetch.getStateWise().data.regional.get(i).discharged
                         -dataFetch.getStateWise().data.regional.get(i).deaths);
          rowData[3] =  + dataFetch.getStateWise().data.regional.get(i).discharged;
          rowData[4] =  +dataFetch.getStateWise().data.regional.get(i).deaths;

          model.addRow(rowData);
       }
       tblStateWise.getColumnModel().getColumn(0).setPreferredWidth(100);
       tblStateWise.getColumnModel().getColumn(1).setPreferredWidth(3);
       tblStateWise.getColumnModel().getColumn(2).setPreferredWidth(3);
       tblStateWise.getColumnModel().getColumn(3).setPreferredWidth(3);
       tblStateWise.getColumnModel().getColumn(4).setPreferredWidth(3);
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistrict;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeaths;
    private javax.swing.JPanel lblHome;
    private javax.swing.JLabel lblLastRefreshed;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblRecovered;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblStateWise;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables


}
