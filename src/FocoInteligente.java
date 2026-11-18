public class FocoInteligente implements Controlable{

    private boolean encendida;

    public FocoInteligente(){
        this.encendida = false;
    }

    @Override
    public void ejecutarAccion(String comando) {

        if(comando.equalsIgnoreCase("Encender")){

            encendida = true;
            System.out.println("Foco Encendido");
        }else if(comando.equalsIgnoreCase("Apagar")){

            encendida = false;
            System.out.println("Foco Apagado");

        }
    }
}
