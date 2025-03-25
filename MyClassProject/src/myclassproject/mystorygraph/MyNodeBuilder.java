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
        .add(new CreateAll(List.of(forest, strangeFruitGrove, spookyArea, appleBasketCabin, apple, sword,  netTrap, lostCity, banditCamp, merchantShop,castle)))
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
        .add(new Wait(10)) //Show the narration for 5 seconds
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
            .add(new Wait(7)) //Wait for the context to be read
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
        .add(new Wait(7))// wait for the player to read context 
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
	
	
	@BuilderMethod
    public void TheCastleActions() {
        var node = get(MyNodeLabels.TheCastle.toString());
        node.add(new FadeOut())
        .add(new CreateCharacterSequence(theKing))
        .add(new CreateCharacterSequence(guard1))
        .add(new CreateCharacterSequence(guard2))
        .add(new CreateCharacterSequence(guard3))
        .add(new SetPosition(theKing, TheKingsCastle, "Throne"))
        .add(new SetPosition(guard1, TheKingsCastle, "LeftGuard"))
        .add(new SetPosition(guard2, TheKingsCastle, "RightGuard"))
        .add(new SetPosition(guard3, TheKingsCastle, "LeftDoor"))
        .add(new Sit(theKing, theThrone))
        .add(new SetPosition(player, TheKingsCastle))
        .add(new FadeIn())
        .add(new NarrationSequence("When you wake up, everything is hazy. You notice the tall, marble ceilings and faint light of gas lanterns. The room is majestic, and very familiar. Suddenly, memories  of being  knocked out fly back.\n"
        		+ "Your thoughts are interrupted by a booming voice..."))
        .add(new Wait(10))
        .add(new HideNarration());
        
  
       
	}
	@BuilderMethod
    public void TheKingActions() {
        var node = get(MyNodeLabels.TheKing.toString());
        node.add(new WalkTo(player,TheKingsCastle, "Supplicant"))
        .add(new DialogSequence(theKing, player, List.of("I knew you would come back, you always do no matter how many times I banish you. Speak up!!"), List.of("What is going on? Who are you?", "**Stay silent**")));
       
	}
	
	@BuilderMethod
    public void StaySilentActions() {
        var node = get(MyNodeLabels.StaySilent.toString());
        node.add(new HideDialog())
        .add(new NarrationSequence("Your mouth stays shut, and you can tell the man in front of you is getting angry."))
        .add(new Wait(5))
        .add(new HideNarration())
        .add(new DialogSequence(theKing, player, List.of("Fine, you always were a stubborn kid. Take him to the dungeon"), List.of("**Go with the guards**", "Fine Fine!! Ill talk. Who are you and what is going on?")));
        
   
        
	}
	@BuilderMethod
    public void SpeakUpActions() {
        var node = get(MyNodeLabels.SpeakUp.toString());
        node.add(new HideDialog())
        .add(new DialogSequence(theKing, player, List.of("I am surprised my wizard has gotten so good at our memory potion. You usually remember by this pointYou really don't know who you are? Strange. Guards, take him away!"), List.of("**Go with the Guards**", "**Try to Talk to Guard**")));
  
	}
	@BuilderMethod
    public void FollowWillinglyActions() {
        var node = get(MyNodeLabels.FollowWillingly.toString());
        node.add(new HideDialog())
        .add(new WalkTo(guard1, player))
        .add(new WalkTo(guard2, player))
        .add(new Wait(5))
        .add(new WalkTo(player, ToTheDungeons))
        .add(new Wait(1))
        .add(new WalkTo(guard1, ToTheDungeons))
        .add(new WalkTo(guard2, ToTheDungeons))
        .add(new Exit(player, ToTheDungeons, true))
        .add(new Exit(player, ToTheDungeons, true))
        .add(new Exit(guard1, ToTheDungeons, true))
        .add(new Exit(guard2, ToTheDungeons, true))
        .add(new CreateCharacterSequence(prisoner))
        .add(new SetPosition(prisoner, TheDungeons, "DirtPile"))
        .add(new Enter(player, EnterDungeons, true))
        .add(new Enter(guard1, EnterDungeons, true))
        .add(new WalkTo(guard1, cellDoor))
        .add(new DialogSequence(guard1, player, List.of("I am sorry my prince"), List.of("Why did you call me that? Can you please explain what's going on?", "**head into cell**")));
        
	}
	
	@BuilderMethod
    public void TheCellActions() {
        var node = get(MyNodeLabels.TheCell.toString());
        node.add(new HideDialog())
        .add(new WalkTo(player, cellDoor))
        .add(new Enter(player, cellDoor, false))
        .add(new WalkTo(player, TheDungeons, "Bed"))
        .add(new DialogSequence(prisoner, player, List.of("Prince is that really you?"), List.of("What is going on?")));
        
        
	}
	
	@BuilderMethod
    public void TalkToGuardActions() {
        var node = get(MyNodeLabels.TalkToGuard.toString());
        node.add(new HideDialog())
        .add(new WalkTo(player, guard1))
        .add(new DialogSequence(guard1, player, List.of("You seriously don't remember anything do you? Those potions really are getting strong. And here we thought you coming back again was our hope at freedomMy Prince, it pains me to have to remind you everything your father did. You've been down here with me before, and every time I hope you figure it out. I am sworn under oath to not say too much... everyone in the kingdom is. The only thing I will say is to ask for the wizard."), List.of("I dont understand...what are you talking about?")));
        
	}
	
	@BuilderMethod
    public void GetContextActions() {
        var node = get(MyNodeLabels.GetContext.toString());
        node.add(new HideDialog())
        .add(new DialogSequence(prisoner, player, List.of("You seriously don't remember anything do you? Those potions really are getting strong. And here we thought you coming back again was our hope at freedomMy Prince, it pains me to have to remind you everything your father did. You've been down here with me before, and every time I hope you figure it out. I am sworn under oath to not say too much... everyone in the kingdom is. The only thing I will say is to ask for the wizard."), List.of("I dont understand...what are you talking about?")));
        
	}
	
	
	
	
