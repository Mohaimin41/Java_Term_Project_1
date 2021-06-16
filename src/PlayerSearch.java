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

    public List<Player> searchByCountry(String Country) {
        List<Player> playerFromSearchedCountry = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (player.getCountry().equalsIgnoreCase(Country)) {
                playerFromSearchedCountry.add(player);
            }
        }

        return playerFromSearchedCountry;
    }

    public List<Player> searchByClubCountry(String country, String club) {
        List<Player> playerFromSearchedCountryClub = new ArrayList<>();
        for (Player player : PlayerDB) {
            if (player.getCountry().equalsIgnoreCase(country) && player.getClub().equalsIgnoreCase(club)) {
                playerFromSearchedCountryClub.add(player);
            }
        }

        return playerFromSearchedCountryClub;
    }

    public List<Player> searchByPosition(String Position) {
        List<Player> playerFromSearchedPosition = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (player.getPosition().equalsIgnoreCase(Position)) {
                playerFromSearchedPosition.add(player);
            }
        }
        return playerFromSearchedPosition;
    }

    public List<Player> searchBySalaryRange(double low, double high) {
        List<Player> playerFromSearchedSalaryRange = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (player.getWeeklySalary() <= high && player.getWeeklySalary() >= low) {
                playerFromSearchedSalaryRange.add(player);
            }
        }

        return playerFromSearchedSalaryRange;
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
        List<String> countries = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (!countries.contains(player.getCountry())) {
                countries.add(player.getCountry());
            }
        }

        return countries;
    }

    //Prints player count by country
    public void printPlayerByCountry(List<String> countryList) {
        System.out.printf("%-20s%-20s\n", "Country", "Players");

        for (String country : countryList) {
            System.out.printf("%-20s ", country);
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
