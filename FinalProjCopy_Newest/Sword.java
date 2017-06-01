import greenfoot.*;
public class Sword extends Actor
{
    private int attack;
    public Sword(int attack)
    {
        this.attack = attack;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack=attack;
    }
    public void use()
    {
        // put your code here
    }
}
