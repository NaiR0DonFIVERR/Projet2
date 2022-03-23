package modele;

public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;
    
    public Date(){
        
    }

    public Date(int parJour, int parMois, int parAnnee){
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee; 
    }

    public String toString() {
        return chJour + "/" + chMois + "/" + chAnnee;
    }

    public static Boolean estBissextile(int parAnnee){
        return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
    }

    public static int dernierJourDuMois(int parMois, int parAnnee){

        switch(parMois){
            case 2:
                if (estBissextile(parAnnee)){
                    return 29;
                }
                else {       
                    return 28;
                }

            case 4 : case 6 : case 9 : case 11 : return 30;
            
            default : return 31;
            
        }
    }

    public Boolean estValide() {
        if (chMois > 13 || chMois < 0) { 
            return false;
        }
        else if (chAnnee > 1583) {
            return false;
        }
        else if (chJour < 0 || chJour > dernierJourDuMois(chMois, chAnnee)) {
            return false;
        }
        return true;
        }
        
        /*public static Date lireDate(){
            System.out.println("Entrez un Jour");
            int jour = Clavier.lireInt();
            System.out.println("Entrez un Mois");
            int mois = Clavier.lireInt();
            System.out.println("Entrez une Annee");
            int annee = Clavier.lireInt();
            return new Date(jour, mois, annee);
        }*/
        public int compareTo(Date parDate){
            if(chAnnee < parDate.chAnnee || chMois < parDate.chMois || chJour < parDate.chJour) {
                return -1;
            } else if(chAnnee > parDate.chAnnee || chMois > parDate.chMois || chJour > parDate.chJour) {
                return 1;
            } else{
                return 0;
            }
        }
        public Date dateDuLenDemain(){
            int lastday = dernierJourDuMois(chMois, chAnnee);
            int nextDay = chJour + 1;
            int nextMonth = chMois + 1;
            int nextYear = chAnnee + 1;

            if (nextDay > lastday){
                if(chMois == 12){
                    return new Date(1,1,nextYear);
                }else{
                return new Date(1, nextMonth, chAnnee);
                }
            } else {
                return new Date(nextDay, chMois, chAnnee);
            }
        }
        public Date dateDeLaVeille(){
            int lastday = dernierJourDuMois(chMois, chAnnee);
            int yesterday = chJour - 1;
            int lastMonth = chMois - 1;
            int lastYear = chAnnee - 1;

            if (yesterday <= 0){
                if(chMois == 1){
                    return new Date(31,12,lastYear);
                }else{
                return new Date(lastday, lastMonth, chAnnee);
                }
            } else {
                return new Date(yesterday, chMois, chAnnee);
            }
        }
}