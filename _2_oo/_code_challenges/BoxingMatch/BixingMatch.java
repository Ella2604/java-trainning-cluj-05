public class BoxingMatch {
    public BoxingMatch(Fighter fighter1, Fighter fighter2) {
        fighter1.name = "Tom";
        fighter2.name = "Jerry";
        fighter1.health = 15;
        fighter2.health = 15;
        fighter1.damagePerAttack = 5;
        fighter2.damagePerAttack = 6;
    }
        public String fight (Fighter fighter1,Fighter fighter2){
            while (fighter1.health > 0 && fighter2.health > 0) {
                fighter1.attack(fighter2);
                System.out.println(fighter1.getName() + " is attacking now.");
                fighter2.attack(fighter1);
                System.out.println(fighter2.getName() + " is attacking now.");
            }

            if (fighter1.health > 0)
                return fighter1.getName();
            else
                return fighter2.getName(); }
}