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
    public static final Characters wiseMan = new Characters("Wise Man", BodyTypes.C, Clothing.Warlock, HairStyle.Long, Colors.Black, 7);
    public static final Characters banditLeader = new Characters("Bandit Leader", BodyTypes.E, Clothing.Bandit, HairStyle.Bald, Colors.Black, 6);
    public static final Characters merchant = new Characters("Mysterious Merchant", BodyTypes.B, Clothing.Merchant, HairStyle.Ponytail, Colors.Blonde, 5);
    public static final Characters forestBandit = new Characters("Forest Bandit", BodyTypes.D, Clothing.Bandit, HairStyle.Spiky, Colors.Black, 4);

    
    public static final Place forest = new Place("Forest", PlaceTypes.ForestPath);
    public static final Place lostCity = new Place("Lost City", PlaceTypes.City);
    public static final Place banditCamp = new Place("Bandit Camp", PlaceTypes.Camp);
    public static final Place merchantShop = new Place("Merchant’s Shop", PlaceTypes.AlchemyShop);
    public static final Place castle = new Place("Castle", PlaceTypes.GreatHall);
    public static final Place strangeFruitGrove = new Place("Strange Fruit Grove", PlaceTypes.ForestPath);
    public static final Place spookyArea = new Place("Net Trap Area", PlaceTypes.SpookyPath);
    public static final Place appleBasketCabin = new Place("Apple Basket Cabin", PlaceTypes.Farm);
    
    
    public static final Item apple = new Item("Apple", ItemTypes.Apple);
    public static final Item sword = new Item("Sword", ItemTypes.Sword);
    public static final Item netTrap = new Item("Net Trap", ItemTypes.BlueCloth);
    
    public static final Furniture eastEndTowardCity = new Furniture(forest, FurnitureTypes.EastEnd);
    public static final Furniture westEndTowardForest = new Furniture(forest, FurnitureTypes.WestEnd);
    public static final Furniture dirtWalk = new Furniture(forest, FurnitureTypes.DirtPile);
    public static final Furniture cabinPath = new Furniture(spookyArea, FurnitureTypes.WestEnd);
    public static final Furniture cabinDoor = new Furniture(appleBasketCabin, FurnitureTypes.Door);
    public static final Furniture streamArea = new Furniture(appleBasketCabin, FurnitureTypes.Exit);
    
  /*
    public static final Furniture merchantCounter = new Furniture(merchantShop, FurnitureTypes.AlchemistTable);
    public static final Furniture banditTent = new Furniture(banditCamp, FurnitureTypes.Firepit);
    public static final Furniture lostCityGate = new Furniture(lostCity, FurnitureTypes.Gate);
    public static final Furniture castleEntrance = new Furniture(castle, FurnitureTypes.Door);
    public static final Furniture appleBasket = new Furniture(appleBasketCabin, FurnitureTypes.Table);
   
   */
    
    //Hrishi Kabra
    
    //Rodrigo Guzman
}
