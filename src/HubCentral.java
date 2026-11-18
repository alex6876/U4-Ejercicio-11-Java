import java.util.ArrayList;

public class HubCentral {

    private ArrayList<Controlable> dispositivos = new ArrayList<>();

    public void agregarDispositivo(Controlable dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void enviarComando(String comando) {
        System.out.println("===== ENVIANDO COMANDO: " + comando + " =====");

        for (Controlable dispositivo : dispositivos) {
            dispositivo.ejecutarAccion(comando);
        }
    }
}
