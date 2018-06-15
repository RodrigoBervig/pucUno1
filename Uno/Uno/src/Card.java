/**
 * Essa classe implementa uma carta de UNO.
 */
public class Card
{
    private int cor;
	private int valor;
	private int valorEsp;
	private boolean special;

	/*
	    Cores:
	        0 - No color (specials)
	        1 - Red
	        2 - Green
	        3 - Blue
	        4 - Yellow

	    Valor especial:
	        0 - Pula
	        1 - Retorno
	        2 - Compra 2
	        3 - Coringa (sem cor a priori)
	        4 - Compra 4 (sem cor a priori)

	 */

    /**
     * Construtor padrão de carta.
     * @param valor valor (inteiro) da carta
     * @param cor   a cor da carta (inteiro).
     */
	public Card(int valor, int cor, boolean special) {
		setSpecial(special);
		setCor(cor);

		if (special) {
            setValorEsp(valor);
            this.valor = -1;
        }
        else {
            setValor(valor);
            this.valorEsp = -1;
        }
	}

    private void setCor(int cor) {
        if(cor >= 0 && cor <= 4)
            this.cor = cor;
    }

    private void setValor(int valor){
        if(valor >= 0 && valor <=9) this.valor = valor;
    }

    private void setValorEsp(int valorEsp) {
        if(valorEsp >= 0 && valorEsp <= 4) this.valorEsp = valorEsp;
    }

    private void setSpecial(boolean special){
	    this.special = special;
    }

    /** Retorna a cor da carta*/
    public int getColor(){
	    return this.cor;
	}

	public String getColorString()
    {
        switch(this.cor)
        {
            case 1: return "red";
            case 2: return "gre";
            case 3: return "blu";
            case 4: return "yel";
            default: return "   ";
        }
    }

	/** Retorna o valor da Carta*/
	public int getValue(){
	    if(special) return this.valorEsp;
        return this.valor;
	}

	public String getValueString()
    {
        StringBuilder sb = new StringBuilder();
        if(special)
            if (valorEsp == 2 || valorEsp == 4) sb.append("+").append(valorEsp).append(" ");
            else sb.append(" ").append(valorEsp).append(" ");
        else sb.append(" ").append(valor).append(" ");

        return sb.toString();
    }

    /** Método que checa se a carta é especial. True se for; False se não for. */
    public boolean isSpecial() { //Como se fosse getSpecial()
        return special;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

		sb.append(" ----- \n");
		sb.append("| ").append(this.getColorString()).append(" |").append(" \n");
        sb.append("| ").append(this.getValueString()).append(" |").append(" \n");
		sb.append(" ----- \n");

		return sb.toString();
	}
}
