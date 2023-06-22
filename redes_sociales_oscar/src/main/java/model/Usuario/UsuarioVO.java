package model.Usuario;

public class UsuarioVO {
    private int idUsuario;
    private String tipoDoc;
    private int numDoc;
    private String nombre;
    private String correo;
    private String pswd;
    private String estado;

    public UsuarioVO() {
    }
    public UsuarioVO(int idUsuario, String tipoDoc, int numDoc, String nombre, String correo, String pswd,
            String estado) {
        this.idUsuario = idUsuario;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.correo = correo;
        this.pswd = pswd;
        this.estado = estado;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getTipoDoc() {
        return tipoDoc;
    }
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    public int getNumDoc() {
        return numDoc;
    }
    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPswd() {
        return pswd;
    }
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
