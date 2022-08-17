import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> pPos = new ArrayList<Integer>();
    static ArrayList<Integer> cpPos = new ArrayList<Integer>();
    private static Object List;

    public static void main(String[] args) {
        char [][] table = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},};

        printTable(table);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your placement (1-9): ");
            int pos = sc.nextInt();

            while (pPos.contains(pos) || cpPos.contains(pPos) || cpPos.contains(pos)) {
                System.out.print("Position taken! Enter new place: ");
                pos = sc.nextInt();
            }

            place(table, pos, "player");

            Random random = new Random();
            int pospc = random.nextInt(9) + 1;

            while (pPos.contains(pospc) || cpPos.contains(pospc)) {
                pospc = random.nextInt(9) + 1;
            }


            place(table, pospc, "pc");
            printTable(table);

            String res = check();
            if (res != " ") {
                System.out.println(res);
                break;
            }
        }
    }

    public static void printTable(char [][] table) {
        for (char[] row : table) {
            for (char c : row) {
                System.out.print(c);
            }

            System.out.println();
        }
    }

    public static void place(char [][]table, int pos, String user) {
        char c = ' ';

        if (user == "player") {
            c = 'X';
            pPos.add(pos);
        } else {
            c = 'O';
            cpPos.add(pos);
        }

        switch (pos) {
            case 1:
                table[0][0] = c;
                break;
            case 2:
                table[0][2] = c;
                break;
            case 3:
                table[0][4] = c;
                break;
            case 4:
                table[2][0] = c;
                break;
            case 5:
                table[2][2] = c;
                break;
            case 6:
                table[2][4] = c;
                break;
            case 7:
                table[4][0] = c;
                break;
            case 8:
                table[4][2] = c;
                break;
            case 9:
                table[4][4] = c;
                break;
            default:
                break;

        }
    }

    public static String check(){
        List frow = Arrays.asList(1, 2, 3);
        List srow = Arrays.asList(4, 5, 6);
        List trow = Arrays.asList(7, 8, 9);
        List fcol = Arrays.asList(1, 4, 7);
        List scol = Arrays.asList(2, 5, 8);
        List tcol = Arrays.asList(3, 6, 9);
        List cro1 = Arrays.asList(1, 5, 9);
        List cro2 = Arrays.asList(3, 5, 7);

        List<List> win = new ArrayList<List>();
        win.add(frow);
        win.add(srow);
        win.add(trow);
        win.add(fcol);
        win.add(scol);
        win.add(tcol);
        win.add(cro1);
        win.add(cro2);

        for (List i : win) {
            if (pPos.containsAll(i)) {
                return "You're winner!";
            } else if (cpPos.containsAll(i)) {
                return "CPU is winner";
            } else if (pPos.size() + cpPos.size() == 9) {
                return "CAT!";
            }
        }

        return " ";
    }
}
