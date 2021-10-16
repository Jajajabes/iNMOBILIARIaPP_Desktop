package controller;


import java.util.ArrayList;
import access.PropertyDAO;
import model.PropertyModel;
import access.UserDAO;
import model.UserModel;
import access.SaleDAO;
import model.SaleModel;


/**
 *
 * @author casierrav
 */
public class InitialData {
    private ArrayList<PropertyModel>       Propertys       = null;
    private ArrayList<PropertyModel>   Enrollments   = null;
    private ArrayList<UserModel> Users = null;
    private ArrayList<SaleModel>     Sales = null;
    
    /**
     * Zero-parameters constructor
     */
    public InitialData(){
        PropertyDAO propertyDAO = new PropertyDAO();
        this.Propertys = propertyDAO.getAllPropertys();
        this.Propertys.add(0, new PropertyModel(-1, "Todas las propiedades"));
        
        UserDAO userDAO = new UserDAO();
        this.Users = userDAO.getAllUsers();
        this.Users.add(0, new UserModel(-1, "Todos los usuarios", "Todos los usuarios", "Todos los usuarios", "Todos los usuarios", -1, "Todos los usuarios", "Todos los usuarios"));
        
        SaleDAO saleDAO = new SaleDAO();
        this.Sales = saleDAO.getAllSales();
    }
    
    public ArrayList<PropertyModel> getPropertyEnrollment() {
        return Enrollments;
    }

    public ArrayList<PropertyModel> getAllPropertys() {
        return Propertys;
    }



    public ArrayList<UserModel> getAllUsers() {
        return Users;
    }


    public ArrayList<SaleModel> getAllSales() {
        return Sales;
    }

}