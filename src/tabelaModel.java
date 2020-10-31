package src;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class tabelaModel extends AbstractTableModel{

	private int line;
	
    private List<informacao> dados = new ArrayList<>();
    private String[] colum = {"Codigo","Palavra"};


    @Override
    public String getColumnName(int column) {
        return colum[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colum.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch(coluna){
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getTermo();
        }

        return null;

    }

    public void addRow(informacao p){
    	line++;
        this.dados.add(p);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha){
    	line--;
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public void clearTable() {
        int size = getRowCount();
        this.dados.clear();
        fireTableRowsDeleted(0,size);
    }
    
    public int getLines() {
        return this.line;
    }

}