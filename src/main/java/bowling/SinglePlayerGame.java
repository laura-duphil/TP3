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
        private int nbTour;
        private int numLancerSpare;  //numéro du lancer du spare
        private int numLancerStrike;  //numéro du lancer du strike
        private boolean premierLancer;   //true si premier lancer d'un tour et false si 2e lancer
        
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            score = 0;
            nbQuillesPrec = 0;
            strike = false;
            spare = false;
            nbTour=0;
            numLancerSpare = 0;
            numLancerStrike = 0;
            premierLancer = true;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            nbTour++;
            if(spare==true){
                score += 2*nombreDeQuillesAbattues;
            }else if(strike==true){
                score += 2*nombreDeQuillesAbattues;
            } else {
                score += nombreDeQuillesAbattues;
            }
            
            if(nombreDeQuillesAbattues==10 && premierLancer==true){
                //Strike
                strike = true;
                spare = false;
                nbTour++;
                numLancerStrike = nbTour;
                
            }else if(nbQuillesPrec+nombreDeQuillesAbattues == 10){
                spare=true;
                numLancerSpare = nbTour;
            }
            if(nbTour > numLancerStrike+1){
                strike = false;
            }
            if(nbTour > numLancerSpare){
                spare = false;
            }
            
            //Déterminer si on est au premier ou 2e tour (pour le prochain lancer
            if(nbTour%2==0 || (nombreDeQuillesAbattues==10 && premierLancer==true)){
                premierLancer = true;
            } else {
               premierLancer = false; 
            }
            nbQuillesPrec = nombreDeQuillesAbattues; //afin de récupérer la valeur pour un éventuel strike ou spare
            //if(nbTour==10 || nbTour==11){
                //lancer(nombreDeQuillesAbattues);
            //}
            
            //S'occuper du cas où le dernier ancer est un spare ou un strike
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
