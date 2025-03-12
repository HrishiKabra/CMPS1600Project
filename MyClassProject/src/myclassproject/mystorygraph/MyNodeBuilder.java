package myclassproject.mystorygraph;

import java.util.List;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.storygraph.*;
import com.actions.*;
import com.entities.*;
import com.sequences.*;


public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	
	
		
	@BuilderMethod
    public void rootActions() {
        var root = get(MyNodeLabels.root.toString());

        root.add(new CreateAll(List.of(forest, lostCity, banditCamp, merchantShop, appleBasketCabin, castle, )))
        //Add All Entities from MyStoryEntities.java^
            .add(new CreateCharacterSequence(player))
            .add(new SetPosition(player, forest, "Clearing"))
            .add(new SetCameraFocus(player))
            .add(new ShowMenu());
    }

    @BuilderMethod
    public void forestTheBeginningActions() {
        var node = get(MyNodeLabels.ForestTheBeginning.toString());
        node.add(new HideMenu()).add(new EnableInput());

        node.add(new NarrationSequence("You wake up in a dense forest, the morning air heavy with mist. " +
                                       "To the left, you hear the distant sounds of a bustling city. " +
                                       "To the right, the forest grows darker and deeper."));
        node.add(null)
    }

    @BuilderMethod
    public void forestTowardTheLostCityActions() {
        var node = get(MyNodeLabels.ForestTowardTheLostCity.toString());

        node.add(new CreateCharacterSequence(wiseMan))
            .add(new SetPosition(wiseMan, forest, "Clearing"))
            .add(new DialogSequence(player, wiseMan, List.of("The city is dangerous. Are you sure you wish to go there?"),
                    List.of("Yes, I must continue!", "No, I’ll turn back.")));
    }

    @BuilderMethod
    public void cabinAppleBasketActions() {
        var node = get(MyNodeLabels.CabinAppleBasket.toString());

        node.add(new CreateAll(List.of(appleBasket)))
            .add(new NarrationSequence("You find a wooden basket filled with apples sitting on a table in an abandoned cabin."));
    }

    @BuilderMethod
    public void forestStrangeFruitActions() {
        var node = get(MyNodeLabels.ForestStrangeFruit.toString());

        node.add(new CreateAll(List.of(strangeFruit)))
            .add(new NarrationSequence("Hanging from a tree branch is a strange, glowing fruit. Its scent is intoxicating."))
            .add(new DialogSequence(player, null, List.of("Will you eat the fruit?"),
                    List.of("Eat the fruit", "Ignore it.")));
    }

    @BuilderMethod
    public void forestTheWarningActions() {
        var node = get(MyNodeLabels.ForestTheWarning.toString());

        node.add(new NarrationSequence("The Wise Man’s voice echoes in your mind: 'Do not eat the fruit. It is cursed.'"));
    }

    @BuilderMethod
    public void forestANetTrapActions() {
        var node = get(MyNodeLabels.ForestANetTrap.toString());

        node.add(new CreateAll(List.of(netTrap)))
            .add(new NarrationSequence("Before you can react, a net shoots up from the ground, trapping you in the air."));
    }

    @BuilderMethod
    public void forestTalkToTheBanditsActions() {
        var node = get(MyNodeLabels.ForestTalkToTheBandits.toString());

        node.add(new CreateCharacterSequence(banditLeader))
            .add(new CreateCharacterSequence(forestBandit))
            .add(new SetPosition(banditLeader, banditCamp, "Tent"))
            .add(new SetPosition(forestBandit, banditCamp, "Perimeter"))
            .add(new DialogSequence(player, banditLeader, List.of("You trespassed in our territory. Now, what should we do with you?"),
                    List.of("Demand answers!", "Run away!")));
    }

    @BuilderMethod
    public void cityTheLostCityActions() {
        var node = get(MyNodeLabels.CityTheLostCity.toString());

        node.add(new CreateAll(List.of(lostCityGate)))
            .add(new NarrationSequence("You finally reach the towering gates of the Lost City. Merchants and travelers bustle around you."));
    }

    @BuilderMethod
    public void forestPlayDeadActions() {
        var node = get(MyNodeLabels.ForestPlayDead.toString());

        node.add(new NarrationSequence("You drop to the ground, feigning unconsciousness. The bandits hesitate."));
    }

    @BuilderMethod
    public void forestFightBanditsActions() {
        var node = get(MyNodeLabels.ForestFightBandits.toString());

        node.add(new CreateAll(List.of(sword)))
            .add(new NarrationSequence("You grab a nearby sword and prepare to fight the bandits."))
            .add(new Draw(player, sword));
    }

    @BuilderMethod
    public void forestTakeAnAppleActions() {
        var node = get(MyNodeLabels.ForestTakeAnApple.toString());

        node.add(new NarrationSequence("You reach for an apple from the basket. It looks fresh and delicious."));
    }

    @BuilderMethod
    public void banditDealActions() {
        var node = get(MyNodeLabels.ForestDemandAnswers.toString());

        node.add(new DialogSequence(player, banditLeader, List.of("Tell me what I need to know!"),
                List.of("I’ll listen.", "I won’t trust you.")));
    }

    @BuilderMethod
    public void acceptDealActions() {
        var node = get(MyNodeLabels.ForestDemandAnswers.toString());

        node.add(new HideDialog())
            .add(new NarrationSequence("The Bandit Leader nods. 'Good choice. Follow me.'"));
    }

    @BuilderMethod
    public void rejectDealActions() {
        var node = get(MyNodeLabels.ForestDemandAnswers.toString());

        node.add(new HideDialog())
            .add(new NarrationSequence("You turn your back on the bandits and walk away, determined to find answers on your own."));
    }

    @BuilderMethod
    public void resetGameActions() {
        var node = get(MyNodeLabels.root.toString());

        node.add(new HideNarration())
            .add(new FadeOut())
            .add(new SetPosition(player, forest, "Clearing"))
            .add(new ShowMenu())
            .add(new FadeIn());
    }
}
