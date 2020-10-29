
import com.google.gson.Gson;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;


public class NewsJframe extends javax.swing.JFrame {
    private News news;
    private int currIndex;
    private int size;
    private File dir;
    private boolean repeate;
    private String currUrl;
    public NewsJframe(Saved saved){
        initComponents();
        taTitle.setText(saved.getTitle());
        taDescription.setText(saved.getDescription());
        taBody.setText(saved.getBody());
        lblSource.setText(saved.getSource());
        currUrl = saved.getUrl();
        btnNext.setVisible(false);
        btnPrev.setVisible(false);
        btnSave.setVisible(false);
        
    }
    public NewsJframe() {
       this.repeate = false;
       initComponents();
       try{
           fetch();
       showLabels(0);
       currIndex = 0;
       size = news.getSize()-1;
       dir = new File("news");
       dir.mkdir();
       pnlHeader.grabFocus();
       }catch(Exception e){}
    }
    public boolean getRepeate(){return this.repeate;}
    public void fetch(){
    HttpRequest request = HttpRequest.newBuilder()
   .uri(URI.create("https://rapidapi.p.rapidapi.com/api/search/NewsSearchAPI?pageSize=10&q=covid%2019%20india&autoCorrect=true&pageNumber=1&safeSearch=true&toPublishedDate=null&fromPublishedDate=null&withThumbnails=false"))
   .header("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
   .header("x-rapidapi-key", "ef6da0019fmsh0fac709bb3488aap16ebf0jsn9d3c7742a884")
   .method("GET", HttpRequest.BodyPublishers.noBody())
   .build();
   HttpResponse<String> response;
  try{
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());        
      String s = response.body();
      Gson g = new Gson();
      news= g.fromJson(s, News.class);
//      System.out.println(news.getValue(0).getBody());
       }catch(Exception e){
//                    System.out.println("Error");
                    e.getStackTrace();
       }

    }
    public void showLabels(int i){
        taTitle.setText(news.getValue(i).getTitle());
        taDescription.setText(news.getValue(i).getDescription());
        taBody.setText(news.getValue(i).getBody());
        lblSource.setText(news.getValue(i).getProvider().getName());
        currUrl = news.getValue(i).getUrl();
    }
    public void next(){
        if(currIndex!=size&&(currIndex>=0&&currIndex<=size)){
            currIndex++;
            showLabels(currIndex);
        }
    }
    public void prev(){
        if(currIndex!=0){
            currIndex--;
            showLabels(currIndex);
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
    public void saveNews(){
        String s ="";
        File f = new File(dir,news.getValue(currIndex).getTitle().replaceAll(":","")+".txt");
        try{
           if(!f.exists()){
           Saved save = new Saved (news.getValue(currIndex).getTitle(),
                                   news.getValue(currIndex).getDescription(),
                                   news.getValue(currIndex).getBody(),
                                   news.getValue(currIndex).getProvider().getName(),
                                   news.getValue(currIndex).getUrl());
           Gson gson = new Gson();
           s = gson.toJson(save);
           BufferedWriter bw = new BufferedWriter(new FileWriter(f));
           bw.write(s);
           bw.flush();
           bw.close();
        }
        else 
        {
            JOptionPane.showMessageDialog(this,"Already Saved");
        }
        }catch(Exception e){System.out.println(e.getMessage());}

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlNewsPage = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTitle = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taBody = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lblSource = new javax.swing.JLabel();
        btnOpenbrowser = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("News");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(33, 32, 54));

        pnlNewsPage.setBackground(new java.awt.Color(33, 32, 54));
        pnlNewsPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Title");
        pnlNewsPage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 100, 30));

        taTitle.setEditable(false);
        taTitle.setBackground(new java.awt.Color(33, 32, 54));
        taTitle.setColumns(20);
        taTitle.setForeground(new java.awt.Color(220, 248, 252));
        taTitle.setLineWrap(true);
        taTitle.setRows(5);
        jScrollPane2.setViewportView(taTitle);

        pnlNewsPage.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 520, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Description");
        pnlNewsPage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Body");
        pnlNewsPage.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 100, 30));

        taBody.setEditable(false);
        taBody.setBackground(new java.awt.Color(33, 32, 54));
        taBody.setColumns(20);
        taBody.setForeground(new java.awt.Color(220, 248, 252));
        taBody.setLineWrap(true);
        taBody.setRows(5);
        taBody.setToolTipText("");
        taBody.setDisabledTextColor(new java.awt.Color(220, 248, 252));
        jScrollPane4.setViewportView(taBody);

        pnlNewsPage.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 520, 190));

        taDescription.setEditable(false);
        taDescription.setBackground(new java.awt.Color(33, 32, 54));
        taDescription.setColumns(20);
        taDescription.setForeground(new java.awt.Color(220, 248, 252));
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane5.setViewportView(taDescription);

        pnlNewsPage.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 520, 80));

        jLabel5.setForeground(new java.awt.Color(0, 255, 0));
        jLabel5.setText("Source");
        pnlNewsPage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        lblSource.setForeground(new java.awt.Color(220, 248, 252));
        lblSource.setText("Source Name");
        pnlNewsPage.add(lblSource, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 440, -1));

        btnOpenbrowser.setText("Open in Browser");
        btnOpenbrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenbrowserActionPerformed(evt);
            }
        });
        pnlNewsPage.add(btnOpenbrowser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 420, 60));

        jScrollPane1.setViewportView(pnlNewsPage);

        pnlHeader.setBackground(new java.awt.Color(33, 32, 54));
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNext.setText(">");
        btnNext.setToolTipText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlHeader.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 25, -1, -1));

        btnPrev.setText("<");
        btnPrev.setToolTipText("Previous");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        pnlHeader.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

        btnSave.setText("Save ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlHeader.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnOpenbrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenbrowserActionPerformed
        openBrowser(currUrl);
    }//GEN-LAST:event_btnOpenbrowserActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveNews();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       repeate = true;        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       repeate = false;        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpenbrowser;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblSource;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNewsPage;
    private javax.swing.JTextArea taBody;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextArea taTitle;
    // End of variables declaration//GEN-END:variables
}
