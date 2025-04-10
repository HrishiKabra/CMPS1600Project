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
        .add(new CreateAll(List.of(forest, strangeFruitGrove, spookyArea, appleBasketCabin, apple, sword,  netTrap, lostCity, banditCamp, merchantShop, castle, insideCabin, NetTrapPlace)))
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
        .add(new SetPosition(theKing, TheKingsCastle, "Throne"))//create king and place him on the throne
        .add(new SetPosition(guard1, TheKingsCastle, "LeftGuard"))//place the guards
        .add(new SetPosition(guard2, TheKingsCastle, "RightGuard"))
        .add(new SetPosition(guard3, TheKingsCastle, "LeftDoor"))
        .add(new Sit(theKing, theThrone))//have the king sit
        .add(new SetPosition(player, TheKingsCastle))//place the player at the normal position 
        .add(new FadeIn())//fade in since the player woke up- did not exit through a door 
        .add(new NarrationSequence("When you wake up, everything is hazy. You notice the tall, marble ceilings and faint light of gas lanterns. The room is majestic, and very familiar. Suddenly, memories  of being  knocked out fly back.\n"
        		+ "Your thoughts are interrupted by a booming voice..."))//give narration 
        .add(new Wait(10))
        .add(new HideNarration());
       
	}
	
	@BuilderMethod
    public void TheKingActions() {
        var node = get(MyNodeLabels.TheKing.toString());
        node.add(new WalkTo(player,TheKingsCastle, "Supplicant"))//have the player walk to the place they are supposed to 
        .add(new DialogSequence(theKing, player, List.of("I knew you would come back, you always do no matter how many times I banish you. Speak up!!"), List.of("What is going on? Who are you?", "**Stay silent**")));
       
        //Options: speak to the king or stay silent 
	}
	
	@BuilderMethod
    public void StaySilentActions() {
        var node = get(MyNodeLabels.StaySilent.toString());
        node.add(new HideDialog())
        .add(new NarrationSequence("Your mouth stays shut, and you can tell the man in front of you is getting angry."))
        .add(new Wait(5))
        .add(new HideNarration())
        .add(new DialogSequence(theKing, player, List.of("Fine, you always were a stubborn kid. Take him to the dungeon"), List.of("**Go with the guards**", "Fine Fine!! Ill talk. Who are you and what is going on?")));
        
   //Options: speak or get taken 
        
	}
	
	@BuilderMethod
    public void SpeakUpActions() {
        var node = get(MyNodeLabels.SpeakUp.toString());
        node.add(new HideDialog())
        .add(new DialogSequence(theKing, player, List.of("I am surprised my wizard has gotten so good at our memory potion. You usually remember by this pointYou really don't know who you are? Strange. Guards, take him away!"), List.of("**Go with the Guards**", "**Try to Talk to Guard**")));
  
        //Options: go silently with guards or get taken away
	}
	@BuilderMethod
    public void FollowWillinglyActions() {
        var node = get(MyNodeLabels.FollowWillingly.toString());
        node.add(new HideDialog())
        .add(new WalkTo(guard1, player))//guards walk to you 
        .add(new WalkTo(guard2, player))
        .add(new Wait(5))
        .add(new WalkTo(player, ToTheDungeons))//walk towards the exit 
        .add(new Wait(1))
        .add(new WalkTo(guard1, ToTheDungeons))
        .add(new WalkTo(guard2, ToTheDungeons))
        .add(new Exit(player, ToTheDungeons, true)) //exit into the dungeons 
        .add(new Exit(player, ToTheDungeons, true))
        .add(new Exit(guard1, ToTheDungeons, true))
        .add(new Exit(guard2, ToTheDungeons, true))
        .add(new CreateCharacterSequence(prisoner)) //add the prisoner
        .add(new SetPosition(prisoner, TheDungeons, "DirtPile")) //put them in the cell 
        .add(new Enter(player, EnterDungeons, true))//enter into the dungeons 
        .add(new Enter(guard1, EnterDungeons, true))
        .add(new WalkTo(guard1, cellDoor))
        .add(new DialogSequence(guard1, player, List.of("I am sorry my prince"), List.of("Why did you call me that? Can you please explain what's going on?", "**head into cell**")));
        
        //Options: talk outside with guard or enter cell 
        
	}
	
	@BuilderMethod
    public void TheCellActions() {
        var node = get(MyNodeLabels.TheCell.toString());
        node.add(new HideDialog())
        .add(new WalkTo(player, cellDoor))//walk to the cell door
        .add(new Enter(player, cellDoor, false))//enter with NO fading
        .add(new WalkTo(player, TheDungeons, "Bed"))
        .add(new DialogSequence(prisoner, player, List.of("Prince is that really you?"), List.of("What is going on?")));
        
        //Options: continue conversation
        
	}
	
	@BuilderMethod
    public void TalkToGuardActions() {
        var node = get(MyNodeLabels.TalkToGuard.toString());
        node.add(new HideDialog())
        .add(new WalkTo(player, guard1))
        .add(new DialogSequence(guard1, player, List.of("You seriously don't remember anything do you? Those potions really are getting strong. And here we thought you coming back again was our hope at freedomMy Prince, it pains me to have to remind you everything your father did. You've been down here with me before, and every time I hope you figure it out. I am sworn under oath to not say too much... everyone in the kingdom is. The only thing I will say is to ask for the wizard."), List.of("I dont understand...what are you talking about?")));
        //Options: continue Conversation 
        
	}
	
	@BuilderMethod
    public void GetContextActions() {
        var node = get(MyNodeLabels.GetContext.toString());
        node.add(new HideDialog())
        .add(new DialogSequence(prisoner, player, List.of("You seriously don't remember anything do you? Those potions really are getting strong. And here we thought you coming back again was our hope at freedomMy Prince, it pains me to have to remind you everything your father did. You've been down here with me before, and every time I hope you figure it out. I am sworn under oath to not say too much... everyone in the kingdom is. The only thing I will say is to ask for the wizard."), List.of("I dont understand...what are you talking about?")));
        
        //Options: Continue Conversation 
	}
	
	
	
	
