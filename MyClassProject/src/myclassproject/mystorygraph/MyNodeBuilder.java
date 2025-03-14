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
        .add(new SetPosition(sword, spookyArea, "Plant"))      //Show a sword that can be clicked
        //How can I place a sword to be picked up???
        .add(new Pickup(player, sword))
      
        //Venture further down the path 
        .add(new Exit(player,westEndTowardForest, true))
        .add(new FadeOut());
    
        
        
        

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
	
	//Hrishi Kabra
	public void AppleBasketActions() {
		var node = get(MyNodeLabels.CabinAppleBasket.toString());
		node.add(new FadeIn())
		//Player is in the same location as CabinintheWoods
		.add(new NarrationSequence("The cabin seems abandoned as you get closer, so you try to go in. The door opens without hesitation, and the first thing  you see is a basket of pristine apples. Starving, you decide to grab one..."))
		.add(new Exit(player, apple, true)) //player has only one choice - to pick up the apple
		.add(new FadeOut());
	}
    
    

	


//Rodrigo Guzman
	
}