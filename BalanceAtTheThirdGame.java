import javax.swing.*;
import java.util.Random;

public class BalanceAtTheThirdGame {

    // 花色与点数
    private static final String[] SUITS = {"hearts", "diamonds", "spades", "clubs"};
    private static final String[] RANKS = {
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };

    // 倍率
    private static final double ROUND1_MULTIPLIER = 2.4;
    private static final double ROUND2_NUMBER_MULTIPLIER = 1.3;
    private static final double ROUND2_LETTER_MULTIPLIER = 2.925;
    private static final double ROUND3_NUMBER_MULTIPLIER = (double) 50 /3;
    private static final double ROUND3_LETTER_MULTIPLIER = (double) 200 /27;

    // 庄家获取卡牌
    public static String[] getTheCard(){
        Random rand = new Random();
        int index1 = rand.nextInt(SUITS.length);
        int index2 = rand.nextInt(RANKS.length);

        return new String[]{SUITS[index1], RANKS[index2]};
    }

    // 检查花色
    public static boolean Suits(String answer, String[] theCard){
        return answer.equals(theCard[0]);
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

    public static void main(String[] args){
        String[] theCard = getTheCard();

    }
}
