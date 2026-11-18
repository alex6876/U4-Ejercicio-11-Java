public class Main {

    public static void main(String[] args) {

        HubCentral hub = new HubCentral();

        FocoInteligente foco = new FocoInteligente();

        AireAcondicionado aire = new AireAcondicionado();

        PersianaMotorizada persiana = new PersianaMotorizada();


        hub.agregarDispositivo(foco);

        hub.agregarDispositivo(aire);

        hub.agregarDispositivo(persiana);


        hub.enviarComando("ENCENDER");

        hub.enviarComando("BAJAR");

        hub.enviarComando("ABRIR");

        hub.enviarComando("APAGAR");

        hub.enviarComando("CERRAR");
    }
}