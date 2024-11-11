/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.User;

/**
 *
 * @author vldmrk
 */
public class ModelTabeleUseri extends AbstractTableModel {

    private final List<User> useri;
    private final String[] kolone = {"ID", "username"};

    public ModelTabeleUseri(List<User> useri) {
        this.useri = useri;
    }

    public List<User> getUseri() {
        return useri;
    }

    @Override
    public int getRowCount() {
        return useri.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return useri.get(rowIndex).getId();
            }
            case 1 -> {
                return useri.get(rowIndex).getUser();
            }
            default ->
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
