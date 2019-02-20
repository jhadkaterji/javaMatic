import java.util.Scanner;

//Jhad Katerji
//Northern Trust Coding Interview
//Starting on 2/19/2019

public class javaMatic 
{
        //Set all the original inventory values for ingredients. 
        public static int cocoaInv;//Starting Cocoa Inventory
        public static int coffeeInv;//Starting Coffee Inventory
        public static int creamInv;//Starting Cream Inventory
        public static int decafInv;//Starting Decaf Coffee Inventory
        public static int espressoInv;//Starting Espresso Inventory
        public static int foamedMilkInv;//Starting FoamedMilk Inventory
        public static int steamedMilkInv;//Starting SteamedMilk Inventory
        public static int sugarInv;//Starting Sugar Inventory
        public static int whippedCreamInv;//Starting Whipped Cream Inventory
        
        //Creating the strings that will later represent whether or not there are enough ingredients to create these specific drinks.
        public static String coffeeDrink;
        public static String decafCoffeeDrink;
        public static String caffeLatteDrink;
        public static String caffeAmericanoDrink;
        public static String caffeMochaDrink;
        public static String cappuccinoDrink;

    public static void main (String[]args)
    {
        restockInventory();//set all things in the inventory to their starting "10" value.
        drinkCheck();//Check the inventory to see what drinks are available and set if they are true or false.
        printInventory();//Print the inventory.
        printMenu();//Print the menu based on what is available.
        userInputFunc();//Start checking for user input - modify based on what the user types. 
    }
    
    public static void printInventory()
    {
        //Printing the Inventory - Item followed by amount of inventory left.
        System.out.println("Inventory:");
        System.out.println("Cocoa," + cocoaInv);
        System.out.println("Coffee," + coffeeInv);
        System.out.println("Cream," + creamInv);
        System.out.println("Decaf Coffee," + decafInv);
        System.out.println("Espresso," + espressoInv);
        System.out.println("Foamed Milk," + foamedMilkInv);
        System.out.println("Steamed Milk," + steamedMilkInv);
        System.out.println("Sugar," + sugarInv);
        System.out.println("Whipped Cream," + whippedCreamInv);
    }

    public static void printMenu()
    {
        //Printing the Menu - Possible option followed by the price and it's "true" or "flase" value.
        System.out.println("Menu:");
        System.out.println("1,Caffe Americano,$3.30," + caffeAmericanoDrink);
        System.out.println("2,Caffe Latte,$2.55," + caffeLatteDrink);
        System.out.println("3,Caffe Mocha,$3.35," + caffeMochaDrink);
        System.out.println("4,Cappucino,$2.90," + cappuccinoDrink);
        System.out.println("5,Coffee,$2.75," + coffeeDrink);
        System.out.println("6,Decaf Coffee,$2.75," + decafCoffeeDrink);

    }

    //This method is used to check each type of drink and whether or not there is enough ingredients to create that drink.
    //If there are enough ingredients, that drink's variable gets set to "true"
    //If there are not enough ingredients, that drink's variable gets set to "false"
    public static void drinkCheck()
    {
        //Check if there is enough inventory for Coffee
        if (coffeeInv >= 3 && sugarInv >= 1 && creamInv >=1)
            coffeeDrink = "true";
        else
            coffeeDrink = "false";

        //Check if there is enough inventory for Decaf Coffee
        if (decafInv >= 3 && sugarInv >= 1 && creamInv >= 1)
            decafCoffeeDrink = "true";
        else
            decafCoffeeDrink = "false";

        //Check if there is enough inventory for Caffe Latte
        if (espressoInv >= 2 && steamedMilkInv >= 1)
            caffeLatteDrink = "true";
        else
            caffeLatteDrink = "false";

        //Check if there is enough inventory for Caffe Americano
        if (espressoInv >= 3)
            caffeAmericanoDrink = "true";
        else
            caffeAmericanoDrink = "false";

        //Check if there is enough inventory for Caffe Mocha
        if (espressoInv >= 1 && cocoaInv >= 1 && steamedMilkInv >= 1 && whippedCreamInv >= 1)
            caffeMochaDrink = "true";
        else
            caffeMochaDrink = "false";

        //Check if there is enough inventory for Caffe Mocha
        if (espressoInv >= 2 && steamedMilkInv >= 1 && foamedMilkInv >= 1)
            cappuccinoDrink = "true";
        else
            cappuccinoDrink = "false";
    }

