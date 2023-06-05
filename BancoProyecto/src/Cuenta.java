abstract public class Cuenta{
    private int numero;
    private String titular;
    private float saldo_actual;
    private char estado;
    private float Ahorro_Meta;

    
    public Cuenta(int numero, String titular, float saldo_actual, char estado, float ahorro_Meta) {
        this.numero = numero;
        this.titular = titular;
        this.saldo_actual = saldo_actual;
        this.estado = estado;
        Ahorro_Meta = ahorro_Meta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(float saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public float getAhorro_Meta() {
        return Ahorro_Meta;
    }

    public void setAhorro_Meta(float ahorro_Meta) {
        Ahorro_Meta = ahorro_Meta;
    }



    public void mostrar_Cuenta(){
        System.out.println("NUMERO CITA:" + this.getNumero());
        System.out.println("TITULAR DE LA CUENTA:" + this.getTitular());
        System.out.println("SALDO DE LA CUENTA:" + this.getEstado());
        System.out.println("ESTADO DE LA CUENTA:" + this.getEstado());
    }
    
    abstract public float generarInteres();
    
    
}