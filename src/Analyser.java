import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
class closer{
    closer(JFrame jframe){
       jframe.dispose();
    } //welcome
}
public class Analyser extends javax.swing.JFrame {
 
    public Analyser() {
        initComponents();
        pnlHome.grabFocus();
    }
    
    public boolean validity(){
       boolean valid = true;
       if(cmbq1.getSelectedIndex()==0||
          cmbq2.getSelectedIndex()==0||
          cmbq3.getSelectedIndex()==0||
          cmbq4.getSelectedIndex()==0)
       {    valid = false;
           JOptionPane.showMessageDialog(this,"Answer All");
       }
       return valid;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spnlHome = new javax.swing.JScrollPane();
        pnlHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnResults = new javax.swing.JButton();
        lblQ4 = new javax.swing.JLabel();
        cmbq4 = new javax.swing.JComboBox<>();
        cmbq3 = new javax.swing.JComboBox<>();
        lblQ3 = new javax.swing.JLabel();
        cmbq2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbq1 = new javax.swing.JComboBox<>();
        lblQ1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Covid Analyser");
        setAlwaysOnTop(true);
        setResizable(false);

        pnlHome.setBackground(new java.awt.Color(33, 32, 54));
        pnlHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 248, 252));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Covid Analyser");
        jLabel1.setToolTipText("");
        pnlHome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 200, 30));

        btnResults.setText("See Results");
        btnResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultsActionPerformed(evt);
            }
        });
        pnlHome.add(btnResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        lblQ4.setForeground(new java.awt.Color(220, 248, 252));
        lblQ4.setText("Q4.Which of the following apply to you?");
        pnlHome.add(lblQ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 410, -1));

        cmbq4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Interacted with covid +ive person", "Checked a person without protective gear", "None of these" }));
        pnlHome.add(cmbq4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 250, -1));

        cmbq3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Yes", "No" }));
        cmbq3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbq3ActionPerformed(evt);
            }
        });
        pnlHome.add(cmbq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, -1));

        lblQ3.setForeground(new java.awt.Color(220, 248, 252));
        lblQ3.setText("Q3.Have you travelled anywhere internationally in last 28 days?");
        pnlHome.add(lblQ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 420, 30));

        cmbq2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Diabetes", "HyperTension", "Lung Disease", "Heart Disease", "Kidney Disorder", "None of these" }));
        pnlHome.add(cmbq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, 20));

        jLabel2.setForeground(new java.awt.Color(220, 248, 252));
        jLabel2.setText("Q2.Have you ever had any of the following");
        pnlHome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 410, -1));

        cmbq1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select One---", "Cough", "Fever", "Difficulty in breathing", "Loss of senses of smell", "None of these" }));
        pnlHome.add(cmbq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 250, -1));

        lblQ1.setForeground(new java.awt.Color(220, 248, 252));
        lblQ1.setText("Q1.Are you experiancing any of the following symptoms");
        pnlHome.add(lblQ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 420, 20));

        spnlHome.setViewportView(pnlHome);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlHome)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlHome, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultsActionPerformed
        if(validity()){
             UIManager UI=new UIManager();
            String message="";
            int sc = score();
            if(sc<=4){
                message = "You are safe";
                 UI.put("OptionPane.background", Color.green);
                UI.put("Panel.background", Color.GREEN);
            }
            else if(sc<=6){
                message = "You are suspecious for Corona";
                 UI.put("OptionPane.background", Color.orange);
                UI.put("Panel.background", Color.orange);
            }
            else{
                message = "You are in high risk";
                 UI.put("OptionPane.background", Color.red);
                UI.put("Panel.background", Color.red);
            }
            JOptionPane.showMessageDialog(this, message);
            
            new closer(this);
        }
    }//GEN-LAST:event_btnResultsActionPerformed

    private void cmbq3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbq3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbq3ActionPerformed
    public int score(){
        int score=0;
        if(cmbq1.getSelectedIndex()!=5) score+=2;      
        if(cmbq2.getSelectedIndex()!=6) score+=1;
        if(cmbq3.getSelectedIndex()!=2) score+=3;
        if(cmbq4.getSelectedIndex()!=3) score+=10;
        return score;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResults;
    private javax.swing.JComboBox<String> cmbq1;
    private javax.swing.JComboBox<String> cmbq2;
    private javax.swing.JComboBox<String> cmbq3;
    private javax.swing.JComboBox<String> cmbq4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblQ1;
    private javax.swing.JLabel lblQ3;
    private javax.swing.JLabel lblQ4;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JScrollPane spnlHome;
    // End of variables declaration//GEN-END:variables
}
