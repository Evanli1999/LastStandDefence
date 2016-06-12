
/**
 * This is a copy of ClassyMix by Allen Mitro
 * But the Fraction and Mixed Fraction Classes are included below this class, so you only need this file! Yay!
 * ICS4U1
 * 04/04/2016
 */
import java.util.Scanner;
public class ClassyMix_StandAlone
{
    static Scanner sc = new Scanner(System.in);

    public static void main (String [] args)
    {
        char users = '1';//user input
        MixedFraction first = new MixedFraction(),second = new MixedFraction(), result = new MixedFraction(); // default declare
        System.out.println("Enter one fraction (use /): ");
        first = first.read(sc.nextLine());//enter value for first
        System.out.println("Enter another fraction (use /): ");
        second = second.read(sc.nextLine());//enter value for second
        while(true) //go until x input
        {
            System.out.println('\u000c'+"Fraction A: "+first.toString()+"\nFraction B: "+second.toString()+"\n\nChoose your action:\na - edit Fraction A\nb - edit Fraction B\nc, d, e, f - add, subtract, multiply and divide respectively");
            System.out.println("G - compareTo\nH - is Equal (redundant?)\nP - Print decimal approximate\nR - reduce (but all other methods will reduce the output automatically)\nS - swap Fraction A and B\nX - quit");
            System.out.print("\nSooooooo, what will you do? ");
            //options, then user input
            users = sc.next().charAt(0);
            System.out.println();
            sc.nextLine();
            if(users=='a'||users=='A')//chooses this option
            {
                System.out.println("Enter a new value for Fraction A (use /): ");
                first = first.read(sc.nextLine());//enter value
            }
            else if(users=='b'||users=='B')//chooses this option
            {
                System.out.println("Enter a new Value for Fraction B (use /): ");
                second = second.read(sc.nextLine());//enter value
            }
            else if(users=='c'||users=='C')//chooses this option
            {
               
                result = first.fromFrac(first.toFrac().add(second.toFrac()));//add it and store in result

                System.out.println("The sum of the two fractions is "+result.toString()+".\nEnter a or b to overwrite a fraction with the result. ");                

                users = sc.next().charAt(0);//choose a or b or nothing

                if(users=='a'||users=='A')
                    first = result;//replace first
                else if(users=='b'||users=='B')
                    second = result;//replace second
            }
            else if(users=='d'||users=='D')//chooses this option
            {
                result = first.fromFrac(first.toFrac().sub(second.toFrac()));//subtract it and store in result

                System.out.println("The difference of the two fractions is "+result.toString()+".\nEnter a or b to overwrite a fraction with the result. ");                

                users = sc.next().charAt(0);

                if(users=='a'||users=='A')
                    first = result;//replace first
                else if(users=='b'||users=='B')
                    second = result;//replace second
            }
            else if(users=='e'||users=='E')//chooses this option
            {
                result = first.fromFrac(first.toFrac().mult(second.toFrac()));//multiply it and store in result

                System.out.println("The product of the two fractions is "+result.toString()+".\nEnter a or b to overwrite a fraction with the result. ");                

                users = sc.next().charAt(0);

                if(users=='a'||users=='A')
                    first = result;//replace first
                else if(users=='b'||users=='B')
                    second = result;//replace second
            }
            else if(users=='f'||users=='F')//chooses this option
            {
                result = first.fromFrac(first.toFrac().div(second.toFrac()));

                System.out.println("The quotient of the two fractions is "+result.toString()+".\nEnter a or b to overwrite a fraction with the result. ");                

                users = sc.next().charAt(0);

                if(users=='a'||users=='A')
                    first = result;//replace first
                else if(users=='b'||users=='B')
                    second = result;//replace second
            }
            else if(users=='g'||users=='G')//chooses this option
            {
                int checking = first.toFrac().compareTo(second.toFrac());//compared it and store result checking

                if(checking==-1)//returns less
                    System.out.println("Fraction A is less than Fraction B.");
                else if (checking==1)//returns more
                    System.out.println("Fraction A is greater than Fraction B.");
                else if (checking==0)//return equals
                    System.out.println("Fraction A is equal to Fraction B.");
                else //returns not real
                    System.out.println("I don't know how to compare undefined numbers.");

                System.out.println("Press Enter to Continue.");
                sc.nextLine();
            }
            else if(users=='h'||users=='H')//chooses this option
            {
                if(first.toFrac().equals(second.toFrac()))//if equals method returns true
                    System.out.println("The two fractions are the same.");
                else //otherwise false
                    System.out.println("The two fractions are different.");

                System.out.println("Press Enter to Continue.");
                sc.nextLine();
            }
            else if(users=='s'||users=='S')//chooses this option
            {
                MixedFraction tempor = first;//store temporarily to recall and swap
                first = second;//Scholar swas here
                second = tempor;
            }
            else if(users=='p'||users=='P')//chooses this option
            {
                System.out.println("Enter a or b to show the decimal value a fraction. ");                
                users = sc.next().charAt(0);//select a or b
                if(users=='a'||users=='A')//first
                    System.out.println("The approximate value of Fraction A is "+first.toDec());
                else if(users=='b'||users=='B')//second
                    System.out.println("The approximate value of Fraction B is "+second.toDec());
                System.out.println("Press Enter to Continue.");
                sc.nextLine();
                sc.nextLine();
            }
            else if(users=='r'||users=='R')//chooses this option
            {
                System.out.println("Enter a or b to reduce a fraction. ");                
                users = sc.next().charAt(0);//select a or b
                if(users=='a'||users=='A')//first
                    first = first.fromFrac(first.reduce(first.toFrac()));
                else if(users=='b'||users=='B')//second
                    second = second.fromFrac(second.reduce(second.toFrac()));
            }
            else if (users=='k')
            {
                System.out.println(first.toFrac().toString());
            }
            else if(users=='x'||users=='X')//chooses this option
                break;//exit and going out of loop
            else//if not any of the above...
                System.out.println("The input does not match any options.");
        }
        System.out.println("Bye!");
    }
}
/**
 * Here's the Mixed Fraction Class. Created by Allen Mitro, with bits taken from the assignment
 * Its parent class, Fraction is under this.
 * ICS4U1
 * April 4th, 2016
**/
class MixedFraction extends Fraction // Fraction class must be in same folder
{
    private int whole;  // numerator, denominator inherited from Fraction

