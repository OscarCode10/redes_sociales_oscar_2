package model.Publicacion;

public class PublicacionVO {
    private int idPublication;
    private String publication;
    private int num;
    
    public PublicacionVO() {
    }
    public PublicacionVO(int idPublication, String publication, int num) {
        this.idPublication = idPublication;
        this.publication = publication;
        this.num = num;
    }
    public int getIdPublication() {
        return idPublication;
    }
    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }
    public String getPublication() {
        return publication;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

}
