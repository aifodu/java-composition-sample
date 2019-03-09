import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){         
        new App().start();
    }    

}

class App {

    /* The class App has-a property of MainCourse class.
        See line 186 for MainCourse class  declaration.
        See the swicth statement on line 47 for its instantiation. */
    private MainCourse main;

    /* The class App has-a property of Garnish class.
        See line 198 for Garnish class declaration.
        See the swicth statement on line 90 for its instantiation. */
    private Garnish garnish;

    /* The class App has-a property of Dessert class.
        See line 208 for Dessert class declaration.
        See the swicth statement on line 128 for its instantiation. */
    private Dessert dessert;

    Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("\nWELCOME TO THE MEAL ORDERING APP USING COMPOSITION");     
        System.out.println("==================================================");     
        selectMainCourse();
    }

    private void selectMainCourse() {
        Integer mainChoice;

        System.out.println("\nPlease select main course"); 
        System.out.println("1. Garri"); 
        System.out.println("2. Rice"); 
        System.out.println("3. Peppersoup"); 

        System.out.print("\nEnter choice: "); 
        mainChoice = Integer.parseInt(scanner.next());
        
        switch(mainChoice) {
            case 1: {
                main = new MainCourse("Garri", "Carbohydrate", 1000);
                printMainCourse(main); 
                selectGarnish();
                break;
            }
            case 2: { 
                main = new MainCourse("Rice", "Starch", 900);
                printMainCourse(main); 
                selectGarnish();
                break;
            }
            case 3: { 
                main = new MainCourse("Peppersoup", "Protein", 1500);
                printMainCourse(main); 
                selectDessert();
                break;
            }
            default: {
                System.out.println("\nThat choice does not exist, try again!"); 
                selectMainCourse();
            }
        }
    }

    private void printMainCourse(MainCourse course){
        System.out.print("MAIN COURSE: ");
        System.out.printf("%s(%s) - N%d.00", main.name, main.classification, main.price);
    }

    private void selectGarnish() {
        Integer garnishchoice;

        System.out.println(new String(new char[3]).replace("\0", "\r\n"));
        System.out.println("Now select garnish"); 
        System.out.println("1. Beef"); 
        System.out.println("2. Chicken"); 
        System.out.println("#. None"); 

        System.out.print("\nEnter choice: "); 
        garnishchoice = Integer.parseInt(scanner.next());
        
        switch(garnishchoice) {
            case 1: {
                garnish = new Garnish("Beef", 300);
                printGarnish(garnish);
                break;
            }
            case 2: { 
                garnish = new Garnish("Chicken", 350);
                printGarnish(garnish);
                break;
            }
            default: {
                garnish = new Garnish("No garnish", 0);
                printGarnish(garnish);
            }
        }
    }

    private void printGarnish(Garnish garnish){
        System.out.print("GARNISH: ");
        System.out.printf("%s - N%d.00", garnish.name, garnish.price); 
        selectDessert();
    }

    
    private void selectDessert() {
        Integer dessertChoice;

        System.out.println(new String(new char[3]).replace("\0", "\r\n"));
        System.out.println("You may also select dessert"); 
        System.out.println("1. Fruitcake"); 
        System.out.println("2. Ice cream"); 
        System.out.println("3. Sweets"); 
        System.out.println("#. None"); 

        System.out.print("\nEnter choice: "); 
        dessertChoice = Integer.parseInt(scanner.next());

        switch(dessertChoice) {
            case 1: {
                dessert = new Dessert("Fruitcake", 180);
                printDessert(dessert);
                break;
            }
            case 2: { 
                dessert = new Dessert("Ice cream", 220);
                printDessert(dessert);
                break;
            }
            case 3: { 
                dessert = new Dessert("Sweets", 220);
                printDessert(dessert);
                break;
            }
            default: {
                dessert = new Dessert("No dessert", 0);
                printDessert(dessert);
            }
        }
    }

    private void printDessert(Dessert dessert){
        System.out.print("DESSERT: ");
        System.out.printf("%s - N%d.00", dessert.name, dessert.price);
        printSummary(); 
    }

    private void printSummary() {
        Integer total;
        System.out.println(new String(new char[4]).replace("\0", "\r\n"));
        System.out.println("\n\n========= ORDER SUMMARY =========");
        System.out.println("=================================\n");

        System.out.print("MAIN COURSE: ");
        System.out.printf("%s(%s) - N%d.00\n", main.name, main.classification, main.price); 

        if(garnish instanceof Garnish) {
            System.out.print("GARNISH: ");
            System.out.printf("%s - N%d.00\n", garnish.name, garnish.price); 
        }

        System.out.print("DESSERT: ");
        System.out.printf("%s - N%d.00\n", dessert.name, dessert.price);

        if(garnish instanceof Garnish) {
            total = main.price + garnish.price + dessert.price;
        }
        else{
            total = main.price + dessert.price;
        }
       
        System.out.printf("\nORDER TOTAL: N%d.00\r\n", total);        

    }
}

class MainCourse {
    public String name;
    public String classification;
    public Integer price;

    public MainCourse(String name, String classification, Integer price){
        this.name = name;
        this.price = price;
        this.classification = classification;
    }
}

class Garnish {
    public String name;
    public Integer price;

    public Garnish(String name, Integer price){
        this.name = name;
        this.price = price;
    }
}

class Dessert {
    public String name;
    public Integer price;

    public Dessert(String name, Integer price){
        this.name = name;
        this.price = price;
    }
}