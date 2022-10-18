public class Humanoid {
    public String name;
    int damage;
    int maxHealth;
    double minDamageMult = 0.8;
    double maxDamageMult = 1.3;
    int health;
    boolean isAlive;
    final boolean isAlly;

    public Humanoid(String name, int maxHealth, int damage, boolean isAlly) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.health = maxHealth;
        this.isAlive = health > 0;
        this.isAlly = isAlly;
    }

    public void Attack(Humanoid target) {
        target.TakeDamage(this.damage, this.minDamageMult, this.maxDamageMult);
    }

    public void TakeDamage(int damage, double minMult, double maxMult) {
        double ranNum = Math.random();
        double ranMult = minMult + (ranNum * (maxMult - minMult));

        int newDamage = (int) Math.floor(damage * ranMult);

        this.health -= newDamage;
        this.isAlive = this.health > 0;

        System.out.println(this.name + " took " + newDamage + " damage!");
        if (this.isAlive) {
            System.out.println("Health left: " + this.health);
        } else {
            System.out.println(this.name + " died!");
        }
    }

    public String toString() {
        return "Humanoid: " + name + " Health: " + health + "Damage: " + damage;
    }
}
