/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import DAO.UsuarioDAO;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danilo.asilv10
 */
public class UsuarioTableModel extends AbstractTableModel{
    private List<Usuario> dados = new ArrayList<>();
    private String[] colunas = {"Nome", "Login", "Senha", "Tipo"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getLogin();
            case 2:
                return dados.get(linha).getSenhaHash();
            case 3:
                return dados.get(linha).getTipo();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setNome((String) valor);
                break;
            case 1:
                dados.get(linha).setLogin((String) valor);
                break;
            case 2:
                dados.get(linha).setSenhaHash((String) valor);
                break;
            case 3:
                dados.get(linha).setTipo((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Usuario u) {
        this.dados.add(u);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Usuario pegaDadosLinha(int linha) {
        return dados.get(linha);
    }

    private void lerDados() {
        UsuarioDAO udao = new UsuarioDAO();

        for (Usuario u : udao.read()) {
            this.addLinha(u);
        }

        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
}
