import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    //File name
    public static final String FILE_NAME = "players.txt";

    public FileIO() {
    }

    public List<Player> readFromFile() throws Exception {
        //Player list to be used as database
        List<Player> PlayerList = new ArrayList();

        BufferedReader PlayersFileBuffer = new BufferedReader(new FileReader(FILE_NAME));

        while (true) {
            //read and tokenize every line
            String line = PlayersFileBuffer.readLine();
            if (line == null) break;

            String[] tokens = line.split(",");

            //Construct a Player object using 8 tokens from each line
            Player playerFromFile = new Player();

            playerFromFile.setName(tokens[0]);
            playerFromFile.setCountry(tokens[1]);
            playerFromFile.setAge(Integer.parseInt(tokens[2]));
            playerFromFile.setHeight(Double.parseDouble(tokens[3]));
            playerFromFile.setClub(tokens[4]);
            playerFromFile.setPosition(tokens[5]);
            playerFromFile.setNumber(Integer.parseInt(tokens[6]));
            playerFromFile.setWeeklySalary(Double.parseDouble(tokens[7]));

            //Add to PlayerList
            PlayerList.add(playerFromFile);
        }

        PlayersFileBuffer.close();
        return PlayerList;
    }

    public void writeToFile(List<Player> PlayerList) throws Exception {
        BufferedWriter playerToFile = new BufferedWriter(new FileWriter(FILE_NAME));

        //write to players.txt the database list
        for (Player playerFromList : PlayerList) {
            playerToFile.write(playerFromList.getName() + "," + playerFromList.getCountry() + "," + playerFromList.getAge()
                    + "," + playerFromList.getHeight() + "," + playerFromList.getClub() + "," + playerFromList.getPosition()
                    + "," + playerFromList.getNumber() + "," + playerFromList.getWeeklySalary());
            playerToFile.write("\n");
        }

        playerToFile.close();
    }
}
