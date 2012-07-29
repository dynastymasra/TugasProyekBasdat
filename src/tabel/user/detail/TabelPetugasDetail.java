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
public class TabelPetugasDetail extends AbstractTableModel {

    private List<PetugasDetail> list = new ArrayList<PetugasDetail>();
    
    public int getRowCount() {
        return list.size();
    }
    public int getColumnCount() {
        return 6;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getPetugasCode();
            case 1 : return list.get(rowIndex).getPetugasName();
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
           case 0 : return "Employees Code";
           case 1 : return "Employees Name";
           case 2 : return "Address";
           case 3 : return "City";
           case 4 : return "Phone";
           case 5 : return "Gender";
           default : return null;
       }
   }
   
   public void add(PetugasDetail petugasDetail) {
       list.add(petugasDetail);
       fireTableRowsInserted(getRowCount(), getColumnCount());
   }
   public void delete(int i, int row) {
       list.remove(i);
       fireTableRowsDeleted(i, row);
   }
   public PetugasDetail get(int row) {
       return (PetugasDetail) list.get(row);
   }
}
