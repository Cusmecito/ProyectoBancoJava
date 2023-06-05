public class Corriente extends Cuenta {
    private String credito_Oficial;
    
    public Corriente(int numero, String titular, float saldo_actual, char estado, float ahorro_Meta,
            String credito_Oficial) {
        super(numero, titular, saldo_actual, estado, ahorro_Meta);
        this.credito_Oficial = credito_Oficial;
    }
    
    public String getCredito_Oficial() {
        return credito_Oficial;
    }
    public void setCredito_Oficial(String credito_Oficial) {
        this.credito_Oficial = credito_Oficial;
    }
    public void mostrar(){
        super.mostrar_Cuenta();
        System.out.println("CREDITO OFICIAL: " + this.getCredito_Oficial());
    }

    public float generarInteres(){
        float valor_interes;
        valor_interes = this.getSaldo_actual() * 0.08f / 100;
        return valor_interes;
    }
}
