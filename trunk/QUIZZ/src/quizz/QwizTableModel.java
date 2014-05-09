/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mama
 */
public class QwizTableModel extends AbstractTableModel
{
    private final String[] columnNames;
    private final  Object[][] data;

   
    @Override
    public int getRowCount()
    {
        return data.length;
    }

    @Override
    public int getColumnCount()
    {        
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return this.data[rowIndex][columnIndex];
    }
    
    @Override
     public void setValueAt(Object value, int row, int col)
     {
         this.data[row][col] = value;
         fireTableCellUpdated(row, col);
         //fireTableStructureChanged();
     }
     
     
    @Override
     public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    
     
     QwizTableModel(int nb)
     { 
        columnNames = new String[]{"Nom", "Thème", "Difficulté", "Date Création", "id qwizz"};
        data = new Object[nb][5];
     }
}
