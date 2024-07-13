
class Solution {
    class Pair{
        int posn;
        int health;
        char dir;
        Pair(int _p, int _h, char _ch){
            this.posn = _p;
            this.health = _h;
            this.dir = _ch;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] posn, int[] heal, String dir) {
        int n=posn.length;
        Pair[] robots = new Pair[n];
        for(int i=0; i<n; i++)  //put each robot pos,health,dir in array
            robots[i] = new Pair(posn[i], heal[i], dir.charAt(i));
        Stack<Pair> st = new Stack<Pair>();
        
        //Then Sort Robot-Pair[]-Array acc. to Positions.
        Arrays.sort(robots, Comparator.comparingInt(r -> r.posn)); //Modern way
        //Arrays.sort(robots, (a,b) -> a.posn - b.posn); //new way
        // Arrays.sort(robots, new Comparator<Pair>() { //Anonymous-fun Old way 
        //     @Override
        //     public int compare(Pair a, Pair b){
        //         return Integer.compare(a.posn, b.posn);
        //     }
        // });
        for(int i=0; i<n; i++) { //Traverse robot array
            Pair curr = robots[i]; //deal with each-elem-of-robot array
            boolean survived = true;

            while(!st.isEmpty() && st.peek().dir=='R' && curr.dir == 'L'){
                Pair top = st.pop();
                if(top.health == curr.health){  //collision of same health robots
                    survived = false; //do not add any not top not curr
                    break;
                }
                else if(top.health > curr.health) { //st-robo.helath > curr-array-robot
                    top.health--; //st-robot eliminate array-robt and 
                    st.push(top); //go again inside stack, with health reduce by 1;
                    survived = false;
                    break;
                }else { //if curr.array-robot.health  > st-robot
                    curr.health--; // eliminate st-robot & add array-Robot to stack
                }
            }

            if(survived) st.push(curr); //done by this if arr-robt-powerful r if St.empty
        }

        HashMap<Integer, Integer> map = new HashMap<>(); //to store acc. to posn->health of 
        for(Pair curr : st) { //each robot
            map.put(curr.posn, curr.health);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) { //run loop on posn array
            if(map.containsKey(posn[i])) //the posn. present in Map
               ans.add(map.get(posn[i]));  //as per posn-arr order return powrfull health robot
        } //into the answer list
        return ans;
    }
}