/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

/**
 *
 * @author Marcin
 */
public class NewBet extends javax.swing.JPanel {

    private Calendar calendar = null;
    
    public NewBet() 
    {
        initComponents();
        calendar = new Calendar(jComboBoxDay, jComboBoxMonth, jComboBoxYear, jComboBoxHour, jComboBoxMinute);
        setFields();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupProgression = new javax.swing.ButtonGroup();
        jPanelNewBet = new javax.swing.JPanel();
        jButtonAddBet = new javax.swing.JButton();
        jPanelProgression = new javax.swing.JPanel();
        jRadioButtonNewProgression = new javax.swing.JRadioButton();
        jRadioButtonExistingProgression = new javax.swing.JRadioButton();
        jLabelNewProgressionName = new javax.swing.JLabel();
        jComboBoxExistingProgression = new javax.swing.JComboBox();
        jTextFieldProgressionName = new javax.swing.JTextField();
        jLabelProgressionBalance = new javax.swing.JLabel();
        jPanelInput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNote = new javax.swing.JTextArea();
        jComboBoxMonth = new javax.swing.JComboBox();
        jLabelBetName = new javax.swing.JLabel();
        jComboBoxMinute = new javax.swing.JComboBox();
        jComboBoxYear = new javax.swing.JComboBox();
        jTextFieldStake = new javax.swing.JTextField();
        jLabelTitle = new javax.swing.JLabel();
        jComboBoxHour = new javax.swing.JComboBox();
        jLabelBukmacher = new javax.swing.JLabel();
        jLabelStake = new javax.swing.JLabel();
        jComboBoxDay = new javax.swing.JComboBox();
        jLabelTime = new javax.swing.JLabel();
        jTextFieldOdd = new javax.swing.JTextField();
        jLabelOdd = new javax.swing.JLabel();
        jComboBoxBukmacher = new javax.swing.JComboBox();
        jLabelType = new javax.swing.JLabel();
        jLabelNote = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldBetName = new javax.swing.JTextField();
        jComboBoxType = new javax.swing.JComboBox();
        jCheckBoxProgression = new javax.swing.JCheckBox();

        jButtonAddBet.setText("jButton1");
        jButtonAddBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBetActionPerformed(evt);
            }
        });

        jRadioButtonNewProgression.setText("jRadioButton1");
        jRadioButtonNewProgression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNewProgressionActionPerformed(evt);
            }
        });

        jRadioButtonExistingProgression.setText("jRadioButton2");
        jRadioButtonExistingProgression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExistingProgressionActionPerformed(evt);
            }
        });

        jLabelNewProgressionName.setText("jLabel1");

        jComboBoxExistingProgression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxExistingProgressionActionPerformed(evt);
            }
        });

        jLabelProgressionBalance.setText("jLabel2");

        javax.swing.GroupLayout jPanelProgressionLayout = new javax.swing.GroupLayout(jPanelProgression);
        jPanelProgression.setLayout(jPanelProgressionLayout);
        jPanelProgressionLayout.setHorizontalGroup(
            jPanelProgressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProgressionLayout.createSequentialGroup()
                .addGroup(jPanelProgressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProgressionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelProgressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonNewProgression)
                            .addComponent(jRadioButtonExistingProgression))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProgressionName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProgressionLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelNewProgressionName))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProgressionLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelProgressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProgressionLayout.createSequentialGroup()
                                .addComponent(jLabelProgressionBalance)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxExistingProgression, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelProgressionLayout.setVerticalGroup(
            jPanelProgressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProgressionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonNewProgression)
                .addGap(2, 2, 2)
                .addGroup(jPanelProgressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewProgressionName)
                    .addComponent(jTextFieldProgressionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jRadioButtonExistingProgression)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxExistingProgression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelProgressionBalance))
        );

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setRows(5);
        jScrollPane1.setViewportView(jTextAreaNote);

        jLabelBetName.setText("jLabel1");

        jLabelTitle.setText("jLabel1");

        jLabelBukmacher.setText("jLabel1");

        jLabelStake.setText("jLabel1");

        jLabelTime.setText("jLabel1");

        jLabelOdd.setText("jLabel1");

        jLabelType.setText("jLabel1");

        jLabelNote.setText("jLabel1");

        jLabelDate.setText("jLabel1");

        jCheckBoxProgression.setText("jCheckBox1");
        jCheckBoxProgression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProgressionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBetName)
                            .addComponent(jLabelDate)
                            .addComponent(jLabelTime)
                            .addComponent(jLabelType))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addComponent(jComboBoxHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBetName)))
                    .addComponent(jCheckBoxProgression))
                .addGap(74, 74, 74))
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addComponent(jLabelNote)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addComponent(jLabelOdd)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldOdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addComponent(jLabelStake)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldStake, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addComponent(jLabelBukmacher)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxBukmacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBetName)
                    .addComponent(jTextFieldBetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDate)
                    .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTime)
                    .addComponent(jComboBoxHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelType)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOdd)
                    .addComponent(jTextFieldOdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStake)
                    .addComponent(jTextFieldStake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBukmacher)
                    .addComponent(jComboBoxBukmacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNote)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxProgression)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNewBetLayout = new javax.swing.GroupLayout(jPanelNewBet);
        jPanelNewBet.setLayout(jPanelNewBetLayout);
        jPanelNewBetLayout.setHorizontalGroup(
            jPanelNewBetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewBetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddBet, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanelNewBetLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanelProgression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelNewBetLayout.setVerticalGroup(
            jPanelNewBetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewBetLayout.createSequentialGroup()
                .addGroup(jPanelNewBetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewBetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNewBetLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonAddBet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelProgression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewBet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNewBet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    private void setFields()
    {
        jLabelTitle.setText("Set information for new bet");
        jLabelBetName.setText("Bet name:");
        jLabelStake.setText("Stake:");
        jLabelOdd.setText("Odd:");
        jLabelDate.setText("Date of event:");
        jLabelTime.setText("Start time:");
        jLabelBukmacher.setText("Bukmacher:");
        jLabelNote.setText("Note:");
        jLabelType.setText("Type:");
        jCheckBoxProgression.setText("is part of progression");
        jPanelProgression.setVisible(false);
        jButtonAddBet.setText("Add bet");
        jLabelProgressionBalance.setText("");
              
        jRadioButtonNewProgression.setText("New progression");
        jRadioButtonExistingProgression.setText("Existing progression");
        buttonGroupProgression.add(jRadioButtonExistingProgression);
        buttonGroupProgression.add(jRadioButtonNewProgression);
        
        jLabelNewProgressionName.setText("Progression name:");
        jRadioButtonExistingProgression.setSelected(true);
        jTextFieldProgressionName.setEnabled(false);
        jComboBoxExistingProgression.setEnabled(true);
        
        jComboBoxExistingProgression.setModel(DataContainer.comboBoxModelProgressions);
        viewProgressionBalanceInLabel();
        //jComboBoxExistingProgression.setSelectedIndex(0);
        fillComboBoxBukmacher();
        fillComboBoxType();
        calendar.fillComboBoxDateTime();
    }
    
    private void fillComboBoxType()
    {
        jComboBoxType.addItem("1");
        jComboBoxType.addItem("x");
        jComboBoxType.addItem("2");
        jComboBoxType.addItem("1x");
        jComboBoxType.addItem("12");
        jComboBoxType.addItem("x2");
        jComboBoxType.addItem("over 2.5");
        jComboBoxType.addItem("under 2.5");
        jComboBoxType.addItem("other");
    }
    
    private void fillComboBoxBukmacher()
    {
        for(BukmacherENUM b : BukmacherENUM.values())
            jComboBoxBukmacher.addItem(b);
    }
    
    private void refreshComboBox()
    {
        DataContainer.comboBoxModelProgressions.removeAllElements();
        DataContainer.fillActiveProgressionsCombo();
        jComboBoxExistingProgression.setModel(DataContainer.comboBoxModelProgressions);
    }
     
    private void jButtonAddBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddBetActionPerformed

        String betName = jTextFieldBetName.getText();
        String date = calendar.setDate();
        double odd = Double.parseDouble(jTextFieldOdd.getText());
        double stake = Double.parseDouble(jTextFieldStake.getText());
        String bukmacher = jComboBoxBukmacher.getSelectedItem().toString();
        String note = jTextAreaNote.getText();
        String type = jComboBoxType.getSelectedItem().toString();
        
        if(jCheckBoxProgression.isSelected())
        {
            String progressionName = "";

            if(jRadioButtonExistingProgression.isSelected())
            {
                progressionName = jComboBoxExistingProgression.getSelectedItem().toString();
                DataContainer.dataFromDB.getQueryManager().addBetInProgressionExisting(betName, date, odd, stake, 
                        bukmacher, note, type, progressionName);
 /*               
                //tworzy obiekt, ktory zostanie dodany do listy
                //id - zaklad zostal dodany, trzeba zliczyc wszystkie zaklady
                betId = DataContainer.dataFromDB.getQueryManager().countAllBets() + 1;
                progressionId = DataContainer.dataFromDB.getQueryManager().countAllProgressions();
                BetInProgression betInProg = new BetInProgression(betId, betName, date, odd, stake, 
                        bukmacher, note, type, progressionId , progressionName, 1);
                Bet bet = (Bet) betInProg;
                
//                aktualizacja list              
//                aktywne zaklady w progresji
                DataContainer.listModelActiveInProg.addElement(betInProg);
                //wszystkie aktywne zaklady
                DataContainer.listModelAllActive.addElement(bet);
                * */
            }

            if(jRadioButtonNewProgression.isSelected())
            {
                progressionName = jTextFieldProgressionName.getText();
                DataContainer.dataFromDB.getQueryManager().addBetInProgressionNew(betName, date, odd, stake, 
                        bukmacher, note, type, progressionName);
 /*               
                //tworzy obiekt, ktory zostanie dodany do listy
                //betId - zaklad zostal dodany, trzeba zliczyc wszystkie zaklady
                //progressionId - jak wyzej
                betId = DataContainer.dataFromDB.getQueryManager().countAllBets() + 1;
                progressionId = DataContainer.dataFromDB.getQueryManager().countAllProgressions();
                BetInProgression betInProg = new BetInProgression(betId, betName, date, odd, stake, 
                        bukmacher, note, type, progressionId , progressionName, 1);
                Bet bet = (Bet) betInProg;
                
                Progression prog = new Progression(progressionId, progressionName, 1);
                
                //wszystkie aktywne zaklady
                DataContainer.listModelAllActive.addElement(bet);
                //aktywne zaklady w progresji
                DataContainer.listModelActiveInProg.addElement(betInProg);
                //aktywne progresje
                DataContainer.listModelProgressions.addElement(prog);
                */
                //uaktualnienie listy progresji w NewBet
                refreshComboBox();
            }
        }
        else
        {
            DataContainer.dataFromDB.getQueryManager().addBet(betName, date, odd, stake, bukmacher, note, type);
    /*        
            //betId - zaklad zostal dodany, trzeba zliczyc wszystkie zaklady
            betId = DataContainer.dataFromDB.getQueryManager().countAllBets() + 1;
            
            Bet bet = new Bet(betId, betName, date, odd, stake, bukmacher, note, type);
            
            //wszystkie aktywne zaklady
            DataContainer.listModelAllActive.addElement(bet);
            //aktywne zaklady nie w progresji
            DataContainer.listModelActiveNotInProg.addElement(bet);           
            * */
        }
        
        DataContainer.updateLists();
    }//GEN-LAST:event_jButtonAddBetActionPerformed

    private void jCheckBoxProgressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProgressionActionPerformed

        if(jCheckBoxProgression.isSelected())
            jPanelProgression.setVisible(true);
        else
            jPanelProgression.setVisible(false);
    }//GEN-LAST:event_jCheckBoxProgressionActionPerformed

    private void jRadioButtonNewProgressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNewProgressionActionPerformed

        if(jRadioButtonNewProgression.isSelected())
        {
            jTextFieldProgressionName.setEnabled(true);
            jComboBoxExistingProgression.setEnabled(false);
            jLabelProgressionBalance.setText("");
        }
        else
        {
            jTextFieldProgressionName.setEnabled(false);
            jComboBoxExistingProgression.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonNewProgressionActionPerformed

    private void jRadioButtonExistingProgressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExistingProgressionActionPerformed

        if(jRadioButtonExistingProgression.isSelected())
        {
            jTextFieldProgressionName.setEnabled(false);
            jComboBoxExistingProgression.setEnabled(true);
            viewProgressionBalanceInLabel();
        }
        else
        {
            jTextFieldProgressionName.setEnabled(true);
            jComboBoxExistingProgression.setEnabled(false);          
        }
    }//GEN-LAST:event_jRadioButtonExistingProgressionActionPerformed

    private void jComboBoxExistingProgressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxExistingProgressionActionPerformed
        
        viewProgressionBalanceInLabel();
    }//GEN-LAST:event_jComboBoxExistingProgressionActionPerformed

    private void viewProgressionBalanceInLabel()
    {
        if(jComboBoxExistingProgression.getSelectedItem() != null)
        {
            Progression prog = (Progression) jComboBoxExistingProgression.getSelectedItem();
            String progressionBalance = DataContainer.dataFromDB.viewProgressionBallance(prog);
            jLabelProgressionBalance.setText(progressionBalance);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupProgression;
    private javax.swing.JButton jButtonAddBet;
    private javax.swing.JCheckBox jCheckBoxProgression;
    private javax.swing.JComboBox jComboBoxBukmacher;
    private javax.swing.JComboBox jComboBoxDay;
    private javax.swing.JComboBox jComboBoxExistingProgression;
    private javax.swing.JComboBox jComboBoxHour;
    private javax.swing.JComboBox jComboBoxMinute;
    private javax.swing.JComboBox jComboBoxMonth;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JComboBox jComboBoxYear;
    private javax.swing.JLabel jLabelBetName;
    private javax.swing.JLabel jLabelBukmacher;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelNewProgressionName;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelOdd;
    private javax.swing.JLabel jLabelProgressionBalance;
    private javax.swing.JLabel jLabelStake;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JPanel jPanelNewBet;
    private javax.swing.JPanel jPanelProgression;
    private javax.swing.JRadioButton jRadioButtonExistingProgression;
    private javax.swing.JRadioButton jRadioButtonNewProgression;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaNote;
    private javax.swing.JTextField jTextFieldBetName;
    private javax.swing.JTextField jTextFieldOdd;
    private javax.swing.JTextField jTextFieldProgressionName;
    private javax.swing.JTextField jTextFieldStake;
    // End of variables declaration//GEN-END:variables
}
