using System;

namespace BlackJack
{
    class BlackJack
    {
        private const int totalRounds = 5;
        private int currentRounds = 0;
        private string winner;
        private const int TwentyOne = 21;
        private bool didHit = false;
        private Random rand = new Random(DateTime.Now.Millisecond);
        private Player Player1 = new Player();
        private Player Player2 = new Player();

        public BlackJack(string name1, string name2)
        {
            Player1.Name = name1;
            Player2.Name = name2;
        }

        public static void gameDialog()
        {
            Console.WriteLine("*Welcome to Blackjack.\n" +
                              "*You will be given two cards.\n" +
                              "*The player whose cards sum gets as close or equal to 21 wins.\n" +
                              "*However if the cards some exceeds 21, a bust, the player loses.\n" +
                              "*After the first hand, you may either hit or pass.\n" +
                              "*An 'Ace' card can equal 11 or 1.\n" +
                              "*Let the game begin!\n" +
                              "******************************************************************\n");
        }

        public void deal()
        {

            for (int i = 0; i < 3; i++)
            {
                Player1.setCard(rand.Next(1, 12), i);
                Player2.setCard(rand.Next(1, 12), i);
            }

            Console.WriteLine("{0} hand: \t\t\t\t{1} hand:" +
                              "\nCard 1: {2}\t\t\t\tCard 1: {3}" +
                              "\nCard 2: {4}\t\t\t\tCard 2: {5}",
                              Player1.Name, Player2.Name,
                              Player1.getCard(1), Player2.getCard(1),
                              Player1.getCard(2), Player2.getCard(2));

            Player1.setPlayerScore();
            Player2.setPlayerScore();

            Console.WriteLine("\nPress any button to continue...\n");
            Console.ReadLine();

            checkForAce(1);

            Console.WriteLine("{0} total: {1}\t\t\t\t{2} total: {3}",
                                Player1.Name, Player1.getPlayerScore(),
                                Player2.Name, Player2.getPlayerScore());

            Console.WriteLine("\nPress any button to continue...");
            Console.ReadLine();

            hit(Player1);
            hit(Player2);

            checkForAce(3);

            Console.WriteLine("************************************************************************");
            Console.WriteLine("{0} total: {1}\t\t\t\t{2} total: {3}",
                    Player1.Name, Player1.getPlayerScore(),
                    Player2.Name, Player2.getPlayerScore());

            Console.WriteLine("End of Round.");
            getRoundWinner();
        }

        public void hit(Player player)
        {
            if (player.Equals(Player1))
            {
                Console.WriteLine("{0}, Choose one of the following:\n1)Hit or 2)pass?", player.Name);
                string pAns = Console.ReadLine();
                if (pAns.Equals("1"))
                {
                    didHit = true;
                    int hit = rand.Next(1, 12);
                    player.setPlayerScore(hit);
                    Console.WriteLine("{0} hits. Draws a {1}", player.Name, hit);
                }
                else
                    Console.WriteLine("{0} passes.", player.Name);
            }
            else if(player.Equals(Player2))
            {

                if (AI())
                {
                    didHit = true;
                    int hit = rand.Next(1, 12);
                    player.setPlayerScore(hit);
                    Console.WriteLine("{0} hits. Draws a {1}", player.Name, hit);
                }
                else
                    Console.WriteLine("{0} passes.", player.Name);
            }

            checkForAce(2);
            didHit = false;
        }

        public void checkForAce(int cardNumber)
        {
            if (didHit)
            {
                if (Player1.getCard(2) == 11)
                    aceDrawn(Player1);
                if (Player2.getCard(2) == 11)
                    aceDrawn(Player2);
            }
            else
            {
                for (int i = cardNumber; i < 3; i++)
                {
                    if (Player1.getCard(i) == 11)
                        aceDrawn(Player1);
                    if (Player2.getCard(i) == 11)
                        aceDrawn(Player2);
                }
            }
        }

        public void aceDrawn(Player player)
        {
            int aceAns;
            if (player.Equals(Player1))
            {
                Console.WriteLine("{0}, you drew an Ace. Would you like it as an 11 or a 1?(Type number)",
                                                                                            player.Name);
                aceAns = Console.Read();
                if (aceAns == 1)
                    player.setPlayerScore(-10);
            }
            else if(player.Equals(Player2))
            {
                Console.WriteLine("{0} drew an ace.", player.Name);
                if(!AI())
                    player.setPlayerScore(-10);
            }
        }

        public bool AI()
        {

            bool doHit = Player2.getPlayerScore() < 15 ? true : false;

            if (Player1.getPlayerScore() > 21)
                doHit = false;

            if (Player2.getCard(3) == 11)
            {
                if (Player2.getPlayerScore() > 10)
                    doHit = false;
                else
                    doHit = true;
            }

            return doHit;
        }

        public void getRoundWinner()
        {

            if (Player1.getPlayerScore() > 21 && Player2.getPlayerScore() <= 21)
            {
                Player2.setMatchesWon();
                Console.WriteLine("{0} busts! {1} wins!!", Player1.Name, Player2.Name);
            }
            else if (Player2.getPlayerScore() > 21 && Player1.getPlayerScore() <= 21)
            {
                Player1.setMatchesWon();
                Console.WriteLine("{0} busts! {1} wins!!", Player2.Name, Player1.Name);
            }
            else if (Player1.getPlayerScore() > 21 && Player2.getPlayerScore() > 21
                || Player1.getPlayerScore() == Player2.getPlayerScore())
            {
                Console.WriteLine("Draw! No point awarded this round.");
                currentRounds--;
            }
            else if(Player1.getPlayerScore() > Player2.getPlayerScore() 
                    && Player1.getPlayerScore() <= 21)
            {
                Console.WriteLine("{0} wins!", Player1.Name);
                Player1.setMatchesWon();
            }
            else if(Player2.getPlayerScore() > Player1.getPlayerScore() 
                    && Player2.getPlayerScore() <= 21)
            {
                Console.WriteLine("{0} wins!", Player2.Name);
                Player2.setMatchesWon();
            }
            else
            {
                Console.WriteLine("An error occured");
            }
            Console.WriteLine("************************************************************************\n\n");
        }

        public void declareWinner()
        {
            if (totalRounds == currentRounds)
            {
                if (Player1.getMatchesWon() > Player2.getMatchesWon())
                    winner = Player1.Name;
                else
                    winner = Player2.Name;
            }
            else
            {
                Console.WriteLine("Next round...");
            }
        }

        public void gameOver()
        {
            Console.WriteLine("Game over. The winner is: {0}", winner);
            currentRounds = 0;
            Player.resetPlayersScore(Player1, Player2);
            winner = "";
        }

        public void startRound()
        {
            while (currentRounds != totalRounds)
            {
                Console.WriteLine("Round {0}!", currentRounds + 1);
                currentRounds++;
                deal();
            }

            declareWinner();
            gameOver();
        }

         ///////////////////////////////////////
        //          MAIN METHOD              //
       ///////////////////////////////////////

        static void Main(string[] args)
        {
            string sPlayAgain = "y";
            string sAns;

            gameDialog();
            Console.WriteLine("Enter your name: ");
            BlackJack game = new BlackJack(Console.ReadLine(), "Dealer");

            do
            {
                game.startRound();
                Console.WriteLine("Would you like to play again(y/n)?");
                sAns = Console.ReadLine();

            } while(sAns.Equals(sPlayAgain));
        } //end of main
    } // end of BlackJack Class 
} //end of BlackJack namespace

