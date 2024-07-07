class Solution {
    public int numWaterBottles(int fullBott, int exgCost) {
        int mtBott=fullBott;
        int canDrink = fullBott;
        int newFullBott = 0;

        while(mtBott>=exgCost) {

            newFullBott = mtBott/exgCost;
            mtBott = (mtBott%exgCost) + newFullBott;
            canDrink += newFullBott;
        }

        return canDrink;
    }
}