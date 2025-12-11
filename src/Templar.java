public class Templar extends Job {
    @Override
    public void giveStarterEquipment(Inventory inventory) {
        inventory.addItem("Sword", 1);
        inventory.addItem("Shield", 1);
        inventory.addItem("Chainmail", 1);
    }
    @Override
    public String getDescription() {
        return "Templars have sworn an Oath to protect the weak and help those in need";
    }
    @Override
    public void printOriginStory(Character c, DialogGui gui, Dialog dialog) {
        gui.print(c.getName() + " was raised in the church from childhood. Once you hit the age of " + c.getAge() + ",you were invited to talk to the Bishop.");
        gui.print("You know Bishop Keeshta, she took very good care of you and is a motherly figure to all the children here.");
        gui.print(c.getName() + " You're old enough to be told what we've hidden from you... Several priests have seen visions of the end times. Demons will destroy the city... we need our Templars to gain strength.");
        gui.print("You must become stronger. Join the near adventurer's guild. It will be the best place to gain combat experience- and to meet strong allies..." + c.getName() + " I'm sorry I have to ask you to do such a dangerous task. Stay safe.");
        gui.print("It feels strange for " + c.getProObj() + " to leave the church, but " + c.getProSubj() + " knows what " + c.getProSubj() + " needs to do.");

        gui.addChoice("Go to the Guildhall", () -> {
            dialog.guildHall(c);
        });
        gui.show();
    }

}
