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
       
        root. add(new CreateCharacterSequence(player))
        .add(new SetCameraFocus(player))
        .add(new CreateAll(List.of(forest, strangeFruitGrove, spookyArea, appleBasketCabin, apple, sword,  netTrap))) //, lostCity, banditCamp, merchantShop,castle
           
            .add(new SetPosition(player, forest))
            
            .add(new ShowMenu());
    }

    @BuilderMethod
    public void forestTheBeginningActions() {
        var node = get(MyNodeLabels.ForestTheBeginning.toString());
        node.add(new HideMenu()).add(new EnableInput());

        node.add(new NarrationSequence("You wake up in a dense forest, the morning air heavy with mist. " +
                                       "To the right, you hear the distant sounds of a bustling city. " +
                                       "To the left, the forest grows darker and deeper. Which way do you go?")) //Narration Gives Context to the choices 
        .add(new Wait(5)) //Show the narration for 5 seconds
        .add(new HideNarration());//then afterwards hide the context so that the player can decide which direction to go 
        
        
      //  .add(new Exit(player, eastEndTowardCity, true)) //walk to the right, will connect to the city location 
      //  .add(new Exit(player, westEndTowardForest, true))//walk to the left, will show walking but will be another forest path 
      //  .add(new FadeOut()); //Fade out to show changing scenery 
   //depending on the side the player walks to, there are different options and it will be taken to different places 
    }
    
    @BuilderMethod
    public void forestTowardTheLostCityActions() {
        var node = get(MyNodeLabels.ForestTowardTheLostCity.toString());
       

        node.add(new Exit(player, eastEndTowardCity, true))//exit from the one location (one side of the path)
        	.add(new Enter(player, westEndTowardForest, true ))//enter from the other side (it will fade in fade out and enter from the other side)
        	.add(new WalkTo(player, dirtWalk)) //Player walks towards the dirt to show movement
            .add(new NarrationSequence("You start walking towards the break in the tree lines as the noises of waits beyond intensifies. Right before exiting the final layer of brush, you hear a snap behind you back towards where you started... "))
           //See narration that you can exit out of to add context
            .add(new Wait(5)) //Wait for the context to be read
            .add(new HideNarration()); //Hide the context to give choice for decision 
        	
        
          //  .add(new Exit(player, eastEndTowardCity, true)).add(new Exit(player, westEndTowardForest, true)).add(new FadeOut());
   //Either go towards one side of the path to cross to next node of the other 
        
    }
    
    @BuilderMethod
    public void forestTheForestActions() {
        var node = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new Exit(player, westEndTowardForest, true)) //exit from the other side of the path 
        .add(new Enter(player, westEndSpookyArea, true)) //enter into another area, both will fade in and fade out 
        .add(new SetPosition(sword, spookyArea, "Plant"))      //place a sword as an entity to interact with 
        
        .add(new NarrationSequence("As you venture deeper into the forest, the trees grow taller and denser. The path that you took to get here seems to have gotten lost amidst the foliage. Suddenly, you hear the snap of a branch. The bushes to your left begin to rustle."))
        //Add narrative sequence that will be shown to the player
        .add(new Wait(5)) //wait for player to read narration 
       .add(new HideNarration());// then hide it to let a decision take place 
       
       
       
     //   .add(new Pickup(player, sword))
      
        //Venture further down the path 
     //   .add(new Exit(player,westEndTowardForest, true))
     //   .add(new FadeOut());
        

}
    @BuilderMethod
    public void theWiseManActions() {
        var node = get(MyNodeLabels.ForestTheWiseMan.toString());
        node.add(new Pickup(player, sword)) //player decides to interact and pick up the sword 
        .add(new Wait(2)) //add a wait before the new character pops in 
        .add(new CreateCharacterSequence(wiseMan)) //place wise man in new scene
        .add(new SetPosition(wiseMan, spookyArea, "Well" )) //put him near the well
        .add(new Face(wiseMan, player)) //face the players
        .add(new NarrationSequence("Holding a sword you picked up for protection in one hand, you see a figure emerge out of the bush. The first thing that catches your eye is the long flowing cloak they’re wearing. Do you talk to him or run away..."))
        .add(new Wait(5))// wait for the player to read context 
        .add(new HideNarration());//hide context 
        
        
      //  .add(new WalkTo(player, wiseMan)) //one action is to walk to the wise man (there will be a dialog sequence if chosen)
      //  .add(new Exit(player, cabinPath, true))//other option is to go to the clearing
      //  .add(new FadeOut());
    }
    
  
	

	@BuilderMethod
    public void CabinintheWoodsActions() {
        var node = get(MyNodeLabels.CabinInTheWoods.toString());
        node.add(new Exit(player, eastEndSpookyArea, true))
        .add(new Enter(player, streamArea, true))
        .add(new Wait(2))
        .add(new NarrationSequence("Running away for fear of your life, the trees begin to thin out. You continue, heart racing as you travel farther into the expansive forest. Soon enough, a clearing emerges, and in it, you see a cabin."))
        .add(new Wait(5))
        .add(new HideNarration());
        
        
       // .add(new Exit(player, cabinDoor, true))//can go to the door and exit into the cabin
       // .add(new Exit(player, streamArea, true))//can walk towards the stream area back through the exit
		//.add(new FadeOut());        
    }
	/*
	//Hrishi Kabra
	public void AppleBasketActions() {
		var node = get(MyNodeLabels.CabinAppleBasket.toString());
		node.add(new FadeIn())
		//Player is in the same location as CabinintheWoods
		.add(new NarrationSequence("The cabin seems abandoned as you get closer, so you try to go in. The door opens without hesitation, and the first thing  you see is a basket of pristine apples. Starving, you decide to grab one..."))
		.add(new Exit(player, apple, true)) //player has only one choice - to pick up the apple
		.add(new FadeOut());
	}
    
    
*/
	


//Rodrigo Guzman
	
}