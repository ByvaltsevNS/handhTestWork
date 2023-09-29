public class Main {
    public static void main(String[] args) {
        Player player1;
        Monster monster1;
        try {
            player1 = new Player(23, 20, 25, 5, 30);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Объект игрока успешно создан! Его параметры: ");
        System.out.println(player1);
        try {
            monster1 = new Monster(25, 20, 40, 10, 20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Объект монстра успешно создан! Его параметры: ");
        System.out.println(monster1);
        System.out.println("Да начнется битва!");
        while (true) {
            System.out.println("Игрок атакует монстра и наносит ему " + player1.hit(monster1) + " урона");
            if (!monster1.isAlive()) {
                System.out.println("Монстр повержен! Битва окончена!");
                return;
            }
            System.out.println("Монстр атакует игрока и наносит ему " + monster1.hit(player1) + " урона");
            if (!player1.isAlive()) {
                System.out.println("Игрок проиграл! Битва окончена!");
                return;
            }
            if (player1.isGoodTimeToHeal() && player1.canHeal()) {
                System.out.println("Игрок восстанавливает свое здоровье на " + player1.heal() + " единиц");
            }
        }
    }
}