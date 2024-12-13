package database;

//import database.Player;

import java.util.ArrayList;
import java.util.List;
//import player_database.menu.InputOutputFormatter;

public class PlayerSearch {
    private static PlayerSearch instance;
    private static List<Player> PlayerDB = new ArrayList<>();

    private PlayerSearch(List<Player> playerDB) {
        PlayerDB = playerDB;
    }

    public static void makeInstance(List<Player> PlayerDB) {
        if (instance != null) {
            System.out.println("Error in PlayerSearch.makeInstance: PlayerSearch is already instantiated");
        } else {
            instance = new PlayerSearch(PlayerDB);
        }
    }

    public static PlayerSearch getInstance() {
        if (instance == null) {
            System.out.println("Error in PlayerSearch.getInstance: PlayerSearch is not instantiated");
        }
        return instance;
    }

    public static List<Player> getPlayerDB() {
        return PlayerDB;
    }

    public static void setPlayerDB(List<Player> playerDB) {
        PlayerDB = playerDB;
    }

    //returns a List of unique countries in PlayerDB, ignores spaces at front or back of country name
    public static List<String> countryList(List<Player> PlayerDB) {
        List<String> countries = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (!countries.contains(player.getCountry().trim())) {
                countries.add(player.getCountry().trim());
            }
        }

        return countries;
    }

    public boolean searchByName(String Name) {
        for (Player player : PlayerDB) {
            if (player.getName().equalsIgnoreCase(Name.trim())) {
                return true;
            }
        }
        return false;
    }

    public Player returnSearchedPlayer(String Name) {
        Player result = null;
        for (Player player : PlayerDB) {
            if (player.getName().equalsIgnoreCase(Name.trim())) {
                result = player;
                break;
            }
        }
        return result;
    }

    public List<Player> searchByCountry(String Country) {
        List<Player> playerFromSearchedCountry = new ArrayList<>();

        if (Country.trim().equalsIgnoreCase("ANY")) {
            playerFromSearchedCountry.addAll(PlayerDB);
        } else {
            for (Player player : PlayerDB) {
                if ((player.getCountry().equalsIgnoreCase(Country.trim())))
                    playerFromSearchedCountry.add(player);
            }
        }

        return playerFromSearchedCountry;
    }

    public List<Player> searchByClubCountry(String country, String club) {
        List<Player> playerFromSearchedCountryClub = new ArrayList<>();
        for (Player player : PlayerDB) {
            if (player.getCountry().equalsIgnoreCase(country.trim()) && player.getClub().equalsIgnoreCase(club.trim())) {
                playerFromSearchedCountryClub.add(player);
            }
        }

        return playerFromSearchedCountryClub;
    }

    public List<Player> searchByPosition(String Position) {
        List<Player> playerFromSearchedPosition = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (player.getPosition().equalsIgnoreCase(Position.trim())) {
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

    public List<countryWisePlayers> countryStat() {
        //make a list of all unique countries in PlayerDB
        List<String> countryList = countryList(PlayerDB);

        //iterate and count over unique countries list
        List<countryWisePlayers> countryWisePlayersCount = new ArrayList<>();
        for (String countryName : countryList
        ) {
            countryWisePlayersCount.add(new countryWisePlayers(countryName));
        }

        for (countryWisePlayers country : countryWisePlayersCount) {
//            System.out.printf("%-20s ", country);
            int totalPlayerOfCountry = 0;

            //iterates over PlayerDB for each country in countryList
            for (Player player : PlayerDB) {
                if (player.getCountry().trim().equalsIgnoreCase(country.getCountry().trim())) {
                    totalPlayerOfCountry++;
                }
            }

            country.setPlayerCount(totalPlayerOfCountry);
        }

        return countryWisePlayersCount;
    }

    //Prints player count by country
    public void printPlayerByCountry(List<String> countryList) {
        System.out.printf("%-20s%-20s\n", "Country", "Players");

        for (String country : countryList) {
            System.out.printf("%-20s ", country);
            int totalPlayerOfCountry = 0;

            //iterates over PlayerDB for each country in countryList
            for (Player player : PlayerDB) {
                if (player.getCountry().trim().equalsIgnoreCase(country.trim())) {
                    totalPlayerOfCountry++;
                }
            }

            System.out.printf("%d\n", totalPlayerOfCountry);
        }
    }
}
