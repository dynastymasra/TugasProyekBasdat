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
public class TabelUserDetail extends AbstractTableModel {

    private List<UserDetail> list = new ArrayList<UserDetail>();
    
    public int getRowCount() {
        return list.size();
    }
    public int getColumnCount() {
        return 10;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getGoodsCode();
            case 1 : return list.get(rowIndex).getGoodsName();
            case 2 : return list.get(rowIndex).getStockMax();
            case 3 : return list.get(rowIndex).getStockMin();
            case 4 : return list.get(rowIndex).getPrice();
            case 5 : return list.get(rowIndex).getSell();
            case 6 : return list.get(rowIndex).getStock();
            case 7 : return list.get(rowIndex).getUnit();
            case 8 : return list.get(rowIndex).getDiscount();
            case 9 : return list.get(rowIndex).getPpn();
            default: return null;
        }
    }
    
   @Override
   public String getColumnName(int column) {
       switch(column) {
           case 0 : return "Goods Code";
           case 1 : return "Goods Name";
           case 2 : return "Stock Max";
           case 3 : return "Stock Min";
           case 4 : return "Price";
           case 5 : return "Sell";
           case 6 : return "Stock";
           case 7 : return "Unit";
           case 8 : return "Discount(%)";
           case 9 : return "PPn(%)";
           default : return null;
       }
   }
   
   public void add(UserDetail userDetail) {
       list.add(userDetail);
       fireTableRowsInserted(getRowCount(), getColumnCount());
   }
   public void delete(int i, int row) {
       list.remove(i);
       fireTableRowsDeleted(i, row);
   }
   public UserDetail get(int row) {
       return (UserDetail) list.get(row);
   }
}
