
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class HelplineJframe extends javax.swing.JFrame {
    private DataFetch dataFetch;
    private DefaultTableModel modelContacts;
    private DefaultTableModel modelAdvisories;
    private String currUrl;
    public HelplineJframe(DataFetch dataFetch) {
        initComponents();
        this.dataFetch = dataFetch;
        pnlHome.grabFocus();
        modelContacts = (DefaultTableModel)tblContacts.getModel();
        modelAdvisories = (DefaultTableModel)tblAdvisories.getModel();
        showInTableContacts();
        showInTableAdvisories();
        showLabels();
    }
    public void showLabels(){
lblEmail.setText(dataFetch.getContactDetails().getData().getContacts().getPrimary().getEmail());
lblNumber.setText(dataFetch.getContactDetails().getData().getContacts().getPrimary().getNumber());
lblTollFreeNumber.setText(dataFetch.getContactDetails().getData().getContacts().getPrimary().getNumberTollfree());
    }
    public void showInTableContacts(){
        Object [] rowData = new Object[2];
   for(int i=0;
      i<dataFetch.getContactDetails().getData().getContacts().getRegional().size();
      i++)
{ 
rowData[0] = dataFetch.getContactDetails().getData().getContacts().getRegional().get(i).getLoc();
rowData[1] = dataFetch.getContactDetails().getData().getContacts().getRegional().get(i).getNumber();
      modelContacts.addRow(rowData);
}
    }
    public void showInTableAdvisories(){
        Object [] rowData = new Object[1];
   for(int i=0;
      i<dataFetch.getAdvisories().getData().getNotifications().size();
      i++)
{ 
      rowData[0] = dataFetch.getAdvisories().getData().getNotifications().get(i).getTitle();
      modelAdvisories.addRow(rowData);
}
    }
    public void openBrowser(String url){
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI(url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdvisories = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblContacts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFacebook = new javax.swing.JButton();
        btnTwitter = new javax.swing.JButton();
        btnMedia = new javax.swing.JButton();
        lblNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taAdvisories = new javax.swing.JTextArea();
        btnOpenBrowser = new javax.swing.JButton();
        lblTollFreeNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Helpline");
        setResizable(false);

        pnlHome.setBackground(new java.awt.Color(33, 32, 54));
        pnlHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAdvisories.setBackground(new java.awt.Color(33, 32, 54));
        tblAdvisories.setForeground(new java.awt.Color(220, 248, 252));
        tblAdvisories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Notifications or Advisories"
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
        tblAdvisories.getTableHeader().setReorderingAllowed(false);
        tblAdvisories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAdvisoriesMousePressed(evt);
            }
        });
        tblAdvisories.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAdvisoriesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdvisories);

        pnlHome.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 383, 173));

        tblContacts.setBackground(new java.awt.Color(33, 32, 54));
        tblContacts.setForeground(new java.awt.Color(220, 248, 252));
        tblContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Region", "Phone number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContacts.getTableHeader().setReorderingAllowed(false);
        tblContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblContactsMousePressed(evt);
            }
        });
        tblContacts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblContactsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblContacts);

        pnlHome.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 370, 173));

        jLabel1.setForeground(new java.awt.Color(220, 248, 252));
        jLabel1.setText("Email");
        pnlHome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(220, 248, 252));
        jLabel2.setText("Toll Free Number:");
        pnlHome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(220, 248, 252));
        jLabel3.setText("Number");
        pnlHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        btnFacebook.setText("Facebook");
        btnFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacebookActionPerformed(evt);
            }
        });
        pnlHome.add(btnFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        btnTwitter.setText("Twitter");
        btnTwitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwitterActionPerformed(evt);
            }
        });
        pnlHome.add(btnTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));

        btnMedia.setText("Media");
        btnMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediaActionPerformed(evt);
            }
        });
        pnlHome.add(btnMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, -1));

        lblNumber.setForeground(new java.awt.Color(220, 248, 252));
        lblNumber.setText(" ");
        pnlHome.add(lblNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 210, -1));

        lblEmail.setForeground(new java.awt.Color(220, 248, 252));
        lblEmail.setText(" ");
        pnlHome.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, -1));

        taAdvisories.setEditable(false);
        taAdvisories.setBackground(new java.awt.Color(33, 32, 54));
        taAdvisories.setColumns(20);
        taAdvisories.setForeground(new java.awt.Color(220, 248, 252));
        taAdvisories.setLineWrap(true);
        taAdvisories.setRows(5);
        taAdvisories.setToolTipText("Full Text for Advisories or Notification");
        jScrollPane3.setViewportView(taAdvisories);

        pnlHome.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 380, -1));

        btnOpenBrowser.setText("Open Link in Browser");
        btnOpenBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenBrowserActionPerformed(evt);
            }
        });
        pnlHome.add(btnOpenBrowser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 160, 40));

        lblTollFreeNumber.setForeground(new java.awt.Color(220, 248, 252));
        lblTollFreeNumber.setText(" ");
        pnlHome.add(lblTollFreeNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 150, -1));

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

    private void tblAdvisoriesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdvisoriesMousePressed
        tblContacts.clearSelection();
        currUrl = dataFetch.getAdvisories().getData().getNotifications().get(tblAdvisories.getSelectedRow()).getLink();
        taAdvisories.setText(dataFetch.getAdvisories().getData().getNotifications().get(tblAdvisories.getSelectedRow()).getTitle());
    }//GEN-LAST:event_tblAdvisoriesMousePressed

    private void tblAdvisoriesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAdvisoriesKeyPressed
        tblContacts.clearSelection();
        currUrl = dataFetch.getAdvisories().getData().getNotifications().get(tblAdvisories.getSelectedRow()).getLink();
        taAdvisories.setText(dataFetch.getAdvisories().getData().getNotifications().get(tblAdvisories.getSelectedRow()).getTitle());
    }//GEN-LAST:event_tblAdvisoriesKeyPressed

    private void btnOpenBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenBrowserActionPerformed
        if(tblAdvisories.getSelectedRow()!=-1){openBrowser(currUrl);}
        else JOptionPane.showMessageDialog(this,"Select a row from Advisories or Notification");
    }//GEN-LAST:event_btnOpenBrowserActionPerformed

    private void btnFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacebookActionPerformed
        openBrowser(dataFetch.getContactDetails().getData().getContacts().getPrimary().getFacebook());
    }//GEN-LAST:event_btnFacebookActionPerformed

    private void btnTwitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwitterActionPerformed
        openBrowser(dataFetch.getContactDetails().getData().getContacts().getPrimary().getTwitter());        // TODO add your handling code here:
    }//GEN-LAST:event_btnTwitterActionPerformed

    private void btnMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediaActionPerformed
        openBrowser(dataFetch.getContactDetails().getData().getContacts().getPrimary().getMedia().get(0));
    }//GEN-LAST:event_btnMediaActionPerformed

    private void tblContactsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactsMousePressed
        tblAdvisories.clearSelection();
    }//GEN-LAST:event_tblContactsMousePressed

    private void tblContactsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblContactsKeyPressed
       tblAdvisories.clearSelection();
    }//GEN-LAST:event_tblContactsKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFacebook;
    private javax.swing.JButton btnMedia;
    private javax.swing.JButton btnOpenBrowser;
    private javax.swing.JButton btnTwitter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblTollFreeNumber;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JTextArea taAdvisories;
    private javax.swing.JTable tblAdvisories;
    private javax.swing.JTable tblContacts;
    // End of variables declaration//GEN-END:variables
}
