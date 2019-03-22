/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetozika.Pages.SeusPedidos;

import Config.Environment;
import Models.Pedido;
import Models.Usuario;
import Templates.BaseLayout;
import Templates.ButtonEditor;
import Templates.ButtonRenderer;
import Utils.Dialogs;
import Utils.Methods;
import Utils.Navigation;
import Utils.Pagination;
import Utils.Styles;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 * Tela de listagem do fornecedores
 * 
 * @author Welison
 */
public class SeusPedidos extends Templates.BaseLayout {
    
    private BaseLayout self;
    public static JTable tabela;
    public static DefaultTableModel tableModel;
    private JButton btnAddPedido;
    private JDateChooser fData;
    private JComboBox<String> fStatus;
    private JLabel lData;
    private JLabel lStatus;
    private JButton bSearch;
    private JScrollPane barraRolagem;
    private ArrayList<Pedido> pedidos;

    /**
     * Cria a tela de fornecedores
     */
    public SeusPedidos() {
        super();
        self = this;
        initComponents();
        createBaseLayout();
        
        pedidos = new ArrayList<Pedido>();
        Usuario u = new Usuario("111111-22", "Nome Usuario", "email@email.com", "99999-9999", "2222-2222", "Contabilidade", "M", "admin", "12/12/1989");
        for (int i = 0; i < 15; i++) {
            Pedido p = new Pedido("10/11/2019", "Pendente", u);
            p.setCodigo(i);
            pedidos.add(p);
        }
        
        addTopContent(Methods.getTranslation("SeusPedidos"));
        addCenterContent();
        addBottomContent();
        addFilterContent();
    }
    
    // Adiciona conteúdo ao centro da area de conteúdo
    public void addCenterContent() {
        makeTable();
        barraRolagem = new JScrollPane();
        Styles.defaultScroll(barraRolagem);
        updateCenterContent();
        pCenter.add(barraRolagem, BorderLayout.CENTER);
    }
    
    private void updateCenterContent() {
        makeTable();
        barraRolagem.getViewport().setView(tabela);
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
            Methods.getTranslation("Data"), 
            Methods.getTranslation("Status"), 
            Methods.getTranslation("Editar"), 
            Methods.getTranslation("Cancelar"), 
            Methods.getTranslation("Ver")
        };
       // seta modelo
        tableModel = new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
               if(column != 3 && column != 4 && column != 5){
                   return false;
               }
               return true;
            }
        };
        // adiciona linhas
        pedidos.forEach(p -> {
            String btnEditar = Methods.getTranslation("Editar");
            String btnCancelar = Methods.getTranslation("Cancelar");
            if ( p.getCodigo() % 2 == 0 ) {
                btnEditar = "";
                btnCancelar = "";
            } 
            Object[] data = {
                p.getCodigo(),
                p.getData(),
                p.getStatus(),
                btnEditar,
                btnCancelar,
                Methods.getTranslation("Ver")
            };
            tableModel.addRow(data);
        });
        // inicializa
        tabela.setModel(tableModel);
        
        tabela.getColumn(Methods.getTranslation("Editar")).setCellRenderer(new ButtonRenderer());
        tabela.getColumn(Methods.getTranslation("Editar")).setCellEditor(new ButtonEditor(new JCheckBox()){
            @Override
            public void buttonAction() {
                String id = Methods.selectedTableItemId(tabela);
                int row = tabela.getSelectedRow();
                String actionValue = (String)tabela.getModel().getValueAt(row, 4);
                if (!actionValue.equals("")) {
                    Navigation.updateLayout("editarSeuPedido", id);
                }
            }
        });
        
        tabela.getColumn(Methods.getTranslation("Cancelar")).setCellRenderer(new ButtonRenderer());
        tabela.getColumn(Methods.getTranslation("Cancelar")).setCellEditor(new ButtonEditor(new JCheckBox()){
            @Override
            public void buttonAction() {
                // TODO: real database delete
                int row = tabela.getSelectedRow();
                String actionValue = (String)tabela.getModel().getValueAt(row, 4);
                if (!actionValue.equals("")) {
                    
                    int opcion = JOptionPane.showConfirmDialog(null, Methods.getTranslation("DesejaRealmenteExcluir?"), "Aviso", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
                        
                        String idTabel = Methods.selectedTableItemId(tabela);
                        for (int i = 0; i < pedidos.size(); i++) {
                            Pedido p = pedidos.get(i);
                            if (idTabel.equals(""+p.getCodigo())) {
                                pedidos.remove(p);
                            }
                        }
                        updateCenterContent();
                       JOptionPane.showMessageDialog(null, Methods.getTranslation("DeletadoComSucesso"));
                       
                    }
                }
            }
        });
        
        tabela.getColumn(Methods.getTranslation("Ver")).setCellRenderer(new ButtonRenderer());
        tabela.getColumn(Methods.getTranslation("Ver")).setCellEditor(new ButtonEditor(new JCheckBox()){
            @Override
            public void buttonAction() {
                String id = Methods.selectedTableItemId(tabela);
                Navigation.updateLayout("verSeuPedido", id);
            }
        });
    }
    
    /**
     * Adiciona o conteúdo à area de filtro da tela de conteúdo
     */
    public void addFilterContent() {
        fData = new JDateChooser();
        Styles.defaultDateChooser(fData);
        
        lData = new JLabel(Methods.getTranslation("Data"));
        Styles.defaultLabel(lData, false);
        
        fStatus = new JComboBox();
        fStatus.setModel(new DefaultComboBoxModel(Environment.STATUS.toArray()));
        Styles.defaultComboBox(fStatus);
        
        lStatus = new JLabel(Methods.getTranslation("Status"));
        Styles.defaultLabel(lStatus, false);
        
        bSearch = new JButton("");
        Styles.searchButton(bSearch);
        
        btnAddPedido = new JButton(Methods.getTranslation("FazerNovoPedido"));
        Styles.defaultButton(btnAddPedido);
        btnAddPedido.setPreferredSize(new Dimension(200, 35));
        
        pFilter.add(lData);
        pFilter.add(fData);
        pFilter.add(lStatus);
        pFilter.add(fStatus);
        pFilter.add(bSearch);
        pFilter.add(btnAddPedido);
        

        // click do buscar
        bSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialogs.showLoadPopup(self);
                timerTest();
            }
        });
        
        // click do add pedido
        btnAddPedido.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Navigation.updateLayout("fazerPedido"); 
            }
        });
    }
    
    /**
     * Adiciona o conteúdo à area de footer do conteúdo
     */
    public void addBottomContent() {
        this.pagination(5);
    }
    
    /**
     * Gera a paginação
     * 
     * @param total o total de páginas
     */
    public void pagination(int total) {
        Pagination pag = new Pagination(pBottom, total){
            @Override
            public void callbackPagination() {
                Dialogs.showLoadPopup(self);
                timerTest();
            }
        };
    }
    
    private Timer t;
    private void timerTest() {
        
        t = new Timer(2000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialogs.hideLoadPopup(self);
                
                for (int i = 0; i < pedidos.size(); i++) {
                    Pedido p = pedidos.get(i);
                    if (p.getCodigo() > 10) {
                        pedidos.remove(p);
                    }
                }
                updateCenterContent();
                pagination(3);
                
                t.stop();
            }
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

        setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 25, 50, 25));
        setMinimumSize(new java.awt.Dimension(1, 1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
