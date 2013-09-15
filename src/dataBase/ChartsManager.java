/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.awt.BorderLayout;
import java.util.LinkedList;
import org.jfree.chart.ChartPanel;


/**
 *
 * @author Marcin
 */
public class ChartsManager extends javax.swing.JPanel {

    private ChartsGenerator chartsGenerator = null;
    private LinkedList<ChartPanel> charts = new LinkedList<ChartPanel>();
    
    private ChartPanel Efficiency = null;
    private ChartPanel EfficiencyInProg = null;
    private ChartPanel EfficiencyNotInProg = null;
    
    private ChartPanel YieldByDates = null;
    private ChartPanel YieldByDatesInProg = null;
    private ChartPanel YieldByDatesNotInProg = null;
            
    private ChartPanel WonLost = null;
    private ChartPanel WonLostInProg = null;
    private ChartPanel WonLostNotInProg = null;

    private ChartPanel Balance = null;
    private ChartPanel BalanceInProg = null;
    private ChartPanel BalanceNotInProg = null;
    
    private ChartPanel WonLostByBukmacher = null;
    private ChartPanel WonLostInProgByBukmacher = null;
    private ChartPanel WonLostNotInProgByBukmacher = null;

    private ChartPanel BalanceByBukmacher = null;
    private ChartPanel BalanceInProgByBukmacher = null;
    private ChartPanel BalanceNotInProgByBukmacher = null;
    
    private ChartPanel WonLostByType = null;
    private ChartPanel BalanceByType = null;
    
    /**
     * Creates new form ChartsManager
     */
    public ChartsManager() {
        initComponents();
        this.setSize(400, 400);
        
        chartsGenerator = new ChartsGenerator();
        
        setFields();
        setCharts();
    }
    
    private void setFields()
    {
        jComboBoxChartType.addItem("Efficiency");
        jComboBoxChartType.addItem("Efficiency in progressions");
        jComboBoxChartType.addItem("Efficiency not in progressions");
        jComboBoxChartType.addItem("Yield");
        jComboBoxChartType.addItem("Yield in progressions");
        jComboBoxChartType.addItem("Yield not in progressions");
        jComboBoxChartType.addItem("Won/Lost by months");
        jComboBoxChartType.addItem("Won/Lost in progressions by months");
        jComboBoxChartType.addItem("Won/Lost not in progressions by months");
        jComboBoxChartType.addItem("Balance by months");
        jComboBoxChartType.addItem("Balance in progressions by months");
        jComboBoxChartType.addItem("Balance not in progressions by months");
        jComboBoxChartType.addItem("Won/Lost by bukmacher");
        jComboBoxChartType.addItem("Won/Lost in progressions by bukmacher");
        jComboBoxChartType.addItem("Won/Lost not in progressions by bukmacher");
        jComboBoxChartType.addItem("Balance by bukmacher");
        jComboBoxChartType.addItem("Balance in progressions by bukmacher");
        jComboBoxChartType.addItem("Balance not in progressions by bukmacher");
        jComboBoxChartType.addItem("Won/Lost by type");
        jComboBoxChartType.addItem("Balance by type");
              
        jPanelChart.setLayout(new BorderLayout());       
    }
    
    
    private void setCharts()
    {
        Efficiency = chartsGenerator.drawEfficiencyChart();
        EfficiencyInProg = chartsGenerator.drawEfficiencyInProgressionChart();
        EfficiencyNotInProg = chartsGenerator.drawEfficiencyNotInProgChart();
        
        YieldByDates = chartsGenerator.drawYieldByDatesChart();
        YieldByDatesInProg = chartsGenerator.drawYieldByDatesInProgChart();
        YieldByDatesNotInProg = chartsGenerator.drawYieldByDatesNotInProgChart();
        
        WonLost = chartsGenerator.drawWonLostBarChart();
        WonLostInProg = chartsGenerator.drawWonLostInProgBarChart();
        WonLostNotInProg = chartsGenerator.drawWonLostNotInProgBarChart();
        
        Balance = chartsGenerator.drawBalanceBarChart();
        BalanceInProg = chartsGenerator.drawBalanceInProgBarChart();
        BalanceNotInProg = chartsGenerator.drawBalanceNotInProgBarChart();
        
        WonLostByBukmacher = chartsGenerator.drawWonLostByBukmacherBarChart();
        WonLostInProgByBukmacher = chartsGenerator.drawWonLostInProgByBukmacherBarChart();
        WonLostNotInProgByBukmacher = chartsGenerator.drawWonLostNotInProgByBukmacherBarChart();
        
        BalanceByBukmacher = chartsGenerator.drawBalanceByBukmacherBarChart();
        BalanceInProgByBukmacher = chartsGenerator.drawBalanceInProgByBukmacherBarChart();
        BalanceNotInProgByBukmacher = chartsGenerator.drawBalanceNotInProgByBukmacherBarChart();
        
        WonLostByType = chartsGenerator.drawWonLostByTypeBarChart();
        BalanceByType = chartsGenerator.drawBalanceByType();
    }
    