    public MixedFraction () // default constructor
    {
        super(); // call default constructor from Fraction 
        whole = 0; // default mixed fraction is 0 0/1
    }

    public MixedFraction (int whole, int num, int den) // alternate constructor
    {
        super(num,den); // call constructor from Fraction (must do first)
        this.whole = whole;
    }

    public String toString ()
    {
        if(whole == 0||dnom == 0)//if there is no whole number, or if extra is insignificant
            return super.toString();
        if(num==0&&dnom!=0)// if there is no fraction, so whole number only
            return whole+"";
        if(dnom==1)//if the fraction is a whole number, I want to add it then try again.
            return fromFrac(reduce(toFrac())).toString();            
        return whole + " " + super.toString (); // super used to access method
        // from same name in parent class
    }                                // when overriding original

    public Fraction toFrac()
    {
        return new Fraction(whole*dnom+num,dnom);
    }

    public MixedFraction fromFrac(Fraction change)
    {
        if(change.dnom==0)
        {
            if(change.num==0)
                return new MixedFraction (0,0,0);
            return new MixedFraction (0,change.num,0);
        }
        return new MixedFraction(change.num/change.dnom,change.num%change.dnom,change.dnom);
    }

    public MixedFraction read(String input)
    {   reduce(this);
        boolean divider = false,neg=false;
        int newnum=0,newdnom=1,newwhole=0;
        String wholestring="";
        if (input.isEmpty())//if empty set as zero
            return new MixedFraction();
        for(int a = 0;a<input.length();a++)//go through each letter in the string
        {
            if(input.charAt(a)=='/')
                break;// stop because if it could be a fraction
            if(((int)input.charAt(a)<48||(int)input.charAt(a)>57))
            {//if is not numerical or - or / character
                if(input.charAt(a)=='-')
                {
                    neg=!neg;
                    input = input.substring(0,a)+input.substring(a+1);
                    a--;
                    continue;
                }
                wholestring = input.substring(0,a);
                input = input.substring(a+1);//remove character and continue
                break;
            }
        }

        for(int a = 0;a<wholestring.length();a++)//go through each letter in the string
        {
            if(((int)wholestring.charAt(a)<48||(int)wholestring.charAt(a)>57)&&wholestring.charAt(a)!='-')
            {//if is not numerical or - or / character                
                wholestring = wholestring.substring(0,a)+wholestring.substring(a+1);//remove character fromtring
                a--;//reduce length value of string to avoid skipping letters
            }
        }

        if(wholestring.isEmpty())
            newwhole=0;
        else if (neg)
            newwhole=-1*Integer.parseInt(wholestring);
        else
            newwhole=Integer.parseInt(wholestring);
        //the above was to find the whole number (the first numbers before a 
        for(int a = 0;a<input.length();a++)//go through each letter in the string
        {
            if(((int)input.charAt(a)<48||(int)input.charAt(a)>57)&&input.charAt(a)!='/'||(input.charAt(a)=='/'&&divider))
            {//if is not numerical or - or / character                
                if(input.charAt(a)=='-')
                    neg=!neg;
                input = input.substring(0,a)+input.substring(a+1);//remove character fromtring
                a--;//reduce length value of string to avoid skipping letters
            }
            if (input.isEmpty())//if empty set as zero
                return new MixedFraction(newwhole,0,1);
            if((a==-1&&input.charAt(0)=='/'))// I only want to allow it once for this char
                divider = true;
            else if (a!=-1&&input.charAt(a)=='/')
                divider = true;
        }
        if(input.isEmpty())
            return new MixedFraction(newwhole,0,1);
        if(!divider)//if no fraction sign
        {
            if(neg)
                return new MixedFraction(-1*(Math.abs(newwhole)+Integer.parseInt(input)),0,1);//set as whole number
            else
                return new MixedFraction(Math.abs(newwhole)+Integer.parseInt(input),0,1);//set as whole number
        }   
        for(int a = 0;a<input.length();a++)//go through each letter in the string
        {
            if(input.charAt(a)=='/')
            {
                String temp = input.substring(0,a);//get part before /
                newnum = temp.isEmpty()?1:Integer.parseInt(temp);//parseInt doesn't work on "", so set to 1 if N/A.
                temp = input.substring(a+1);//get part after /
                newdnom = temp.isEmpty()?1:Integer.parseInt(temp);//same thing
                break;
            }
        }

        return new MixedFraction(newwhole,newnum,newdnom);//return the read fraction.
    }
}

