package dao;

public class Ventilador {
 
    //criamos as vari�veis de instancia normalmente
    float preco;
    EnumTamanho tamanho;
 
    //criamos o enum
    enum EnumTamanho{
        //criamos as constantes do enum passando os detalhes
        PEQUENO("Di�metro: 20 cm"),
        MEDIO("Di�metro: 30 cm"),
        GRANDE("Di�metro: 45 cm");
 
        //construtor do enum recebendo a String tamanho
        EnumTamanho(String tamanho){
            this.tamanhoDetalhado = tamanho;
        }
 
        //criamos uma vari�vel para armazenar detalhes sobre o tamanho
        private String tamanhoDetalhado;
 
        //seu m�todo get normalmente
        public String getTamanhoDetalhado() {
            return tamanhoDetalhado;
        }
    }
 
    //vamos testar nosso enum com o m�todo main
    public static void main(String[] args) {
        Ventilador ventilador = new Ventilador();
        ventilador.preco = 80.50f; //usa se o f por causa do ponto flutuante
        ventilador.tamanho = EnumTamanho.PEQUENO;
 
        System.out.println("Pre�o do ventilador: " + ventilador.preco);
        System.out.println("Tamanho do ventilador: " + ventilador.tamanho.getTamanhoDetalhado());
 
    }
}