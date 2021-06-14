public class Player {
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

    public Player( String Name, String Country, int Age, double Height, String Club, String Position, int Number, double WeeklySalary ) {
        this.Name = Name;
        this.Country = Country;
        this.Age = Age;
        this.Height = Height;
        this.Club = Club;
        this.Position = Position;
        this.Number = Number;
        this.WeeklySalary = WeeklySalary;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return Name;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getCountry() {
        return Country;
    }

    public void setAge(int age) {
        this.Age = Age;
    }

    public int getAge() {
        return Age;
    }

    public void setHeight(double height) {
        this.Height = Height;
    }

    public double getHeight() {
        return Height;
    }

    public void setClub(String club) {
        this.Club = club;
    }

    public String getClub() {
        return Club;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getPosition() {
        return Position;
    }

    public void setNumber(int number) {
        this.Number = number;
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
        System.out.println("Player Name: " + Name + ", Country: " + Country + ", Club: " + Club);
        System.out.println("Player Age: " + Age + ", Height: " + Height + ", Position: " + Position + ", Number: " + Number + ", Weekly Salary: " + WeeklySalary );
        System.out.println("================================================================================");
    }
}
