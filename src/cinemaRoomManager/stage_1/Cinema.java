package cinemaRoomManager.stage_1;

/**
* STAGE 1
*
* Цели
* В нашем новом кинотеатре не так много места, поэтому нужно учитывать ограничения по количеству мест.
* Ваши друзья сказали, что в зале будет 7 рядов по 8 мест. Ваша задача -
* помочь им визуализировать расстановку сидений, распечатав схему на консоли.
*
* Результат должен быть как в примере ниже
*
* Cinema:
*   1 2 3 4 5 6 7 8
* 1 S S S S S S S S
* 2 S S S S S S S S
* 3 S S S S S S S S
* 4 S S S S S S S S
* 5 S S S S S S S S
* 6 S S S S S S S S
* 7 S S S S S S S S
*/

public class Cinema {

    public static void main(String[] args) {
        String  str;

        System.out.println("\nCinema:");
        str = " ";
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    str += " " + (j + 1);
                } else {
                    str += " S";
                }
            }
            System.out.println(str);
            str = "" + (i + 1);
        }
        System.out.println();
    }
}