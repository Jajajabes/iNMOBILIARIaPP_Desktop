package model;

public class UserModel {
    private int userId;
    private String userUsername;
    private String userNombre;
    private String userApellido;
    private String userEmail;
    private int userCelular;
    private String userClave;
    private String userFechaNacimiento;

    public UserModel(int userId, String userUsername, String userNombre, String userApellido, String userEmail, int userCelular, String userClave, String userFechaNacimiento) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userNombre = userNombre;
        this.userApellido = userApellido;
        this.userEmail = userEmail;
        this.userCelular = userCelular;
        this.userClave = userClave;
        this.userFechaNacimiento = userFechaNacimiento;
    }

    
    public int getUserId() {
        return userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserApellido() {
        return userApellido;
    }

    public void setUserApellido(String userApellido) {
        this.userApellido = userApellido;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserCelular() {
        return userCelular;
    }

    public void setUserCelular(int userCelular) {
        this.userCelular = userCelular;
    }

    public String getUserClave() {
        return userClave;
    }

    public void setUserClave(String userClave) {
        this.userClave = userClave;
    }

    public String getUserFechaNacimiento() {
        return userFechaNacimiento;
    }

    public void setUserFechaNacimiento(String userFechaNacimiento) {
        this.userFechaNacimiento = userFechaNacimiento;
    }
    
    
}
