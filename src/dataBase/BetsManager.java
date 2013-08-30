/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BetsManager.java
 *
 * Created on 2013-04-04, 19:49:57
 */
package dataBase;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;

/**
 *
 * @author Marcin
 */
public class BetsManager extends javax.swing.JPanel {
    
    private int betId = 0;
    
    private Bet selectedBet = null;
    private BetInProgression selectedBetInProg = null;
    private Progression selectedProgression = null;
    
    private DefaultListModel filteredBets = new DefaultListModel();
      
    public BetsManager() 
    {
        initComponents();
        this.setSize(400, 400);
       
        setFields();
        activateButtons(false);
        fillLists();         
        fillTodayBets();
        fillEndedBetsToUpdate();
        fillEndedBetsInProgToUpdate();
    }
    
    private void setFields()
    {
        jLabel2.setText("Today events:");
        jLabel3.setText("Ended events to update:");
        jLabel4.setText("Ended events in progression:");
        
        jLabel1.setText("Bet status:");
        jTextAreaBetInfo.setText("Choose other Bet Status to view bet information.");
        jTextAreaBetInfo.setEditable(false);
        fillJComboBoxStatus();
        jComboBoxDate.setModel(DataContainer.comboBoxModelDate);
        
        jButtonUpdate.setText("Update");
        jLabelInformation.setText("");
        jButtonAddNewBet.setText("Add new bet");
        jButtonEdit.setText("Edit");
        jButtonDelete.setText("Delete");
        
        jListTodayBets.setEnabled(false);
    }
       
    public static void fillLists()
    {
        DataContainer.fillActiveProgressionsCombo();
        DataContainer.fillDateCombo();
        DataContainer.fillAllProgressionsCombo();
        
        DataContainer.fillActiveBetsInProgression();
        DataContainer.fillActiveBetsNotInProgression();
        DataContainer.fillAllActiveBetsList();
        DataContainer.fillActiveProgressions();
        
        DataContainer.fillTodayBets();
        DataContainer.fillEndedBetsToUpdate();
        DataContainer.fillEndedBetsInProgToUpdate();
        
        DataContainer.fillResolvedBetsNotInProg();
        DataContainer.fillResolvedBetsInProg();
        DataContainer.fillResolvedProgressions();
        
        DataContainer.fillWonBetsNotInProg();
        DataContainer.fillLostBetsNotInProg();
        
        DataContainer.fillWonBetsInProg();
        DataContainer.fillLostBetsInProg();
    }
    
    private void fillJComboBoxStatus()
    {
        //aktywne
        jComboBoxBetStatus.addItem("All active bets");
        jComboBoxBetStatus.addItem("Active bets not in progressions");
        jComboBoxBetStatus.addItem("Active bets in progressions");
        jComboBoxBetStatus.addItem("Active progressions");
        
        //zakonczone
        jComboBoxBetStatus.addItem("Resolved bets not in progressions");
        jComboBoxBetStatus.addItem("Won bets not in progressions");
        jComboBoxBetStatus.addItem("Lost bets not in progressions");
        
        jComboBoxBetStatus.addItem("Resolved bets in progressions");
        jComboBoxBetStatus.addItem("Won bets in progressions");
        jComboBoxBetStatus.addItem("Lost bets in progressions");
           
        jComboBoxBetStatus.addItem("Resolved progressions");
    }
    
    private void fillTodayBets()
    {
        jListTodayBets.setModel(DataContainer.listModelTodayBets);
    }
    
    private void fillEndedBetsToUpdate()
    {
        jListEndedBetsToUpdate.setModel(DataContainer.listModelEndedBetsToUpdate);
    }
    
    private void fillEndedBetsInProgToUpdate()
    {
        jListEndedBetsInProgToUpdate.setModel(DataContainer.listModelEndedBetsInProgToUpdate);
    }
    
    private String getYearWithMonth(String date)
    {
        String month = "";
        String year = "";
        String [] split = date.split("-");
        month = split[1];
        year = split[0];
        return year + "-" + month;
    }
    
