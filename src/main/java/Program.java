import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd" );

    public static void main(String[] args) {

        boolean wyj= false;
        Kot mruczek = new Kot();

        System.out.print("Podaj imię kota: ");
        mruczek.setImie(getUserInput());


        System.out.print("Podaj, kto jest opiekunem kota: ");
        mruczek.setImieOpiekuna(getUserInput());

        Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");

        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            String date = getUserInput();
            if (wzorzecDaty.matcher(date).matches()) {
                try {
                    mruczek.setDataUrodzenia(sdf.parse(date));
                } catch (ParseException pe) {
                    System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
                }
            }
        } while (mruczek.getDataUrodzenia()==null);

        Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String waga;

        do {
            System.out.print("Podaj dokładną datę wagę kota: ");
            waga = getUserInput();

            if (wzorzecWagi.matcher(waga).matches()) {
                mruczek.setWaga(Float.valueOf(waga));
            }
        } while (mruczek.getWaga() == null);

        System.out.println("Dziękuję, teraz już wiem wszystko o kocie!");

        System.out.println(mruczek.przedstawSie());

    }

    public static String getUserInput() {
        return sc.nextLine().trim();
    }

}
