import com.example.diplomat.dijoo.Dijoo;

/**
 * Created by Diplomat on 3/13/2016.
 */
public class DijooDates {

    public String checkInDate;
    public int dijooValue;


    public DijooDates(){
    }

    public DijooDates(String date, int value){
        this.checkInDate = date;
        this.dijooValue = value;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public int getDijooValue() {
        return dijooValue;
    }


}
