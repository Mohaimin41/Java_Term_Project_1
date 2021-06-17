public interface InputOutputFormatter {
    default void horizontalLine() {
        System.out.println("=========================================================================================");
    }

    default void chooseCorrectOption() {
        System.out.println("Please choose a correct option:");
        horizontalLine();
    }
}