    public static void userInputFunc()
    {
        //Check for user input
        //What number are they asking to get dispensed?? - we find out HERE. 
        Scanner inputScanner = new Scanner(System.in);
        String userSelectionNumber = inputScanner.next();

        //What happens if the user types "q" to quit the program
        if (userSelectionNumber.equals("q") || userSelectionNumber.equals("Q"))
            {
                System.exit(0);//Line to cause the program to quit.
            }

        //What happens if the user types "r" to restock the machine
        else if (userSelectionNumber.equals("r") || userSelectionNumber.equals("R"))
            {
                restockInventory();//set the inventory of everything back to 10.
            }

        //What happens if the user types the number 1 (Selects Caffe Americano).
        else if (userSelectionNumber.equals("1"))
            {
                if (caffeAmericanoDrink.equals("true"))//Check to see if there is enough inventory to make the drink.
                {
                espressoInv -= 3;//removes 3 espresso from inventory.
                System.out.println("Dispensing: Caffe Americano");
                }
                else//There is not enough inventory to make the drink. 
                System.out.println("Out of stock: Caffe Americano");
            }

        //What happens if the user types the number 2 (Caffe Latte).
        else if (userSelectionNumber.equals("2"))
            {
                if (caffeLatteDrink.equals("true"))//Check to see if there is enough inventory to make the drink.
                {
                espressoInv -= 2;//removes 2 espresso from inventory.
                steamedMilkInv -= 1;//removes 1 unit of steamed milk from inventory.
                System.out.println("Dispensing: Caffe Latte");
                }
                else//There is not enough inventory to make the drink. 
                System.out.println("Out of stock: Caffe Latte");
            }

        //What happens if the user types the number 3 (Caffe Mocha).
        else if (userSelectionNumber.equals("3"))
            {
                if (caffeMochaDrink.equals("true"))//Check to see if there is enough inventory to make the drink.
                {
                espressoInv -= 1;//removes 1 unit of espresso from inventory.
                cocoaInv -= 1;// removes 1 unit of cocoa from inventory.
                steamedMilkInv -= 1;//removes 1 unit of steamed milk from inventory.
                whippedCreamInv -= 1;//removes 1 unit of Whipped Cream from inventory.
                System.out.println("Dispensing: Caffe Mocha"); 
                }
                else//There is not enough inventory to make the drink. 
                System.out.println("Out of stock: Caffe Mocha"); 
            }

        //What happens if the user types the number 4 (Cappuccino).
        else if (userSelectionNumber.equals("4"))
            {
                if (cappuccinoDrink.equals("true"))//Check to see if there is enough inventory to make the drink.
                {
                espressoInv -= 2;//removes 2 units of espresso from inventory.
                steamedMilkInv -= 1;//removes 1 unit of steamed milk from inventory.
                foamedMilkInv -= 1;//removes 1 unit of foamed milk from inventory.
                System.out.println("Dispensing: Cappuccino");
                }
                else//There is not enough inventory to make the drink. 
                System.out.println("Out of stock: Cappuccino");
            }

        //What happens if the user types the number 5 (Coffee).
        else if (userSelectionNumber.equals("5"))
            {
                if (coffeeDrink.equals("true"))//Check to see if there is enough inventory to make the drink.
                {
                coffeeInv -= 3;//removes 3 units of coffee inventory.
                creamInv -= 1;//removes 1 unit of cream.
                sugarInv -= 1;//removes 1 unit of Sugar. 
                System.out.println("Dispensing: Coffee");
                }
                else//There is not enough inventory to make the drink. 
                System.out.println("Out of stock: Coffee");
            }

        //What happens if the user types the number 6 (Decaf Coffee).
        else if (userSelectionNumber.equals("6"))
            {
                if (decafCoffeeDrink.equals("true"))//Check to see if there is enough inventory to make the drink.
                {
                decafInv -= 3;//removes 3 units of Decaf coffee inventory.
                creamInv -= 1;//removes 1 unit of cream.
                sugarInv -= 1;//removes 1 unit of Sugar. 
                System.out.println("Dispensing: Decaf Coffee");
                }
                else//There is not enough inventory to make the drink. 
                System.out.println("Out of stock: Decaf Coffee");
            }
        else
            System.out.println("Invalid selection:" + userSelectionNumber);

            drinkCheck();//Check the inventory to see what drinks are available and set if they are true or false.
            printInventory();//Print the inventory.
            printMenu();//Print the menu based on what is available.
            userInputFunc();//Start checking for user input again. 
    }
    
    public static void restockInventory()
    {
                //Set all the original inventory values for ingredients. 
                cocoaInv=10;//Starting Cocoa Inventory
                coffeeInv=10;//Starting Coffee Inventory
                creamInv=10;//Starting Cream Inventory
                decafInv=10;//Starting Decaf Coffee Inventory
                espressoInv=10;//Starting Espresso Inventory
                foamedMilkInv=10;//Starting FoamedMilk Inventory
                steamedMilkInv=10;//Starting SteamedMilk Inventory
                sugarInv=10;//Starting Sugar Inventory
                whippedCreamInv=10;//Starting Whipped Cream Inventory
    }
}