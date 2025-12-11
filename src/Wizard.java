public class Wizard extends Job {
    @Override
    public void giveStarterEquipment(Inventory inventory) {
        inventory.addItem("Wand", 1);
        inventory.addItem("Spellbook", 1);
        inventory.addItem("Cloth Robes", 1);
    }
    @Override
    public String getDescription() {
        return "Wizards attend the college to unravel the many mysteries about the flow of Mana into the world";
    }
    @Override
    public void printOriginStory(Character c, DialogGui gui, Dialog dialog) {
        gui.print(c.getName() + " has been a student at Mayflower college for mages for several years. Ever since a young age " + c.getProSubj() + " has been able to use minor magics.");
        gui.print("It was a normal day of studying the arcane theories when " + c.getName() + " felt a wand jab into " + c.getProPossAdj() + " back. It was " + c.getName() + "'s bully- Ned.");
        gui.print("You've been doing far too well... time to get rid of you... Ned casts a spell that knocks " + c.getName() + " unconscious.");
        gui.print(c.getName() + " notices a few things when " + c.getProSubj() + " comes to. " + c.getProSubj() + " has no money, no more ID for college and " + c.getProSubj() + " in a town called Lindhelm- far away from Mayflower. The adventurer's guild might be " + c.getName() + "'s only hope.");

        gui.addChoice("Go to the Guildhall", () -> {
            dialog.guildHall(c);
        });
        gui.show();
    }

}
