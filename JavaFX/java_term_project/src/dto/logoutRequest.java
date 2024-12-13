package dto;

import java.io.Serializable;

public class logoutRequest implements Serializable {
    String club;

    public logoutRequest() {
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
