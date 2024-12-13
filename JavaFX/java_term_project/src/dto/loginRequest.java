package dto;

import java.io.Serializable;

public class loginRequest implements Serializable {
   String clubName;
   String password;

    public loginRequest() {
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
