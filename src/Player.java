public class Player implements InputOutputFormatter {
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

    /*public Player(String Name, String Country, int Age, double Height, String Club, String Position, int Number, double WeeklySalary) {
        this.Name = Name;
        this.Country = Country;
        this.Age = Age;
        this.Height = Height;
        this.Club = Club;
        this.Position = Position;
        this.Number = Number;
        this.WeeklySalary = WeeklySalary;
    }*/

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountry() {
        return Country;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getAge() {
        return Age;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public double getHeight() {
        return Height;
    }

    public void setClub(String club) {
        Club = club;
    }

    public String getClub() {
        return Club;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getPosition() {
        return Position;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.WeeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return WeeklySalary;
    }

    public void display() {
        System.out.println("Player Name: " + Name);
        System.out.println("Country: " + Country);
        System.out.println("Club: " + Club);
        System.out.println("Age: " + Age + " years");
        System.out.println("Height: " + Height + " meter");
        System.out.println("Position: " + Position);
        System.out.println("Number: " + Number);
        System.out.println("Weekly Salary: " + WeeklySalary);
        horizontalLine();
    }
}
