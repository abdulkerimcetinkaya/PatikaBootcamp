package Week5;

import java.util.*;

public class Fiksture {

    public static void main (String[] args){
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        generateFixture(teams);
    }

    public static void generateFixture(List<String> teams){
        if (teams.size() % 2 != 0){
            teams.add("Bay");
        }

        int totalWeeks = teams.s;
        int matchesPerWeek = teams.size() / 2;

        for (int week = 1; week <= totalWeeks; week++) {
            System.out.println(week + ". Hafta");
            Collections.rotate(teams, 1); // Takımları döndürerek iç saha/dış saha değişimini sağlar

            for (int i = 0; i < matchesPerWeek; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teams.size() - 1 - i);
                System.out.println(homeTeam + " vs " + awayTeam);
            }
        }

        // İkinci devre için takımların sırasını tersine çevirerek fikstürü oluştur
        Collections.reverse(teams);

        for (int week = 1; week <= totalWeeks; week++) {
            System.out.println((week + totalWeeks) + ". Hafta (İkinci Devre)");
            Collections.rotate(teams, 1); // Takımları döndürerek iç saha/dış saha değişimini sağlar

            for (int i = 0; i < matchesPerWeek; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teams.size() - 1 - i);
                System.out.println(homeTeam + " vs " + awayTeam);
            }
        }
    }
}
