package Week5;

import java.util.*;

public class Fiksture {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> teams = new ArrayList<>();

        teams.add("Galatasaray");// trabszon list[0] 1,2,3,4,5
        teams.add("Bursaspor"); // başakşehir
        teams.add("Fenerbahçe"); // beşiktaş
        teams.add("Beşiktaş"); // fenerbahçe
        teams.add("Başakşehir"); // bursa
        teams.add("Trabzonspor"); // galatesatar

        generateFixture(teams);
    }

    public static void generateFixture(List<String> teams) {
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }
        int matchPerWeek = teams.size() / 2;
        int totalWeek = teams.size() - 1;
        List<String> matchList = new ArrayList<>();

        for (int i = 1; i < totalWeek + 1; i++) {
            System.out.println(i + ". Hafta");
            Collections.shuffle(teams);
            for (int j = 0; j < matchPerWeek; j++) {
                int firstIndex = j;
                int secondIndex = (teams.size() - 1) - j;
                System.out.println(teams.get(firstIndex) + " vs " + teams.get(secondIndex));
            }
        }
    }
}