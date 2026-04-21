import java.util.Random;
import java.util.Scanner;

public class BalanceAtTheThirdGame {

    // 花色与点数
    private static final String[] SUITS = {"hearts", "diamonds", "spades", "clubs"};
    private static final String[] RANKS = {
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };

    // 倍率
    private static final float ROUND1_MULTIPLIER = 2.4f;
    private static final float ROUND2_NUMBER_MULTIPLIER = 1.3f;
    private static final float ROUND2_LETTER_MULTIPLIER = 2.925f;
    private static final float ROUND3_NUMBER_MULTIPLIER = (float) 50 /3;
    private static final float ROUND3_LETTER_MULTIPLIER = (float) 200 /27;

    // 庄家获取卡牌
    public static String[] getTheCard(){
        Random rand = new Random();
        int index1 = rand.nextInt(SUITS.length);
        int index2 = rand.nextInt(RANKS.length);

        return new String[]{SUITS[index1], RANKS[index2]};
    }

    // 检查花色
    public static boolean Suits(String answer, String[] theCard){
        if(theCard[0].equals("hearts") && answer.equals("h")){
            return true;
        } else if (theCard[0].equals("diamonds") && answer.equals("d")) {
            return true;
        } else if (theCard[0].equals("spades") && answer.equals("s")) {
            return true;
        } else if (theCard[0].equals("clubs") && answer.equals("c")){
            return true;
        }else {
            return false;
        }
    }

    // 检查类别
    public static boolean Type(String answer, String[] theCard){
        if(theCard[1].equals("A")|| theCard[1].equals("J") || theCard[1].equals("Q") || theCard[1].equals("K")){
            return answer.equals("L") || answer.equals("l");
        }else{
            return answer.equals("N") || answer.equals("n");
        }
    }

    // 检查具体的值
    public static boolean Value(String answer, String[] theCard){
        return answer.equals(theCard[1]);
    }

    // 游戏开始
    public static float GameStart(){
        String[] theCard = getTheCard();
        Scanner sc = new Scanner(System.in);
        System.out.println("------Game Start!-----");
        System.out.print("Please place your bet: $");
        // float theBet = sc.nextFloat();
        float theBet = 10;
        System.out.println("Your bet is " + theBet);
        System.out.println();

        System.out.println("Round 1: ");
        System.out.println("Please Guess the Suit: (h)earts, (d)iamonds, (s)pades, (c)lubs");
        // String suit = sc.nextLine();
        String[] suits = {"h", "d", "s", "c"};
        Random rand = new Random();
        int index = rand.nextInt(suits.length);
        String suit = suits[index];
        System.out.println("You chose " + suit + ".");
        if(!Suits(suit, theCard)) {
            System.out.println("You loss in round 1.");
            return 0;
        }
        System.out.println("You win in round 1.");
        theBet = theBet * ROUND1_MULTIPLIER;

        System.out.println("Round 2: ");
        System.out.println("Please Guess the Type: (n)umber(2-10), (l)etter(AKQJ)");
        // String type = sc.nextLine();
        boolean typei = rand.nextBoolean();
        boolean ans;
        if(typei){
            System.out.println("You chose number card.");
            ans = Type("n", theCard);
        }else{
            System.out.println("You chose letter card.");
            ans = Type("l", theCard);
        }
        if(!ans){
            System.out.println("You loss in round 2.");
            return 0;
        }
        System.out.println("You win in round 2.");
        if(typei){
            theBet = theBet * ROUND2_NUMBER_MULTIPLIER;
        }else{
            theBet = theBet * ROUND2_LETTER_MULTIPLIER;
        }

        // Round 3
        System.out.println("Round 3");
        boolean result;
        if(typei){ // 数字卡牌
            System.out.println("Please Guess the Card: 2, 3, 4, 5, 6, 7, 8, 9, 10");
            String[] num = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
            int index3 = rand.nextInt(num.length);
            String ans3 = num[index3];
            System.out.println("You chose " + ans3 + ".");
            result = Value(ans3, theCard);
            if(!result){
                System.out.println("You loss in round 3.");
                return 0;
            }
            theBet = theBet * ROUND3_NUMBER_MULTIPLIER;
        }else{ // 字母卡牌
            System.out.println("Please Guess the Card: A, K, Q, J");
            String[] letter = {"A", "K", "Q", "J"};
            int index3 = rand.nextInt(letter.length);
            String ans3 = letter[index3];
            System.out.println("You chose " + ans3 + ".");
            result = Value(ans3, theCard);
            if(!result){
                System.out.println("You loss in round 3.");
                return 0;
            }
            theBet = theBet * ROUND3_LETTER_MULTIPLIER;
        }
        System.out.println("You win in round 3!");
        System.out.println();
        System.out.println();
        return theBet;
    }

    public static void main(String[] args){
        int success = 0;
        float moneyInput = 0;
        float moneyAward = 0;
        for(int i = 0; i < 900000; i++){
            float v = GameStart();
            moneyInput += 10;
            if(!(v == 0)){
                success += 1;
                moneyAward += v;
            }
        }
        System.out.println("Success = " + success);
        System.out.println("You have spend $" + moneyInput + " in total.");
        System.out.println("Your reward is $" + moneyAward + " in total.");

    }
}
