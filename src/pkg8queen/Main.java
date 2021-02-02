package pkg8queen;

public class Main {

    static int tempreture;
    static Board board;

    public static void main(String[] args) {
        
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new Board().setVisible(true);
         }
         });
         
        
    }

    public static State simulatedAnnealing(State initial) {
        State current = null; 
        if (initial == null) {
            current = randomGenerateInitialState();
        }else{
            current = initial ;
        }
        int T, randomSuccessorIndex, deltaE;
        double possibility;
        State next;
        System.out.println(current + "\nh : " + current.getH());
        for (int t = 1; t < 100000; t++) {
            // Goal reached

            if (current.getH() == 0) {
                return current;
            }

            T = schedule(t);
            if (T == 0) {
                return current;
            }
            current.generateSuccessors();
            randomSuccessorIndex = (int) (Math.random() * current.getSuccessors().size());
            next = current.getSuccessors().get(randomSuccessorIndex);
            deltaE = current.getH() - next.getH();
            if (deltaE > 0) {
                current = next;
            } else {
                possibility = Math.random();
                if (possibility < Math.pow(Math.E, (double) (deltaE / T))) {
                    current = next;
                }
            }
        }

        return current;
    }

    public static State randomGenerateInitialState() {
        return new State();
    }

    // a mapping from t to T 
    public static int schedule(int t) {
        return t;
    }

}
