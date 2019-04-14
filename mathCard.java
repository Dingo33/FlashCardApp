//MADE BY DANIEL INGO
public class mathCard extends Card {
    double answer;

    public mathCard() {
        super.front = "";
        this.answer = -1;
    }

    public mathCard(String front, double answer) {
        super.front = front;
        this.answer = answer;
    }

    public double getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Front = "+front+", Back = "+answer;
    }

    public int compareTo(mathCard c) {
        int frontComp =front.compareTo(c.front);

        if (frontComp==0){
            if((answer == c.answer)){
                return 0;
            }
            else if(answer>c.answer){
                return 1;
            }
            return -1;
        }
        return frontComp;

    }
}
