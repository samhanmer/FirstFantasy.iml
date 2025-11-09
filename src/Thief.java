public class Thief extends Job {
        @Override
        public void giveStarterEquipment(Inventory inventory) {
            inventory.addItem("Lockpick", 5);
            inventory.addItem("Tattered Prison Garb", 1);
            inventory.addItem("Dagger", 1);
        }

        @Override
        public String getDescription() {
            return "Quick with their hands and wit to take what they need- either out of necessity or for fun";
        }

        @Override
        public void printOriginStory(Character c) {
            System.out.println(c.getName() + " hasn't had an easy life. " + c.getProSubj() + " was forgotten about- left to starve. One day, someone reached a hand out to you. A thieves guild member named Scrap.");
            System.out.println("Being on the verge of starvation, you join- and don't look back. You steal and plunder from the towns richest- eating more food than you ever thought possible... until that day.");
            System.out.println("Scrap promised the biggest payday yet- but the mission didn't go as planned. Scrap sold the group out... the guards were waiting and caught " + c.getName() + ".");
            System.out.println("Turns out, there really isn't any honor among thieves... \n" + "The prison guard informs you that you must join the guild for community service. Join or die. With little option, you let the guard take you to the guild.");
        }
    }