    private void addChartsToList()
    {
        charts.add(Efficiency);
        charts.add(EfficiencyInProg);
        charts.add(EfficiencyNotInProg);
        
        charts.add(YieldByDates);
        charts.add(YieldByDatesInProg);
        charts.add(YieldByDatesNotInProg);
        
        charts.add(WonLost);
        charts.add(WonLostInProg);
        charts.add(WonLostNotInProg);
        
        charts.add(Balance);
        charts.add(BalanceInProg);
        charts.add(BalanceNotInProg);
        
        charts.add(WonLostByBukmacher);
        charts.add(WonLostInProgByBukmacher);
        charts.add(WonLostNotInProgByBukmacher);
        
        charts.add(BalanceByBukmacher);
        charts.add(BalanceInProgByBukmacher);
        charts.add(BalanceNotInProgByBukmacher);
        
        charts.add(WonLostByType);
        charts.add(BalanceByType);
    }
       
    private void viewChart(ChartPanel chart)
    {
        addChartsToList();
        
        for(ChartPanel cp : charts)
        {
            if(cp != chart)
                jPanelChart.remove(cp);
        }
        
        jPanelChart.add(chart, BorderLayout.CENTER);
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxChartType = new javax.swing.JComboBox();
        jPanelChart = new javax.swing.JPanel();

        jComboBoxChartType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChartTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxChartType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxChartType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxChartTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChartTypeActionPerformed
            
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {                               
                if(jComboBoxChartType.getSelectedItem().toString().equals("Efficiency"))                 
                    viewChart(Efficiency);

                if(jComboBoxChartType.getSelectedItem().toString().equals("Efficiency in progressions"))
                    viewChart(EfficiencyInProg);                   
                    
                if(jComboBoxChartType.getSelectedItem().toString().equals("Efficiency not in progressions"))                   
                    viewChart(EfficiencyNotInProg);
        
                if(jComboBoxChartType.getSelectedItem().toString().equals("Yield"))
                    viewChart(YieldByDates);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Yield in progressions"))
                    viewChart(YieldByDatesInProg);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Yield not in progressions"))
                    viewChart(YieldByDatesNotInProg);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost by months"))
                    viewChart(WonLost);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost in progressions by months"))
                    viewChart(WonLostInProg);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost not in progressions by months"))
                    viewChart(WonLostNotInProg);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance by months"))
                    viewChart(Balance);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance in progressions by months"))
                    viewChart(BalanceInProg);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance not in progressions by months"))
                    viewChart(BalanceNotInProg);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost by bukmacher"))
                    viewChart(WonLostByBukmacher);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost in progressions by bukmacher"))
                    viewChart(WonLostInProgByBukmacher);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost not in progressions by bukmacher"))
                    viewChart(WonLostNotInProgByBukmacher);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance by bukmacher"))
                    viewChart(BalanceByBukmacher);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance in progressions by bukmacher"))
                    viewChart(BalanceInProgByBukmacher);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance not in progressions by bukmacher"))
                    viewChart(BalanceNotInProgByBukmacher);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Won/Lost by type"))
                    viewChart(WonLostByType);
                
                if(jComboBoxChartType.getSelectedItem().toString().equals("Balance by type"))
                    viewChart(BalanceByType);
                                       
                jPanelChart.validate();
                jPanelChart.updateUI();
            }
        });

        
    }//GEN-LAST:event_jComboBoxChartTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxChartType;
    private javax.swing.JPanel jPanelChart;
    // End of variables declaration//GEN-END:variables
}
