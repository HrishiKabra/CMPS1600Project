package myclassproject.mystorygraph;

import java.util.List;
import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.actions.*;
import com.sequences.*;
import com.playerInput.*;

import com.storygraph.*;

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
     


/*
    @BuilderMethod
    public void theBeginningEdges() {
        var node = get(MyNodeLabels.ForestTheBeginning.toString());

        var choice1 = new MenuChoice(MyChoiceLabels.HeadTowardTheLight.toString());
        var nextNode1 = get(MyNodeLabels.ForestTowardTheLostCity.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.HeadDeeperIntoTheForest.toString());
        var nextNode2 = get(MyNodeLabels.CabinInTheWoods.toString());
        node.add(new Edge(choice2, nextNode2));
    }
    

    @BuilderMethod
    public void towardsTheLostCityEdges() {
        var node = get(MyNodeLabels.ForestTowardTheLostCity.toString());

        var choice1 = new PlayerInteraction(MyChoiceLabels.SpeakToWiseMan.toString(), wiseMan, Icons.talk, "Speak to the Wise Man.");
        var nextNode1 = get(MyNodeLabels.ForestTheWiseMan.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.IgnoreTheWiseMan.toString());
        var nextNode2 = get(MyNodeLabels.CityTheLostCity.toString());
        node.add(new Edge(choice2, nextNode2));
    }

    @BuilderMethod
    public void inTheWoodsEdges() {
        var node = get(MyNodeLabels.CabinInTheWoods.toString());

        var choice1 = new MenuChoice(MyChoiceLabels.PickAnApple.toString());
        var nextNode1 = get(MyNodeLabels.CabinAppleBasket.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.LeaveBasket.toString());
        var nextNode2 = get(MyNodeLabels.ForestStrangeFruit.toString());
        node.add(new Edge(choice2, nextNode2));
    }

    @BuilderMethod
    public void strangeFruitEdges() {
        var node = get(MyNodeLabels.ForestStrangeFruit.toString());

        var choice1 = new MenuChoice(MyChoiceLabels.EatStrangeFruit.toString());
        var nextNode1 = get(MyNodeLabels.ForestANetTrap.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.IgnoreStrangeFruit.toString());
        var nextNode2 = get(MyNodeLabels.ForestTheWarning.toString());
        node.add(new Edge(choice2, nextNode2));
    }

    @BuilderMethod
    public void theWarningEdges() {
        var node = get(MyNodeLabels.ForestTheWarning.toString());

        var choice1 = new MenuChoice(MyChoiceLabels.ListenToWarning.toString());
        var nextNode1 = get(MyNodeLabels.ForestTalkToTheBandits.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.IgnoreWarning.toString());
        var nextNode2 = get(MyNodeLabels.CityTheLostCity.toString());
        node.add(new Edge(choice2, nextNode2));
    }

    @BuilderMethod
    public void aNetTrapEdges() {
        var node = get(MyNodeLabels.ForestANetTrap.toString());

        var choice1 = new MenuChoice(MyChoiceLabels.StruggleAgainstNet.toString());
        var nextNode1 = get(MyNodeLabels.ForestTalkToTheBandits.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.StayStill.toString());
        var nextNode2 = get(MyNodeLabels.ForestPlayDead.toString());
        node.add(new Edge(choice2, nextNode2));
    }

    @BuilderMethod
    public void talkToTheBanditsEdges() {
        var node = get(MyNodeLabels.ForestTalkToTheBandits.toString());

        var choice1 = new PlayerInteraction(MyChoiceLabels.DemandAnswers.toString(), banditLeader, Icons.talk, "Demand answers.");
        var nextNode1 = get(MyNodeLabels.DemandAnswers.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.RunAway.toString());
        var nextNode2 = get(MyNodeLabels.CityTheLostCity.toString());
        node.add(new Edge(choice2, nextNode2));
    }

    @BuilderMethod
    public void playDeadEdges() {
        var node = get(MyNodeLabels.ForestPlayDead.toString());

        var choice1 = new DialogChoice(MyChoiceLabels.Surrender.toString());
        var nextNode1 = get(MyNodeLabels.TheCastle.toString());
        node.add(new Edge(choice1, nextNode1));

        var choice2 = new MenuChoice(MyChoiceLabels.FightBandits.toString());
        var nextNode2 = get(MyNodeLabels.ForestFightBandits.toString());
        node.add(new Edge(choice2, nextNode2));
    }
    */
	
	//Hrishi Kabra
	//Rodrigo Guzman
}

