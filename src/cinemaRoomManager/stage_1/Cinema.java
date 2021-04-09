package cinemaRoomManager.stage_1;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Cinema:");
        // цикл по строчкам
        for (int i = 0; i < 8; i++) {
            // цикл по столбцам
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    if (j == 0)
                        System.out.print(" ");
                    else
                        System.out.print(j);
                } else {
                    if (j == 0)
                        System.out.print(i);
                    else
                        System.out.print("S");
                }
                if (j + 1 != 9) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}