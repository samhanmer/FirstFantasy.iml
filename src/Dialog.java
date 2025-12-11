import javafx.stage.Stage;

public class Dialog {

    private Character currentCharacter;
    private Stage stage;
    private DialogGui gui;
    private Game game;

    public Dialog(Stage stage) {
        this.stage = stage;
        this.gui = gui;
    }
    public Dialog(DialogGui gui, Game game) {
        this.gui = gui;
        this.game = game;

    }

    public void setCharacter(Character c) {
        this.currentCharacter = c;
    }
    private void lockpickMinigame() {
        game.lockpickMinigame("easy");
    }


    public void guildHall(Character c) {
        setCharacter(c);

        if (c.getClassName().equalsIgnoreCase("thief")) {
            gui.print("You're forcefully brought to the guild. Citizens point at you as you walk by. Your chains rattle with every step.\n" + "The guard who never introduced himself pushes you through the guild doors- still with shackles around your arms and legs.");
            gui.print("The woman at the receptionist desk looks at you wearily- notably moving a gold pouch out of your view.");
        } else if (c.getClassName().equalsIgnoreCase("alchemist")) {
            gui.print("You rush through the bustling streets of Lindhelm in a panic- Cid is in danger!\n" + "You burst through the doors of the guild. The woman at the counter jumps but composes herself. You explain your situation to her.");
            gui.print("'I see. The city has been more dangerous lately- guards have had to patrol outside the walls because of monster attacks. I'm afraid you're at the bottom of a large list of those in need.' she says with an empathetic look.");
        } else if (c.getClassName().equalsIgnoreCase("wizard")) {
            gui.print("You manage to ask around and find your way to the guild. You explain your situation to the lady at the receptionist desk.");
            gui.print("'I see... Sounds like things have been rough for you. That's a long way- perhaps we can help you out if you're interested in work.' she propositions.");
        } else if (c.getClassName().equalsIgnoreCase("ranger")) {
            gui.print("You enter the city of Lindhelm- it feels strange to be among people again. It takes awhile, but you find the Guildhall.");
            gui.print("'Welcome in.' a woman at the receptionist desk greets you.\n" + "You explain what you saw in the woods.\n" + "'I've heard rumors that's why the towns guard is on patrols out there. Everyone is busy, but the guild helps you gain strength with quests!' She explains.");
        } else if (c.getClassName().equalsIgnoreCase("templar")) {
            gui.print("You easily find your way to the Guildhall. A woman at the receptionist desk waves at you with a smile. \n" + "'What can we do for you, Templar?' she says with a slight bow of her head.");
        } else {
            gui.print("You wander into the city of Lindhelm. When you ask for instructions you find the little people here answer very quickly and leave your presence just as fast.");
            gui.print("As you enter the Guildhall, a woman at a table waves at you. \n" + "'Ah, another glory-seeker are we? How can I help you?' She says with a big smile.");
        }

        gui.print("\n 'So, what can I help you with today?' the receptionist asks with a polite smile.");
        guildHallChoice();
    }

    private void guildHallChoice() {
        gui.clear();

        gui.addChoice("What's the history of the Guild?", () -> {
            gui.print("'There's not much history here yet, wanderer. The guild was formed only a couple months ago- our leader is a skilled adventurer regarded as a hero- however he's not been seen since we opened up!'");
            guildHallChoice();
        });

        gui.addChoice("Any famous adventurers in today?", () -> {
            gui.print("'We've three of them in right now. Agnis the Holy Templar, Ragnar the Tempest- a Ranger, and finally Harold of the Page, our best wizard. They love talking to new blood.'");
            guildHallChoice();
        });

        if (currentCharacter.getClassName().equalsIgnoreCase("alchemist")) {
            gui.addChoice("[ALCHEMIST] Ask about being accepted", () -> {
                gui.print("*She looks you up and down* 'It's certainly unorthodox- and I mean really unheard of... but I don't see why not. Just... be mindful when accepting quests.'");
                guildHallChoice();
            });
        }

        gui.addChoice("I'd like to join the guild.", () -> {
            gui.print("'Great! Just sign here- here and here... and there... and we aren't liable for any injuries, loss of limbs or death when questing.' She says the last part quickly.");

            gui.clear();
            gui.addChoice("Continue", () -> {
                gui.print("You approach Henry, who hands you 3 lockpicks.");
                currentCharacter.addItem("Lockpick", 3);
                gui.print("LOCKPICK MINIGAME NEEDS WORK BEFORE IMPLEMENTING"); //Minigame works, just couldn't get it working with JavaFX story flow yet.

                if (currentCharacter.getClassName().equalsIgnoreCase("barbarian")) {
                    gui.print("'By the gods...! You know... I really should've expected this. Here, take this copper amulet- that is your rank in the guild now.");
                } else if (currentCharacter.getClassName().equalsIgnoreCase("thief")) {
                    gui.print("'Perhaps it might help your case if you at least pretend you can't do that so well. Haha just messing with you. Take this copper amulet- you're a copper rank now.'");
                } else {
                    gui.print("'Looks like you got some good practice in. Take this copper amulet- that indicates your rank in the guild.'");
                }
                guildPrologue();
            });
        });
    }