    private void filterBets(DefaultListModel modelToFilter)
    {
        filteredBets.removeAllElements();
        
        for(int i=0; i<modelToFilter.size(); i++)
        {
            Bet bet = (Bet) modelToFilter.get(i);
            String date = getYearWithMonth(bet.getDate());
                    
            if(date.equals(jComboBoxDate.getSelectedItem().toString()))
                filteredBets.addElement(bet);
        }
    }
    
    private void filterBetsInProg(DefaultListModel modelToFilter)
    {
        filteredBets.removeAllElements();
        
        for(int i=0; i<modelToFilter.size(); i++)
        {
            BetInProgression bip = (BetInProgression) modelToFilter.get(i);
            String date = getYearWithMonth(bip.getDate());
            
            if(date.equals(jComboBoxDate.getSelectedItem().toString()))
                filteredBets.addElement(bip);           
        }
    }
    
    private void activateButtons(boolean bool)
    {
        jButtonDelete.setEnabled(bool);
        jButtonEdit.setEnabled(bool);
    }
    
    private void comboBoxActionPerformed()
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("All active bets"))
                {           
                    jListBets.setModel(DataContainer.listModelAllActive);
                   // jListBets.repaint();
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("Choose other Bet Status to view bet information.");
                    jComboBoxDate.setEnabled(false);
                    activateButtons(false);
                }       
                
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets not in progressions"))
                {
                    jListBets.setModel(DataContainer.listModelActiveNotInProg);
                    //jListBets.repaint();
                    //jListBets.setSelectedIndex(0);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(false);
                    activateButtons(true);
                }
                
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets in progressions"))
                {
                    jListBets.setModel(DataContainer.listModelActiveInProg);
                    //jListBets.repaint();
                    //jListBets.setSelectedIndex(0);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(false);
                    activateButtons(true);
                }
        
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active progressions"))
                {
                    jListBets.setModel(DataContainer.listModelProgressions);
                    //jListBets.repaint();
                    //jListBets.setSelectedIndex(0);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(false);
                    activateButtons(true);
                }
        
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets not in progressions"))
                {
                    
                    filterBets(DataContainer.listModelResolvedBetsNotInProg);
                    //jListBets.setModel(DataContainer.listModelResolvedBetsNotInProg);
                    jListBets.setModel(filteredBets);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(true);
                    activateButtons(true);
                }
        
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets in progressions"))
                {
                    filterBetsInProg(DataContainer.listModelResolvedBetsInProg);
                    //jListBets.setModel(DataContainer.listModelResolvedBetsInProg);
                    jListBets.setModel(filteredBets);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(true);
                    activateButtons(true);
                }
        
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved progressions"))
                {
                    jListBets.setModel(DataContainer.listModelResolvedProgressions);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(false);
                    activateButtons(true);
                }
                
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets not in progressions"))
                {
                    filterBets(DataContainer.listModelWonBetsNotInProg);
                    //jListBets.setModel(DataContainer.listModelWonBetsNotInProg);
                    jListBets.setModel(filteredBets);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(true);
                    activateButtons(true);
                }
                
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets not in progressions"))
                {
                    filterBets(DataContainer.listModelLostBetsNotInProg);
                    //jListBets.setModel(DataContainer.listModelLostBetsNotInProg);
                    jListBets.setModel(filteredBets);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(true);
                    activateButtons(true);
                }               
                                   
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets in progressions"))
                {
                    filterBetsInProg(DataContainer.listModelWonBetsInProg);
                    //jListBets.setModel(DataContainer.listModelWonBetsInProg);
                    jListBets.setModel(filteredBets);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(true);
                    activateButtons(true);
                }
                
                if(jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets in progressions"))
                {
                    filterBetsInProg(DataContainer.listModelLostBetsInProg);
                    //jListBets.setModel(DataContainer.listModelLostBetsInProg);
                    jListBets.setModel(filteredBets);
                    jListBets.updateUI();
                    jTextAreaBetInfo.setText("");
                    jComboBoxDate.setEnabled(true);
                    activateButtons(true);
                }              
            }
        });        
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxBetStatus = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBets = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaBetInfo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListTodayBets = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListEndedBetsToUpdate = new javax.swing.JList();
        jButtonUpdate = new javax.swing.JButton();
        jLabelInformation = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListEndedBetsInProgToUpdate = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAddNewBet = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jComboBoxDate = new javax.swing.JComboBox();

        jLabel1.setText("jLabel1");

        jComboBoxBetStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jComboBoxBetStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBetStatusActionPerformed(evt);
            }
        });

        jListBets.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListBets.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListBetsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListBets);

        jTextAreaBetInfo.setColumns(20);
        jTextAreaBetInfo.setRows(5);
        jScrollPane2.setViewportView(jTextAreaBetInfo);

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jListTodayBets.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListTodayBets);

        jListEndedBetsToUpdate.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListEndedBetsToUpdate.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListEndedBetsToUpdateValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jListEndedBetsToUpdate);

        jButtonUpdate.setText("jButton1");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jLabelInformation.setText("jLabel4");

        jLabel4.setText("jLabel4");

        jListEndedBetsInProgToUpdate.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListEndedBetsInProgToUpdate.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListEndedBetsInProgToUpdateValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jListEndedBetsInProgToUpdate);

        jButtonAddNewBet.setText("jButton1");
        jButtonAddNewBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewBetActionPerformed(evt);
            }
        });

        jButtonEdit.setText("jButton2");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setText("jButton3");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jComboBoxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jComboBoxBetStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButtonAddNewBet, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInformation)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 196, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jButtonUpdate)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBetStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAddNewBet, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelInformation))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //TODO
    //przy przelaczaniu combobox na x.getSelectedValue pojawia sie NULL !!!
    
    //doszlo data container
    private void jComboBoxBetStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBetStatusActionPerformed
        
        //problem selekcji
        //jListBets.clearSelection();
        jListBets.setSelectedIndex(0);
        DataContainer.listName = jComboBoxBetStatus.getSelectedItem().toString();
            
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask(), 100);
        
