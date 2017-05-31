import greenfoot.*;
public abstract class Item extends Actor
{
    private String name;
    private String itemDesc;
    private int defense;
    private int attack;
    public Item()
    {
        name="?";
        itemDesc="???";
        attack=0;
        defense=0;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack=attack;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int defense){
        this.defense=defense;
    }
    public String getItemDesc(){
        return itemDesc;
    }
    public void setIDesc(String itemDesc){
        this.itemDesc=itemDesc;
    }
    public abstract void use();//performs Special action. 
}
