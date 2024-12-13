package database;

public class countryWisePlayers {
    String country;
    int playerCount;

    public countryWisePlayers(String country) {
        this.country = country;
    }

    public countryWisePlayers(String country, int playerCount) {
        this.country = country;
        this.playerCount = playerCount;
    }

    public countryWisePlayers(int playerCount) {
        this.playerCount = playerCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
