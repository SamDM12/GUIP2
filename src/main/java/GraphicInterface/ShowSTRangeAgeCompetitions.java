/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GraphicInterface;

import DBProcedures.GetSetData;
import com.mycompany.project1db.AgeXSport;
import com.mycompany.project1db.CompetitionType;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author chedr
 */
public class ShowSTRangeAgeCompetitions extends javax.swing.JFrame {
    private GetSetData getSetElements = new GetSetData();
    private int year;
    /**
     * Creates new form ShowSTRangeAge
     * @param year
     */
    public ShowSTRangeAgeCompetitions(int year) {
        this.year = year;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ActionEvent evt = new ActionEvent(seeGraphicButton, ActionEvent.ACTION_PERFORMED, "command");
        seeGraphicButtonActionPerformed(evt);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPanel = new javax.swing.JPanel();
        sinceSP = new javax.swing.JSpinner();
        toSP = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        seeGraphicButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalPanel.setBackground(new java.awt.Color(255, 255, 204));

        sinceSP.setModel(new javax.swing.SpinnerNumberModel(5, 5, 99, 1));

        toSP.setModel(new javax.swing.SpinnerNumberModel(5, 5, 99, 1));

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        jLabel3.setText("Nota: si colocas desde un numero mayor hasta un numero menor se invertirá el intervalo.");

        seeGraphicButton.setText("Ver gráfico");
        seeGraphicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeGraphicButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sinceSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(116, 116, 116)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(principalPanelLayout.createSequentialGroup()
                                .addComponent(toSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(seeGraphicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sinceSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seeGraphicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seeGraphicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeGraphicButtonActionPerformed
        int high;
        int low;

    if ((Integer) sinceSP.getValue() > (Integer) toSP.getValue()) {
        high = (Integer) sinceSP.getValue();
        low = (Integer) toSP.getValue();
    } else {
        high = (Integer) toSP.getValue();
        low = (Integer) sinceSP.getValue();
    }

    ArrayList<AgeXSport> competitions = getSetElements.getCompetitorsInAgeRange(low, high, this.year);
    
    DefaultPieDataset dataset = createDatasetCompetition(competitions);

    JFreeChart pieChart = createPieChart(dataset, "Distribución de Personas Rango de Edad");

    ChartPanel chartPanel = new ChartPanel(pieChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600)); 
    principalPanel.removeAll();  

    principalPanel.setLayout(new BorderLayout());  
    
    JPanel controlsPanel = new JPanel();  
    controlsPanel.add(new JLabel("Desde:"));
    controlsPanel.add(sinceSP);  
    controlsPanel.add(new JLabel("Hasta:"));
    controlsPanel.add(toSP);     
    controlsPanel.add(seeGraphicButton);  

  
    principalPanel.add(controlsPanel, BorderLayout.NORTH);
    
    principalPanel.add(chartPanel, BorderLayout.CENTER); 

    principalPanel.revalidate();
    principalPanel.repaint();
    this.pack();

    }//GEN-LAST:event_seeGraphicButtonActionPerformed
private static DefaultPieDataset createDatasetCompetition(ArrayList<AgeXSport> competitions) {
    DefaultPieDataset dataset = new DefaultPieDataset();

    for (AgeXSport competition : competitions) {
        dataset.setValue(competition.getCompetitionName() + ", dentro: " + competition.getInRange(), competition.getInRange());
        dataset.setValue(competition.getCompetitionName() + ", Fuera: " + competition.getOutRange(), competition.getOutRange());
    }

    return dataset;
}

private static JFreeChart createPieChart(DefaultPieDataset dataset, String title) {
    return ChartFactory.createPieChart(
            title,     
            dataset,    
            true,       
            true,       
            false      
    );
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JButton seeGraphicButton;
    private javax.swing.JSpinner sinceSP;
    private javax.swing.JSpinner toSP;
    // End of variables declaration//GEN-END:variables
}
