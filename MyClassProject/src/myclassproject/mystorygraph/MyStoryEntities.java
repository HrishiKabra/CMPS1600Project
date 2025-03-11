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
	
	
	public static final Characters player = new Characters("Player", BodyTypes.A, Clothing.Adventurer, HairStyle.Short, Colors.Brown, 5);
    public static final Characters wiseMan = new Characters("Wise Man", BodyTypes.C, Clothing.Robe, HairStyle.Long, Colors.White, 7);
    public static final Characters banditLeader = new Characters("Bandit Leader", BodyTypes.E, Clothing.Bandit, HairStyle.Bald, Colors.Black, 6);
    public static final Characters merchant = new Characters("Mysterious Merchant", BodyTypes.B, Clothing.Merchant, HairStyle.Ponytail, Colors.DarkBrown, 5);
    public static final Characters forestBandit = new Characters("Forest Bandit", BodyTypes.D, Clothing.Bandit, HairStyle.BuzzCut, Colors.Black, 4);

    
    public static final Place forest = new Place("Forest", PlaceTypes.Wilderness);
    public static final Place lostCity = new Place("Lost City", PlaceTypes.City);
    public static final Place banditCamp = new Place("Bandit Camp", PlaceTypes.Camp);
    public static final Place merchantShop = new Place("Merchant’s Shop", PlaceTypes.Shop);
    public static final Place castle = new Place("Castle", PlaceTypes.Fortress);
    public static final Place strangeFruitGrove = new Place("Strange Fruit Grove", PlaceTypes.Garden);
    public static final Place netTrapArea = new Place("Net Trap Area", PlaceTypes.Wilderness);
    public static final Place appleBasketCabin = new Place("Apple Basket Cabin", PlaceTypes.Cottage);
    
    
    public static final Item apple = new Item("Apple", ItemTypes.Fruit);
    public static final Item strangeFruit = new Item("Strange Fruit", ItemTypes.Fruit);
    public static final Item sword = new Item("Sword", ItemTypes.Weapon);
    public static final Item netTrap = new Item("Net Trap", ItemTypes.Trap);

    
    public static final Furniture forestPath = new Furniture(forest, FurnitureTypes.Pathway);
    public static final Furniture merchantCounter = new Furniture(merchantShop, FurnitureTypes.Counter);
    public static final Furniture banditTent = new Furniture(banditCamp, FurnitureTypes.Tent);
    public static final Furniture lostCityGate = new Furniture(lostCity, FurnitureTypes.Gate);
    public static final Furniture castleEntrance = new Furniture(castle, FurnitureTypes.Door);
    public static final Furniture appleBasket = new Furniture(appleBasketCabin, FurnitureTypes.Table);

}
