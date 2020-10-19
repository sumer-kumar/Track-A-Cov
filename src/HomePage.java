
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


public class HomePage extends javax.swing.JFrame {
   private DataFetch dataFetch;
   private LocalDateTime dateTime;
   private String formatDateTime; 
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
        lblLastRefreshed = new javax.swing.JLabel();
        lblLastUpdated = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        lblRecovered = new javax.swing.JLabel();
        lblDeaths = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL");
        jPanel1.add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(33, 32, 54));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ACTIVE");
        jPanel1.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(33, 32, 54));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RECOVERED");
        jPanel1.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(33, 32, 54));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DEATHS");
        jPanel1.add(jLabel4);

        lblHome.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 730, 70));

        lblCountry.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(220, 248, 252));
        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountry.setText("INDIA");
        lblHome.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 150, 50));

        lblLastRefreshed.setForeground(new java.awt.Color(220, 248, 252));
        lblHome.add(lblLastRefreshed, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 140, 30));

        lblLastUpdated.setForeground(new java.awt.Color(220, 248, 252));
        lblHome.add(lblLastUpdated, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 90, 30));

        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 140));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 131, 730, 50));

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

        jPanel4.setLayout(new java.awt.GridLayout());

        jButton2.setText("State Wise ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

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
                .addGap(303, 303, 303)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 730, 200));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                    StateWiseJframe swjf = new StateWiseJframe();
                    swjf.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
            jPanel3.grabFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked
        
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
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeaths;
    private javax.swing.JPanel lblHome;
    private javax.swing.JLabel lblLastRefreshed;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblRecovered;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables


}