//        if(jComboBoxBetStatus.getSelectedItem().toString().equals("All active bets"))
//                {           
//                    jListBets.setModel(listModelAllActive);
//                   // jListBets.repaint();
//
//                    jListBets.updateUI();
//                    jTextAreaBetInfo.setText("Choose other Bet Status to view bet information.");
//                }
        
        comboBoxActionPerformed();
    }//GEN-LAST:event_jComboBoxBetStatusActionPerformed
    
    //TODO
    //przy przelaczaniu combobox na x.getSelectedValue pojawia sie NULL !!!
    private void jListBetsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListBetsValueChanged
        
       // String info = "";
        //jListBets.setSelectedIndex(0);        // DZIAŁA !!!
   
        
            java.awt.EventQueue.invokeLater(new Runnable() {
                
                public void run() {
               
                    String info = "";
                    
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("All active bets"))
                    {
                        info = "Choose other Bet Status to view bet information.";           
                    }
        
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets not in progressions"))
                    {
                        info = DataContainer.dataFromDB.getBetNotInProgInfo
                                ((Bet)jListBets.getSelectedValue());
                    }
        
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets in progressions"))
                    {
                        info = DataContainer.dataFromDB.getBetInProgressionInfo
                                ((BetInProgression)jListBets.getSelectedValue());
                    }
            
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active progressions"))
                    {
//                        DataContainer.object = DataContainer.listModelProgressions.getElementAt(
//                            jListBets.getSelectedIndex());
//                        Progression prog = (Progression) DataContainer.object;
                        
//                        DataContainer.object = jListBets.getSelectedValue();
//                        Progression prog = (Progression) DataContainer.object;
//                        info = DataContainer.dataFromDB.getProgressionInfo(prog);     
                        
                        Progression prog = (Progression) jListBets.getSelectedValue();
                        info = DataContainer.dataFromDB.viewProgressionInfo(prog);
                        info += DataContainer.dataFromDB.viewProgressionBallance(prog);
                    }
        
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets not in progressions")
                            || jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets not in progressions")
                            || jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets not in progressions"))
                    {
                        info = DataContainer.dataFromDB.getResolvedBetNotInProgInfo
                                ((Bet) jListBets.getSelectedValue());     
                    }
                    
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets in progressions")
                            || jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets in progressions")
                            || jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets in progressions"))
                    {
                        info = DataContainer.dataFromDB.getResolvedBetInProgInfo
                                ((BetInProgression) jListBets.getSelectedValue());
                    }
                    
                    if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved progressions"))
                    {
//                        Progression prog = (Progression) jListBets.getSelectedValue();
//                        double balance = DataContainer.dataFromDB.getResolvedProgressionBalance(prog);
//                        info = "Progression balance: " + Double.toString(balance) + "\n" +
//                                DataContainer.dataFromDB.getProgressionInfo(prog);  
                        
                        Progression prog = (Progression) jListBets.getSelectedValue();
                        info = DataContainer.dataFromDB.viewProgressionInfo(prog);
                        info += DataContainer.dataFromDB.viewProgressionBallance(prog);
                    }
        
                    jTextAreaBetInfo.setText(info);
            }
        });    
    }//GEN-LAST:event_jListBetsValueChanged

   
    
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        
        if(jListEndedBetsToUpdate.getSelectedValue() == null
                && jListEndedBetsInProgToUpdate.getSelectedValue() == null)
        {
            jLabelInformation.setText("Choose ended bet to update from one of lists in the top.");
        }
        else        
        {
            String betInfo = "";
            
            if(jListEndedBetsToUpdate.getSelectedValue() != null)
            {
                DataContainer.object = DataContainer.listModelEndedBetsToUpdate.getElementAt
                        (jListEndedBetsToUpdate.getSelectedIndex());
                selectedBet = (Bet) DataContainer.object;
                betId = selectedBet.getBetId();
                DataContainer.id = betId;
                betInfo = DataContainer.dataFromDB.getBetNotInProgInfo(selectedBet);
            }
            
            if(jListEndedBetsInProgToUpdate.getSelectedValue() != null)
            {
                DataContainer.object = DataContainer.listModelEndedBetsInProgToUpdate.getElementAt
                        (jListEndedBetsInProgToUpdate.getSelectedIndex());
                selectedBetInProg = (BetInProgression) DataContainer.object;
                betId = selectedBetInProg.getBetId();
                DataContainer.id = betId;
                betInfo = DataContainer.dataFromDB.getBetInProgressionInfo(selectedBetInProg);
            }         
            
            //otwiera okno - wszystkie zmiany zachodza w UpdateBet po kliknieciu Confirm
            UpdateBet updateBet = new UpdateBet();
            updateBet.setVisible(true);
            updateBet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateBet.getLists(jListEndedBetsToUpdate, jListEndedBetsInProgToUpdate, jListTodayBets);
      
            updateBet.getjTextAreaInfo().setText(betInfo);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jListEndedBetsToUpdateValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListEndedBetsToUpdateValueChanged
        
        jListEndedBetsInProgToUpdate.clearSelection();
    }//GEN-LAST:event_jListEndedBetsToUpdateValueChanged

    private void jListEndedBetsInProgToUpdateValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListEndedBetsInProgToUpdateValueChanged
        
        jListEndedBetsToUpdate.clearSelection();
    }//GEN-LAST:event_jListEndedBetsInProgToUpdateValueChanged

    private void jButtonAddNewBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewBetActionPerformed
        
        JFrame addBetFrame = new JFrame();
        addBetFrame.setVisible(true);
        addBetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addBetFrame.setSize(600, 600);
        addBetFrame.setTitle("New bet");
        
        NewBet newBet = new NewBet();
        addBetFrame.add(newBet);
    }//GEN-LAST:event_jButtonAddNewBetActionPerformed

    private void saveBetData()
    {
                //zapamietanie danych zakladu
                DataContainer.object = jListBets.getSelectedValue();             
                selectedBet = (Bet) DataContainer.object;
                betId = selectedBet.getBetId();
                DataContainer.id = betId;
    }
    
    private void saveBetInProgData()
    {
                //zapamietanie danych zakladu
                DataContainer.object = jListBets.getSelectedValue();
                selectedBetInProg = (BetInProgression) DataContainer.object;
                betId = selectedBetInProg.getBetId();
                DataContainer.id = betId;
    }
    
    private void saveProgressionData(ListModel listModel)
    {
        //zapamietanie danych progresji
        DataContainer.object = listModel.getElementAt(
                jListBets.getSelectedIndex());
        selectedProgression = (Progression) DataContainer.object;
        betId = selectedProgression.getProgressionId();
        DataContainer.id = betId;
    }
    
    private void runEditWindow()
    {
            //uruchomienie okna edycji zakladu
            JFrame editBetFrame = new JFrame();
            editBetFrame.setVisible(true);
            editBetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            editBetFrame.setSize(600, 600);
            editBetFrame.setTitle("Edit bet");

            EditBet editBet = new EditBet();
            editBetFrame.add(editBet);
    }
    
    private void runEditProgressionWindow()
    {
        //uruchomienie okna edycji progresji
        JFrame editProgFrame = new JFrame();
        editProgFrame.setVisible(true);
        editProgFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editProgFrame.setSize(700, 320);
        editProgFrame.setTitle("Edit progression");
        
        EditProgression editProg = new EditProgression();
        editProgFrame.add(editProg);       
    }
    
    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        
        if(jListBets.getSelectedValue() == null)
        {
            jLabelInformation.setText("Choose position from the list on left side.");
        }
        else
        {
            jLabelInformation.setText("");
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets not in progressions"))
            {
                  saveBetData();
                  runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets not in progressions"))
            {
                  saveBetData();
                  runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets not in progressions"))
            {
                  saveBetData();
                  runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets not in progressions"))
            {
                saveBetData();
                runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets in progressions"))
            {
                  saveBetInProgData();
                  runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets in progressions"))
            {
                  saveBetInProgData();
                  runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets in progressions"))
            {
                  saveBetInProgData();
                  runEditWindow();
            }          
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets in progressions"))
            {
                saveBetInProgData();
                runEditWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active progressions"))
            {
                saveProgressionData(DataContainer.listModelProgressions);
                runEditProgressionWindow();
            }
            
            if(jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved progressions"))
            {
                saveProgressionData(DataContainer.listModelResolvedProgressions);
                runEditProgressionWindow();
            }
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void runDeleteWindow()
    {
            JFrame deleteProgFrame = new JFrame();
            deleteProgFrame.setVisible(true);
            deleteProgFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            deleteProgFrame.setSize(200, 245);
            deleteProgFrame.setTitle("Delete progression");

            DeleteProgression delProg = new DeleteProgression();
            deleteProgFrame.add(delProg);
    }
    
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        //
        //TODO delete - autocommit
        //
        //      AUTOCOMMIT = false  !!!!!!!!!!!!!!!!!
        //
        //
        
        try
                {
                    DataContainer.dataFromDB.getQueryManager().getConn().setAutoCommit(false);
                }
                catch(SQLException e)
                {
                    System.out.println("autocommit error");
                }
        DataContainer.object = jListBets.getSelectedValue();
        
        //w zaleznosci od listy (zaklad lub progresja)
        if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets not in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets not in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets not in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets not in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Active bets in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Won bets in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Lost bets in progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved bets in progressions"))
        {
            
            Bet betToDelete = (Bet) DataContainer.object;
            DataContainer.id = betToDelete.getBetId();
            DataContainer.dataFromDB.getQueryManager().deleteBet(DataContainer.id);
            DataContainer.updateLists();
        }
        
        if(jComboBoxBetStatus.getSelectedItem().toString().equals("Active progressions")
                || jComboBoxBetStatus.getSelectedItem().toString().equals("Resolved progressions"))
        {
            Progression progToDelete = (Progression) DataContainer.object;
            DataContainer.id = progToDelete.getProgressionId();
            runDeleteWindow();
        }      
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDateActionPerformed
      
        comboBoxActionPerformed();
    }//GEN-LAST:event_jComboBoxDateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewBet;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBoxBetStatus;
    private javax.swing.JComboBox jComboBoxDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JList jListBets;
    private javax.swing.JList jListEndedBetsInProgToUpdate;
    private javax.swing.JList jListEndedBetsToUpdate;
    private javax.swing.JList jListTodayBets;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaBetInfo;
    // End of variables declaration//GEN-END:variables
}
