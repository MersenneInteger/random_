using System;

namespace BlackJack
{
    class Player
    {
        private string name;
        private int matchesWon;
        private int playerScore = 0;
        private int[] cards = new int[3];

        public Player()
        {
            foreach (int card in cards)
                cards[card] = 0;
        }

        //name methods

        public string Name
        {
            get { return name; }
            set { name = value; }
        }
        
        //matches methods

        public int getMatchesWon()
        {
            return matchesWon;
        }

        public void setMatchesWon()
        {
            matchesWon++;
        }
        
        //player score methods
        public int getPlayerScore()
        {
            return playerScore;
        }

        public void setPlayerScore()
        {
            this.playerScore = cards[0] + cards[1];
        }

        public void setPlayerScore(int playerScore)
        {
            this.playerScore = this.playerScore + playerScore;
        }
        
        public static void resetPlayersScore(Player p1, Player p2)
        {
            p1.playerScore = 0;
            p2.playerScore = 0;
        }

        public int getCard(int cardNumber)
        {
            switch (cardNumber)
            {
                case 1:
                    return cards[0];
                case 2:
                    return cards[1];
                case 3:
                    return cards[2];
                default:
                    return 0;
            }
        }

        public void setCard(int card, int cardNumber)
        {
            switch (cardNumber)
            {
                case 1:
                    cards[0] = card;
                    break;
                case 2:
                    cards[1] = card;
                    break;
                case 3:
                    cards[2] = card;
                    break;
            }
        }
    } //end of player class
}
