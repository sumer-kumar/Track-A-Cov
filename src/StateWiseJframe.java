
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class StateWiseJframe extends javax.swing.JFrame {
    private DataFetch dataFetch;
    private DefaultTableModel model;
    //*******************Constructor
    public StateWiseJframe(DataFetch dataFetch) {
        initComponents();
        this.dataFetch = dataFetch;
        model = (DefaultTableModel)tblStateWise.getModel();
        showInTable();
    }
    
    //******************************
    public void showInTable(){
       Object[] rowData = new Object[6];
       
       for(int i=0;i<dataFetch.getStateWise().data.regional.size();i++){
         rowData[0]=i+1;
          rowData[1] = dataFetch.getStateWise().data.regional.get(i).loc;
          rowData[2] = dataFetch.getStateWise().data.regional.get(i).confirmedCasesIndian;
          
          rowData[3]=    (dataFetch.getStateWise().data.regional.get(i).confirmedCasesIndian
                         -dataFetch.getStateWise().data.regional.get(i).discharged
                         -dataFetch.getStateWise().data.regional.get(i).deaths);
          rowData[4] =  + dataFetch.getStateWise().data.regional.get(i).discharged;
          rowData[5] =  +dataFetch.getStateWise().data.regional.get(i).deaths;

          model.addRow(rowData);
       }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStateWise = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("State Wise");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStateWise.setAutoCreateRowSorter(true);
        tblStateWise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.no.", "Region", "Total Cases", "Active Cases", "Recovered", "Deaths Cases"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStateWise.setRowSorter(null);
        jScrollPane1.setViewportView(tblStateWise);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 720, 260));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String search = jTextField1.getText().toLowerCase();
        
    }//GEN-LAST:event_jTextField1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblStateWise;
    // End of variables declaration//GEN-END:variables
}
