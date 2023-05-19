package Modelo;

public class CClientes {
    protected String nombre_cliente;
    protected String rut_clientte;
    protected int ventas;
    protected String correo;
    public CClientes() {
    }

    public CClientes(String nombre_cliente, String rut_clientte, int ventas,String correo) {
        this.nombre_cliente = nombre_cliente;
        this.rut_clientte = rut_clientte;
        this.ventas = ventas;
        this.correo=correo;
    }

    public String getnombre_cliente() {
        return nombre_cliente;
    }

    public void setnombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getrut_clientte() {
        return rut_clientte;
    }

    public void setrut_clientte(String rut_clientte) {
        this.rut_clientte = rut_clientte;
    }

    public int getventa() {
        return ventas;
    }

    public void setventa(int ventas) {
        this.ventas = ventas;
    }   
    
    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

}
