package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.SaleModel;
import utils.ConnectionDB;

public class SaleDAO {
    
    
     private Connection conn = null;
    
    
     //todas las propiedades
    public ArrayList<SaleModel> getAllSales() {
        ArrayList<SaleModel> sales = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT venta.id, usuario.nombre, usuario.apellido, usuario.celular, venta.fecha, inmueble.matricula_inmobiliaria FROM venta JOIN usuario ON usuario.id = usuario_id JOIN inmueble ON inmueble.id = venta.inmueble_id ORDER BY venta.id ASC;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                SaleModel sale = new SaleModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6));
                sales.add(sale);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return sales;
    }
    
    //consultar ventas por nombre de usuario
    public ArrayList<SaleModel> getSalesByUser(String usuarioNombre) {
        ArrayList<SaleModel> sales = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT venta.id, usuario.nombre, usuario.apellido, usuario.celular,venta.fecha, inmueble.matricula_inmobiliaria FROM venta JOIN usuario ON usuario.id = usuario_id JOIN inmueble ON inmueble.id = venta.inmueble_id WHERE usuario.nombre = '?' ORDER BY venta.id ASC;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuarioNombre);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                SaleModel sale = new SaleModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6));
                sales.add(sale);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return sales;
    }
    
    //consultar venta por id
    public SaleModel getSaleById(int saleId) {
        SaleModel sale = null;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT venta.id, usuario.nombre, usuario.apellido, usuario.celular,venta.fecha, inmueble.matricula_inmobiliaria FROM venta JOIN usuario ON usuario.id = usuario_id JOIN inmueble ON inmueble.id = venta.inmueble_id WHERE venta.id = ? ORDER BY venta.id ASC;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, saleId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                sale = new SaleModel(saleId, result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6));
                break;
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return sale;
    }
    
    //Obtener ventas por matricula inmobiliaria
    public ArrayList<SaleModel> getSalesByEnrollment(String matriculaInmueble) {
        ArrayList<SaleModel> sales = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT venta.id, usuario.nombre, usuario.apellido, usuario.celular,venta.fecha, inmueble.matricula_inmobiliaria FROM venta JOIN usuario ON usuario.id = usuario_id JOIN inmueble ON inmueble.id = venta.inmueble_id WHERE inmueble.matricula_inmobiliaria = '?' ORDER BY venta.id ASC;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, matriculaInmueble);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                SaleModel sale = new SaleModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6));
                sales.add(sale);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return sales;
    }

    
    //Insertar una venta nueva
    public void insertSale(SaleModel sale){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO venta VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, sale.getSaleId());
            statement.setInt(2, sale.getSaleUsuarioId());
            statement.setInt(3, sale.getSaleMuebleId());
            statement.setString(4, sale.getSaleFecha());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    //Actualizar la fecha de una venta desde su id
    public void updateSale(SaleModel sale) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE venta SET fecha = '?' WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, sale.getSaleFecha());
            statement.setInt(2, sale.getSaleId());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }

    
    //Borrar una venta desde su id
    public void deleteSale(int SaleId) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM venta WHERE id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, SaleId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
    
    
}
