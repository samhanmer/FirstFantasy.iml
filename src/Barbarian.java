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
    public void printOriginStory(Character c, DialogGui gui, Dialog dialog) {
        gui.print(c.getName() + " used to live in the snowy mountains with " + c.getProPossAdj() + " tribe- until that fateful day. The day of " + c.getProPossAdj() + " father's 60th birthday.");
        gui.print("The chieftain demanded you leave and never return until you've become a legendary warrior.");
        gui.print(c.getName() + " has been slaying monsters for glory- seeking bards to sing " + c.getProPossAdj() + " name. In a small settlement, you heard an interesting rumor...");
        gui.print("The city of Lindhelm just established an adventurer's guild- there's a ranking system, and all the top ranked people are famous now. You think it's time to show them how hungry for glory you are!");

        gui.addChoice("Go to the Guildhall", () -> {
            dialog.guildHall(c);
        });
        gui.show();
    }
}
