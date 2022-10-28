package example;

import java.util.Random;

public interface SharedConstants {
    int NO = 1;
    int YES = 2;
    int LATER = 3;
    int SOON = 4;
    int NEVER = 5;
}

class Question implements SharedConstants{
    Random rand = new Random();
    int ask(){
        int prob = (int)(100*rand.nextDouble());
        if(prob < 30)
            return NO;
        else if(prob < 60)
            return YES;
        else if(prob < 75)
            return LATER;
        else if(prob < 98)
            return SOON;
        else
            return NEVER;
    }
}

class  Shar implements SharedConstants{
    static void answer(int result){
        switch (result){
            case NO:
                System.out.println("NO");
                break;
            case YES:
                System.out.println("YES");
                break;
            case LATER:
                System.out.println("LATER");
                break;
            case SOON:
                System.out.println("SOON");
                break;
            case NEVER:
                System.out.println("NEVER");
                break;
        }
    }
    public static void main(String[] args){
        Question q = new Question();
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
    }
}
