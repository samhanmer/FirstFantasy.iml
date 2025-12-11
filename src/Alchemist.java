public class Alchemist extends Job {
    @Override
    public void giveStarterEquipment(Inventory inventory) {
        inventory.addItem("Alchemist Tools", 1);
        inventory.addItem("Component Pouch", 1);
        inventory.addItem("Cloth Robes", 1);
    }
    @Override
    public String getDescription() {
        return "Alchemists are apothecaries that make plants into magical concoctions";
    }
    @Override
    public void printOriginStory(Character c, DialogGui gui, Dialog dialog) {
        gui.print(c.getName() + " is an apprentice Alchemist at a local medicine shop in the city of Lindhelm. Master Cid is your teacher and employer.");
        gui.print("One day while " + c.getName() + " was grinding some herbs- the window to the lab shattered. Debt-collecters finally came for old man Cid.");
        gui.print(c.getName() + " was beaten while Cid was dragged off. They left " + c.getName() + " with " + c.getProPossAdj() + " basic alchemy gear and a note:");
        gui.print("Get 1000 gold coins and Cid will be returned, if you take too long, we'll get our money's worth outta him. You decide reporting this to the new guild in town would be the best thing to do.");

        gui.addChoice("Go to the Guildhall", () -> {
            dialog.guildHall(c);
        });
        gui.show();
    }
}
