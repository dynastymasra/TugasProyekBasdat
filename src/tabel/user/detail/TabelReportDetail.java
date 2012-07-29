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
public class TabelReportDetail extends AbstractTableModel {

    private List<ReportDetail> list = new ArrayList<ReportDetail>();
    
    public int getRowCount() {
        return list.size();
    }
    public int getColumnCount() {
        return 4;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getNumber();
            case 1 : return list.get(rowIndex).getDate();
            case 2 : return list.get(rowIndex).getDebit();
            case 3 : return list.get(rowIndex).getKredit();
            default: return null;
        }
    }
    
   @Override
   public String getColumnName(int column) {
       switch(column) {
           case 0 : return "Number Cash";
           case 1 : return "Date";
           case 2 : return "Debit";
           case 3 : return "Kredit";
           default : return null;
       }
   }
   
   public void add(ReportDetail reportDetail) {
       list.add(reportDetail);
       fireTableRowsInserted(getRowCount(), getColumnCount());
   }
   public void delete(int i, int row) {
       list.remove(i);
       fireTableRowsDeleted(i, row);
   }
   public ReportDetail get(int row) {
       return (ReportDetail) list.get(row);
   }
}
