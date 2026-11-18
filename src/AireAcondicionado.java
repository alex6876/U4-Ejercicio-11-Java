public class AireAcondicionado implements Controlable {

    private boolean encendido;
    private int temperatura;

    public AireAcondicionado() {
        this.encendido = false;
        this.temperatura = 24;
    }

    @Override
    public void ejecutarAccion(String comando) {

        if (comando.equalsIgnoreCase("ENCENDER")) {

            encendido = true;
            System.out.println("Aire acondicionado encendido.");

        } else if (comando.equalsIgnoreCase("APAGAR")) {

            encendido = false;
            System.out.println("Aire acondicionado apagado.");

        } else if (comando.equalsIgnoreCase("SUBIR")) {

            temperatura++;
            System.out.println("Temperatura aumentada a " + temperatura + " grados.");

        } else if (comando.equalsIgnoreCase("BAJAR")) {

            temperatura--;
            System.out.println("Temperatura reducida a " + temperatura + " grados.");

        } else {

            System.out.println("Comando no reconocido para el aire acondicionado.");
        }
    }
}