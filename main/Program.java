package excecoes.exemplo02.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import excecoes.exemplo02.modelentities.Reservation;

import java.util.Date;

public class Program {
    public static void main(String [] Args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            int num = sc.nextInt();
            System.out.print("Check-in date: (dd/mm/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/mm/yyyy)");
            Date checkOut = sdf.parse(sc.next());

            Reservation res = new Reservation(num,checkIn,checkOut);
            System.out.println(res);

            System.out.println("Enter data to update reservation: ");


            System.out.print("Check-in date: (dd/mm/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/mm/yyyy)");
            checkOut = sdf.parse(sc.next());

            res.updateDates(checkIn, checkOut);

            System.out.println(res);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(IllegalArgumentException e ){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        


        
        sc.close();
    }
}
