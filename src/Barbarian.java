public class Barbarian extends Job{
    @Override
    public void giveStarterEquipment(Inventory inventory) {
        inventory.addItem("Greataxe", 1);
        inventory.addItem("Primitive Armor", 1);
    }
    @Override
    public String getDescription() {
        return "Barbarians are a tribal people from the North. Might makes right, strength is a virtue.";
    }
    @Override
    public void printOriginStory(Character c) {
        System.out.println(c.getName() + " used to live in the snowy mountains with " + c.getProPossAdj() + " tribe- until that fateful day. The day of " + c.getProPossAdj() + "father's 60th birthday.");
        System.out.println("The chieftain demanded you leave and never return until you've become a legendary warrior.");
        System.out.println(c.getName() + " has been slaying monsters for glory- seeking bards to sing " + c.getProPossAdj() + " name. In a small settlement, you heard an interesting rumor...");
        System.out.println("The city of Lindhelm just established an adventurer's guild- there's a ranking system, and all the top ranked people are famous now. You think it's time to show them how hungry for glory you are!");
    }
}
