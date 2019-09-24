package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        // score courant du joueur
	private int score;
	private int nbQuillesPrec; //score précédent du joueur. ex : 8
	//private int nbQuillesPrec2; //
        private boolean strike;  //true si il y a eu un strike
        private boolean spare;  //true si il y a eu un spare
        private int nbLancer;
        private int numLancerSpare;  //numéro du lancer du spare
        private int numLancerStrike;  //numéro du lancer du strike
        
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            score = 0;
            nbQuillesPrec = 0;
            strike = false;
            spare = false;
            nbLancer=0;
            numLancerSpare = 0;
            numLancerStrike = 0;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            nbLancer++;
            if(spare==true){
                score += 2*nombreDeQuillesAbattues;
            }else if(strike==true){
                score += 2*nombreDeQuillesAbattues;
            } else {
                score += nombreDeQuillesAbattues;
            }
            
            if(nombreDeQuillesAbattues==10){
                strike = true;
                spare = false;
                numLancerStrike = nbLancer;
            }else if(nbQuillesPrec+nombreDeQuillesAbattues == 10){
                spare=true;
                numLancerSpare = nbLancer;
            }
            if(numLancerStrike>nbLancer+2){
                strike = false;
            }
            if(numLancerSpare>nbLancer+1){
                spare = false;
            }
            nbQuillesPrec = nombreDeQuillesAbattues; //afin de récupérer la valeur pour un éventuel strike ou spare
            //if(nbLancer==10 || nbLancer==11){
                //lancer(nombreDeQuillesAbattues);
            //}
        }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            if(score<0 || score>300){
		throw new UnsupportedOperationException("Pas encore implémenté");
            }
            return score;
	}
}
