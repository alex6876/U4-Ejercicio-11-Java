public class PersianaMotorizada implements Controlable {

    private int apertura;

    public PersianaMotorizada() {
        this.apertura = 0;
    }

    @Override
    public void ejecutarAccion(String comando) {

        if (comando.equalsIgnoreCase("ABRIR")) {

            apertura = 100;
            System.out.println("Persiana completamente abierta.");

        } else if (comando.equalsIgnoreCase("CERRAR")) {

            apertura = 0;
            System.out.println("Persiana completamente cerrada.");

        } else {

            System.out.println("Comando no reconocido para la persiana.");
        }
    }
}