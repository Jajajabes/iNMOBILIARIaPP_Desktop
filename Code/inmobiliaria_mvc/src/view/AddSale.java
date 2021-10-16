package view;

import access.SaleDAO;
import controller.ClickEvent;
import controller.InitialData;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.SaleModel;
import model.UserModel;
import model.PropertyModel;


public class AddSale extends JFrame implements ActionListener {
    private JLabel                     lblSaleId;
    private JTextField                 txtSaleId;
    private JLabel                     lblUserId;
    private JTextField                 txtUserId;
    private JLabel                     lblPropertyId;
    private JTextField                 txtPropertyId;
    private JLabel                     lblSaleFecha;
    private JTextField                 txtSaleFecha;
    private JButton                    btnInsertSale;
    
    public AddSale(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Ventas inmuebles - Agregar venta");
        setLayout(new GridLayout(8,2));
        InitialData initialData = new InitialData();
        
        this.lblSaleId = new JLabel("ID de la venta");
        add(this.lblSaleId);
        this.txtSaleId = new JTextField();
        add(this.txtSaleId);
        
        
        this.lblUserId = new JLabel("ID del propietario");
        add(this.lblUserId);
        this.txtUserId = new JTextField();
        add(this.txtUserId);
        
        
        this.lblPropertyId = new JLabel("ID del mueble/referencia");
        add(this.lblPropertyId);
        this.txtPropertyId = new JTextField();
        add(this.txtPropertyId);
        
        
        this.lblSaleFecha = new JLabel("Fecha de venta");
        add(this.lblSaleFecha);
        this.txtSaleFecha = new JTextField();
        add(this.txtSaleFecha);
        
        this.btnInsertSale = new JButton("Agregar a BD");
        add(this.btnInsertSale);
        
        this.btnInsertSale.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertSale) {
            int    saleId = Integer.parseInt((String)this.txtSaleId.getText()); 
            int    userId = Integer.parseInt((String)this.txtUserId.getText());
            int    propertyId = Integer.parseInt((String)this.txtPropertyId.getText());
            String fecha = (String)this.txtSaleFecha.getText(); 
            
            SaleModel sale = new SaleModel(saleId, userId, propertyId, fecha);
            
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            SaleDAO saleDAO = new SaleDAO();
            saleDAO.insertSale(sale);
        }
    }
}