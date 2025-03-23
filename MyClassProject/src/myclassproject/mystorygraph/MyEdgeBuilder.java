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
	        
	 
	 
	 
	 
	 
	//Hrishi Kabra
	@BuilderMethod
	 	public void AppleBasketEdges() {
		 var node = get(MyNodeLabels.CabinAppleBasket.toString());
		 
		 var choice1 = new PlayerInteraction(MyChoiceLabels.PickUpApple.toString(), apple, Icons.exit, "Eat the apple"); //Help - what to do here?
		 //var nextNode1 = get(MyNodeLabels.CabinEatApple.toString()); - commented out because the next node is not there in the current one
		 //node.add(new Edge(choice1, nextNode1));
	 }
	 
	 public void StrangeFruitEdges() {
		 var node = get(MyNodeLabels.ForestStrangeFruit.toString());
        
         var choice1 = new PlayerInteraction(MyChoiceLabels.IgnoreFruit.toString(), westEndTowardForest, Icons.exit, "Ignore them and continue walking");
         var nextNode1 = get(MyNodeLabels.ForestANetTrap.toString());
         node.add(new Edge(choice1, nextNode1));
        
         //var choice2 = new PlayerInteraction(MyChoiceLabels.EatApple.toString(), apple, Icons.pickup, "Eat the fruit");
         //var nextNode2 = get(MyNodeLabels.CabinEatApple.toString());
         //node.add(new Edge(choice2, nextNode2));
	 }
	 
	 public void TheWarningEdges() {
		 var node = get(MyNodeLabels.ForestTheWarning.toString());
	     var choice1 = new PlayerInteraction(MyChoiceLabels.GoDeeper.toString(), westEndTowardForest, Icons.exit, "Go deeper into the forest");
         var nextNode1 = get(MyNodeLabels.ForestStrangeFruit.toString());
         node.add(new Edge(choice1, nextNode1));
        
         //var choice2 = new PlayerInteraction(MyChoiceLabels.GoBack.toString(), eastEndTowardCity, Icons.exit, "Go back towards the city");
         //var nextNode2 = get(MyNodeLabels.TheLostCity.toString());
         //node.add(new Edge(choice2, nextNode2));
		 
	 }
	 
	 
	 public void NetTrapEdges() {
		 var node = get(MyNodeLabels.ForestANetTrap.toString());
        
         //var choice1 = new PlayerInteraction(MyChoiceLabels.DemandAnswers.toString(), banditLeader, Icons.talk, "Fight your fate");
         //var nextNode1 = get(MyNodeLabels.ForestDemandAnswers.toString());
         //node.add(new Edge(choice1, nextNode1));
        
         var choice2 = new PlayerInteraction(MyChoiceLabels.PlayDead.toString(), netTrap, Icons.sleep, "Play Dead");
         var nextNode2 = get(MyNodeLabels.ForestPlayDead.toString());
         node.add(new Edge(choice2, nextNode2));
	 }
	 
	 public void PlayDeadEdges() {
		 var node = get(MyNodeLabels.ForestPlayDead.toString());
		 //var choice1 = new PlayerInteraction(MyChoiceLabels.WakeUp.toString(), castleEntrance, Icons.exit, "WAKE UP");
	     //var nextNode1 = get(MyNodeLabels.TheCastle.toString());
	     //node.add(new Edge(choice1, nextNode1));
	 }
	 
	 
	 
	 
	 
	//Rodrigo Guzman
	 
	 @BuilderMethod
	    public void demandAnswersEdges() {
	        var node = get(MyNodeLabels.ForestDemandAnswers.toString());

	        var choice1 = new PlayerInteraction(MyChoiceLabels.GetAnswers.toString(), forestBandit, Icons.talk, "Demand answers from the bandits");
	        var nextNode1 = get(MyNodeLabels.ForestTalkToTheBandits.toString());
	        node.add(new Edge(choice1, nextNode1));

	        var choice2 = new PlayerInteraction(MyChoiceLabels.RunAway.toString(), westEndTowardForest, Icons.exit, "Run away as fast as possible");
	        var nextNode2 = get(MyNodeLabels.CityTheLostCity.toString());
	        node.add(new Edge(choice2, nextNode2));
	    }

	    @BuilderMethod
	    public void cityTheLostCityEdges() {
	        var node = get(MyNodeLabels.CityTheLostCity.toString());

	        var choice = new PlayerInteraction(MyChoiceLabels.EnterCity.toString(), lostCityGate, Icons.exit, "Enter the Lost City");
	        var nextNode = get(MyNodeLabels.TheCastle.toString());
	        node.add(new Edge(choice, nextNode));
	    }

	    @BuilderMethod
	    public void talkToBanditsEdges() {
	        var node = get(MyNodeLabels.ForestTalkToTheBandits.toString());

	        var choice1 = new PlayerInteraction(MyChoiceLabels.TakeApple.toString(), apple, Icons.apple, "Take an apple");
	        var nextNode1 = get(MyNodeLabels.ForestTakeAnApple.toString());
	        node.add(new Edge(choice1, nextNode1));

	        var choice2 = new PlayerInteraction(MyChoiceLabels.FightThem.toString(), sword, Icons.draw, "Fight them");
	        var nextNode2 = get(MyNodeLabels.ForestFightBandits.toString());
	        node.add(new Edge(choice2, nextNode2));
	    }

	    @BuilderMethod
	    public void fightBanditsEdges() {
	        var node = get(MyNodeLabels.ForestFightBandits.toString());

	        var nextNode = get(MyNodeLabels.TheCastle.toString());
	        node.add(new Edge(new PlayerInteraction(MyChoiceLabels.KnockedOut.toString(), sword, Icons.swords, "Knocked out in battle"), nextNode));
	    }

	    @BuilderMethod
	    public void takeAnAppleEdges() {
	        var node = get(MyNodeLabels.ForestTakeAnApple.toString());

	        var nextNode = get(MyNodeLabels.TheCastle.toString());
	        node.add(new Edge(new PlayerInteraction(MyChoiceLabels.EatApple.toString(), apple, Icons.apple, "Eat the apple"), nextNode));
	    }
}

