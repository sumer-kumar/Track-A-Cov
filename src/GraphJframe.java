
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class GraphJframe extends javax.swing.JFrame {
    private DataFetch dataFetch;
    public GraphJframe(DataFetch dataFetch) {
        initComponents();
        this.dataFetch = dataFetch;
        LineChartIndiaTotal();
        LineChartIndiaActive();
        LineChartIndiaRecovered();
        LineChartIndiaDeaths();
        LineChartIndiaCombined();
    }
    public void LineChartIndiaTotal(){
        DefaultCategoryDataset total = new DefaultCategoryDataset();
        int size = dataFetch.getHistory().getData().size();
        int difference;
        for(int i=0;i<size-1;i++){
       difference = dataFetch.getHistory().getData().get(i+1).getSummary().getConfirmedCasesIndian()-
               dataFetch.getHistory().getData().get(i).getSummary().getConfirmedCasesIndian()
               ;
    total.setValue(difference, 
                 "Toatal Cases",
                 dataFetch.getHistory().getData().get(i).getDay());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("Daily Total Cases", "Days", "cases", total);
        
        ChartPanel totalChartPanel = new ChartPanel(chart);
        
          pnlTotal.removeAll();
          pnlTotal.add(totalChartPanel, BorderLayout.CENTER);
          pnlTotal.validate();
    }
    public void LineChartIndiaActive(){
        DefaultCategoryDataset active = new DefaultCategoryDataset();
        int size = dataFetch.getHistory().getData().size();
        int difference;
        for(int i=0;i<size-1;i++){
       difference = dataFetch.getHistory().getData().get(i+1).getSummary().getConfirmedCasesIndian()-
                    dataFetch.getHistory().getData().get(i).getSummary().getConfirmedCasesIndian()-
                    (dataFetch.getHistory().getData().get(i+1).getSummary().getDischarged()-
                     dataFetch.getHistory().getData().get(i).getSummary().getDischarged())-
                    (dataFetch.getHistory().getData().get(i+1).getSummary().getDeaths()-
                     dataFetch.getHistory().getData().get(i).getSummary().getDeaths());               
               
    active.setValue(difference, 
                 "Active Cases",
                 dataFetch.getHistory().getData().get(i).getDay());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("Daily Active Case", "Days", "cases", active);
        
        ChartPanel totalChartPanel = new ChartPanel(chart);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getRenderer().setSeriesPaint(0, Color.BLUE);

          pnlActive.removeAll();
          pnlActive.add(totalChartPanel, BorderLayout.CENTER);
          pnlActive.validate();
    }
    public void LineChartIndiaRecovered(){
        DefaultCategoryDataset recovered = new DefaultCategoryDataset();
        int size = dataFetch.getHistory().getData().size();
        int difference;
        for(int i=0;i<size-1;i++){
       difference = dataFetch.getHistory().getData().get(i+1).getSummary().getDischarged()-
                     dataFetch.getHistory().getData().get(i).getSummary().getDischarged();
                    
    recovered.setValue(difference, 
                 "Recovered Cases",
                 dataFetch.getHistory().getData().get(i).getDay());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("Daily Recovered cases", "Days", "cases", recovered);
        
        ChartPanel totalChartPanel = new ChartPanel(chart);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getRenderer().setSeriesPaint(0, Color.GREEN);
        
          pnlRecovered.removeAll();
          pnlRecovered.add(totalChartPanel, BorderLayout.CENTER);
          pnlRecovered.validate();
    }
    public void LineChartIndiaDeaths(){
        DefaultCategoryDataset deaths = new DefaultCategoryDataset();
        int size = dataFetch.getHistory().getData().size();
        int difference;
        for(int i=0;i<size-1;i++){
       difference = dataFetch.getHistory().getData().get(i+1).getSummary().getDeaths()-
                     dataFetch.getHistory().getData().get(i).getSummary().getDeaths();
                    
    deaths.setValue(difference, 
                 "Deaths",
                 dataFetch.getHistory().getData().get(i).getDay());
        }
        
        JFreeChart chart = ChartFactory.createLineChart("Daily Deaths", "Days", "cases", deaths);
        
        ChartPanel totalChartPanel = new ChartPanel(chart);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getRenderer().setSeriesPaint(0, Color.GRAY);

          pnlDeaths.removeAll();
          pnlDeaths.add(totalChartPanel, BorderLayout.CENTER);
          pnlDeaths.validate();
    }
    public void LineChartIndiaCombined(){
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries total = new XYSeries("Total");
    XYSeries active = new XYSeries("Active");
    XYSeries recovered = new XYSeries("Recovered");
    XYSeries deaths = new XYSeries("Deaths");
    for(int i=0;i<dataFetch.getHistory().getData().size();i++){
        total.add(i+1,dataFetch.getHistory().getData().get(i).getSummary().getConfirmedCasesIndian());
        
        active.add(i+1,dataFetch.getHistory().getData().get(i).getSummary().getConfirmedCasesIndian()-
                dataFetch.getHistory().getData().get(i).getSummary().getDeaths()-
                dataFetch.getHistory().getData().get(i).getSummary().getDischarged());
        
        recovered.add(i+1,dataFetch.getHistory().getData().get(i).getSummary().getDischarged());
        
        deaths.add(i+1,dataFetch.getHistory().getData().get(i).getSummary().getDeaths());
    }
    dataset.addSeries(total);
    dataset.addSeries(active);
    dataset.addSeries(recovered);
    dataset.addSeries(deaths);
    XYDataset d = dataset;
    JFreeChart chart = ChartFactory.createXYLineChart("Combined", "Days","Cases", d);
    XYPlot plot = chart.getXYPlot();
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

    // sets paint color for each series
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesPaint(1, Color.BLUE);
    renderer.setSeriesPaint(2, Color.YELLOW);
    ChartPanel cp = new ChartPanel(chart);
        pnlCombined.removeAll();
        pnlCombined.add(cp,BorderLayout.CENTER);
        pnlCombined.validate();   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        pnlHome = new javax.swing.JPanel();
        pnlActive = new javax.swing.JPanel();
        pnlTotal = new javax.swing.JPanel();
        pnlRecovered = new javax.swing.JPanel();
        pnlDeaths = new javax.swing.JPanel();
        pnlCombined = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Graph");
        setResizable(false);

        pnlHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlActive.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        pnlActive.setLayout(new java.awt.BorderLayout());
        pnlHome.add(pnlActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 530, 180));

        pnlTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        pnlTotal.setLayout(new java.awt.BorderLayout());
        pnlHome.add(pnlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 530, 180));

        pnlRecovered.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        pnlRecovered.setLayout(new java.awt.BorderLayout());
        pnlHome.add(pnlRecovered, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 530, 172));

        pnlDeaths.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        pnlDeaths.setLayout(new java.awt.BorderLayout());
        pnlHome.add(pnlDeaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 530, 172));

        jScrollPane2.setViewportView(pnlHome);

        pnlCombined.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        pnlCombined.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCombined, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pnlCombined, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlActive;
    private javax.swing.JPanel pnlCombined;
    private javax.swing.JPanel pnlDeaths;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlRecovered;
    private javax.swing.JPanel pnlTotal;
    // End of variables declaration//GEN-END:variables
}
