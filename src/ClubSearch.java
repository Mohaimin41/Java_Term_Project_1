import java.util.ArrayList;
import java.util.List;

public class ClubSearch{
    List<Player> PlayerDB;

    public ClubSearch(List<Player> PlayerDB) {
        this.PlayerDB = PlayerDB;
    }

    public boolean searchByName (String club) {
        for (Player player : PlayerDB) {
            if (player.getClub().equalsIgnoreCase(club)) {
                return true;
            }
        }
        return false;
    }

    //return a List of all players in the club
    public List<Player> clubPlayerList (String club) {
        List<Player> CLubPlayerList = new ArrayList();

        for (Player player : PlayerDB) {
            if (player.getClub().equalsIgnoreCase(club)) {
                CLubPlayerList.add(player);
            }
        }

        return CLubPlayerList;
    }

    public double maxSalaryInCLub (String club) {
        double maxSalary = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            if (player.getWeeklySalary() > maxSalary) {
                maxSalary = player.getWeeklySalary();
            }
        }

        return maxSalary;
    }

    public void printPlayerInClubBySalary (double weeklySalary, String club) {
        List<Player> clubPlayerList = clubPlayerList(club);
        int total = 0;

        for (Player player : clubPlayerList) {
            if (player.getWeeklySalary() == weeklySalary) {
                System.out.println(++total + ".");
                player.display();
            }
        }
    }

    public double maxAgeInCLub (String club) {
        double maxAge = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            if (player.getAge() > maxAge) {
                maxAge = player.getAge();
            }
        }

        return maxAge;
    }

    public void printPlayerInClubByAge (double age, String club) {
        List<Player> clubPlayerList = clubPlayerList(club);
        int total = 0;

        for (Player player : clubPlayerList) {
            if (player.getAge() == age) {
                System.out.println(++total + ".");
                player.display();
            }
        }
    }

    public double maxHeightInCLub (String club) {
        double maxHeight = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            if (player.getHeight() > maxHeight) {
                maxHeight = player.getHeight();
            }
        }

        return maxHeight;
    }

    public void printPlayerInClubByHeight (double Height, String club) {
        List<Player> clubPlayerList = clubPlayerList(club);
        int total = 0;

        for (Player player : clubPlayerList) {
            if (player.getHeight() == Height) {
                System.out.println(++total + ".");
                player.display();
            }
        }
    }

    public double totalYearlySalaryClub (String club) {
        double totalWeeklySalary = 0.0;
        List<Player> clubPlayerList = clubPlayerList(club);

        for (Player player : clubPlayerList) {
            totalWeeklySalary += player.getWeeklySalary();
        }

        return (totalWeeklySalary / 7.0) * 365.0;
    }
}