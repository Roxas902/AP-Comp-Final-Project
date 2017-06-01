import greenfoot.*;
public class Shield extends ScrollActor
{
    private int defense;
    public Shield(int defense)
    {
        this.defense=defense;
    }
    
    public int getDefense(){
        return defense;
    }
    public void setDefense(int defense){
        this.defense=defense;
    }
    public void use()
    {
        // put your code here
    }
}
