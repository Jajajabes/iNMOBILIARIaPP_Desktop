package controller;

import access.SaleDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.SaleModel;
import model.PropertyModel;
import model.UserModel;
import view.AddSale;
import view.ControlsPanel;


public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            int idSale            = ((SaleModel)this.controlsPanel.getCbxSaleList().getSelectedItem()).getSaleId();
            int idUser      = ((UserModel)this.controlsPanel.getCbxUsersList().getSelectedItem()).getUserId();
            String idSalee     = (String)this.controlsPanel.getTxtNumberSale().getText();
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            SaleDAO saleDAO = new SaleDAO();
            ArrayList<SaleModel> sales = saleDAO.getAllSales();
            
            this.controlsPanel.setTblResults(sales);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddSale()) {
            AddSale addSaleView = new AddSale();
            addSaleView.setVisible(true);
    }   }
}