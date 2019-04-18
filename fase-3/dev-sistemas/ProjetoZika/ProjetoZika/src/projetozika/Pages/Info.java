/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetozika.Pages;

import Utils.Methods;
import Utils.Styles;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author welis
 */
public class Info extends Templates.BaseLayout {
    private String textContent;
    private JLabel textContainer;
    private JPanel wrapText;

    /**
     * Creates new form Help
     * @param params
     */
    public Info(Properties params) {
        super();
        this.params = params;
        
        initPage();
        System.out.println("help page");
    }
    
    private void initPage() {
        initComponents();
        createBaseLayout();
        addTopContent(Methods.getTranslation("Sobre"));
        addCenterContent();
    }
    
    /**
     * Adiciona conteúdo ao centro da area de conteúdo
     */
    private void addCenterContent() {
        barraRolagem = new JScrollPane();
        Styles.defaultScroll(barraRolagem);
        
        wrapText = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wrapText.setOpaque(false);

        helpContentPT();
        
        textContainer = new JLabel("<html>"+textContent+"</html>");
        textContainer.setFont(new java.awt.Font("Tahoma", 0, 16));
        textContainer.setForeground(new java.awt.Color(255, 255, 255));
        
        wrapText.add(textContainer);
        barraRolagem.getViewport().setView(wrapText);
        pCenter.add(barraRolagem, BorderLayout.CENTER);
    }
    
    private void helpContentPT() {
        textContent = "<h2>Projeto Zika</h2>"
                + "<br><p>Donec faucibus nec orci ut sollicitudin. Proin fermentum nec augue nec luctus. Vivamus elementum molestie tortor rhoncus lobortis.</p>"
                + "<br><p>Cras convallis ultricies diam, consequat consequat sapien condimentum a. Phasellus nibh leo, luctus id tincidunt et, pharetra pharetra turpis.</p>"
                + "<br><p>Quisque pretium tincidunt bibendum. Fusce malesuada diam id urna tristique, nec imperdiet dui malesuada. Morbi sodales mattis porta. Ut cursus rutrum commodo. Mauris tincidunt maximus suscipit. Aliquam erat volutpat.</p>"
                + "<br><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus nec orci ut sollicitudin.</p>";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}