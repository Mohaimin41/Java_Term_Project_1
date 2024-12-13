package dto;

import database.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class updatePlayerList implements Serializable {
    List<Player> updatedPlayerDB = new ArrayList<>();
    private String club;

    public updatePlayerList(List<Player> UpdatedPlayerDB, String Club) {
        this.club = Club;
        for (Player player: UpdatedPlayerDB
        ) {
            if (player.getClub().equals(club)) {
                updatedPlayerDB.add(player);
            }
        }

    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public List<Player> getUpdatedPlayerDB() {
        return updatedPlayerDB;
    }

    public void setUpdatedPlayerDB(List<Player> updatedPlayerDB) {
        this.updatedPlayerDB = updatedPlayerDB;
    }
}
