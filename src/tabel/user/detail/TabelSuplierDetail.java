/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel.user.detail;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Dynastymasra
 */
public class TabelSuplierDetail extends AbstractTableModel {

    private List<SuplierDetail> list = new ArrayList<SuplierDetail>();
    
    public int getRowCount() {
        return list.size();
    }
    public int getColumnCount() {
        return 6;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getSuplierCode();
            case 1 : return list.get(rowIndex).getSuplierName();
            case 2 : return list.get(rowIndex).getAddress();
            case 3 : return list.get(rowIndex).getCity();
            case 4 : return list.get(rowIndex).getPhone();
            case 5 : return list.get(rowIndex).getGender();
            default: return null;
        }
    }
    
   @Override
   public String getColumnName(int column) {
       switch(column) {
           case 0 : return "Suplier Code";
           case 1 : return "Suplier Name";
           case 2 : return "Address";
           case 3 : return "City";
           case 4 : return "Phone";
           case 5 : return "Gender";
           default : return null;
       }
   }
   
   public void add(SuplierDetail suplierDetail) {
       list.add(suplierDetail);
       fireTableRowsInserted(getRowCount(), getColumnCount());
   }
   public void delete(int i, int row) {
       list.remove(i);
       fireTableRowsDeleted(i, row);
   }
   public SuplierDetail get(int row) {
       return (SuplierDetail) list.get(row);
   }
}
