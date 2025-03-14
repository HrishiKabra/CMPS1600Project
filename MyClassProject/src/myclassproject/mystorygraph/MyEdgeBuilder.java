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
        var choice1 = new PlayerInteraction(MyChoiceLabels.HeadTowardTheLight.toString(), eastEndTowardCity, Icons.exit, "Go to The Lost City");
        var nextNode1 = get(MyNodeLabels.ForestTowardTheLostCity.toString());
        node.add(new Edge(choice1, nextNode1));
        
        var choice2 = new PlayerInteraction(MyChoiceLabels.HeadDeeperIntoTheForest.toString(), westEndTowardForest, Icons.exit, "Venture Into forest");
        var nextNode2 = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new Edge(choice2, nextNode2));
        
	}
	
	@BuilderMethod
    public void towardsTheLostCityEdges() {
        var node = get(MyNodeLabels.ForestTowardTheLostCity.toString());

        var choice1 = new PlayerInteraction(MyChoiceLabels.ToTheCity.toString(), eastEndTowardCity, Icons.exit, "Go to The Lost City");
        
        //Should we make different entities for the the same action^^?
        var nextNode1 = get(MyNodeLabels.CityTheLostCity.toString());
        node.add(new Edge(choice1, nextNode1));
        
        var choice2 = new PlayerInteraction(MyChoiceLabels.BackToForest.toString(), westEndTowardForest, Icons.exit, "Go Back");
        var nextNode2 = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new Edge(choice2, nextNode2));
    }
	
	 @BuilderMethod
	    public void TheForestEdges() {
	        var node = get(MyNodeLabels.ForestTheForest.toString());
	        
	        
	        
	        var choice1 = new PlayerInteraction(MyChoiceLabels.StayWithSword.toString(), sword, Icons.draw, "pick up sword"); //How can I make the choice to pickup the sword??
	        var nextNode1 = get(MyNodeLabels.ForestTheWiseMan.toString());
	        node.add(new Edge(choice1, nextNode1));
	       
	        
	        var choice2 = new PlayerInteraction(MyChoiceLabels.RunToClearing.toString(), westEndTowardForest, Icons.exit, "Run to the Clearing");
	        var nextNode2 = get(MyNodeLabels.CabinInTheWoods.toString());
	        node.add(new Edge(choice2, nextNode2));
	
	 }
	 
	 @BuilderMethod
	    public void CabinInTheWoodsEdges() {
	        var node = get(MyNodeLabels.CabinInTheWoods.toString());
	        
	        var choice1 = new PlayerInteraction(MyChoiceLabels.GoIntoCabin.toString(), cabinDoor, Icons.exit, "Go into the Cabin");
	        var nextNode1= get(MyNodeLabels.CabinAppleBasket.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        var choice2 = new PlayerInteraction(MyChoiceLabels.WalkToStream.toString(), streamArea, Icons.exit, "Go explore the stream");
	        var nextNode2 = get(MyNodeLabels.ForestStrangeFruit.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	        
	        
	 }
	 
	 @BuilderMethod
	    public void TheWiseManEdges() {
	        var node = get(MyNodeLabels.ForestTheWiseMan.toString());
	        
	        var choice1 = new PlayerInteraction(MyChoiceLabels.RunToClearing.toString(), westEndTowardForest, Icons.exit, "Run to the Clearing");
	        var nextNode1 = get(MyNodeLabels.CabinInTheWoods.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        var choice2 = new PlayerInteraction(MyChoiceLabels.TalkToWiseMan.toString(), wiseMan, Icons.talk, "Go talk to the Wise Man");
	        var nextNode2 = get(MyNodeLabels.ForestTheWarning.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	        
	        
	 }
	        
	 
	//Hrishi Kabra
	 @BuilderMethod
	 	public void AppleBasketEdges() {
		 var node = get(MyNodeLabels.CabinAppleBasket.toString());
		 
		 var choice1 = new PlayerInteraction(MyChoiceLabels)
	 }
	 
	 
	//Rodrigo Guzman
	 
	 
}

