public class Character { //Class keeps all info about the player character in one place.
    private String name;            //e.g. Sam
    private String proSubj;         // e.g., he / she / they
    private String proObj;          // e.g., him / her / them
    private String proPossAdj;      // e.g., his / her / their
    private int age;                //e.g. 38
    private Job job;                //Stores class related information
    private Inventory inventory;    //Stores the inventory system

    public Character(String name, String proSubj, String proObj, String proPossAdj, int age) {
        this.name = name;
        this.proSubj = proSubj;
        this.proObj = proObj;
        this.proPossAdj = proPossAdj;
        this.age = age;
        this.inventory = new Inventory();
    }

    //Constructors
    public String getName() {
        return name;
    }

    public String getProSubj() {
        return proSubj;
    }

    public String getProObj() {
        return proObj;
    }

    public String getProPossAdj() {
        return proPossAdj;
    }

    public int getAge() {
        return age;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Job getPlayerClass() {
        return job;
    }

    public void setPlayerClass(Job playerClass) {
        this.job = playerClass;
    }

    public String getClassName() {
        return job.getClass().getSimpleName();
    }

    public void addItem(String item, int amount) {
        inventory.addItem(item, amount);


    }
}
