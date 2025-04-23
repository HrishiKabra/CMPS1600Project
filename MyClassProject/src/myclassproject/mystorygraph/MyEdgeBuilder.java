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
	        var choice1 = new PlayerInteraction(player, MyChoiceLabels.RunToClearing.toString(), eastEndSpookyArea);
	        var nextNode1 = get(MyNodeLabels.CabinInTheWoods.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //player decides to talk with the entity
	        var choice2 = new PlayerInteraction(MyChoiceLabels.TalkToWiseMan.toString(), wiseMan, Icons.talk, "Go talk to the Wise Man");
	        var nextNode2 = get(MyNodeLabels.ForestTheWarning.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	       
	 }
	        
	 @BuilderMethod
	    public void TheCastleEdges() {
	        var node = get(MyNodeLabels.TheCastle.toString());
	        
	       //Player decides to speak with the king 
	        var choice1 = new PlayerInteraction(MyChoiceLabels.TalkToKing.toString(), theKing, Icons.talk, "Speak with the King");
	        var nextNode1 = get(MyNodeLabels.TheKing.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	 }
	 
	 @BuilderMethod
	    public void TheCastle2Edges() {
	        var node = get(MyNodeLabels.TheCastle2.toString());
	        
	       //Player decides to speak with the king 
	        var choice1 = new PlayerInteraction(MyChoiceLabels.TalkToKing.toString(), theKing, Icons.talk, "Speak with the King");
	        var nextNode1 = get(MyNodeLabels.TheKing.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	 }
	 
	 @BuilderMethod
	    public void TheCastle3Edges() {
	        var node = get(MyNodeLabels.TheCastle3.toString());
	        
	       //Player decides to speak with the king 
	        var choice1 = new PlayerInteraction(MyChoiceLabels.TalkToKing.toString(), theKing, Icons.talk, "Speak with the King");
	        var nextNode1 = get(MyNodeLabels.TheKing.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	 }
	 
	 
	 @BuilderMethod
	    public void TheKingEdges() {
	        var node = get(MyNodeLabels.TheKing.toString());
	        
	        //Talk to the king 
	        var choice1 = new DialogChoice("What is going on? Who are you?");
	        var nextNode1 = get(MyNodeLabels.SpeakUp.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //choose not to talk
	        var choice2 = new DialogChoice("**Stay silent**");
	        var nextNode2 = get(MyNodeLabels.StaySilent.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	 }
	 
	 
	 @BuilderMethod
	    public void SpeakUpEdges() {
	        var node = get(MyNodeLabels.SpeakUp.toString());
	        
	        //Go with the guards silently 
	        var choice1 = new DialogChoice("**Go with the guards**");
	        var nextNode1 = get(MyNodeLabels.FollowWillingly.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //Talk to the guard for answer
	        var choice2 = new DialogChoice("**Try to talk to guard**");
	        var nextNode2 = get(MyNodeLabels.AskGuardForTruth.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	 }
	 
	 
	 @BuilderMethod
	    public void StaySilentEdges() {
	        var node = get(MyNodeLabels.StaySilent.toString());
	        
	        //Go with the guards silently 
	        var choice1 = new DialogChoice("**Go with the guards**");
	        var nextNode1 = get(MyNodeLabels.FollowWillingly.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //speak to the king 
	        var choice2 = new DialogChoice("Fine Fine!! Ill talk. Who are you and what is going on?");
	        var nextNode2 = get(MyNodeLabels.SpeakUp.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	 }
	 
	 
	 @BuilderMethod
	    public void FollowWillinglyEdges() {
	        var node = get(MyNodeLabels.FollowWillingly.toString());
	        
	        //ask the guard to give context
	        var choice1 = new DialogChoice("Why did you call me that? Can you please explain what's going on?");
	        var nextNode1 = get(MyNodeLabels.TalkToGuard.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	        //Choose not to speak to the guard and go into the cell
	        var choice2 = new DialogChoice("**head into cell**");
	        var nextNode2 = get(MyNodeLabels.TheCell.toString());
	        node.add(new Edge(choice2, nextNode2));
	        
	 }
	 
	 @BuilderMethod
	    public void TalkToGuardEdges() {
	        var node = get(MyNodeLabels.TalkToGuard.toString());
	        
	        //ask the stationed guard to continue explaining
	        var choice1 = new DialogChoice("I dont understand...what are you talking about?");
	        var nextNode1 = get(MyNodeLabels.AskStationedGuard.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	      
	 }
	 
	 @BuilderMethod
	    public void TheCellEdges() {
	        var node = get(MyNodeLabels.TheCell.toString());
	        
	        //ask the prisoner to continue explaining
	        var choice1 = new DialogChoice("What is going on?");
	        var nextNode1 = get(MyNodeLabels.GetContext.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	      
	 }
	 @BuilderMethod
	    public void GetContextEdges() {
	        var node = get(MyNodeLabels.GetContext.toString());
	        
	        //ask the stationed guard to continue explaining
	        var choice1 = new DialogChoice("I dont understand...what are you talking about?");
	        var nextNode1 = get(MyNodeLabels.AskPrisoner.toString());
	        node.add(new Edge(choice1, nextNode1));
	        
	      
	 }
	 
	 @BuilderMethod
	 public void AskPrisonerEdges() {
		 var node = get(MyNodeLabels.AskPrisoner.toString());
		 var choice1 = new DialogChoice("I WANT TO SPEAK TO THE WIZARD");
		 var nextNode1 = get(MyNodeLabels.TheWizardCell.toString());
	     node.add(new Edge(choice1, nextNode1));
		 
	 }
	 
	 @BuilderMethod
	 public void AskStationedGuardEdges() {
		 var node = get(MyNodeLabels.AskStationedGuard.toString());
		 var choice1 = new DialogChoice("I WANT TO SPEAK TO THE WIZARD");
		 var nextNode1 = get(MyNodeLabels.TheWizardCell.toString());
	     node.add(new Edge(choice1, nextNode1));
		 
	 }

	 
	//Hrishi Kabra
	 @BuilderMethod
	 	public void AppleBasketEdges() {
		 var node = get(MyNodeLabels.CabinAppleBasket.toString());
		 
		 var choice1 = new PlayerInteraction(MyChoiceLabels.PickUpApple.toString(), apple, Icons.exit, "Eat the apple"); //Help - what to do here?
		 var nextNode1 = get(MyNodeLabels.TheCastle.toString()); 
		 node.add(new Edge(choice1, nextNode1));
	 }
	
	@BuilderMethod
	 public void StrangeFruitEdges() {
		 var node = get(MyNodeLabels.ForestStrangeFruit.toString());
      var choice1 = new PlayerInteraction(player, MyChoiceLabels.IgnoreFruit.toString(), strangeFruitGroveExit);
      var nextNode1 = get(MyNodeLabels.ForestANetTrap.toString());
      node.add(new Edge(choice1, nextNode1));
     
      var choice2 = new PlayerInteraction(MyChoiceLabels.EatApple.toString(), strangeFruitGrovePlant, Icons.draw, "Eat Apple");
      var nextNode2 = get(MyNodeLabels.TheCastle2.toString());
      node.add(new Edge(choice2, nextNode2));
      
      
	 }
	
	@BuilderMethod
	 public void StrangeFruit2Edges() {
		 var node = get(MyNodeLabels.ForestStrangeFruit2.toString());
     var choice1 = new PlayerInteraction(player, MyChoiceLabels.IgnoreFruit.toString(), strangeFruitGroveExit);
     var nextNode1 = get(MyNodeLabels.ForestANetTrap.toString());
     node.add(new Edge(choice1, nextNode1));
    
     var choice2 = new PlayerInteraction(MyChoiceLabels.EatApple.toString(), strangeFruitGrovePlant, Icons.draw, "Eat Apple"); 
     var nextNode2 = get(MyNodeLabels.TheCastle2.toString());
     node.add(new Edge(choice2, nextNode2));
	}
	
	
	
	@BuilderMethod
	 public void TheWarningEdges() {
		 var node = get(MyNodeLabels.ForestTheWarning.toString());
      var choice1 = new PlayerInteraction(player, MyChoiceLabels.GoDeeper.toString(), eastEndSpookyArea);
		 var nextNode1 = get(MyNodeLabels.ForestStrangeFruit2.toString());
		 node.add(new Edge(choice1, nextNode1));
		 
		 var choice2 =new PlayerInteraction(player, MyChoiceLabels.GoBack.toString(), westEndSpookyArea);
		 var nextNode2 = get(MyNodeLabels.CityTheLostCity.toString());
		 node.add(new Edge(choice2, nextNode2));
	 }
	 
	@BuilderMethod
	 public void NetTrapEdges() {
		 var node = get(MyNodeLabels.ForestANetTrap.toString());
     
      var choice1 = new PlayerInteraction(MyChoiceLabels.DemandAnswers.toString(), banditLeader, Icons.talk, "Fight your fate");
      var nextNode1 = get(MyNodeLabels.ForestDemandAnswers.toString());
      node.add(new Edge(choice1, nextNode1));
     
      var choice2 = new PlayerInteraction(MyChoiceLabels.PlayDead.toString(), banditLeader, Icons.kneel, "Play Dead");
      var nextNode2 = get(MyNodeLabels.TheCastle3.toString());
      node.add(new Edge(choice2, nextNode2));
	 }
	
	@BuilderMethod
	 public void PlayDeadEdges() {
		 var node = get(MyNodeLabels.ForestPlayDead.toString());
	//	 var choice1 = new PlayerInteraction(MyChoiceLabels.WakeUp.toString(), castleEntrance, Icons.exit, "WAKE UP");
	  //   var nextNode1 = get(MyNodeLabels.TheCastle.toString());
	 //    node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 	public void AskGuardForTruthEdges() {
		 var node = get(MyNodeLabels.AskGuardForTruth.toString());
		 
		 var choice1 = new DialogChoice("**Ask For The Wizard**");
		 var nextNode1 = get(MyNodeLabels.TheWizard.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 /*
	 @BuilderMethod
	 public void AskStationedGuardEdges() {
		     var node = get(MyNodeLabels.AskStationedGuard.toString());
		          
		     var choice = new DialogChoice("I WANT TO SPEAK TO THE WIZARD");
		      var nextNode1 = get(MyNodeLabels.TheWizardAlternate.toString());
		      }
	 
	 @BuilderMethod
	 public void AskPrisonerEdges() {
		     var node = get(MyNodeLabels.AskPrisoner.toString());
		          
		     var choice = new DialogChoice("I WANT TO SPEAK TO THE WIZARD");
		      var nextNode1 = get(MyNodeLabels.TheWizard.toString());
		      }
		 */
	 
	 @BuilderMethod
	 public void TheWizardEdges() {
		 var node = get(MyNodeLabels.TheWizard.toString());
		 
		 var choice1 = new PlayerInteraction(MyChoiceLabels.TalkToWizard.toString(), Wizard, Icons.talk, "Go talk to the Wizard");
		 var nextNode1 = get(MyNodeLabels.TheWizard0.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 public void TheWizardCellEdges() {
		 var node = get(MyNodeLabels.TheWizardCell.toString());
		 
		 var choice1 = new PlayerInteraction(MyChoiceLabels.TalkToWizard.toString(), Wizard, Icons.talk, "Go talk to the Wizard");
		 var nextNode1 = get(MyNodeLabels.TheWizard0.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 public void TheWizard0Edges() {
		 var node = get(MyNodeLabels.TheWizard0.toString());
		 
		 var choice1 = new DialogChoice("Its you again! Who are you??");	
		 var nextNode1 = get(MyNodeLabels.TheWizard2.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 public void TheWizard2Edges() {
		 var node = get(MyNodeLabels.TheWizard2.toString());
		 
		 var choice1 = new DialogChoice("Ready? For what?");
		 var nextNode1 = get(MyNodeLabels.TheWizard3.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 public void TheWizard3Edges() {
		 var node = get(MyNodeLabels.TheWizard3.toString());
		 
		 var choice1 = new DialogChoice("What do I need to learn?");
		 var nextNode1 = get(MyNodeLabels.TheRiddle.toString());
		 node.add(new Edge(choice1, nextNode1));
		 
		 var choice2 = new DialogChoice("I am still confused?");
		 var nextNode2 = get(MyNodeLabels.TheWizardsFinalWords.toString());
		 node.add(new Edge(choice2, nextNode2));
	 }
	 
	 @BuilderMethod
	 public void TheWizardsFinalWordsEdges() {
		 var node = get(MyNodeLabels.TheWizardsFinalWords.toString());
		 
		 var choice1 = new DialogChoice("Send me away?");
		 var nextNode1 = get(MyNodeLabels.TheWizardsFinalWords2.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 public void TheWizardsFinalWords2Edges() {
		 var node = get(MyNodeLabels.TheWizardsFinalWords2.toString());
		 
		 var choice1 = new DialogChoice("The answer to what?");
		 var nextNode1 = get(MyNodeLabels.TheRiddle.toString());
		 node.add(new Edge(choice1, nextNode1));
	 }
	 
	 @BuilderMethod
	 public void TheRiddleEdges() {
		 var node = get(MyNodeLabels.TheRiddle.toString());
		 
		 var choice1 = new DialogChoice("The Crown");
		 var choice2 = new DialogChoice("Power");
		 var choice3 = new DialogChoice("The Forest");
		 var choice4 = new DialogChoice("The Apple");
		 var choice5 = new DialogChoice("Bread");
		 var nextNode1 = get(MyNodeLabels.Youfail.toString());
		 var nextNode2 = get(MyNodeLabels.TheEnd.toString());
		 node.add(new Edge(choice1, nextNode1));
		 node.add(new Edge(choice2, nextNode1));
		 node.add(new Edge(choice3, nextNode1));
		 node.add(new Edge(choice4, nextNode2));
		 node.add(new Edge(choice5, nextNode1));
	 }
	 
	 
	 
	 
 
 
 
	 
	 /*
	 
	 
	 
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
	    

    
	   
    
    @BuilderMethod
    public void eatAppleEdges() {
        var node = get(MyNodeLabels.EatApple.toString());
        var choice = new PlayerInteraction("WakeUp", player, Icons.exit, "Wake Up");
        var nextNode = get(MyNodeLabels.TheCastle.toString());
        node.add(new Edge(choice, nextNode));
    }
    /*
    @BuilderMethod
    public void theMarketEdges() {
        var node = get(MyNodeLabels.TheMarket.toString());
        var choice1 = new PlayerInteraction(player, "BuyBread", merchantShop, Icons.exit, "Buy Bread");
        var nextNode1 = get(MyNodeLabels.TheBreadWoman.toString());
        node.add(new Edge(choice1, nextNode1));
        var choice2 = new PlayerInteraction(player, "ApproachPeople", merchantShop, Icons.talk, "Approach people");
        var nextNode2 = get(MyNodeLabels.WhereAreYouNow.toString());
        node.add(new Edge(choice2, nextNode2));
    }
    
    @BuilderMethod
    public void theBreadWomanEdges() {
        var node = get(MyNodeLabels.TheBreadWoman.toString());
        var choice = new PlayerInteraction("WakeUp", player, Icons.exit, "Wake Up");
        var nextNode = get(MyNodeLabels.TheCastle.toString());
        node.add(new Edge(choice, nextNode));
    }
  
    @BuilderMethod
    public void whereAreYouNowEdges() {
        var node = get(MyNodeLabels.WhereAreYouNow.toString());
        var choice = new PlayerInteraction(player, "ChaseMerchants", merchantShop, Icons.talk, "Chase the merchants");
        var nextNode = get(MyNodeLabels.FollowTheMerchants.toString());
        node.add(new Edge(choice, nextNode));
    }
    
    @BuilderMethod
    public void followTheMerchantsEdges() {
        var node = get(MyNodeLabels.FollowTheMerchants.toString());
        var choice1 = new PlayerInteraction(player, "Eavesdrop", merchantShop, Icons.talk, "Eavesdrop on their conversation");
        var nextNode1 = get(MyNodeLabels.TheSpy.toString());
        node.add(new Edge(choice1, nextNode1));
        var choice2 = new PlayerInteraction(player, "TalkToMerchants", merchantShop, Icons.talk, "Talk to the merchants");
        var nextNode2 = get(MyNodeLabels.MerchantsChat.toString());
        node.add(new Edge(choice2, nextNode2));
    }
    
    @BuilderMethod
    public void theSpyEdges() {
        var node = get(MyNodeLabels.TheSpy.toString());
        var choice = new PlayerInteraction("WakeUp", player, Icons.exit, "Wake Up");
        var nextNode = get(MyNodeLabels.TheCastle.toString());
        node.add(new Edge(choice, nextNode));
    }
    
    
    @BuilderMethod
    public void merchantsChatEdges() {
        var node = get(MyNodeLabels.MerchantsChat.toString());
        var choice = new PlayerInteraction("WakeUp", player, Icons.exit, "Wake Up");
        var nextNode = get(MyNodeLabels.TheCastle.toString());
        node.add(new Edge(choice, nextNode));
    }
    */
}