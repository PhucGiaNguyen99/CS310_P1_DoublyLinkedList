import java.util.Scanner;

public class ReadStringsWithArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = new String[5];
        int Stringcount = 0;

        System.out.println("Enter any number of strings, one per line; ");
        System.out.println("Terminate with empty line: ");

        while (in.hasNextLine()) {
            String oneLine = in.nextLine();
            if (oneLine.equals("")) {
                break;
            }
            if (Stringcount == arr.length) {
                arr = resize(arr, arr.length * 2);
            }
            arr[Stringcount++] = oneLine;
        }
        System.out.println("Done reading!");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Resize a String[] array; return new array
    private static String[] resize(String[] arr, int newSize) {
        System.out.println("Old size = " + arr.length + " New size = " + newSize);

        String[] original = arr;

        // make sure that the number of elements to copy is the smallest between the length of the original array and of the new length
        int numToCopy = Math.min(original.length, newSize);

        arr = new String[newSize];
        for (int i = 0; i < numToCopy; i++) {
            arr[i] = original[i];
        }
        return arr;

    }
}
