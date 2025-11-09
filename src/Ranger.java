public class Ranger extends Job {
    @Override
    public void giveStarterEquipment(Inventory inventory) {
        inventory.addItem("Longbow", 1);
        inventory.addItem("Arrow", 20);
        inventory.addItem("Leather Armor", 1);
    }

    @Override
    public String getDescription() {
        return "Opting to live in the wilds, rangers live off the land and attune to nature- fighting to protect it";
    }

    @Override
    public void printOriginStory(Character c) {
        System.out.println(c.getName() + " has enjoyed a life of solitude among nature. The woods have given " + c.getProObj() + " all " + c.getProSubj() + " could ever need.");
        System.out.println("One day however, something interrupted that peace and tranquility. Birds left much earlier than they should've, deer ran up into wolf infested mountains... something is causing a disturbance.");
        System.out.println(c.getName() + " decides to investigate, and figures out there's a good reason for the animals to leave. Tracks of a demon. A big one.");
        System.out.println("The demon tracks indicate that it's far too big for" + c.getProObj() + " to take alone. " + c.getAge() + " knows " + c.getProSubj() + " has to go to Lindhelm to find help.");
    }

}
