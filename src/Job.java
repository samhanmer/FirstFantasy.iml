public abstract class Job { //Exists to be @overwritten in the selected classes
    public abstract void giveStarterEquipment(Inventory inventory);
    public abstract String getDescription();
    public abstract void printOriginStory(Character c, DialogGui gui, Dialog dialog);
}
