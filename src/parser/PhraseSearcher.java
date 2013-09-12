/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Marcin
 */
public class PhraseSearcher implements DocumentListener{

    private JLabel jLabelStatus;
    private JTextArea jTextAreaOdds;
    private JTextField jTextFieldPhrase;
    
    final static Color  HIGHLIGHTER_COLOR = Color.LIGHT_GRAY;
    final static Color  ERROR_COLOR = Color.RED;
    final static String CANCEL_ACTION = "cancel-search";
    
    final Color jTextFieldPhraseBackground;
    final Highlighter highlighter;
    final Highlighter.HighlightPainter painter;
    
    private int indexOfPhrase = 0;
    
    public PhraseSearcher(JLabel jLabelStatus, JTextArea jTextAreaOdds, JTextField jTextFieldPhrase)
    {
        this.jLabelStatus = jLabelStatus;
        this.jTextAreaOdds = jTextAreaOdds;
        this.jTextFieldPhrase = jTextFieldPhrase;
        
        highlighter = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(HIGHLIGHTER_COLOR);
        jTextAreaOdds.setHighlighter(highlighter);
        
        jTextFieldPhraseBackground = jTextFieldPhrase.getBackground();
        jTextFieldPhrase.getDocument().addDocumentListener(this);
        
        InputMap im = jTextFieldPhrase.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = jTextFieldPhrase.getActionMap();
        im.put(KeyStroke.getKeyStroke("ESCAPE"), CANCEL_ACTION);
        am.put(CANCEL_ACTION, new CancelAction());
    }
    
    public void search() 
    {
        highlighter.removeAllHighlights();
        
        String inputText = jTextFieldPhrase.getText();
        if (inputText.length() <= 0) 
        {
            message("Nothing to search");
            return;
        }
        
        String content = jTextAreaOdds.getText();
        int index = content.indexOf(inputText, 0);
        if (index >= 0) 
        {   // match found
            try 
            {
                int end = index + inputText.length();
                highlighter.addHighlight(index, end, painter);
                jTextAreaOdds.setCaretPosition(end);
                jTextFieldPhrase.setBackground(jTextFieldPhraseBackground);
                message("'" + inputText + "' found. Press ESC to end search");
                indexOfPhrase = end;
            } 
            catch (BadLocationException e) 
            {
                e.printStackTrace();
            }
        } 
        else 
        {
            jTextFieldPhrase.setBackground(ERROR_COLOR);
            message("'" + inputText + "' not found. Press ESC to start a new search");
        }
    }
        
    public void searchNext()
    {
        highlighter.removeAllHighlights();
        
        String inputText = jTextFieldPhrase.getText();
        if (inputText.length() <= 0) 
        {
            message("Nothing to search");
            return;
        }
        
        String content = jTextAreaOdds.getText();
        int index = content.indexOf(inputText, indexOfPhrase);
        if (index >= 0) 
        {   // match found
            try 
            {
                int end = index + inputText.length();
                highlighter.addHighlight(index, end, painter);
                jTextAreaOdds.setCaretPosition(end);
                jTextFieldPhrase.setBackground(jTextFieldPhraseBackground);
                message("'" + inputText + "' found. Press ESC to end search");
                indexOfPhrase = end;
            } 
            catch (BadLocationException e) 
            {
                e.printStackTrace();
            }
        } 
        else 
        {
            jTextFieldPhrase.setBackground(ERROR_COLOR);
            message("'" + inputText + "' not found. Press ESC to start a new search");
        }
    }

    void message(String msg) 
    {
        jLabelStatus.setText(msg);
    }

    @Override
    public void insertUpdate(DocumentEvent ev) 
    {
        search();
    }
    
    @Override
    public void removeUpdate(DocumentEvent ev)
    {
        search();
    }
    
    @Override
    public void changedUpdate(DocumentEvent ev) {}
        
    class CancelAction extends AbstractAction 
    {
        @Override
        public void actionPerformed(ActionEvent ev) 
        {
            highlighter.removeAllHighlights();
            jTextFieldPhrase.setText("");
            jTextFieldPhrase.setBackground(jTextFieldPhraseBackground);
        }
    }  
}
  
    

