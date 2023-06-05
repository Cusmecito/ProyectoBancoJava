import java.util.Scanner;

public class Ejecucion {
    public static int posicion = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int MAX = 2;
        Cuenta [] cta = new Cuenta[MAX];
        menuPrincipal(entrada, cta);
    }

    public static void menuPrincipal(Scanner entrada, Cuenta[] cta) {
        int opcion;
        System.out.println("\n\n MENU PRINCIPAL");
        System.out.println("===================");
        System.out.println("1. APERTURAR CUENTA DE AHORRO");
        System.out.println("2. APERTURAR CUENTA CORRIENTE");
        System.out.println("3. DEPOSITO EN CUENTA DE AHORRO");
        System.out.println("4. DEPOSITO EN CUENTA CORRIENTE");
        System.out.println("5. RETIRAR AHORRO");
        System.out.println("6. RETIRAR CORRIENTE");
        System.out.println("7. CONSULTAR SALDOS DE CUENTAS");
        System.out.println("8. GENERAR INTERES");
        System.out.println("9. SALIR");
        System.out.print("DIGITE LA OPCION: ");
        opcion = entrada.nextInt();
        switch(opcion){
            case 1: crearCuentaAhorro(entrada, cta); menuPrincipal(entrada, cta); break;
            case 2: crearCuentaCorriente(entrada, cta); menuPrincipal(entrada, cta); break;
            case 3: depositarAhorro(cta); menuPrincipal(entrada, cta); break;
            case 4: depositarCorriente(cta); menuPrincipal(entrada, cta); break;
            case 5: retirarAhorro(cta);menuPrincipal(entrada, cta);break;
            case 6: retirarCorriente(cta);menuPrincipal(entrada, cta); break;
            case 7: consultarSaldos(cta); menuPrincipal(entrada, cta); break;
            case 8: generarInteres(cta);menuPrincipal(entrada, cta);break;
            

        }

    }
    
    public static void consultarSaldos(Cuenta[] cta){
        System.out.println("\nREALIZANDO CONSULTA DE DATOS...");
        for(int i=0; i<cta.length;i++){
            System.out.println("Tipo de cuenta: "+cta[i].getClass()+ " Titular: "+cta[i].getTitular()+ " Saldo actual: "+cta[i].getSaldo_actual());
            System.out.println("CONSULTA DE DATOS REALIZADO CORRECTAMENTE..");
        }
    }


    public static void depositarAhorro(Cuenta[] cta){
        Scanner entrada = new Scanner(System.in);
        int posicion = -1; float valor_deposito;
        int numero_cuenta, indice = 0; boolean encontrado = false;
        System.out.println("DEPOSITO DE AHORRO");
        System.out.println("========================");
        System.out.print("INGRESAR NUMERO DE CUENTA: ");
        numero_cuenta = entrada.nextInt();
        while (indice < cta.length && encontrado == false){
            if (cta[indice].getNumero() == numero_cuenta){
                posicion = indice;
                encontrado = true;
            }
            indice++;
        }
        if (encontrado == true){
            System.out.println("TITULAR: " + cta[posicion].getTitular());
            System.out.print("INGRESAR VALOR DEL DEPOSITO: ");
            valor_deposito = entrada.nextFloat();
            cta[posicion].setSaldo_actual(valor_deposito + cta[posicion].getSaldo_actual());
            System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
            System.out.println("\nDEPOSITO REALIZADO CON EXITO...");
        }else{
            System.out.println("\nCUENTA INEXISTENTE...");
        }
    }

    public static void depositarCorriente(Cuenta[] cta){
        Scanner entrada = new Scanner(System.in);
        int posicion = -1; float valor_deposito;
        int num_cuenta, indice = 0; boolean encontrado = false;
        System.out.println("\n===== DEPOSITO DE CUENTA CORRIENTE =====");
        System.out.println("============================");
        System.out.print("INGRESAR NUMERO DE CUENTA: ");
        num_cuenta = entrada.nextInt();
        while (indice < cta.length && encontrado == false){
            if (cta[indice].getNumero() == num_cuenta){
                posicion = indice;
                encontrado = true;
            }
            indice++;
        }
        if (encontrado == true){
            System.out.println("TITULAR: " + cta[posicion].getTitular());
            System.out.print("INGRESAR VALOR DEL DEPOSITO: ");
            valor_deposito = entrada.nextFloat();
            cta[posicion].setSaldo_actual(valor_deposito + cta[posicion].getSaldo_actual());
            System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
            System.out.println("\nDEPOSITO REALIZADO EXITOSAMENTE...");
        }else{
            System.out.println("\nCUENTA INEXISTENTE...");
        }
    }

    public static void crearCuentaAhorro(Scanner entrada, Cuenta[] cta ){
        int dc = -1; int num_cta; String titular_cta; float saldo_actual, ah_meta; char estado;
        int ind = 0;
        do{
            System.out.println("\nCREACION DE CTAS. DE AHORRO");
            System.out.println("===================================");
            System.out.print("INGRESE Nº DE CUENTA: ");
            num_cta = entrada.nextInt();
            System.out.print("INGRESE TITULAR: ");
            titular_cta = entrada.next();
            System.out.print("INGRESE SALDO ACTUAL: ");
            saldo_actual = entrada.nextFloat();
            System.out.print("INGRESE AHORRO META: ");
            ah_meta = entrada.nextFloat();
            estado = 'A';
            cta[ind]= new  Ahorro(num_cta, titular_cta, saldo_actual, estado, ah_meta, ah_meta);
            ind++;
            System.out.println("DATOS GUARDADOS...");
            System.out.print("DIGITE [1] CONTINUAR - DIGITE [2] SALIR: ");
            dc = entrada.nextInt();
            System.out.println(dc);
            System.out.println("GRACIAS POR CONFIMAR...");
        }while (dc == 1);
    }

    public static void crearCuentaCorriente(Scanner entrada, Cuenta[] cta){
        int dc = -1; int num_cta; String titular_cta, of_cred; float saldo_actual; char estado;
        int ind = 0;
        do{
            System.out.println("\nCREACION DE CTAS. DE CORRIENTES");
            System.out.println("===================================");
            System.out.print("INGRESE Nº DE CUENTA: ");
            num_cta = entrada.nextInt();
            System.out.print("INGRESE TITULAR: ");
            titular_cta = entrada.next();
            System.out.print("INGRESE SALDO ACTUAL: ");
            saldo_actual = entrada.nextFloat();
            System.out.print("INGRESE CREDITO OFICIAL: ");
            of_cred = entrada.next();
            estado = 'A';
            cta[ind] = new Corriente(num_cta, titular_cta, saldo_actual, estado, 0, of_cred);
            ind++;
            System.out.println("DATOS GUARDADOS...");
            System.out.println("DIGITE [1] CONTINUAR - DIGITE [2] SALIR: ");
            dc = entrada.nextInt();
            System.out.println(dc);
            System.out.println("GRACIAS POR CONFIRMAR...");
        }while (dc == 1);
    }


    public static void generarInteres(Cuenta[] cta){
        System.out.println("\nGENERANDO INTERES DE LAS CUENTAS...");
        for (int i = 0; i < cta.length; i++){
            System.out.println("TITULAR: " + cta[i].getTitular() + " INTERES: " + cta[i].generarInteres());
            cta[i].setSaldo_actual(cta[i].getSaldo_actual() + cta[i].generarInteres());
            System.out.println("SALO ACTUAL ACTUALIZADO: " + cta[i].getSaldo_actual());
        }
    }

    private static void retirarAhorro(Cuenta[] cta){

        Scanner entrada = new Scanner(System.in); 
        int retiro_deposito, numero_cuenta, indice = 0, posicion = -1; boolean encontrado = false; 
        System.out.println("\n***RETIRO EN LA CUENTA DE AHORRO***");
        System.out.println("-------------------------------------");
        System.out.print("INGRESA EL NUMERO DE LA CUENTA: ");
        numero_cuenta = entrada.nextInt();
        while(indice<cta.length && encontrado == false){
            if(cta[indice].getNumero()==numero_cuenta){
                posicion = indice; 
                encontrado = true; 
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: "+cta[posicion].getTitular());
            System.out.print("INGRESAR EL VALOR QUE VA A RETIRAR:  ");
            retiro_deposito = entrada.nextInt();
            if((retiro_deposito<0)&(retiro_deposito<cta[posicion].getSaldo_actual())|(retiro_deposito<=cta[posicion].getAhorro_Meta())){
                System.out.println("NO SE HA REALIZADO EL RETIRO......");
            }else{
                cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual()-retiro_deposito);
                System.out.println("SALDO : "+cta[posicion].getSaldo_actual());
                System.out.println("\nRETIRO REALIZADO EXITOSAMENTE...");
            }
        }
    }
        

    public static void retirarCorriente(Cuenta[]cta){
        Scanner entrada = new Scanner(System.in);
        int num_Cuenta, indice = 0; boolean encontrado = false; float val_retiro;
        System.out.println("\n***RETIRO EN LA CUENTA CORRIENTE***");
        System.out.println("------------------------------------");
        System.out.print("INGRESE NUMERO DE CUENTA: ");
        num_Cuenta = entrada.nextInt();
        while(indice < cta.length && encontrado == false){
            if(cta[indice].getNumero() == num_Cuenta){
                posicion = indice;
                encontrado = true;
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: " + cta[posicion].getTitular());
            
            if(cta[posicion].getSaldo_actual() < 1000){
                System.out.println("CUENTA INACTIVA, IMPOSIBLE REALIZAR RETIRO...");
                cta[posicion].setEstado('I');
                System.out.println("ESTADO DE CUENTA: " + cta[posicion].getEstado() + " [INACTIVA]");
            }else if(cta[posicion].getSaldo_actual() >= 1000){
                System.out.println("ESTADO DE CUENTA: " + cta[posicion].getEstado() + " [ACTIVA]");
                System.out.print("INGRESE VALOR A RETIRAR: ");
                val_retiro = entrada.nextFloat();
                if(val_retiro <= 0){
                    System.out.println(" IMPOSIBLE RETIRAR UNA CANTIDAD NEGATIVA..."
                        + "NI IGUAL A 0...");
                }else if(val_retiro > cta[posicion].getSaldo_actual()){
                    System.out.println("IMPOSIBLE REALIZAR UN RETIRO DE UNA CANTIDAD MAYOR"
                        + " A LA QUE POSEE EN SU CUENTA...");
                }else if(val_retiro < cta[posicion].getSaldo_actual()){
                    cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual() - val_retiro);
                    System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
                    System.out.println("\nRETIRO REALIZADO EXITOSAMENTE...");
                }
            }
            
        }else{
            System.out.println("\nCUENTA NO EXISTENTE");
        }

    }
}