
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
   private NewsJframe newsJframe;
   private boolean internet;
   private Bookmark bookmark;
   private GraphJframe graph;
   
    public HomePage() {
        initComponents();
        dataFetch = new DataFetch();
        time();
        new Thread(){
            public void run(){
               btnGraph.setEnabled(false);
               try{
               dataFetch.refreshHistory();
               }catch(Exception e){System.out.println(e.getMessage());}
               dataFetch.fetchHistory();
               graph = new GraphJframe(dataFetch);
               btnGraph.setEnabled(true);
            }
        }.start();
            new Thread(){
            public void run(){
            btnNews.setEnabled(false);
            newsJframe = new NewsJframe();
            btnNews.setEnabled(true);    
            }
        }.start();
        bookmark = new Bookmark();
       try {
           new Thread(){
               public void run(){
                   btnDistrict.setEnabled(false);
                   try {
                       dataFetch.refreshDistrict();                       
                   } catch (Exception ex) {
                       System.out.println(ex.getMessage());
                   }
                   dataFetch.fetchDataDistrict();                                                      
                  btnDistrict.setEnabled(true);
               }
           }.start();
           dataFetch.refresh();
           lblLastRefreshed.setText(formatDateTime );
           lblLastUpdated.setText("Last Updated:");
           internet = true;
       } catch (Exception ex) {
           this.setVisible(true);
           internet = false;
        JOptionPane.showMessageDialog(this,"No Internet Connection\n"
                +"Connect to Internet to See Latest Data");
       }
       dataFetch.fetchData();
       displayIndiaData();
       this.setVisible(true);
       
       model = (DefaultTableModel)tblStateWise.getModel();
       showInTable();
       df = new DistrictJframe(dataFetch);
       
       
   }
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
          rowData[3] =   dataFetch.getStateWise().data.regional.get(i).discharged;
          rowData[4] =  dataFetch.getStateWise().data.regional.get(i).deaths;

          model.addRow(rowData);
       }
       tblStateWise.getColumnModel().getColumn(0).setPreferredWidth(100);
       tblStateWise.getColumnModel().getColumn(1).setPreferredWidth(3);
       tblStateWise.getColumnModel().getColumn(2).setPreferredWidth(3);
       tblStateWise.getColumnModel().getColumn(3).setPreferredWidth(3);
       tblStateWise.getColumnModel().getColumn(4).setPreferredWidth(3);
    }
    public void showLabels(){
lblState.setText((String)model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),0));
lblStateTC.setText(""+model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),1));
lblStateAC.setText(""+model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),2));
lblStateRC.setText(""+model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),3));
lblStateDC.setText(""+model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),4));
lblStateA.setText("Active");
lblStateT.setText("Total");
lblStateR.setText("Recovered");
lblStateD.setText("Deaths");

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
        btnAnakyser = new javax.swing.JButton();
        btnLinks = new javax.swing.JButton();
        btnNews = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        bntBookmark = new javax.swing.JButton();
        btnGraph = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStateWise = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDistrict = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblStateTC = new javax.swing.JLabel();
        lblStateAC = new javax.swing.JLabel();
        lblStateRC = new javax.swing.JLabel();
        lblStateDC = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblStateT = new javax.swing.JLabel();
        lblStateA = new javax.swing.JLabel();
        lblStateR = new javax.swing.JLabel();
        lblStateD = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblLastRefreshed = new javax.swing.JLabel();
        lblLastUpdated = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Track A Cov");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.setBackground(new java.awt.Color(33, 32, 54));
        lblHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblDate.setForeground(new java.awt.Color(220, 248, 252));
        lblDate.setText("Date/Time");
        lblHome.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 30));

        jPanel1.setBackground(new java.awt.Color(33, 32, 54));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(33, 32, 54));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(33, 32, 54));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ACTIVE");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(33, 32, 54));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RECOVERED");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(33, 32, 54));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DEATHS");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4);

        lblHome.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 370, 40));

        lblCountry.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(220, 248, 252));
        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountry.setText("INDIA");
        lblHome.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 180, 80));

        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 140));
        lblHome.getAccessibleContext().setAccessibleParent(lblHome);

        jPanel2.setBackground(new java.awt.Color(33, 32, 54));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        jPanel2.add(lblTotal);

        lblActive.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblActive.setForeground(new java.awt.Color(51, 51, 255));
        lblActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActive.setText("0");
        jPanel2.add(lblActive);

        lblRecovered.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblRecovered.setForeground(new java.awt.Color(0, 204, 51));
        lblRecovered.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecovered.setText("0");
        jPanel2.add(lblRecovered);

        lblDeaths.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setBackground(new java.awt.Color(0, 204, 204));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel3.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 104, -1));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnAnakyser.setText("Covid Analyzer");
        jPanel4.add(btnAnakyser);

        btnLinks.setText("Important Links");
        btnLinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinksActionPerformed(evt);
            }
        });
        jPanel4.add(btnLinks);

        btnNews.setText("News");
        btnNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewsActionPerformed(evt);
            }
        });
        jPanel4.add(btnNews);

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 219, 370, 40));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jButton2.setText("Helpline ");
        jPanel8.add(jButton2);

        bntBookmark.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bntBookmark.setText("Bookmarked News");
        bntBookmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBookmarkActionPerformed(evt);
            }
        });
        jPanel8.add(bntBookmark);

        btnGraph.setText("Graphs");
        btnGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphActionPerformed(evt);
            }
        });
        jPanel8.add(btnGraph);

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 370, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 370, 270));

        jPanel5.setBackground(new java.awt.Color(33, 32, 54));
        jPanel5.setForeground(new java.awt.Color(33, 32, 54));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStateWise.setAutoCreateRowSorter(true);
        tblStateWise.setBackground(new java.awt.Color(33, 32, 54));
        tblStateWise.setForeground(new java.awt.Color(220, 248, 252));
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
        tblStateWise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblStateWiseKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStateWiseKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblStateWise);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 530, 230));

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
        jPanel5.add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 220, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 248, 252));
        jLabel5.setText("Search");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 60, 20));

        btnDistrict.setText("District");
        btnDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistrictActionPerformed(evt);
            }
        });
        jPanel5.add(btnDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jPanel6.setBackground(new java.awt.Color(33, 32, 54));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        lblStateTC.setForeground(new java.awt.Color(255, 0, 51));
        lblStateTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateTC.setText(" ");
        jPanel6.add(lblStateTC);

        lblStateAC.setForeground(new java.awt.Color(51, 153, 255));
        lblStateAC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateAC.setText(" ");
        jPanel6.add(lblStateAC);

        lblStateRC.setForeground(new java.awt.Color(51, 255, 51));
        lblStateRC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateRC.setText(" ");
        jPanel6.add(lblStateRC);

        lblStateDC.setForeground(new java.awt.Color(153, 153, 153));
        lblStateDC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateDC.setText(" ");
        jPanel6.add(lblStateDC);

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 350, 30));

        jPanel7.setBackground(new java.awt.Color(33, 32, 54));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        lblStateT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStateT.setForeground(new java.awt.Color(255, 0, 51));
        lblStateT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateT.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(lblStateT);

        lblStateA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStateA.setForeground(new java.awt.Color(51, 153, 255));
        lblStateA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateA.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(lblStateA);

        lblStateR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStateR.setForeground(new java.awt.Color(51, 255, 51));
        lblStateR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(lblStateR);

        lblStateD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStateD.setForeground(new java.awt.Color(153, 153, 153));
        lblStateD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateD.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(lblStateD);

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 350, 30));

        lblState.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblState.setForeground(new java.awt.Color(220, 248, 252));
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState.setText(" ");
        jPanel5.add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 310, 40));

        lblLastRefreshed.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLastRefreshed.setForeground(new java.awt.Color(220, 248, 252));
        jPanel5.add(lblLastRefreshed, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 140, 30));
        lblLastRefreshed.getAccessibleContext().setAccessibleParent(jPanel5);

        lblLastUpdated.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLastUpdated.setForeground(new java.awt.Color(220, 248, 252));
        jPanel5.add(lblLastUpdated, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 90, 30));
        lblLastUpdated.getAccessibleContext().setAccessibleParent(jPanel5);

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 530, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
      try {
            new Thread(){
               public void run(){
                   btnDistrict.setEnabled(false);
                   try {
                    dataFetch.refreshDistrict();
                    dataFetch.fetchDataDistrict();
                   } catch (Exception ex) {
                       System.out.println(ex.getMessage());
                   }
                  btnDistrict.setEnabled(true);
               }
           }.start();
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
        showLabels();
    }//GEN-LAST:event_tblStateWiseMouseClicked

    private void btnDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistrictActionPerformed
     if(df.getRepeate()){}
     else if(tblStateWise.getSelectedRow()!=-1){
        df.setState((String)model.getValueAt(tblStateWise.convertRowIndexToModel(tblStateWise.getSelectedRow()),0));
        df.showInTable();
        df.setVisible(true);    
        
        }
    else
    {
        JOptionPane.showMessageDialog(this, "Please Select a row");
    }
        
    }//GEN-LAST:event_btnDistrictActionPerformed

    private void tblStateWiseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStateWiseKeyPressed
        showLabels();
    }//GEN-LAST:event_tblStateWiseKeyPressed

    private void tblStateWiseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStateWiseKeyReleased
     showLabels();        // TODO add your handling code here:
    }//GEN-LAST:event_tblStateWiseKeyReleased

    private void btnNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewsActionPerformed
     if(internet){
        if(!newsJframe.getRepeate()){
         newsJframe.setVisible(true);
     }}
     else
         JOptionPane.showMessageDialog(this,"No Internet Connection");
    }//GEN-LAST:event_btnNewsActionPerformed

    private void bntBookmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBookmarkActionPerformed
    bookmark.setVisible(true);
        if(!bookmark.getRepeate()) {
    bookmark.showInTable();
   }
   
    }//GEN-LAST:event_bntBookmarkActionPerformed

    private void btnGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphActionPerformed
        graph.setVisible(true);
    }//GEN-LAST:event_btnGraphActionPerformed

    private void btnLinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinksActionPerformed
       LinksJframe lf = new LinksJframe();
       lf.setVisible(true);
    }//GEN-LAST:event_btnLinksActionPerformed
        

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBookmark;
    private javax.swing.JButton btnAnakyser;
    private javax.swing.JButton btnDistrict;
    private javax.swing.JButton btnGraph;
    private javax.swing.JButton btnLinks;
    private javax.swing.JButton btnNews;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeaths;
    private javax.swing.JPanel lblHome;
    private javax.swing.JLabel lblLastRefreshed;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblRecovered;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStateA;
    private javax.swing.JLabel lblStateAC;
    private javax.swing.JLabel lblStateD;
    private javax.swing.JLabel lblStateDC;
    private javax.swing.JLabel lblStateR;
    private javax.swing.JLabel lblStateRC;
    private javax.swing.JLabel lblStateT;
    private javax.swing.JLabel lblStateTC;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblStateWise;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables


}
