/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author Welison
 */
public class Styles {
    
    public static void defaultButton(JButton btn) {
        // styles
        btn.setFont(new Font("Tahoma", 0, 12));
        btn.setForeground(new Color(8, 253, 216));
        btn.setBorder(BorderFactory.createLineBorder(new Color(8, 253, 216)));
        btn.setContentAreaFilled(false);
        btn.setMargin(new Insets(0, 0, 0, 0));
        btn.setPreferredSize(new Dimension(100, 35));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBackground(new Color(8, 253, 216));
        // hover event
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btn.setForeground(new Color(0, 0, 0));
                btn.setContentAreaFilled(true);
            }
            public void mouseExited(MouseEvent evt) {
                btn.setForeground(new Color(8, 253, 216));
                btn.setContentAreaFilled(false);
            }
        });
    }
    
    public static void defaultField(JTextField field) {
        field.setBackground(new Color(55, 57, 59));
        field.setForeground(new Color(255, 255, 255));
        field.setCaretColor(new Color(255, 255, 255));
        field.setOpaque(false);
        field.setPreferredSize(new Dimension(200, 39));
    }
    
    public static void defaultDateChooser(JDateChooser fDate) {
        fDate.setBackground(new Color(55, 57, 59));
        fDate.setForeground(new Color(255, 255, 255));
        fDate.getDateEditor().getUiComponent().setBackground(new Color(55, 57, 59));
        fDate.getDateEditor().getUiComponent().setForeground(new Color(255, 255, 255));
        fDate.setPreferredSize(new Dimension(200, 39));
    }
    
    public static void defaultComboBox(JComboBox field) {
        //field.setBackground(new Color(55, 57, 59));
        //field.setForeground(new Color(255, 255, 255));
        //field.setCaretColor(new Color(255, 255, 255));
        field.setOpaque(false);
        field.setPreferredSize(new Dimension(160, 39));
    }
    
    public static void defaultLabel(JLabel label) {
        label.setPreferredSize( new Dimension( 150, 39 ) );
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Tahoma", 0, 12));
    }
    
    public static void errorLabel(JLabel label) {
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("Tahoma", 0, 12));
        label.setPreferredSize( new Dimension( 150, 20 ) );
    }
    
    public static void menuButton(JLabel label) {
        label.setBackground(new Color(7, 7, 7));
        label.setFont(new Font("Tahoma", 1, 14));
        label.setForeground(new Color(8, 253, 216));
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setOpaque(true);
        /*
        label.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                setMenuButtonActive(label);
            }
            public void mouseExited(MouseEvent evt) {
                setMenuButtonInactive(label);
            }
        }); 
        */
    }
    
    public static void setMenuButtonActive(JLabel label) {
        label.setBackground(new Color(8, 253, 216));
        label.setForeground(new Color(7, 7, 7));
    }
    
    public static void setMenuButtonInactive(JLabel label) {
        label.setBackground(new Color(7, 7, 7));
        label.setForeground(new Color(8, 253, 216));
    }
    
    public static void searchButton(JButton btn) {
        btn.setContentAreaFilled(false);
        btn.setPreferredSize(new Dimension(35, 35));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setIcon(new ImageIcon(btn.getClass().getResource("/sources/lupa.png")));
    }
    
    public static void internalFrame(JFrame frame) {
        Methods.makePanelRelativeSize(frame, 450, 350);
        _internalFramesBase(frame);
    }
    
    public static void internalFrame(JFrame frame, int width, int height) {
        Methods.makePanelRelativeSize(frame, width, height);
        _internalFramesBase(frame);
    }
    
    private static void _internalFramesBase(JFrame frame) {
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(37, 38, 39));
        Methods.positionFrameInCenter(frame);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
    }
    
    public static void resetScrollPanel(JScrollPane panel) {
        panel.setLayout(new ScrollPaneLayout());
        panel.getViewport().setOpaque(false);
        panel.getViewport().setBackground(new Color(37, 38, 39));
        panel.setBorder(createEmptyBorder());
        panel.setViewportBorder(null);
    }
    
    public static void defaultSuggestions(JScrollPane panel, JList list, String[] model) {
        list.setModel(new AbstractListModel<String>() {
            String[] strings = model;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
            });
        panel.setPreferredSize( new Dimension( 200, 200 ) );
        panel.setViewportView(list);
        panel.setVisible(false);
    }
}
