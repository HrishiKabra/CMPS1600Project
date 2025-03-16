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
        .add(new CreateAll(List.of(forest, strangeFruitGrove, spookyArea, appleBasketCabin, apple, sword,  netTrap))) //, lostCity, banditCamp, merchantShop,castle (saving for when we need to implement because it slows testing)
           
            .add(new SetPosition(player, forest))
            
            .add(new ShowMenu());
    }

    @BuilderMethod
    public void forestTheBeginningActions() {
        var node = get(MyNodeLabels.ForestTheBeginning.toString());
        node.add(new HideMenu()).add(new EnableInput());

        node.add(new NarrationSequence("You wake up in a dense forest, the morning air heavy with mist. " +
                                       "Behind you, you hear the distant sounds of a bustling city. " +
                                       "In front of you, the forest grows darker and deeper. Which way do you go?")) //Narration Gives Context to the choices 
        .add(new Wait(5)) //Show the narration for 5 seconds
        .add(new HideNarration());//then afterwards hide the context so that the player can decide which direction to go 
        
        //Options: walk through one exit on the side of the path or the other. depending on the side, the player will go to different locations
     
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
        	
        
        //Options: Again gives two different exit options. One will go back towards the forest the other will go into a city
        
    }
    
    @BuilderMethod
    public void forestTheForestActions() {
        var node = get(MyNodeLabels.ForestTheForest.toString());
        node.add(new Exit(player, westEndTowardForest, true)) //exit from the other side of the path 
        .add(new Enter(player, westEndSpookyArea, true)) //enter into another area, both will fade in and fade out 
        .add(new SetPosition(sword, spookyArea, "Plant"))      //place a sword as an entity to interact with 
        
        .add(new NarrationSequence("As you venture deeper into the forest, the trees grow taller and denser. The path that you took to get here seems to have gotten lost amidst the foliage. Suddenly, you hear the snap of a branch. The bushes to your left begin to rustle. Do you pick up the sword you see in the dirt or run away?"))
        //Add narrative sequence that will be shown to the player
        .add(new Wait(10)) //wait for player to read narration 
       .add(new HideNarration());// then hide it to let a decision take place 
       
       
       
     //Options: The player has the option to go to a new location (farm), or to pick up a sword located at the dirt pile they walked to 
        

}
    @BuilderMethod
    public void theWiseManActions() {
        var node = get(MyNodeLabels.ForestTheWiseMan.toString());
        node.add(new Draw(player, sword)) //player decides to interact and pick up the sword 
        .add(new Wait(2)) //add a wait before the new character pops in 
        .add(new CreateCharacterSequence(wiseMan)) //place wise man in new scene
        .add(new SetPosition(wiseMan, spookyArea, "Well" )) //put him near the well
        .add(new Face(wiseMan, player)) //face the players
        .add(new NarrationSequence("Holding a sword you picked up for protection in one hand, you see a figure emerge out of the bush. The first thing that catches your eye is the long flowing cloak they’re wearing. Do you talk to him or run away..."))
        .add(new Wait(5))// wait for the player to read context 
        .add(new HideNarration());//hide context 
        
        
      //Options: The player picked up the sword and a new entity shows up. The player can speak with the entity to move forward or run away to the new location 
    }
    
  
	

	@BuilderMethod
    public void CabinintheWoodsActions() {
        var node = get(MyNodeLabels.CabinInTheWoods.toString());
        node.add(new Exit(player, eastEndSpookyArea, true)) //Exit the area and enter into the cabin 
        .add(new Enter(player, streamArea, true))
        .add(new Wait(2)) //Do not show narration immediately to show new location 
        .add(new NarrationSequence("Running away for fear of your life, the trees begin to thin out. You continue, heart racing as you travel farther into the expansive forest. Soon enough, a clearing emerges, and in it, you see a cabin."))
        //get context for possible choices 
        .add(new Wait(5))
        .add(new HideNarration());
    
        
       //Options: The player decided to run away and enters a farm. They can exit to a new stream location, or they can enter the farm cabin they see through the door    
    }
	
//Hrishi Kabra
	
	


//Rodrigo Guzman
	
}