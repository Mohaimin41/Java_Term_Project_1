package database;


import java.util.ArrayList;
import java.util.List;

public class ClubSearch {
    static ClubSearch instance;
    static List<Player> PlayerDB;

    private ClubSearch(List<Player> PlayerDB) {
        this.PlayerDB = PlayerDB;
    }

    public static void makeInstance(List<Player> PlayerDB) {
        if (instance != null) {
            System.out.println("Error in ClubSearch.makeInstance: ClubSearch is already instantiated");
        } else {
            instance = new ClubSearch(PlayerDB);
        }
    }

    public static ClubSearch getInstance() {
        if (instance == null) {
            System.out.println("Error in ClubSearch.getInstance: not instantiated");
        }
        return instance;
    }

    public static List<Player> getPlayerDB() {
        return PlayerDB;
    }

    public static void setPlayerDB(List<Player> playerDB) {
        PlayerDB = playerDB;
    }

    public boolean searchClubByName(String club) {
        for (Player player : PlayerDB) {
            if (player.getClub().equalsIgnoreCase(club.trim())) {
                return true;
            }
        }
        return false;
    }

    //return a List of all players in the club
    public List<Player> clubPlayerList(String club) {
        List<Player> CLubPlayerList = new ArrayList<>();

        for (Player player : PlayerDB) {
            if (player.getClub().equalsIgnoreCase(club.trim())) {
                CLubPlayerList.add(player);
            }
        }

        return CLubPlayerList;
    }

    public double maxSalaryInCLub(String club) {
        double maxSalary = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            if (player.getWeeklySalary() > maxSalary) {
                maxSalary = player.getWeeklySalary();
            }
        }

        return maxSalary;
    }

    public List<Player> printPlayerInClubBySalary(double weeklySalary, String club) {
        List<Player> clubPlayerList = clubPlayerList(club);
        List<Player> searchedPlayerList = new ArrayList<>();
//        int total = 0;

        for (Player player : clubPlayerList) {
            if (player.getWeeklySalary() == weeklySalary) {
                searchedPlayerList.add(player);
            }
        }

        return searchedPlayerList;
    }

    public int maxAgeInCLub(String club) {
        int maxAge = 0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            if (player.getAge() > maxAge) {
                maxAge = player.getAge();
            }
        }

        return maxAge;
    }

    public List<Player> printPlayerInClubByAge(double age, String club) {
        List<Player> clubPlayerList = clubPlayerList(club);
        List<Player> searchedPlayerList = new ArrayList<>();

        for (Player player : clubPlayerList) {
            if (player.getAge() == age) {
                searchedPlayerList.add(player);
            }
        }

        return searchedPlayerList;
    }

    public double maxHeightInCLub(String club) {
        double maxHeight = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            if (player.getHeight() > maxHeight) {
                maxHeight = player.getHeight();
            }
        }

        return maxHeight;
    }

    public List<Player> printPlayerInClubByHeight(double Height, String club) {
        List<Player> clubPlayerList = clubPlayerList(club);
        List<Player> searchedPlayerList = new ArrayList<>();

        for (Player player : clubPlayerList) {
            if (player.getHeight() == Height) {
                searchedPlayerList.add(player);
            }
        }

        return searchedPlayerList;
    }

    public double totalYearlySalaryClub(String club) {
        double totalWeeklySalary = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            totalWeeklySalary += player.getWeeklySalary();
        }

        return (totalWeeklySalary / 7.0) * 365.0;
    }
}