import java.util.ArrayList;
import java.util.Scanner;

public class ReadStringsWithArrayList {
    public static void main(String[] args) {
        ArrayList<String> arr = getStrings();
    }

    private static ArrayList<String> getStrings() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Enter any number of strings, one per line; ");
        System.out.println("Terminate with empty line: ");

        while (in.hasNextLine()) {
            String oneLine = in.nextLine();
            if (oneLine.equals("")) {
                break;
            }
            arr.add(oneLine);
        }

        System.out.println("Done reading!");
        return arr;
    }
}
