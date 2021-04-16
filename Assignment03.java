/**
* CSE 110     : Class 77686 / iCourse
* Assignment  : Assignment 3
* Author      : Joseph Kharzo
* Description : The program calculates, based on a number of inputs, whether the
* user should purchase, hold, or sell shares. The decision is based on a number
* of calculations that ensure a profit is made from the trade. If no profit can
* be made, then the user is told to hold their position. The user inputs the
* number of shares currently owned, the price at which the shares were bought, the
* current market price per share, and the amount of money the user is willing to
* spend on a transaction.
*/

import java.util.Scanner;

public class Assignment03 {

    public static void main(String[] args) {
        // declare and instantiate a Scanner
        Scanner userInput = new Scanner(System.in);
        
        // declare and initialize variables
        
        // Input variables
        
        int numberOfShares; // The amount of shares currently owned
        
        // The costBasis is the breakeven market price
        // The marketPrice is the current price per share
        // The availableFunds is the amount of money the user is willing to spend
        double costBasis, marketPrice, availableFunds;

        // Output variables
        
        int numberOfSharesToBuy; // How many shares can be bought by the user
        
        double perShareBuyValue, perShareSellValue, totalBuyValue, totalSellValue;
        
        String decision = ""; // Whether to buy, hold, or sell
        
        // Constant
        
        final int FEE = 10; // 10 dollar fee when purchasing and selling
        
        
        
        // prompt for and collect inputs
        System.out.println("Current Shares:");
        numberOfShares = userInput.nextInt();
        
        System.out.println("Purchase Price:");
        costBasis = userInput.nextInt();
        
        System.out.println("Market Price");
        marketPrice = userInput.nextInt();
        
        System.out.println("Available Funds");
        availableFunds = userInput.nextInt();
        
        // compute required values
        
        // The number of shares the user can buy with the available funds
        numberOfSharesToBuy = (int)Math.floor(((availableFunds - FEE)/marketPrice));
        
        // Calculates the difference between the price the shares were purchsed
        // and the current price per share
        perShareBuyValue = costBasis - marketPrice;
        
        // The difference between the costBasis and the market price multiplied by
        // the shares the user can buy gives the value of the purchasing of shares
        totalBuyValue = perShareBuyValue * numberOfSharesToBuy;
        
        // Inverses the logic of the perShareBuyValue
        perShareSellValue = marketPrice - costBasis;
        
        // Inverses the logic of the totalBuyValue but instead of looking at how
        // many shares can be bought, the number of shares owned is considered
        totalSellValue = perShareSellValue * numberOfShares;
        
        // If statements that decide on what the user should do
        
        // If the costBasis is higher than the current market price and if the profit
        // is greater than 10 dollars, then the user should buy shares
        if(perShareBuyValue > 0 && totalBuyValue > 10){
            decision = "Buy " + numberOfSharesToBuy + " shares";
        }
        
        // If the costBasis is lower than the current market price and if the profit
        // is greater than 10 dollars, then the user should sell shares
        if(perShareSellValue > 0 && totalSellValue > 10){
            decision = "Sell " + numberOfShares + " shares";
        }
        
        /* If the profit of selling or buying shares is less than or equal to 10
        * dollars, then the user should hold as the fees that must be payed will
        * reduce the gain from the trade.
        */
        if(totalBuyValue <= 10 && totalSellValue <= 10){
            decision = "Hold shares";
        }
        
        
        // display required outputs
        System.out.println();
        System.out.println(decision);
        
        
        
    }
    
    
}
