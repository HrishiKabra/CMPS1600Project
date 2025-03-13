package myclassproject.mystorygraph;

import java.util.List;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.storygraph.*;
import com.actions.*;
import com.entities.*;
import com.sequences.*;


public class MyNodeBuilder extends NodeBuilder {
	private static final IAction NarrationSequence = null;

	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	
	
		//Petra Radmanovic
	@BuilderMethod
    public void rootActions() {
        var root = get(MyNodeLabels.root.toString());
       
        root.add(new CreateAll(List.of(forest, lostCity, banditCamp, merchantShop,castle, strangeFruitGrove, spookyArea, appleBasketCabin, apple, sword,  netTrap)))
            .add(new CreateCharacterSequence(player))
            .add(new SetPosition(player, forest))
            .add(new SetCameraFocus(player))
            .add(new ShowMenu());
    }

    @BuilderMethod
    public void forestTheBeginningActions() {
        var node = get(MyNodeLabels.ForestTheBeginning.toString());
        node.add(new HideMenu()).add(new EnableInput());

        node.add(new NarrationSequence("You wake up in a dense forest, the morning air heavy with mist. " +
                                       "To the right, you hear the distant sounds of a bustling city. " +
                                       "To the left, the forest grows darker and deeper. Which way do you go?"))
        .add(new Exit(player, eastEndTowardCity, true)) //walk to the right, will connect to the city location 
        .add(new Exit(player, westEndTowardForest, true))//walk to the left, will show walking but will be another forest path 
        .add(new FadeOut()); //Fade out to show changing scenery 
   //depending on the side the player walks to, there are different options and it will be taken to different places 
    }
    
    @BuilderMethod
    public void forestTowardTheLostCityActions() {
        var node = get(MyNodeLabels.ForestTowardTheLostCity.toString());

        node.add(new FadeIn()) //Fade back in, same setting but give illusion of movement 
        	.add(new WalkTo(player, dirtWalk)) //Player walks towards the dirt to show movement
            .add(new NarrationSequence("You start walking towards the break in the tree lines as the noises of waits beyond intensifies. Right before exiting the final layer of brush, you hear a snap behind you back towards where you started... "))
           //See narration that you can exit out of to add context
            .add(new Exit(player, eastEndTowardCity, true)).add(new Exit(player, westEndTowardForest, true)).add(new FadeOut());
   //Either go towards one side of the path to cross to next node of the other 
    }
    
    @BuilderMethod
    public void forestTheForestActions() {
        var node = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new FadeIn()) //Undo fade out
        .add(new SetPosition(player, spookyArea)) //Create new position in new place 
        .add(new SetCameraFocus(player)) //focus on player
        .add(new NarrationSequence("As you venture deeper into the forest, the trees grow taller and denser. The path that you took to get here seems to have gotten lost amidst the foliage. Suddenly, you hear the snap of a branch. The bushes to your left begin to rustle."))
        //Add narrative sequence that will be shown to the player
        
        //Show a sword that can be clicked
        //How can I place a sword to be picked up???
        .add(new Pickup(player, sword))
      
        //Venture further down the path 
        .add(new Exit(player,westEndTowardForest, true))
        .add(new FadeOut());
    
        //how can I add a sword option to see, and a place to exit???
        
        

}
    @BuilderMethod
    public void theWiseManActions() {
        var node = get(MyNodeLabels.ForestTheWiseMan.toString());
        node.add(new FadeIn())
        .add(new CreateCharacterSequence(wiseMan)) //place wiseman in new scene
        .add(new SetPosition(wiseMan, spookyArea, "Well" )) //put him near the well
        .add(new Face(wiseMan, player)) //face the players
        .add(new NarrationSequence("Holding a stick you picked up for protection in one hand, you see a figure emerge out of the bush. While you can't distinguish his face, the first thing that catches your eye is the long flowing cloak they’re wearing."))
        .add(new WalkTo(player, wiseMan)) //one action is to walk to the wise man (there will be a dialog sequence if chosen)
        .add(new Exit(player, cabinPath, true))//other option is to go to the clearing
        .add(new FadeOut());
    }
    
  
	

	@BuilderMethod
    public void CabinintheWoodsActions() {
        var node = get(MyNodeLabels.CabinInTheWoods.toString());
        node.add(new FadeIn())
        .add(new SetPosition(player, appleBasketCabin))//player is now in a new location 
        .add(new NarrationSequence("Running away for fear of your life, the trees begin to thin out. You continue, heart racing as you travel farther into the expansive forest. Soon enough, a clearing emerges, and in it, you see a cabin."))
        .add(new Exit(player, cabinDoor, true))//can go to the door and exit into the cabin
        .add(new Exit(player, streamArea, true))//can walk towards the stream area back through the exit
		.add(new FadeOut());
       
        
    }
    
    

/*
    
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
*/
	
	
	
	
	

//Hrishi Kabra

//Rodrigo Guzman
	
}