/**
The Fraction Class
Forked from Mr. Jay's Fraction Class 1.0
by Allen Mitro
March 29, 2016
ICS 4U1
*/
class Fraction
{
    protected int num, dnom; // gives access to subclass

    // default constructor is automatically defined, setting all fields to 0
    // unless you create your own, which you should generally do
    public Fraction ()
    {
        num = 0;
        dnom = 1; // makes more sense than 0/0
    }

    // copy constructor creates a distinct duplicate of an object by copying data;
    // can’t simply assign one object to another because two names will now point
    // to the same memory address meaning that when one is changed, the other 
    // one is too because they are the same object – usually not desirable
    public Fraction (Fraction F)
    {
        num = F.num;
        dnom = F.dnom;
    }

    // alternate constructor (there may be several to initialize object)
    public Fraction (int n, int d)
    {   num = n;
        dnom = d;
    }

    public String toString ()
    {
        if(dnom==0)// if the denominator is zero
        {
            if(num==0)
                return "Indeterminate";
            else if(num>0)
                return "+ infinity";
            else
                return "- infinity";
        }
        if(dnom==1)//if a whole number
            return num + "";
        if(num==0)//if zero, does not matter what denom is
            return "0";
        return num + "/" + dnom;//otherwise regular fraction
    }

    public double toDec ()
    {
        double dnum = num, ddnom = dnom;//convert ints to doubles
        return dnum/ddnom;// so that we can return a double
    }
    
