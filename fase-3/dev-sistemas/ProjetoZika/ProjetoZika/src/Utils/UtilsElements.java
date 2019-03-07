/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import projetozika.Pages.Dashboard;
import projetozika.Pages.Fornecedores.Fornecedores;
import projetozika.Pages.NotFound;

/**
 *
 * @author Welison
 */
public class UtilsElements {
    
    private static JPanel jBody;
    private static String currentPage = "";
    
    public static void makeFrameFullSize(JFrame aFrame)
    {
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        aFrame.setSize(screenSize.width, screenSize.height);
    }
    
    public static void setJBody(JPanel jb) {
        jBody = jb;
    }
    
    public static JPanel getJBody() {
       return  jBody;
    }
    
    public static String getCurrentPage() {
        return currentPage;
    }
    
    public static void setAllInvisible() {
        JPanel jb = getJBody();
        Component[] comps = jb.getComponents();
        System.out.println(comps.length);
        for (Component comp : comps) {
            comp.setVisible(false);
        }
    }
    
    public static void clearStage() {
        JPanel jb = getJBody();
        jb.removeAll();
        jb.revalidate();
    }
    
    ///*
    public static void updateLayout(String pageName) {
        if (currentPage.equals(pageName)) return;
        JPanel tmpPanel = null;
        currentPage = pageName;
        clearStage();
        switch (pageName) {
            case "dashboard":
                tmpPanel = new Dashboard();
                break;
            case "fornecedores":
                tmpPanel = new Fornecedores();
                break;
            default:
                currentPage = "";
                tmpPanel = new NotFound();
        }
        getJBody().add(tmpPanel, BorderLayout.CENTER);
        tmpPanel.setVisible(true);
    }
    //*/
    /*
    public static void updateLayout(String pageName){
        setAllInvisible();
        if (PagesModel.getPage(pageName) != null) {
            JPanel tmpPanel = PagesModel.getPage(pageName).getPanel();
            getJBody().add(tmpPanel, BorderLayout.CENTER);
            tmpPanel.setVisible(true);
        } else {
            switch (pageName) {
                case "login":
                    PagesModel.addPage(new PageModel("login", new Login()));
                    updateLayout("login");
                    break;
                case "dashboard":
                    PagesModel.addPage(new PageModel("dashboard", new Dashboard()));
                    updateLayout("dashboard");
                    break;
                case "fornecedores":
                    PagesModel.addPage(new PageModel("fornecedores", new Fornecedores()));
                    updateLayout("fornecedores");
                    break;
                default:
                    System.out.println("Page Not Found.");
            }
        }
    }
    //*/
}
