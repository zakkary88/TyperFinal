/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progressivebooker;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author Marcin
 */
public class ProgressiveBooker extends javax.swing.JPanel {

    private ProgressiveSimulator ps;
    private NumberFormat nf = NumberFormat.getInstance();
            
    public ProgressiveBooker() {
        initComponents();
        
        ps = new ProgressiveSimulator();
        int df = jSliderDrawFrequency.getValue();
        jLabelDrawFrequency.setText(Integer.toString(df));
        setFields();
    }
    
    private double checkField(String fieldValue)
    {
        double result = 0;
        
        try
        {
            Number parsed = nf.parse(fieldValue);
            result = parsed.doubleValue();
        }
        catch (ParseException pex)
        {
            jLabelInfo.setText("Invalid input data.");
        }  
        
        return result;        
    }  
    
    private void setFields()
    {
        jLabel1.setText("Progression type:");
        jLabel2.setText("Percentage draw chance:");
        jLabel3.setText("Desired profit:");
        jLabel4.setText("Number of events draw odds to generate:");
        jLabelInfo.setText("");
        jRadioButton1.setText("Steady profit");
        jRadioButton2.setText("Doubling-Up");
        jRadioButton3.setText("Fibonacci");
        
        jTextAreaSimulation.setEnabled(false);
        jTextAreaOdds.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupProgType = new javax.swing.ButtonGroup();
        jPanelProgressiveBooker = new javax.swing.JPanel();
        jTextFieldEventsNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSimulation = new javax.swing.JTextArea();
        jButtonGenerate = new javax.swing.JButton();
        jLabelDrawFrequency = new javax.swing.JLabel();
        jSliderDrawFrequency = new javax.swing.JSlider();
        jButtonSimulate = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldStake = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaOdds = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();

        jTextAreaSimulation.setColumns(20);
        jTextAreaSimulation.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSimulation);

        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jLabelDrawFrequency.setText("jLabel1");

        jSliderDrawFrequency.setMaximum(35);
        jSliderDrawFrequency.setMinimum(20);
        jSliderDrawFrequency.setValue(20);
        jSliderDrawFrequency.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderDrawFrequencyStateChanged(evt);
            }
        });

        jButtonSimulate.setText("Simulate");
        jButtonSimulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimulateActionPerformed(evt);
            }
        });

        buttonGroupProgType.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        buttonGroupProgType.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroupProgType.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jTextAreaOdds.setColumns(20);
        jTextAreaOdds.setRows(5);
        jScrollPane3.setViewportView(jTextAreaOdds);

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanelProgressiveBookerLayout = new javax.swing.GroupLayout(jPanelProgressiveBooker);
        jPanelProgressiveBooker.setLayout(jPanelProgressiveBookerLayout);
        jPanelProgressiveBookerLayout.setHorizontalGroup(
            jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelProgressiveBookerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProgressiveBookerLayout.createSequentialGroup()
                        .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProgressiveBookerLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEventsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelProgressiveBookerLayout.createSequentialGroup()
                        .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelProgressiveBookerLayout.createSequentialGroup()
                        .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonSimulate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelProgressiveBookerLayout.createSequentialGroup()
                                    .addComponent(jSliderDrawFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelDrawFrequency))
                                .addComponent(jLabel2)
                                .addGroup(jPanelProgressiveBookerLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldStake, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelProgressiveBookerLayout.setVerticalGroup(
            jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProgressiveBookerLayout.createSequentialGroup()
                .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldEventsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jButtonGenerate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelProgressiveBookerLayout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addGap(30, 30, 30)
                        .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldStake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProgressiveBookerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSliderDrawFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDrawFrequency)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSimulate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelInfo.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProgressiveBooker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProgressiveBooker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSimulateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimulateActionPerformed

        jLabelInfo.setText("");
        int drawFrequency = jSliderDrawFrequency.getValue();
        double stake = checkField(jTextFieldStake.getText());
        String simulationInfo = "";
        
        if(jTextAreaOdds.getText().equals(""))
        {
            jLabelInfo.setText("Generate events draw odds before starting simulation.");
        }
        else
        {
            if(jLabelInfo.getText().equals(""))
            {
                if(jRadioButton1.isSelected())
                    simulationInfo = ps.getPbm().simulate(drawFrequency, stake, ProgressionTypeENUM.Steady_Profit);

                if(jRadioButton2.isSelected())
                    simulationInfo = ps.getPbm().simulate(drawFrequency, stake, ProgressionTypeENUM.Doubling_Up);

                if(jRadioButton3.isSelected())          
                    simulationInfo = ps.getPbm().simulate(drawFrequency, stake, ProgressionTypeENUM.Fibonacci);  
            }
        }

        jTextAreaSimulation.setText(simulationInfo);
    }//GEN-LAST:event_jButtonSimulateActionPerformed

    private void jSliderDrawFrequencyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderDrawFrequencyStateChanged

        int currentValue = jSliderDrawFrequency.getValue();
        jLabelDrawFrequency.setText(Integer.toString(currentValue));
    }//GEN-LAST:event_jSliderDrawFrequencyStateChanged

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed

        jLabelInfo.setText("");
        String eventsNumberString = jTextFieldEventsNumber.getText();
        double eventsNumberDouble = checkField(eventsNumberString);
        int eventsNumber = (int) eventsNumberDouble;
        ps.generateOddsList(eventsNumber);
        String odds = ps.viewOdds();

        jTextAreaOdds.setText(odds);
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
        jLabel3.setText("Desired profit:");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        
        jLabel3.setText("Beggining stake:");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        
        jLabel3.setText("Beggining stake:");
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupProgType;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonSimulate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDrawFrequency;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JPanel jPanelProgressiveBooker;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSliderDrawFrequency;
    private javax.swing.JTextArea jTextAreaOdds;
    private javax.swing.JTextArea jTextAreaSimulation;
    private javax.swing.JTextField jTextFieldEventsNumber;
    private javax.swing.JTextField jTextFieldStake;
    // End of variables declaration//GEN-END:variables
}
