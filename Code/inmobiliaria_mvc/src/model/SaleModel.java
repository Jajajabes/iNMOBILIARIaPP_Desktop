package model;

public class SaleModel {
    private int saleId;
    private int saleUsuarioId;
    private int saleMuebleId;
    private String saleFecha;
    
    private String saleMuebleMatricula;
    private String saleUsuarioNombre;
    private String saleUsuarioApellido;
    private int saleUsuarioCel;


    public SaleModel(int saleId, String saleUsuarioNombre, String saleUsuarioApellido, int saleUsuarioCel, String saleFecha, String saleMuebleMatricula) {
        this.saleId = saleId;
        this.saleUsuarioNombre = saleUsuarioNombre;
        this.saleUsuarioApellido = saleUsuarioApellido;
        this.saleUsuarioCel = saleUsuarioCel;
        this.saleFecha = saleFecha;
        this.saleMuebleMatricula = saleMuebleMatricula;
    }
    
    public SaleModel(int saleId, int saleUsuarioId, int saleMuebleId, String saleFecha) {
        this.saleId = saleId;
        this.saleUsuarioId = saleUsuarioId;
        this.saleMuebleId = saleMuebleId;
        this.saleFecha = saleFecha;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getSaleUsuarioId() {
        return saleUsuarioId;
    }

    public int getSaleMuebleId() {
        return saleMuebleId;
    }

    public String getSaleFecha() {
        return saleFecha;
    }

    public void setSaleFecha(String saleFecha) {
        this.saleFecha = saleFecha;
    }

    public String getSaleMuebleMatricula() {
        return saleMuebleMatricula;
    }

    public void setSaleMuebleMatricula(String saleMuebleMatricula) {
        this.saleMuebleMatricula = saleMuebleMatricula;
    }

    public String getSaleUsuarioNombre() {
        return saleUsuarioNombre;
    }

    public void setSaleUsuarioNombre(String saleUsuarioNombre) {
        this.saleUsuarioNombre = saleUsuarioNombre;
    }

    public String getSaleUsuarioApellido() {
        return saleUsuarioApellido;
    }

    public void setSaleUsuarioApellido(String saleUsuarioApellido) {
        this.saleUsuarioApellido = saleUsuarioApellido;
    }

    public int getSaleUsuarioCel() {
        return saleUsuarioCel;
    }

    public void setSaleUsuarioCel(int saleUsuarioCel) {
        this.saleUsuarioCel = saleUsuarioCel;
    }
    
    
    public Object[] toArray(){
        Object[] data = {saleId, saleMuebleMatricula, saleUsuarioNombre, saleUsuarioApellido, saleUsuarioCel, saleFecha};
        return data;
    }
    
    
}
