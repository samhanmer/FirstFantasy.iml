import java.util.Scanner;


public class Dialog {
    private Scanner scnr;

    public Dialog(Scanner scnr) {
        this.scnr = scnr;
    }


    public void guildHall(Character c) {
        if (c.getClassName().equalsIgnoreCase("thief")) {
            System.out.println("You're forcefully brought to the guild. Citizens point at you as you walk by. Your chains rattle with every step.\n" + "The guard who never introduced himself pushes you through the guild doors- still with shackles around your arms and legs.");
            System.out.println("The woman at the receptionist desk looks at you wearily- notably moving a gold pouch out of your view.");
        } else if (c.getClassName().equalsIgnoreCase("alchemist")) {
            System.out.println("You rush through the bustling streets of Lindhelm in a panic- Cid is in danger!\n" + "You burst through the doors of the guild. The woman at the counter jumps but composes herself. You explain your situation to her.");
            System.out.println("'I see. The city has been more dangerous lately- guards have had to patrol outside the walls because of monster attacks. I'm afraid you're at the bottom of a large list of those in need.' she says with an empathetic look.");
        } else if (c.getClassName().equalsIgnoreCase("wizard")) {
            System.out.println("You manage to ask around and find your way to the guild. You explain your situation to the lady at the receptionist desk.");
            System.out.println("'I see... Sounds like things have been rough for you. That's a long way- perhaps we can help you out if you're interested in work.' she propositions.");
        } else if (c.getClassName().equalsIgnoreCase("ranger")) {
            System.out.println("You enter the city of Lindhelm- it feels strange to be among people again. It takes awhile, but you find the Guildhall.");
            System.out.println("'Welcome in.' a woman at the receptionist desk greets you.\n" + "You explain what you saw in the woods.\n" + "'I've heard rumors that's why the towns guard is on patrols out there. Everyone is busy, but the guild helps you gain strength with quests!' She explains.");
        } else if (c.getClassName().equalsIgnoreCase("templar")) {
            System.out.println("You easily find your way to the Guildhall. A woman at the receptionist desk waves at you with a smile. \n" + "'What can we do for you, Templar?' she says with a slight bow of her head.");
        } else {
            System.out.println("You wander into the city of Lindhelm. When you ask for instructions you find the little people here answer very quickly and leave your presence just as fast.");
            System.out.println("As you enter the Guildhall, a woman at a table waves at you. \n" + "'Ah, another glory-seeker are we? How can I help you?' She says with a big smile.");
        }

        System.out.println("\n 'So, what can I help you with today?' the receptionist asks with a polite smile.");
        System.out.println("\n1. 'What's the history of this Guild?'");
        System.out.println("\n2. 'Any famous adventurers in today?'");
        if (c.getClassName().equalsIgnoreCase("alchemist")) {
            System.out.println("\n3.[ALCHEMIST]'You'll even accept an alchemist as a member? I've never fought a monster before.'");
        }
        System.out.println("\n9. 'I would like to join the guild.'");

        int option = -1;
        int choice = -1;

        while (option != 9) {
            choice = scnr.nextInt();
            option = choice;

            switch (choice) {
                case 1:
                    System.out.println("\n1. 'There's not much history here yet, wanderer. The guild was formed only a couple months ago- our leader is a skilled adventurer regarded as a hero- however he's not been seen since we opened up!'");
                    break;
                case 2:
                    System.out.println("\n2. 'We've three of them in right now. Agnis the Holy Templar, Ragnar the Tempest- a Ranger, and finally Harold of the Page, our best wizard. They love talking to new blood.'");
                    break;
                case 3:
                    if (c.getClassName().equalsIgnoreCase("alchemist")) {
                        System.out.println("\n[ALCHEMIST]: 3. *She looks you up and down* 'It's certainly unorthodox- and I mean really unheard of... but I don't see why not. Just... be mindful when accepting quests.'");
                    } else {
                        System.out.println("I didn't quite catch that. Could you repeat yourself?");
                    }
                    break;
                case 9:
                    System.out.println("\n9. 'Great! Just sign here- here and here... and there... and we aren't liable for any injuries, loss of limbs or death when questing.' She says the last part quickly.");
                    break;

                default:
                    System.out.println("I didn't quite catch that. Could you repeat yourself?");
            }
        }
        System.out.println("\n 'Now that that's taken care of... go talk to Henry. He'll teach you how to pick locks- a valuable lesson for any adventurer in a dungeon.'");
        if (c.getClassName().equalsIgnoreCase("thief")) {
            System.out.println("'...Though I kind of doubt you need this training- reviewing the basics never hurts. Good luck.' She says awkwardly scratching the back of her head.");
        }
        System.out.println("You approach Henry- a tall human man who's clearly a skilled adventurer. \n" + "'Greetings newblood! Name's Henry. Take these lockpicks and try to open that chest over there... Then I'll explain more stuff.' he says as he hands you 3 lockpicks.");
        c.addItem("Lockpick", 3);
    }

