package myclassproject.mystorygraph;

import java.util.List;
import static myclassproject.mystorygraph.MyStoryEntities.*;
import static myclassproject.questexample.QuestStoryEntities.cottageDoor;

import com.actions.*;
import com.sequences.*;
import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.*;

import myclassproject.questexample.ChoiceLabels;
import myclassproject.questexample.NodeLabels;

public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 * 
	 */
	
	
	//Petra Radmanovic
	
	@BuilderMethod
    public void rootEdges() {
        var root = get(MyNodeLabels.root.toString());
        var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.ForestTheBeginning.toString());
		root.add(new Edge(choice, nextNode));
	}
     
	@BuilderMethod
    public void theBeginningEdges() {
        var node = get(MyNodeLabels.ForestTheBeginning.toString());
        
        //Player decides to go towards the city
        var choice1 = new PlayerInteraction(player, MyChoiceLabels.HeadTowardTheLight.toString(), eastEndTowardCity); 
        var nextNode1 = get(MyNodeLabels.ForestTowardTheLostCity.toString());
        node.add(new Edge(choice1, nextNode1));
        
        //Player decides to go further into the forest
        var choice2 = new PlayerInteraction(player, MyChoiceLabels.HeadDeeperIntoTheForest.toString(), westEndTowardForest);
        var nextNode2 = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new Edge(choice2, nextNode2));
        
	}
	
	@BuilderMethod
    public void towardsTheLostCityEdges() {
        var node = get(MyNodeLabels.ForestTowardTheLostCity.toString());

        //Player decides to fully enter the city 
        var choice1 = new PlayerInteraction(player, MyChoiceLabels.ToTheCity.toString(), eastEndTowardCity);
        var nextNode1 = get(MyNodeLabels.CityTheLostCity.toString());
        node.add(new Edge(choice1, nextNode1));
        
        //Player goes back to the forest to discover the noise
        var choice2 = new PlayerInteraction(player, MyChoiceLabels.BackToForest.toString(), westEndTowardForest);
        var nextNode2 = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new Edge(choice2, nextNode2));
    }
	
	 @BuilderMethod
	    public void TheForestEdges() {
	        var node = get(MyNodeLabels.ForestTheForest.toString());
	       
	        //Player decides to pick up the sword to see entity emerge
	        var choice1 = new PlayerInteraction(MyChoiceLabels.StayWithSword.toString(), swordInDirt, Icons.draw, "Find your sword in the dirt"); 
	        var nextNode1 = get(MyNodeLabels.ForestTheWiseMan.toString());
	        node.add(new Edge(choice1, nextNode1));
	       
	        //Player decides to run away- goes to the farm cabin 
	        var choice2 = new PlayerInteraction(player, MyChoiceLabels.RunToClearing.toString(), eastEndSpookyArea);
	        var nextNode2 = get(MyNodeLabels.CabinInTheWoods.toString());
	        node.add(new Edge(choice2, nextNode2));
	
	 }
	 
	 @BuilderMethod
	    public void CabinInTheWoodsEdges() {
	        var node = get(MyNodeLabels.CabinInTheWoods.toString());
	
	        //Player decides to use the door to enter the cabin 
	        var choice1 = new PlayerInteraction(MyChoiceLabels.GoIntoCabin.toString(), cabinDoor, Icons.exit, "Go into the Cabin");
	        var nextNode1= get(MyNodeLabels.CabinAppleBasket.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //Player decides to go to the stream to see the fruits 
	        var choice2 = new PlayerInteraction(player, MyChoiceLabels.WalkToStream.toString(), streamArea);
	        var nextNode2 = get(MyNodeLabels.ForestStrangeFruit.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	        
	        
	 }
	 
	 @BuilderMethod
	    public void TheWiseManEdges() {
	        var node = get(MyNodeLabels.ForestTheWiseMan.toString());
	        
	        //Player decides to run to away from the entity and go to the farm cabin
	        var choice1 = new PlayerInteraction(player, MyChoiceLabels.RunToClearing.toString(), westEndSpookyArea);
	        var nextNode1 = get(MyNodeLabels.CabinInTheWoods.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //player decides to talk with the entity
	        var choice2 = new PlayerInteraction(MyChoiceLabels.TalkToWiseMan.toString(), wiseMan, Icons.talk, "Go talk to the Wise Man");
	        var nextNode2 = get(MyNodeLabels.ForestTheWarning.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	        
	        
	 }
	        
	 /*
	//Hrishi Kabra
	 @BuilderMethod
	 	public void AppleBasketEdges() {
		 var node = get(MyNodeLabels.CabinAppleBasket.toString());
		 
		 var choice1 = new PlayerInteraction(MyChoiceLabels);
	 }
	 */
	 
	//Rodrigo Guzman
	 
	 
}

