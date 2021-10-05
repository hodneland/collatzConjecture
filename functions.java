public class functions {
    //Algorithm returns all hailstone numbers in one string
    public String collatz(int a) {
        String s = "";
        while (true) {
            if (a == 1 ) {
                return s + "1";
            }
            s = s + Integer.toString(a) + " -> ";
            if (a % 2 == 0) {
                a /= 2;
            }
            else {
                a = (a * 3) + 1;
            }
        }
    }
    //Algorithm finds largest hailstone number
    public int max(int a) {
        int max = a;
        while (true) {
            if (a == 1) {
                break;
            }
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = (a * 3) + 1;
            }
            if (a >= max) {
                max = a;
            }
        }
        return max;
    }
    //Algorithm counts the number of hailstone numbers
    public int iterations(int c) {
        int i = 0;
        while (true) {

            if (c == 1) {
                i++;
                return i;
            }
            if (c % 2 == 0) {
                c /= 2;
                i++;
            } else {
                c = (3 * c) + 1;
            }
        }
    }
}