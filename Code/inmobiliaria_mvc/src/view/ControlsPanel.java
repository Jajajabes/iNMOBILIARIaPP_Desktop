package view;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.SaleModel;
import model.PropertyModel;
import model.UserModel;

/**
 *
 * @author casierrav
 */
public class ControlsPanel extends JPanel {
 
    private JLabel                       lblEnrollment;
    private JComboBox<SaleModel>         cbxSaleList;
    private JLabel                       lblUsers;
    private JComboBox<SaleModel>         cbxUsersList;
    private JLabel                       lblNumberSale;
    private JTextField                   txtNumberSale;
    private JButton                      btnSearch;
    private JButton                      btnAddSale;
    private JTable                       tblResults;
    
   
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();
        
        this.setTblResults(initialData.getAllSales());
        
        /*
        this.cbxSaleList = new JComboBox();
        this.cbxSaleList.setModel(new DefaultComboBoxModel<>(initialData.getAllSales().toArray(new SaleModel[initialData.getAllSales().size()])));
        this.cbxSaleList.setSelectedIndex(0);
        add(this.getCbxSaleList());
*/
        //ChangeEvent changeEvent = new ChangeEvent(this);
        //this.getCbxSaleList().addActionListener(changeEvent);
        

        /*
        this.lblUsers = new JLabel("Usuarios");
        add(this.getLblUsers());
        this.cbxUsersList = new JComboBox();
        //this.setCbxUsersList(initialData.getAllUsers());
        add(this.getCbxUsersList());
        */
        

        this.lblNumberSale = new JLabel("Numero de venta");
        add(this.getLblNumberSale());
        
        this.txtNumberSale = new JTextField();
        add(this.getTxtNumberSale());
        
        

        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        this.btnAddSale = new JButton("Agregar Nueva venta");
        add(this.getBtnAddSale());
        this.getBtnAddSale().addActionListener(clickEvent);
    }

    public JLabel getLblEnrollment() {
        return lblEnrollment;
    }

    public JComboBox getCbxSaleList() {
        return cbxSaleList;
    }


    public JLabel getLblUsers() {
        return lblUsers;
    }

    
    public JComboBox getCbxUsersList() {
        return cbxUsersList;
    }

    
    public JLabel getLblNumberSale() {
        return lblNumberSale;
    }

    
    public JTextField getTxtNumberSale() {
        return txtNumberSale;
    }

   
    public JButton getBtnSearch() {
        return btnSearch;
    }

    
    public JTable getTblResults() {
        return tblResults;
    }
/*
    public void setCbxUsersList(JComboBox<SaleModel> cbxUsersList) {
        this.cbxPresentationsList.setModel(new DefaultComboBoxModel<>(presentations.toArray(new PresentationModel[presentations.size()])));
        this.cbxUsersList.setModel(new DefaultComboBoxModel<>(cbxUsersList.toArray(new UserModel[cbxUsersList.size()])));

        this.getCbxPresentationsList().setSelectedIndex(0);
        
        this.cbxUsersList = cbxUsersList;
    }
*/
    
    
    public void setTblResults(ArrayList<SaleModel> sales) {
        String[] headers = {"NúmeroDeVenta", "Matricula", "NombrePropietario", "ApellidoPropietario", "Contacto", "FechaAdquisicion"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<sales.size(); i++){
            tableModel.addRow(sales.get(i).toArray() );
        }
    }

    
    public JButton getBtnAddSale() {
        return btnAddSale;
    }


}