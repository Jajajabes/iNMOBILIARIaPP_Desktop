package controller;

import access.PropertyDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.PropertyModel;
import access.SaleDAO;
import model.SaleModel;
import view.ControlsPanel;

/**
 *
 * @author casierrav
 */
public class ChangeEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    
    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getCbxSaleList()) {
            SaleDAO saleDAO = new SaleDAO();
            ArrayList<SaleModel> sales = null;
            int sale     = ((SaleModel)this.controlsPanel.getCbxSaleList().getSelectedItem()).getSaleId();
            if(sale == -1) {
                sales = saleDAO.getAllSales();
                sales.add(0, new SaleModel(-1, -1, -1, "Todas las presentaciones"));
            }
            else {
                sales = saleDAO.getAllSales();
                sales.add(0, new SaleModel(-1, -1, -1, "Todas las presentaciones"));
            }
            this.controlsPanel.setTblResults(sales);
        }
    }
    
}