//Hrishi Kabra
	
	public void AppleBasketActions() {//Picking up the apple in the cabin
		var node = get(MyNodeLabels.CabinAppleBasket.toString());
		node.add(new Enter(player, insideCabinDoor, true)) //Player is now inside the cabin in the woods
		.add(new SetPosition(apple, insideCabin, "Table"))
		.add(new Pickup(player, apple)) //player has only one choice - to pick up the apple
		.add(new Wait(2))
		.add(new NarrationSequence("The cabin seems abandoned as you get closer, so you try to go in. The door opens without hesitation, and the first thing  you see is a basket of pristine apples. Starving, you decide to grab one..."))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	
	public void StrangeFruitActions() {//Picking up the apple in the woods - CabinInWoods&TheWarning lead to this - leads to EatApple
		var node = get(MyNodeLabels.ForestStrangeFruit.toString());
		node.add(new Enter(player, strangeFruitGroveEntrance, true))
		.add(new SetPosition(apple, strangeFruitGrove, "Plant"))
		.add(new Pickup(player, apple))
		.add(new Wait(2))
		.add(new NarrationSequence("As you are walking, you notice fruit trees scattered between the other vegetation. The juicy looking apples call your name, but something seems off about them…"))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	
	public void TheWarningActions() {
		var node = get(MyNodeLabels.ForestTheWarning.toString());
		node
        .add(new Face(wiseMan, player)) //face the players
		.add(new Wait(2))
		.add(new NarrationSequence("The person removes their hood to reveal a man. You stare at each other in silence. Finally, he says, “The city is not what you think.” Before you have a chance to ask more, he disappears in a puff of smoke"))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	
	public void NetTrapActions() {
		var node = get(MyNodeLabels.ForestANetTrap.toString());
		node.add(new CreateCharacterSequence(banditLeader))
		.add(new SetPosition(banditLeader, strangeFruitGrove, "Well"))
		.add(new CreateCharacterSequence(forestBandit))
		.add(new SetPosition(forestBandit, strangeFruitGrove, "DirtPile"))
		.add(new Face(banditLeader, player))
		.add(new Face(forestBandit, player))
		.add(new Wait(2))
		.add(new NarrationSequence("you start walking and before you know it, something catches you by your feet and you are hanging in the air stuck in a net! A group of people jump out of the bushes. "))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	
	public void PlayDeadActions() {
		var node = get(MyNodeLabels.ForestPlayDead.toString());
		node.add(new CreateCharacterSequence(banditLeader))
		.add(new SetPosition(banditLeader, strangeFruitGrove, "Well"))
		.add(new CreateCharacterSequence(forestBandit))
		.add(new SetPosition(forestBandit, strangeFruitGrove, "DirtPile"))
		.add(new Face(banditLeader, player))
		.add(new Face(forestBandit, player))
		.add(new Wait(2))
		.add(new NarrationSequence("You decide to play dead in the net trap. It doesn't work, your captors know you are alive. After a few minutes of whispering and shock in their eyes, they proclaim that they are taking you to the castle. You start panicking and try to free yourself, but you are sorely out numbered. One of them hits you over the head with the butt of his sword. You immediately go unconscious and drop to the floor.\n"))
		.add(new Wait(10))
		.add(new HideNarration());
	}


	
	
	
	
	
	
	
	
//Rodrigo Guzman
	
	@BuilderMethod
    public void demandAnswersActions() {
        var node = get(MyNodeLabels.ForestDemandAnswers.toString());

        node.add(new FadeIn())
            .add(new NarrationSequence("While your captives were whispering about what to do with you, you find a knife from your pocket and cut yourself down. You are too fast for them, and soon are standing on your own feet with a weapon in front of you."))
            .add(new Wait(5))          
            .add(new FadeOut());
    }

    @BuilderMethod
    public void cityTheLostCityActions() {
        var node = get(MyNodeLabels.CityTheLostCity.toString());

        node.add(new FadeIn())
            .add(new NarrationSequence("You reach the gates of the Lost City, a place of mystery and danger. The guards eye you suspiciously as you approach."))
           .add(new Wait(5))
            .add(new SetPosition(player, lostCity))
            .add(new Exit(player, lostCityGate, true))
            .add(new FadeOut());
    }

    @BuilderMethod
    public void talkToBanditsActions() {
        var node = get(MyNodeLabels.ForestTalkToTheBandits.toString());

        node.add(new FadeIn())
            .add(new NarrationSequence("You demand the bandits to tell you everything. One speaks up, offering you two choices: follow them, or eat an apple from the forest to find out yourself."))
            .add(new Wait(5))
            .add(new FadeOut());
    }

    @BuilderMethod
    public void fightBanditsActions() {
        var node = get(MyNodeLabels.ForestFightBandits.toString());

        node.add(new FadeIn())
            .add(new NarrationSequence("You start rushing one of them, but you are sorely outnumbered. One of them hits you over the head with the butt of his sword. You immediately go unconscious and drop to the floor."))
            .add(new Wait(5))
            .add(new Exit(player, westEndTowardForest, true))
            .add(new FadeOut());
    }

    @BuilderMethod
    public void takeAnAppleActions() {
        var node = get(MyNodeLabels.ForestTakeAnApple.toString());

        node.add(new FadeIn())
            .add(new NarrationSequence("You bite into the crunchy flesh and fall to your knees. Unclear memories from your childhood flood back in. Before you know it, the world goes dark yet again..."))
            .add(new Wait(5))
            .add(new Exit(player, eastEndTowardCity, true))
            .add(new FadeOut());
    }
	
}