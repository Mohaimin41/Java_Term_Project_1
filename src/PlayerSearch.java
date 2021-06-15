import java.util.List;
import java.util.ArrayList;

public class PlayerSearch implements InputOutputFormatter {
    List<Player> PlayerDB;

    public PlayerSearch(List<Player> PlayerDB) {
        this.PlayerDB = PlayerDB;
    }

    public boolean searchByName(String Name) {
        for (Player player : PlayerDB) {
            if (player.getName().equalsIgnoreCase(Name)) {
                return true;
            }
        }
        return false;
    }

    public Player returnSearchedPlayer(String Name) {
        Player result = null;
        for (Player player : PlayerDB) {
            if (player.getName().equalsIgnoreCase(Name)) {
                result = player;
                break;
            }
        }
        return result;
    }

    public void searchByCountry(String Country) {
        int total = 0;
        for (Player player : PlayerDB) {
            if (player.getCountry().equalsIgnoreCase(Country)) {
                total++;
                System.out.println(total + ".");
                player.display();
            }
        }
        if (total == 0) {
            System.out.println("No player found with the given country and club");
            horizontalLine();
        }
    }

    public void searchByClubCountry(String country, String club) {
        int total = 0;
        for (Player player : PlayerDB) {
            if (player.getCountry().equalsIgnoreCase(country) && player.getClub().equalsIgnoreCase(club)) {
                total++;
                System.out.println(total + ".");
                player.display();
            }
        }
        if (total == 0) {
            System.out.println("No player found with the given country and club");
            horizontalLine();
        }
    }

    public void searchByPosition(String Position) {
        int total = 0;
        for (Player player : PlayerDB) {
            if (player.getPosition().equalsIgnoreCase(Position)) {
                total++;
                System.out.println(total + ".");
                player.display();
            }
        }
        if (total == 0) {
            System.out.println("No player found with the given position");
            horizontalLine();
        }
    }

    public void searchBySalaryRange(double low, double high) {
        int total = 0;
        for (Player player : PlayerDB) {
            if (player.getWeeklySalary() <= high && player.getWeeklySalary() >= low) {
                total++;
                System.out.println(total + ".");
                player.display();
            }
        }
        if (total == 0) {
            System.out.println("No player found with the given weekly salary range");
            horizontalLine();
        }
    }

    public void countryStat() {
        int totalPlayer = PlayerDB.size();
        //make a list of all unique countries in PlayerDB
        List<String> countryList = countryList(PlayerDB);
        //iterate and count over unique countries list
        int totalCountry = countryList.size();

        System.out.println("Total number of different countries: " + totalCountry);
        System.out.println("Total number of players: " + totalPlayer);
        System.out.println("Country-wise player count:");

        printPlayerByCountry(countryList);

        horizontalLine();
    }

    //returns a List of unique countries in PlayerDB
    public List<String> countryList(List<Player> PlayerDB) {
        List<String> countries = new ArrayList();

        for (Player player : PlayerDB) {
            if (!countries.contains(player.getCountry())) {
                countries.add(player.getCountry());
            }
        }

        return countries;
    }

    //Prints player count by country
    public void printPlayerByCountry(List<String> countryList) {
        System.out.println("Country\t\t\tPlayers");

        for (String country : countryList) {
            System.out.printf("%s\t\t\t", country);
            int totalPlayerOfCountry = 0;

            //iterates over PlayerDB for each country in countryList
            for (Player player : PlayerDB) {
                if (player.getCountry().equalsIgnoreCase(country)) {
                    totalPlayerOfCountry++;
                }
            }

            System.out.printf("%d\n", totalPlayerOfCountry);
        }
    }
}