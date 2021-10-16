package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.UserModel;
import utils.ConnectionDB;

public class UserDAO {
    private Connection conn = null;
    
    
    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> users = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT id, username, nombre, apellido, email, celular, clave, fecha_nacimiento FROM usuario;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                UserModel user = new UserModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6), result.getString(7), result.getString(8));
                users.add(user);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return users;
    }

    

    public ArrayList<UserModel> getUserById(int UserId) {
        ArrayList<UserModel> users = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT id, username, nombre, apellido, email, celular, clave, fecha_nacimiento FROM usuario WHERE id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, UserId);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                UserModel user = new UserModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6), result.getString(7), result.getString(8));
                users.add( user );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return users;
    }
    


    public void insertUser(UserModel user){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO usuario(id, username, nombre, apellido, email, celular, clave, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserUsername());
            statement.setString(3, user.getUserUsername());
            statement.setString(4, user.getUserApellido());
            statement.setString(5, user.getUserEmail());
            statement.setInt(6, user.getUserCelular());
            statement.setString(7, user.getUserClave());
            statement.setString(8, user.getUserFechaNacimiento());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    /**
     * 
     * @param user 
     */
    public void updateUser(UserModel user) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE usuario SET username = ? WHERE id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUserUsername());
            statement.setInt(2, user.getUserId());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }

    
    
    public void deleteUser(int id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM usuario WHERE id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
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
