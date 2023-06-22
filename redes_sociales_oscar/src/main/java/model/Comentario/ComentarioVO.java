package model.Comentario;

public class ComentarioVO {
    private int idComents;
    private String coments;
    private int num;
    
    public ComentarioVO() {
    }
    public ComentarioVO(int idComents, String coments, int num) {
        this.idComents = idComents;
        this.coments = coments;
        this.num = num;
    }
    public int getIdComents() {
        return idComents;
    }
    public String getComents() {
        return coments;
    }
    public int getNum() {
        return num;
    }
    public void setIdComents(int idComents) {
        this.idComents = idComents;
    }
    public void setComents(String coments) {
        this.coments = coments;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
