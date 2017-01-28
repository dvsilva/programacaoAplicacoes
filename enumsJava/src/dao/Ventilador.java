package dao;

public class Ventilador {
 
    //criamos as variáveis de instancia normalmente
    float preco;
    EnumTamanho tamanho;
 
    //criamos o enum
    enum EnumTamanho{
        //criamos as constantes do enum passando os detalhes
        PEQUENO("Diâmetro: 20 cm"),
        MEDIO("Diâmetro: 30 cm"),
        GRANDE("Diâmetro: 45 cm");
 
        //construtor do enum recebendo a String tamanho
        EnumTamanho(String tamanho){
            this.tamanhoDetalhado = tamanho;
        }
 
        //criamos uma variável para armazenar detalhes sobre o tamanho
        private String tamanhoDetalhado;
 
        //seu método get normalmente
        public String getTamanhoDetalhado() {
            return tamanhoDetalhado;
        }
    }
 
    //vamos testar nosso enum com o método main
    public static void main(String[] args) {
        Ventilador ventilador = new Ventilador();
        ventilador.preco = 80.50f; //usa se o f por causa do ponto flutuante
        ventilador.tamanho = EnumTamanho.PEQUENO;
 
        System.out.println("Preço do ventilador: " + ventilador.preco);
        System.out.println("Tamanho do ventilador: " + ventilador.tamanho.getTamanhoDetalhado());
 
    }
}