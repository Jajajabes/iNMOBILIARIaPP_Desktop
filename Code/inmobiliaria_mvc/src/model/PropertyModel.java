package model;

public class PropertyModel {
    private int proId;
    private String proMatricula;
    
    public PropertyModel(int proid, String proMatricula){
        this.proId = proid;
        this.proMatricula = proMatricula;
    }
    
    
    public int getProId() {
        return proId;
    }

    public String getProMatricula() {
        return proMatricula;
    }
    
    
    public void setProMatricula(String proMatricula) {
        this.proMatricula = proMatricula;
    }
    
}
