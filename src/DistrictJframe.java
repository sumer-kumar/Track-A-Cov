
//import DataFetch.DataFetch;
//import DataFetch.DistrictWise;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class DistrictJframe extends javax.swing.JFrame {
   private DefaultTableModel model;
   private DataFetch dataFetch;
   private String state;
   private boolean repeate;
   private int position;
    public DistrictJframe(DataFetch dataFetch) {
        initComponents();
        this.dataFetch = dataFetch;
        model = (DefaultTableModel)tblDistrict.getModel();
        
    }
    public void setState(String state){
        this.state = state;
    }
    public boolean getRepeate(){
        return this.repeate;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDistrict = new javax.swing.JTable();
        lblState = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        lblRecovered = new javax.swing.JLabel();
        lblDeaths = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTotalCount = new javax.swing.JLabel();
        lblActiveCount = new javax.swing.JLabel();
        lblRecoveredCount = new javax.swing.JLabel();
        lblDeathsCount = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("District");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(33, 32, 54));
        jPanel1.setToolTipText("District Wise");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(33, 32, 54));

        tblDistrict.setAutoCreateRowSorter(true);
        tblDistrict.setBackground(new java.awt.Color(33, 32, 54));
        tblDistrict.setForeground(new java.awt.Color(220, 248, 252));
        tblDistrict.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "District", "Total", "Active", "Recovered", "Deaths"
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
        tblDistrict.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDistrictMouseClicked(evt);
            }
        });
        tblDistrict.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDistrictKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                none(evt);
            }
        });
        jScrollPane1.setViewportView(tblDistrict);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 590, 220));

        lblState.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblState.setForeground(new java.awt.Color(220, 248, 252));
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 580, 40));

        jPanel2.setBackground(new java.awt.Color(33, 32, 54));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblTotal);

        lblActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblActive.setForeground(new java.awt.Color(0, 153, 255));
        lblActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblActive);

        lblRecovered.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRecovered.setForeground(new java.awt.Color(0, 153, 0));
        lblRecovered.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblRecovered);

        lblDeaths.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDeaths.setForeground(new java.awt.Color(153, 153, 153));
        lblDeaths.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblDeaths);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 590, 30));

        jPanel3.setBackground(new java.awt.Color(33, 32, 54));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        lblTotalCount.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblTotalCount.setForeground(new java.awt.Color(204, 0, 0));
        lblTotalCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblTotalCount);

        lblActiveCount.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblActiveCount.setForeground(new java.awt.Color(0, 153, 255));
        lblActiveCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblActiveCount);

        lblRecoveredCount.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblRecoveredCount.setForeground(new java.awt.Color(0, 153, 0));
        lblRecoveredCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblRecoveredCount);

        lblDeathsCount.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblDeathsCount.setForeground(new java.awt.Color(153, 153, 153));
        lblDeathsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblDeathsCount);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 590, 30));

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });
        jPanel1.add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            repeate = true;        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          repeate = false;    
          model.setRowCount(0);
           lblTotal.setText("");
   lblRecovered.setText("");
   lblActive.setText("");
   lblDeaths.setText("");
   lblState.setText("");
   lblTotalCount.setText("");
   lblActiveCount.setText("");
   lblRecoveredCount.setText("");
  lblDeathsCount.setText("");
          
    }//GEN-LAST:event_formWindowClosing

    private void tblDistrictMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDistrictMouseClicked
        showLabels();        // TODO add your handling code here:
    }//GEN-LAST:event_tblDistrictMouseClicked

    private void none(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_none
       showLabels(); // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void tblDistrictKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDistrictKeyPressed
showLabels();        // TODO add your handling code here:
    }//GEN-LAST:event_tblDistrictKeyPressed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
       String search = tfSearch.getText().toUpperCase();
        TableRowSorter<DefaultTableModel> ts = new TableRowSorter<DefaultTableModel>(model);
        tblDistrict.setRowSorter(ts);
        ts.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tfSearchKeyReleased
  public void showInTable(){
      this.setTitle(state);
   Object [] rowData = new Object[5];
   DistrictWise [] dw = dataFetch.getDistrictWiseObj();
  for(position=0;position<dw.length;position++ ){
      if(this.state.equalsIgnoreCase(dw[position].getState()))
          break;
  }
  
  for(int j=0;j<dw[position].getDistrictData().size();j++){
     rowData[0]= dw[position].getDistrictData().get(j).getDistrict().toUpperCase();
     rowData[1]= dw[position].getDistrictData().get(j).getConfirmed();
     rowData[2]= dw[position].getDistrictData().get(j).getActive();
     rowData[3]= dw[position].getDistrictData().get(j).getRecovered();
     rowData[4]= dw[position].getDistrictData().get(j).getDeceased();
     model.addRow(rowData);
  }
   }
  public void showLabels(){
   lblTotal.setText("Total");
   lblRecovered.setText("Recovered");
   lblActive.setText("Active");
   lblDeaths.setText("Deaths");
   lblState.setText((String)tblDistrict.getValueAt(tblDistrict.getSelectedRow(),0));
   lblTotalCount.setText(""+tblDistrict.getValueAt(tblDistrict.getSelectedRow(),1));
   lblActiveCount.setText(""+tblDistrict.getValueAt(tblDistrict.getSelectedRow(),2));
   lblRecoveredCount.setText(""+tblDistrict.getValueAt(tblDistrict.getSelectedRow(),3));
  lblDeathsCount.setText(""+tblDistrict.getValueAt(tblDistrict.getSelectedRow(),4));
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblActiveCount;
    private javax.swing.JLabel lblDeaths;
    private javax.swing.JLabel lblDeathsCount;
    private javax.swing.JLabel lblRecovered;
    private javax.swing.JLabel lblRecoveredCount;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalCount;
    private javax.swing.JTable tblDistrict;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
