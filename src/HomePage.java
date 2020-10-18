
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class HomePage extends javax.swing.JFrame {
   private StateWise stateWiseObj;
   private LocalDateTime dateTime;
   private String formatDateTime; 
   public HomePage() {
        initComponents();
        time();
        refresh();
       try {
           fetchData();
       } catch (IOException ex) {
           ex.getStackTrace();
       }
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
        jPanel2 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        lblRecovered = new javax.swing.JLabel();
        lblDeaths = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

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
        jPanel1.setLayout(new java.awt.GridLayout());

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
        lblLastRefreshed.setText("Last Refreshed");
        lblHome.add(lblLastRefreshed, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 140, 30));

        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 140));

        jPanel2.setBackground(new java.awt.Color(33, 32, 54));
        jPanel2.setLayout(new java.awt.GridLayout());

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

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 730, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        time();
        refresh();
       try {
           fetchData();
       } catch (IOException ex) {
           Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_jButton1ActionPerformed
        
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
    public void refresh(){
        try {
            URL url = new URL("https://api.rootnet.in/covid19-in/stats/latest");
            URLConnection urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            int i;
            String s="";
            while((i = is.read())!=-1){
                s = s+(char)i;
            }
            File offlineStateWise = new File("offlineStateWise.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
            lblLastRefreshed.setText(formatDateTime );
        }catch(Exception e){
           e.getStackTrace();
           this.setVisible(true);
        JOptionPane.showMessageDialog(this,"No Internet Connection\n"
                +"Connect to Internet to See Latest Data");  
        }
        
    }
    public void fetchData() throws FileNotFoundException, IOException{
        File offlineStateWise = new File("offlineStateWise.txt");
        BufferedReader bfreader = new BufferedReader(new FileReader(offlineStateWise));
        String s = "";
        String endChecker;
        while((endChecker = bfreader.readLine())!=null){
            s+=endChecker;
        }
        bfreader.close();
        Gson gson = new Gson();
        stateWiseObj = gson.fromJson(s,StateWise.class);
        lblTotal.setText(""+stateWiseObj.data.summary.total);
        lblActive.setText(""+(stateWiseObj.data.summary.total-stateWiseObj.data.summary.deaths-stateWiseObj.data.summary.discharged));
        lblRecovered.setText(""+stateWiseObj.data.summary.discharged);
        lblDeaths.setText(""+stateWiseObj.data.summary.deaths);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeaths;
    private javax.swing.JPanel lblHome;
    private javax.swing.JLabel lblLastRefreshed;
    private javax.swing.JLabel lblRecovered;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables


}
