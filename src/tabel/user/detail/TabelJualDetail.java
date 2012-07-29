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
public class TabelJualDetail extends AbstractTableModel {

    private List<JualDetail> list = new ArrayList<JualDetail>();
    
    public int getRowCount() {
        return list.size();
    }
    public int getColumnCount() {
        return 7;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getNumber();
            case 1 : return list.get(rowIndex).getGoodsCode();
            case 2 : return list.get(rowIndex).getGoodsName();
            case 3 : return list.get(rowIndex).getPrice();
            case 4 : return list.get(rowIndex).getDiscount();
            case 5 : return list.get(rowIndex).getPpn();
            case 6 : return list.get(rowIndex).getTotal();
            default: return null;
        }
    }
    
   @Override
   public String getColumnName(int column) {
       switch(column) {
           case 0 : return "No Invoice";
           case 1 : return "Goods Code";
           case 2 : return "Goods Name";
           case 3 : return "Sell Price";
           case 4 : return "Discount";
           case 5 : return "PPn";
           case 6 : return "Total";
           default : return null;
       }
   }
   
   public void add(JualDetail jualDetail) {
       list.add(jualDetail);
       fireTableRowsInserted(getRowCount(), getColumnCount());
   }
   public void delete(int i, int row) {
       list.remove(i);
       fireTableRowsDeleted(i, row);
   }
   public JualDetail get(int row) {
       return (JualDetail) list.get(row);
   }
}
