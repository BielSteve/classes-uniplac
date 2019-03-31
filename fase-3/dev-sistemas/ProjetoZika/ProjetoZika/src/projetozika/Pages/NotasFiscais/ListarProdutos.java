/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetozika.Pages.NotasFiscais;

import Models.NotaFiscalProduto;
import Models.Produto;
import Templates.ButtonEditor;
import Templates.ButtonRenderer;
import Utils.Methods;
import Utils.Styles;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Welison
 */
public class ListarProdutos extends javax.swing.JPanel {
    
    private DefaultTableModel tableModel;
    private JTable tabela;
    private String mode;
    private JScrollPane barraRolagem;
    public ArrayList<NotaFiscalProduto> notaProdutos;

    /**
     * Creates new form ListarProdutos
     * @param mode Mostra como o painel foi chamado, se como edição ou como visualização
     */
    public ListarProdutos(String mode) {
        this.mode = mode;
        this.notaProdutos = new ArrayList<>();
        
        initPage();
    }
    
    /**
     * Creates new form ListarProdutos
     * @param mode Mostra como o painel foi chamado, se como edição ou como visualização
     */
    public ListarProdutos(String id, String mode) {
        this.mode = mode;
        this.notaProdutos = new ArrayList<>();
        
        /*
        for (int i = 0; i < 5; i++) {
            Produto p = new Produto(i, "Nome produto", "Unidade produto", "Descrição produto", "22/10/2019");
            NotaFiscalProduto np = new NotaFiscalProduto(null, p, 3, 4.5f, "");
            notaProdutos.add(np);
        }
        */
        
        initPage();
    }
    
    private void initPage() {
        
        initComponents();
        Styles.setBorderTitle(this, Methods.getTranslation("ProdutosDaNotaFiscal"));
        setLayout(new BorderLayout());
        
        
        barraRolagem = new JScrollPane();
        Styles.defaultScroll(barraRolagem);
        updateCenterContent();
        add(barraRolagem, BorderLayout.CENTER);
    }
    
    private void updateCenterContent() {
        makeTable();
        barraRolagem.getViewport().setView(tabela);
    }
    
    private void makeTable() {
        tabela = new JTable();
        tabela.setRowHeight(35);
        // seta colunas
        String[] colunas = {
            Methods.getTranslation("Codigo"),
            Methods.getTranslation("Nome"),
            Methods.getTranslation("Unidade"),
            Methods.getTranslation("Valor"),
            Methods.getTranslation("Quantidade"),
            ""
        };
        if(! mode.equals("view")) {
            colunas[5] = Methods.getTranslation("Excluir");
        } 
        
       // seta modelo
        tableModel = new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (mode.equals("view")) {
                    return false;
                } else {
                    if(column != 5){
                        return false;
                    }
                }
               return true;
            }
        };
        // adiciona linhas
        notaProdutos.forEach(np -> {
            Object[] data = {np.getProduto().getId(),np.getProduto().getNome(),np.getProduto().getUnidade(),np.getValor(),np.getQuantidade(),""};
            if (! mode.equals("view")) {
                data[5] = Methods.getTranslation("Excluir");
            }
            tableModel.addRow(data);
        });
        // inicializa
        tabela.setModel(tableModel);
        
        if (! mode.equals("view")) {
            TableColumn colExcluir = tabela.getColumn(Methods.getTranslation("Excluir"));
            colExcluir.setMaxWidth(40);
            colExcluir.setCellRenderer(new ButtonRenderer());
            colExcluir.setCellEditor(new ButtonEditor(new JCheckBox()){
                @Override
                public void buttonAction() {
                    String idTabel = Methods.selectedTableItemId(tabela);
                    for (int i = 0; i < notaProdutos.size(); i++) {
                        NotaFiscalProduto np = notaProdutos.get(i);
                        if (idTabel.equals(""+np.getProduto().getId())) {
                            notaProdutos.remove(np);
                        }
                    }
                    updateCenterContent();
                }
            });
        }
    }
    
    public boolean addProduto(NotaFiscalProduto notaFiscalProduto) {
        if (! hasProduct(notaFiscalProduto.getProduto().getId())) {
            notaProdutos.add(notaFiscalProduto);
            updateCenterContent();
            return true;
        }
        return false;
    }
    
    private boolean hasProduct(int id) {
        for (int i = 0; i < notaProdutos.size(); i++) {
            NotaFiscalProduto nfp = notaProdutos.get(i);
            if (id == nfp.getProduto().getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
