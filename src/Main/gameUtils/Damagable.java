package src.Main.gameUtils;

public interface Damagable {

    boolean damage(double damage);
    boolean heal(double healAmount);

    double getHealth();
}
