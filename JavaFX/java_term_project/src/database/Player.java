package database;

//import player_database.menu.InputOutputFormatter;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    String Name;
    String Country;
    int Age;
    double Height;
    String Club;
    String Position;
    int Number;
    double WeeklySalary;

    public Player() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String club) {
        Club = club;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public double getWeeklySalary() {
        return WeeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        WeeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Age=" + Age +
                ", Height=" + Height +
                ", Club='" + Club + '\'' +
                ", Position='" + Position + '\'' +
                ", Number=" + Number +
                ", WeeklySalary=" + WeeklySalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Age == player.Age && Double.compare(player.Height, Height) == 0 && Number == player.Number && Double.compare(player.WeeklySalary, WeeklySalary) == 0 && Name.equals(player.Name) && Objects.equals(Country, player.Country) && Objects.equals(Club, player.Club) && Objects.equals(Position, player.Position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Country, Age, Height, Club, Position, Number, WeeklySalary);
    }
}
