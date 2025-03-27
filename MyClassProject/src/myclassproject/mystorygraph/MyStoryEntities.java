package myclassproject.mystorygraph;

import com.entities.*;
import com.enums.*;

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	
	//Petra Radmanovic
	
	public static final Characters player = new Characters("Player", BodyTypes.A, Clothing.LightArmour, HairStyle.Short, Colors.Brown, 5);
    public static final Characters wiseMan = new Characters("Wise Man", BodyTypes.B, Clothing.Warlock, HairStyle.Spiky, Colors.Black, 7);
    public static final Characters banditLeader = new Characters("Bandit Leader", BodyTypes.E, Clothing.Bandit, HairStyle.Bald, Colors.Black, 6);
    public static final Characters merchant = new Characters("Mysterious Merchant", BodyTypes.B, Clothing.Merchant, HairStyle.Ponytail, Colors.Blonde, 5);
    public static final Characters forestBandit = new Characters("Forest Bandit", BodyTypes.D, Clothing.Bandit, HairStyle.Spiky, Colors.Black, 4);
    public static final Characters guard1 = new Characters("Guard 1", BodyTypes.D, Clothing.HeavyArmour, HairStyle.Short, Colors.Brown,5);
    public static final Characters guard2 = new Characters("Guard 2", BodyTypes.D, Clothing.HeavyArmour, HairStyle.Short, Colors.Brown,5);
    public static final Characters guard3 = new Characters("Guard 3", BodyTypes.D, Clothing.HeavyArmour, HairStyle.Short, Colors.Brown,5);
    public static final Characters guardCell = new Characters("Guard Cell", BodyTypes.D, Clothing.HeavyArmour, HairStyle.Short, Colors.Brown,5);
    public static final Characters theKing = new Characters("The King", BodyTypes.D, Clothing.King, HairStyle.Short, Colors.Brown, 5);
    public static final Characters prisoner = new Characters("Prisoner", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 5);
    
    public static final Place forest = new Place("Forest", PlaceTypes.ForestPath);
    public static final Place strangeFruitGrove = new Place("Strange Fruit Grove", PlaceTypes.ForestPath);
    public static final Place spookyArea = new Place("Net Trap Area", PlaceTypes.SpookyPath);
    public static final Place appleBasketCabin = new Place("Apple Basket Cabin", PlaceTypes.Farm);
    public static final Place TheKingsCastle = new Place("The King Castle", PlaceTypes.GreatHall);
    public static final Place TheDungeons = new Place("The Dungeons", PlaceTypes.Dungeon);
    
    
    public static final Place lostCity = new Place("Lost City", PlaceTypes.City);
     public static final Place banditCamp = new Place("Bandit Camp", PlaceTypes.Camp);
     public static final Place merchantShop = new Place("Merchant Shop", PlaceTypes.AlchemyShop);
     public static final Place castle = new Place("Castle", PlaceTypes.GreatHall);
    
    
    public static final Item apple = new Item("Apple", ItemTypes.Apple);
    public static final Item sword = new Item("Sword", ItemTypes.Sword);
    public static final Item netTrap = new Item("Net Trap", ItemTypes.BlueCloth);
    
    public static final Furniture eastEndTowardCity = new Furniture(forest, FurnitureTypes.EastEnd);
    public static final Furniture westEndTowardForest = new Furniture(forest, FurnitureTypes.WestEnd);
    public static final Furniture dirtWalk = new Furniture(forest, FurnitureTypes.DirtPile);
    public static final Furniture swordInDirt = new Furniture(spookyArea, FurnitureTypes.DirtPile);
    public static final Furniture cabinPath = new Furniture(spookyArea, FurnitureTypes.WestEnd);
    public static final Furniture cabinDoor = new Furniture(appleBasketCabin, FurnitureTypes.Door);
    public static final Furniture streamArea = new Furniture(appleBasketCabin, FurnitureTypes.Exit);
    public static final Furniture westEndSpookyArea = new Furniture(spookyArea, FurnitureTypes.WestEnd);
    public static final Furniture eastEndSpookyArea = new Furniture(spookyArea, FurnitureTypes.EastEnd);
    public static final Furniture ToTheDungeons = new Furniture(TheKingsCastle, FurnitureTypes.Gate);
    public static final Furniture theThrone = new Furniture(TheKingsCastle, FurnitureTypes.Throne);
    public static final Furniture EnterDungeons = new Furniture(TheDungeons, FurnitureTypes.Door);
    public static final Furniture cellDoor = new Furniture(TheDungeons, FurnitureTypes.CellDoor);
    
  
  
    
    //Hrishi Kabra
    
    public static final Place insideCabin = new Place("Inside Cabin", PlaceTypes.Cottage);
    public static final Furniture insideCabinDoor = new Furniture(insideCabin, FurnitureTypes.Door);
    public static final Furniture strangeFruitGroveEntrance = new Furniture(strangeFruitGrove, FurnitureTypes.EastEnd);
    public static final Furniture toTheWizard = new Furniture(TheKingsCastle, FurnitureTypes.Gate);
    public static final Place TheWizardLibrary = new Place("The Wizard's Library", PlaceTypes.Library);
    public static final Furniture EnterWizardLibrary = new Furniture(TheWizardLibrary, FurnitureTypes.Door);
    
    
    
    //Rodrigo Guzman
    public static final Furniture lostCityGate = new Furniture(lostCity, FurnitureTypes.NorthEnd);
    
}