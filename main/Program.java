package excecoes.exemplo02.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import excecoes.exemplo02.modelentities.Reservation;

import java.util.Date;

public class Program {
    public static void main(String [] Args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int num = sc.nextInt();
        System.out.print("Check-in date: (dd/mm/yyyy)");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date: (dd/mm/yyyy)");
        Date checkOut = sdf.parse(sc.next());
        if(!checkOut.after(checkIn)){ // se lê : ! = não. Se checkout não for depois de checkin faça
            System.out.print("Check-out date must be after check-in date!");
        }else{
            Reservation res = new Reservation(num,checkIn,checkOut);
            System.out.println(res);

            System.out.println("Enter data to update reservation: ");
            
            
            System.out.print("Check-in date: (dd/mm/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/mm/yyyy)");
            checkOut = sdf.parse(sc.next());

            String error = res.updateDates(checkIn, checkOut);
            if(error != null){
                System.err.print("Error in reservation: " + error);
            }
            else{
                System.out.println(res);
            }
            
        }


        
        sc.close();
    }
}
