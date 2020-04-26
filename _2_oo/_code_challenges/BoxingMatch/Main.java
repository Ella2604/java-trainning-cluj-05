public class main {
    public static void main(String[] args) {
    Fighter fighter1 = new Fighter();
    Fighter fighter2 = new Fighter();

    BoxingMatch combat = new BoxingMatch(fighter1, fighter2);

     System.out.println("The winner is " + combat.fight(fighter1,fighter2) + "!");
     System.out.println("Game over");
}
}