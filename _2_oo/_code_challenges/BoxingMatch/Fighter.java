
public class Fighter {
     String name;
     Integer health;
     Integer damagePerAttack;

    public void attack(Fighter opponent){
        opponent.health = opponent.health - this.damagePerAttack;
    }

    public String getName() {
        return name;
    }

}