    public void guildPrologue() {

        setCharacter(currentCharacter);
        gui.clear();

        gui.print("'Feel free to take a load off for a bit. Talk to people, look at the quest board- whatever ya like.' He walks off to do other tasks.");

        gui.addChoice("Approach Agnis the Holy Templar", () -> {
            if (currentCharacter.getClassName().equalsIgnoreCase("templar")) {
                gui.print("\n[TEMPLAR]: *Agnis looks up at you as you approach her table* 'Why look who it is! Been awhile since I've seen you " + currentCharacter.getName() + " I heard you'd be here eventually.");
            } else {
                gui.print("\n *Agnis looks up at you as you approach her table* 'Hail stranger. My name is Agnis. I can tell you're strong- I look forward to hearing your achievements.");
            }
            guildPrologue(); // go back to choices after reading
        });

        gui.addChoice("Approach Ragnar the Tempest Ranger", () -> {
            if (currentCharacter.getClassName().equalsIgnoreCase("ranger")) {
                gui.print("\n[RANGER]: *Ragnar stops aiming his bow at the target range and speaks* 'Another Ranger... I know what brings you here. Demons disturb the forest...");
            } else {
                gui.print("*You find Ragnar, but he shoos you away. It seems he has nothing to say at this moment*");
            }
            guildPrologue();
        });

        gui.addChoice("Approach Harold the Wizard", () -> {
            if (currentCharacter.getClassName().equalsIgnoreCase("wizard")) {
                gui.print("[WIZARD]: Harold is in a large crowd- luckily you could find him as you get sense is Mana...");
            } else {
                gui.print("*You're unable to find the wizard despite knowing he's here somewhere...");
            }
            guildPrologue();
        });

        if (currentCharacter.getClassName().equalsIgnoreCase("barbarian")) {
            gui.addChoice("[BARBARIAN]: CHUG. ALE.", () -> {
                gui.print("*You grab the nearest Ale and smash it down in record time. You feel refreshed!");
                guildPrologue();
            });
        }

        gui.addChoice("Inspect the Questboard", () -> {
            gui.print("*You inspect the Questboard, noticing only one quest. Something about scouting the forest for signs of monsters. You accept this quest.");
            firstQuest();
        });
    }
    public void firstQuest() {
        gui.clear();
        setCharacter(currentCharacter);
        gui.print("You hand the receptionist the paper to accept your quest.");
        gui.print("'Remember, this is not a combat quest. Report any strange sightings or dangerous creatures- but stay out of harms way.' She says in a serious tone.");
        if (currentCharacter.getClassName().equalsIgnoreCase("ranger")) {
            gui.print("[RANGER]: You think to yourself that there's most certainly a demonic being in the forest. Best be cautious.");
        }

        gui.print("You give one last glance at the city as you wander out of the gates before entering the forest.");
        gui.print("As you enter the deep woods, an uneasy feeling washes over you.\n");
        if (currentCharacter.getClassName().equalsIgnoreCase("barbarian")) {
            gui.print("[BARBARIAN]: The hairs on your neck stand up- your instincts never fail you. Something is *hunting* you- worse is you can tell it's a fight you would lose.");
        }
        if (currentCharacter.getClassName().equalsIgnoreCase("templar")) {
            gui.print("[TEMPLAR]: You feel a darkness cling to you. This is something you've only read about... a strong demonic being is nearby.");
        }
        gui.print("You hear a twig snap behind you. When you turn to face it- a hulking behemoth of a creature stands before you. Large muscular body, spiked infernal armor, giant horns, easily over 10 feet tall... A powerful demon.");
        gui.print("It says something in tongues you do not comprehend. You notice that this demon is holding something small and shiny, almost magical in it's left hand...\n");
        if (currentCharacter.getClassName().equalsIgnoreCase("wizard")) {
            gui.print("[WIZARD]: You recognize that gemstone... it's a magical object said to have unlimited potential... but only teachers at your school receive these. Magic is highly regulated. Something strange is going on.");
        }
        if (currentCharacter.getClassName().equalsIgnoreCase("Alchemist")) {
            gui.print("[ALCHEMIST]: From your understanding this is a magical object you've seen professors at the magic college use. It seems to have a lot of uses- but can be used in potion crafting.");
        }

        gui.print("Suddenly you feel a splitting headache- a voice infiltrates your mind. 'LEAVE, WILL NOT ASK TWICE.' It rattles every bone in your body.");

        gui.addChoice("Fight the demon", () -> {
            gui.print("You brace yourself to fight. The demon sighs in annoyance. Your vision fades to black- you perish before you manage anything. GAME OVER");
            return;
                });
        gui.addChoice("Flee from the area, never return to the city.", () -> {
            gui.print("You flee from the big city, never to show your face to the guild again. You live peacefully... well... until... BAD END.");
            return;
                });
        gui.addChoice("Escape back to the guild.", () -> {
            gui.print("You leave the forest in a hurry. That creature was far more than you could handle in your current state. You make it back into town without further incident.");
            gui.print("Thanks for playing! End of the prologue episode.");
                });
    }
}



