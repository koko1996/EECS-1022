
package ca.roumani.rex1;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 3/1/17.
 */
public class RexModel
{   public final static int SET_SIZE=3;
    private boolean Digit=false;
    private boolean Letter=false;
    private boolean Anchor=false;
    private int repeat;
    private Random rng;
    private String digitGen;
    private String letterGen;
    private String quantGen;
    private String regex;

    public RexModel(){
 rng=new Random();



    }
    public void setDigit(boolean digit){
    this.Digit=digit;
    }
    public void setLetter(boolean letter){
        this.Letter=letter;
    }
    public void setAnchor(boolean anchor){
        this.Anchor=anchor;
    }

    public String getRex(){
        return regex;
    }

    public boolean doesMatch(String s){

        // Create a Pattern object
        Pattern r = Pattern.compile(regex);

        // Now create matcher object.
        Matcher m = r.matcher(s);

        return  (m.find( ));
    }
    public void generate(int repeat)
    {
        regex = "";
        if (Anchor)
        {
            regex += "^";
        }
        for (int i = 0; i < repeat; i++)
        {
            if (Digit)
            {
                genDigit();
                regex+=digitGen;
            }
            if (Letter)
            {
                genLetter();
                regex+=letterGen;
            }

            if (Anchor)
            {
                regex += "$";
            }

        }
    }

    private void genDigit(){
       genQuantifier();
        if (rng.nextDouble() < 0.5) {
            digitGen="[0-9]"+quantGen;
        }
        else{
            digitGen="["+(99+rng.nextInt(1000))+"]"+quantGen;
        }
    }       // generates the digit piece

    private void genLetter(){
        if (rng.nextDouble() < 0.5) {
            letterGen="[az]"+quantGen;
        }
        else{
            letterGen="["+((char) (97 + rng.nextInt(25))) +(char) (97 + rng.nextInt(25)) +(char) (97 + rng.nextInt(25))  +"]"+quantGen;
        }

    }      // generates the letter piece


    private void genQuantifier(){
        double random=rng.nextDouble();
        if (random< 0.5)
        {  quantGen="{"+(rng.nextInt(SET_SIZE-1) +1)+"}";
        }
        else if(random< (0.5+0.16666667)){
            quantGen ="*";
        }
        else if(random< (0.5+0.16666667+1.6666667)){
            quantGen="+";
        }
        else {
            quantGen="?";
        }

    }  // generates a quantifier

}
