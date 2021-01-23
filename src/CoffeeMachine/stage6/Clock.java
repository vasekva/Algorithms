package CoffeeMachine.stage6;

class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (minutes == 59) {
            if (hours == 12) {
                hours = 1;
            } else {
                hours++;
            }
            minutes = 0;
        } else {
            minutes++;
        }
    }
}