//Hrishi Kabra
	
	@BuilderMethod
	public void AppleBasketActions() {//Picking up the apple in the cabin
		var node = get(MyNodeLabels.CabinAppleBasket.toString());
		node.add(new Exit(player, cabinDoor, true))
		.add(new Enter(player, insideCabinDoor, true)) //Player is now inside the cabin in the woods
		.add(new SetPosition(apple, insideCabin, "Table"))
		.add(new Wait(2))
		.add(new NarrationSequence("The cabin seems abandoned as you get closer, so you try to go in. The door opens without hesitation, and the first thing  you see is a basket of pristine apples. Starving, you decide to grab one..."))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	@BuilderMethod
	public void TheWarningActions() {
		var node = get(MyNodeLabels.ForestTheWarning.toString());
		node
        .add(new Face(wiseMan, player)) //face the players
        .add(new WalkTo(player, wiseMan))
		.add(new NarrationSequence("The person removes their hood to reveal a man. You stare at each other in silence. Finally, he says, “The city is not what you think.” Before you have a chance to ask more, he disappears in a puff of smoke"))
		.add(new Wait(5))
		.add(new HideNarration());
	}
	
	@BuilderMethod
	public void StrangeFruitActions() {//Picking up the apple in the woods - CabinInWoods&TheWarning lead to this - leads to EatApple
		var node = get(MyNodeLabels.ForestStrangeFruit.toString());
		node.add(new Exit(player, streamArea, true))
		.add(new Enter(player, strangeFruitGroveEntrance, true))
		.add(new Wait(2))
		.add(new NarrationSequence("As you are walking, you notice fruit trees scattered between the other vegetation. The juicy looking apples call your name, but something seems off about them…"))
		.add(new Wait(10))
		.add(new HideNarration())
		.add(new SetPosition(apple, strangeFruitGrove, "Plant"));
	}
	
	@BuilderMethod
	public void StrangeFruit2Actions() {//Picking up the apple in the woods - CabinInWoods&TheWarning lead to this - leads to EatApple
		var node = get(MyNodeLabels.ForestStrangeFruit2.toString());
		node.add(new Exit(player, eastEndSpookyArea, true))
		.add(new Enter(player, strangeFruitGroveEntrance, true))
		.add(new Wait(2))
		.add(new NarrationSequence("As you are walking, you notice fruit trees scattered between the other vegetation. The juicy looking apples call your name, but something seems off about them…"))
		.add(new Wait(10))
		.add(new HideNarration())
		.add(new SetPosition(apple, strangeFruitGrove, "Plant"));
	}
	
	
	@BuilderMethod
	public void NetTrapActions() {
		var node = get(MyNodeLabels.ForestANetTrap.toString());
		node.add(new Exit(player, strangeFruitGroveExit, true))
		.add(new Enter(player, NetTrapEntrance, true))
		.add(new CreateCharacterSequence(banditLeader))
		.add(new SetPosition(banditLeader, strangeFruitGrove, "Plant"))
		.add(new CreateCharacterSequence(forestBandit))
		.add(new SetPosition(forestBandit, strangeFruitGrove, "DirtPile"))
		.add(new Face(banditLeader, player))
		.add(new Face(forestBandit, player))
		.add(new Wait(2))
		.add(new NarrationSequence("you start walking and before you know it, something catches you by your feet and you are hanging in the air stuck in a net! A group of people jump out of the bushes. "))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	@BuilderMethod
	public void PlayDeadActions() {
		var node = get(MyNodeLabels.ForestPlayDead.toString());
		node
		.add(new Wait(2))
		.add(new NarrationSequence("You decide to play dead in the net trap. It doesn't work, your captors know you are alive. After a few minutes of whispering and shock in their eyes, they proclaim that they are taking you to the castle. You start panicking and try to free yourself, but you are sorely out numbered. One of them hits you over the head with the butt of his sword. You immediately go unconscious and drop to the floor.\n"))
		.add(new Wait(10))
		.add(new HideNarration());
	}
	
	@BuilderMethod
	public void AskGuardForTruthActions() {
		var node = get(MyNodeLabels.AskGuardForTruth.toString());
		node.add(new HideDialog())
		.add(new WalkTo(player, TheKingsCastle, "RightGuard"))
		.add(new DialogSequence(guard2, player, List.of("\"You seriously don't remember anything do you? Those potions really are getting strong. And here we thought you coming back again was our hope at freedom.\"\n"
				+ "You look obviously confused.\n"
				+ "\"My Prince, it pains me to have to remind you everything your father did. You've been down here with me before, and every time I hope you figure it out. I am sworn under oath to not say too much... everyone in the kingdom is. The only thing I will say is to ask for the wizard.\""), List.of("**Ask for the Wizard**")));
		//Options: Ask for the wizard -> TheWizard
	}
	
	
	@BuilderMethod
	public void TheWizardActions() {
		var node = get(MyNodeLabels.TheWizard.toString());
		node.add(new HideDialog())
		  .add(new WalkTo(player, toTheWizard))
	      .add(new Exit(player, toTheWizard, true))
	      .add(new Enter(player, EnterWizardLibrary, true))
	      .add(new CreateCharacterSequence(wiseMan))
	      .add(new SetPosition(wiseMan, TheWizardLibrary, "Stand"))
	      .add(new NarrationSequence("You come to stand in front of two, large, ornate oak doors. They open on their own, and you walk inside the tower. A cloaked man is staring out the bay windows."))
	      .add(new Wait(5))
	      .add(new DialogSequence(wiseMan, player, List.of("\"You always come back.\""), List.of()))
	      .add(new HideDialog())
	      .add(new NarrationSequence(" He says and turns around. Its the cloaked man from the woods!!"))
	      .add(new Wait(5))
	      .add(new HideNarration());
	}
	
	public void theWizard2Actions() {
		var node = get(MyNodeLabels.TheWizard2.toString());
		node.add(new DialogSequence(player, wiseMan, List.of("\"Its you again! Who are you??\"\n"), List.of()))
	    .add(new HideDialog())
	    .add(new DialogSequence(wiseMan, player, List.of("\"My name is The Great Wizard, and it pains me you no longer remember me. I suppose you can only wipe someones memory a handful of times before seeing lasting effects. Hopefully you will be ready soon.\"\n"), List.of("\\\"Ready? For what?\\\"\\n")))
	    .add(new HideDialog())
	    .add(new DialogSequence(wiseMan, player, List.of("\"To take over the kingdom from your father of course!\" The Great Shirvani laughs. \"You should be grateful really, he thought you were a waste of space. Never an heir worthy of the kingdom. I was the one who convinced him that you could learn. You haven't yet, but maybe soon.\"\n"), List.of("What do I need to learn?", "I am still confused?")))
	    .add(new HideDialog());
	}

	public void TheWizardsFinalWordsActions() {
		var node = get(MyNodeLabels.TheWizardsFinalWords.toString());
		node.add(new DialogSequence(wiseMan, player, List.of("\"Ah, of course you are. All is well and you will remember more with time. That is, unless we have to send you away again.\"\n"), List.of("\"Send me away?\"\n")))
	    .add(new HideDialog())
	    .add(new DialogSequence(wiseMan, player, List.of("\"Yes, Unless of course, you now know the answer.\"\n"), List.of("\"The answer to what?\"\n")))
	    .add(new HideDialog());
	}
	
	public void TheRiddleActions() {
		var node = get(MyNodeLabels.TheRiddle.toString());
		node.add(new DialogSequence(wiseMan, player, List.of("\"The answer to the riddle of course! Answer correct, and you have learned enough across these trials to take over the kingdom. Answer wrong, and your dad is right, but I will keep trying. However, at the rate of this memory last we may only have a few resets left\"\n"
				+ "The Riddle:\n"
				+ "\n"
				+ "In a kingdom fair, where trees abound,\n"
				+ "With fruite of wonder the land is crown’d.\n"
				+ "Beneath yon oake and ash so tall,\n"
				+ "The prize awaiteth, yet danger doth call.\n"
				+ "A fruite there is, both faire and bright,\n"
				+ "Its tempting flesh hides secret blight.\n"
				+ "Once it did lure both king and knave,\n"
				+ "A path to ruin, yet wisdom it gave.\n"
				+ "If thou wouldst seek thy wayward home,\n"
				+ "Through forests deep thou needs must roam.\n"
				+ "Choose well the fruite, for fate is near—\n"
				+ "Thy heart shall guide thee, conquer thy fear"), List.of("The Crown", "Power", "The Forest", "Bread", "The Apple")))
		.add(new HideDialog());
	}
	
	public void TheEndActions() {
		var node = get(MyNodeLabels.TheEnd.toString());
		node.add(new NarrationSequence("A bright light fills the room, and all of your memories come back. You feel the power shift, and a crown sits a top your head.\n"
				+ "Welcome King."))
		.add(new Wait(5))
		.add(new HideDialog());
		//How to give him aura?
	}
	
	public void YouFailActions() {
		var node = get(MyNodeLabels.Youfail.toString());
		node.add(new DialogSequence(wiseMan, player, List.of("\"Maybe your father was right...\"\n"), List.of()));
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