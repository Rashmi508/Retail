package sr.unasat.retailShop.designpatterns.factory;

import java.util.Scanner;

public class MerkFactory {

    public void  chooseBedBrandScanner() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which brand do you want?  ");
        System.out.println("Sealy, Sierra or Serta");

        String merk = scanner.nextLine();

        if (merk.equalsIgnoreCase("Sealy")) {
            new Sealy().merk();
            new Sealy().prijs();
        }

        else if (merk.equalsIgnoreCase("Sierra")) {
            new Sierra().merk();
            new Sierra().prijs();
        }

        else if (merk.equalsIgnoreCase("Serta")) {
            new Serta().merk();
            new Serta().prijs();
        }

        else {
            System.out.println("You need to choose one of the mentioned brands");
        }

    }


}