    public Fraction reduce(Fraction toReduce)
    {
        if(toReduce.dnom==0)//can't reduce if denom is 0
            return new Fraction(toReduce.num,0);
        if(toReduce.num==0)// become 0/1 if numerator is 0
            return new Fraction();
            
        boolean neg = false;
        
        if(toReduce.dnom<0&&toReduce.num>=0||toReduce.dnom>=0&&toReduce.num<0)
            neg = true;// if signs are different then 
            
        toReduce.num = Math.abs(toReduce.num);//make both positive
        toReduce.dnom = Math.abs(toReduce.dnom);
        long temp = toReduce.num,temp2 = toReduce.dnom,temp3 = 0;//set these to find the lcm
        
        while(temp!=temp2)//keep going until it is the same (lcm)
            if(temp<temp2)//if the first is less switch the order
            {
                temp3 = temp2;
                temp2 = temp;
                temp = temp3;
            }
            else if(temp>temp2)//otherwise switch the order and subtract the second from first.
            {
                temp3 = temp;
                temp = temp2;
                temp2 =temp3-temp2;
            }
        
        toReduce.num/=temp;//then divide both by the lcm
        toReduce.dnom/=temp;
        
        if(neg)//add the sign at the end, so that there is no confusion (3/-2)?
            toReduce.num *= -1;
            
        return toReduce;
    }
    
    public Fraction add(Fraction toAdd)
    {
        int sumnum = toAdd.dnom*num + dnom*toAdd.num, sumdnom = toAdd.dnom*dnom;//use butterfly method
        return reduce(new Fraction(sumnum,sumdnom));//then reduce the fraction
    }

    public Fraction sub(Fraction toSub)
    {
        toSub.num *= -1;//reverse the sign
        int diffnum = toSub.dnom*num + dnom*toSub.num, diffdnom = toSub.dnom*dnom;//same idea as add
        toSub.num *= -1;//changing it back just in case
        return reduce(new Fraction(diffnum, diffdnom));//reduce then return
    }

    public Fraction mult(Fraction toMult)
    {
        return reduce(new Fraction(num*toMult.num, dnom*toMult.dnom));//just multiply tops and bottoms, and reduce
    }

    public Fraction div(Fraction toDiv)
    {
        return reduce(new Fraction(num*toDiv.dnom, dnom*toDiv.num));//just multiply after flipping, then reduce
    }

    public boolean isReal (Fraction check)
    {
        if(check.dnom == 0)//it can't be real if denom is zero
            return false;
            
        return true;//other wise it's real
    }

    public boolean equals(Fraction check)
    {
        check = check.reduce(check);//reduce first
        reduce(this);
        
        if (check.num==num&&check.dnom==dnom)//if they are the same return true
            return true;
            
        return false;//otherwise false
    }

    public int compareTo(Fraction check)
    {
        System.out.println(check.toString()+" "+toString());
        if(dnom == 0 | check.dnom == 0)
            return -2;
            
        check = reduce (check);
        reduce (this);
        
        if (equals(check))//if they are the same
            return 0;
        
            double frac2 = check.num/check.dnom,frac1=num/dnom;//compare decimal values
            
        if(frac2-frac1>0)//if they the second is larger
            return -1;
            
        return 1;//otherwise the first is larger
    }

    public Fraction read(String input)
    {   reduce(this);
        boolean divider = false, neg = false;
        int newnum=0,newdnom=1;
        
        if (input.isEmpty())//if empty set as zero
            return new Fraction();
        for(int a = 0;a<input.length();a++)//go through each letter in the string
        {
                if(((int)input.charAt(a)<48||(int)input.charAt(a)>57)&&input.charAt(a)!='/'||(input.charAt(a)=='/'&&divider))
                {//if is not numerical or - or / character
                    if(input.charAt(a)=='-')
                        neg = !neg;
                    input = input.substring(0,a)+input.substring(a+1);//remove character fromtring
                    a--;//reduce length value of string to avoid skipping letters
                }
            if (input.isEmpty())//if empty set as zero
                return new Fraction();
            if((a==-1&&input.charAt(0)=='/'))// I only want to allow it once for this char
                divider = true;
            else if (a!=-1&&input.charAt(a)=='/')
                divider = true;
        }
        if (neg)
            input = "-"+input;
        if(!divider)//if no fraction sign
            return new Fraction(Integer.parseInt(input),1);//set as whole number
        for(int a = 0;a<input.length();a++)//go through each letter in the string
        {
            if(input.charAt(a)=='/')
            {
                String temp = input.substring(0,a);//get part before /
                newnum = temp.isEmpty()?1:Integer.parseInt(temp);//parseInt doesn't work on "", so set to 1 if N/A.
                temp = input.substring(a+1);//get part after /
                newdnom = temp.isEmpty()?1:Integer.parseInt(temp);//same thing
                break;
            }
        }
        
        return new Fraction(newnum,newdnom);//return the read fraction.
    }

}