    public void guildPrologue(Character c) {
        if (c.getClassName().equalsIgnoreCase("barbarian")) {
            System.out.println("'By the gods...! You know... I really should've expected this. Here, take this copper amulet- that is your rank in the guild now.");
        } else if (c.getClassName().equalsIgnoreCase("thief")) {
            System.out.println("'Perhaps it might help your case if you at least pretend you can't do that so well. Haha just messing with you. Take this copper amulet- you're a copper rank now.'");
        } else {
            System.out.println("'Looks like you got some good practice in. Take this copper amulet- that indicates your rank in the guild.'");
        }
        System.out.println("'Feel free to take a load off for a bit. Talk to people, look at the quest board- whatever ya like.' He walks off to do other tasks.");

        System.out.println("1. Approach Agnis the Holy Templar.");
        System.out.println("2. Approach Ragnar the Tempest Ranger.");
        System.out.println("3. Approach Harold of the Page, the Wizard.");
        if (c.getClassName().equalsIgnoreCase("barbarian")) {
            System.out.println("4. [BARBARIAN]: CHUG. ALE.");
        }
        System.out.println("9. Inspect the Questboard [END OF THIS VERSION]");
        int option = -1;
        int choice = -1;

        while (option != 9) {
            choice = scnr.nextInt();
            option = choice;

            switch (choice) {
                case 1:
                    if (c.getClassName().equalsIgnoreCase("templar")) {
                        System.out.println("\n[TEMPLAR]: *Agnis looks up at you as you approach her table* 'Why look who it is! Been awhile since I've seen you " + c.getName() + " I heard you'd be here eventually.\n" + " ");
                    } else {
                        System.out.println("\n *Agnis looks up at you as you approach her table* 'Hail stranger. My name is Agnis. I'm a Templar. I can tell you're strong- I look forward to hearing your achievements.");
                    }
                    break;
                case 2:
                    if (c.getClassName().equalsIgnoreCase("ranger")) {
                        System.out.println("\n[RANGER]: *Ragnar stops aiming his bow at the target range and speaks* 'Another Ranger... I know what brings you here. Demons disturb the forest. This is what keeps the town guard so busy. \n" + " I would suggest accepting quests that take out outside the walls. You may find more clues as to what causes this issue...' *He resumes training*");
                    } else {
                        System.out.println("*You find Ragnar, but he shoos you away. It seems he has nothing to say at this moment*");
                    }
                    break;
                case 3:
                    if (c.getClassName().equalsIgnoreCase("wizard")) {
                        System.out.println("[WIZARD]: Harold is in a large crowd- luckily you could find him as you get sense is Mana. \n" + "'Ahh, a young wizard... wait- you're from Mayflower? Most troubling... The Headmaster is acting most strangly. Tell me, do you know where Mana truly comes from?... nevermind. Find me when the time is right.' *He vanishes*");
                    } else {
                        System.out.println("*You're unable to find the wizard despite knowing he's here somewhere...");
                    }
                    break;
                case 4: if (c.getClassName().equalsIgnoreCase("barbarian")) {
                    System.out.println("*You grab the nearest Ale and smash it down in record time. You feel refreshed!");
                } else {
                    System.out.println("Invalid input, try again.");
                }
                break;
                case 9:
                    System.out.println("*You inspect the Questboard- ~WORK IN PROGRESS, END OF BUILD~*");
                    break;
                default: System.out.println("Invalid input, try again.");
                break;
            }

        }
    }
}
