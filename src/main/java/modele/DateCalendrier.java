package modele;
import java.util.Calendar;
public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date>{
    private int chJourSem;//1 pour lundi, 2 pour mardi, 3 pou...
    private int chNoSem;
    public DateCalendrier(){
        Calendar today=Calendar.getInstance();
        chAnnee=today.get(Calendar.YEAR);
        chMois=today.get(Calendar.MONTH)+1;
        chJour=today.get(Calendar.DAY_OF_MONTH);
        chJourSem=today.get(Calendar.DAY_OF_WEEK);
        chNoSem=today.get(Calendar.WEEK_OF_YEAR);

        if(chJourSem==Calendar.SUNDAY){
            chJourSem=7;
        } else{
            chJourSem--;
        }
    
    }
    public DateCalendrier(int parJour , int parMois, int parAnnee){
        super(parJour, parMois, parAnnee);

        Calendar date=Calendar.getInstance();
        date.set(parAnnee,parMois-1,parJour);
        chJourSem=date.get(Calendar.DAY_OF_WEEK);
        chNoSem=date.get(Calendar.WEEK_OF_YEAR);

        if(chJourSem==Calendar.SUNDAY){
            chJourSem=7;
        } else{
            chJourSem--;
        }
    }

    public String toString(){
        return super.toString()+","+JOURS_SEMAINE[chJourSem-1];
    }
    public Date dateDuLendemain(){
        return super.dateDuLenDemain();
    }
    public Date dateDeLaVeille(){
        return super.dateDeLaVeille();
    }
    public int getNoSem(){
        return chNoSem;
    }
}