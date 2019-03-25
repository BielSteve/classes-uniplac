/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetozika.Pages.Pedidos;

import Config.Environment;
import Models.PedidoProduto;
import Models.Produto;
import Utils.Dialogs;
import Utils.Methods;
import Utils.Navigation;
import Utils.Styles;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Welison
 */
public class EditarPedido extends Templates.BaseFrame {
    private JPanel bg;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private JLabel title;
    private JScrollPane barraRolagem;
    private JButton btnFinalizar;
    private JPanel paction;
    private ArrayList<PedidoProduto> pedidosProdutos;
    private JButton btnNegar;
    
   public EditarPedido(Properties params) {
       this.self = this;
       this.params = params;
   }
    
    public EditarPedido(String id, String mode, Properties params) {
        this.self = this;
        this.mode = mode;
        this.params = params;
        
        initPage(Methods.getTranslation("Pedido"));
    }
    
    private void initPage(String title) {
        
        initComponents();
        Styles.internalFrame(this, 1000, 600);
        Methods.setAccessibility(this);
        
        
        pedidosProdutos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Produto p = new Produto(i, "Nome Produto", "Caixa", "Descrição Produto", "1/12/2009");
            PedidoProduto pp = new PedidoProduto(p, 1, Methods.getTranslation("Pendente"));
            pp.setId(i);
            pedidosProdutos.add(pp);
        }
        
        createBaseLayout();
        addTopContent(title);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Navigation.currentPage = "pedidos";
            }
        });
        
        addCenterContent();
        addBottomContent();
    }
    
    private void addCenterContent() {
        bg = new JPanel();
        bg.setLayout(new BorderLayout());
        bg.setOpaque(false);
        
        title = new JLabel(Methods.getTranslation("Itens"));
        Styles.defaultLabel(title);
        bg.add(title, BorderLayout.NORTH);
        
        makeTable();
        barraRolagem = new JScrollPane(tabela);
        Styles.defaultScroll(barraRolagem);
        bg.add(barraRolagem, BorderLayout.CENTER);
        
        pCenter.add(bg);
    }
    
    private void addBottomContent() {
        btnFinalizar = new JButton(Methods.getTranslation("FinalizarPedido"));
        Styles.defaultButton(btnFinalizar);
        
        btnFinalizar.addActionListener((ActionEvent e) -> {
            // TODO: finalizar pedido aqui
   
            Dialogs.showLoadPopup(bg);
            timerTest();
        });
        
        btnNegar = new JButton(Methods.getTranslation("NegarPedido"));
        Styles.redButton(btnNegar);
        
        btnNegar.addActionListener((ActionEvent e) -> {
            // TODO: negar pedido aqui

            Dialogs.showLoadPopup(bg);
            timerTest();
        });
        
        paction = new JPanel();
        paction.setLayout(new FlowLayout(FlowLayout.RIGHT));
        paction.setOpaque(false);
        paction.add(btnNegar);
        paction.add(btnFinalizar);
        pBottom.add(paction, BorderLayout.SOUTH);
    }
    
    /**
     * Gera a tabela com os dados
     */
    private void makeTable() {
        // cria tabela
        tabela = new JTable();
        tabela.setRowHeight(35);
        // seta colunas
        String[] colunas = {
            Methods.getTranslation("Codigo"),
            Methods.getTranslation("Produto"), 
            Methods.getTranslation("QuantidadeSolicitada"), 
            Methods.getTranslation("QuantidadeAprovada")
        };
       // seta modelo
        tableModel = new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
               if (column != 3 && column != 4){
                   return false;
               }
               return true;
            }
        };
        // adiciona linhas
        pedidosProdutos.forEach(pp -> {
            Object[] data = {pp.getId(), pp.getProduto().getNome(), pp.getQuantidade(), pp.getQuantidadeAprovada()};
            tableModel.addRow(data);
        });

        // inicializa
        tabela.setModel(tableModel);
        
        TableColumn quantidadeCol = tabela.getColumnModel().getColumn(3);
        JComboBox cquantidade = new JComboBox();
        for(int i = 1; i <= 5; i++) {
            cquantidade.addItem(i);
        }
        quantidadeCol.setCellEditor(new DefaultCellEditor(cquantidade));
      
        tabela.getModel().addTableModelListener((TableModelEvent e) -> {
            // TODO: editar produto do pedido
            
            if (!tabela.getSelectionModel().isSelectionEmpty()) {
                String newQtd = Methods.selectedTableItemValue(tabela, 3);
                String idTable = Methods.selectedTableItemId(tabela);
                for (int i = 0; i < pedidosProdutos.size(); i++) {
                    PedidoProduto pp = pedidosProdutos.get(i);
                    int idModel = pp.getProduto().getId();
                    if (idTable.equals(""+idModel)) {
                        pp.setQuantidade(Integer.parseInt(newQtd));
                        break;
                    }
                }
            }
        });
    }
    
    private Timer t;
    private void timerTest() {
        
        t = new Timer(2000, (ActionEvent e) -> {
            Dialogs.hideLoadPopup(bg);
            self.dispose();
            JOptionPane.showMessageDialog(null, Methods.getTranslation("OkItemAguardandoRetirada"));
            
            Navigation.updateLayout("", new Properties());
            Navigation.updateLayout("pedidos", params);
            
            t.stop();
        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(37, 38, 39));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
