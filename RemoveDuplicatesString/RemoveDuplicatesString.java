import java.util.Iterator;
import java.util.Vector;

/**
 * Given a string, recursively remove adjacent duplicate characters from string. The output string should not have any adjacent duplicates
 * @author sabman
 *
 */
public class RemoveDuplicatesString {

    
    private static boolean removeAdjacents(Vector<Character> vector, int index)
    {
        char val = vector.elementAt(index);
        boolean result = false;
        while( ( index < vector.size()-1 ) && (vector.elementAt(index+1) == val) )
        {
            vector.remove(index+1);
            if( !result )
                result = true;
        }
        
        if(result)
         vector.remove(index);
        return result;
    }
    
    private static Vector<Character> initVector(String input)
    {
        char[] inputArray = input.toCharArray();
        Vector<Character> output = new Vector<Character>(input.length());
        
        for( int i = 0; i < inputArray.length; i++)
        {
            output.add( inputArray[i] );
        }
        
        return output;
    }
    
    private static String removeDuplicates(String input)
    {
        Vector<Character> output = initVector(input);
        
        int currIndex = 0;
        while( currIndex >= 0 && currIndex < output.size()-1)
        {
            currIndex = (removeAdjacents( output, currIndex)) ? 
                    ( (currIndex<=0) ? currIndex: currIndex-1) :  currIndex+1;
        }
        
        return vectorToString( output );
    }
    
    private static String vectorToString (Vector<Character> vector)
    {
        String result = "";
        
        Iterator<Character> iter = vector.iterator();
        while( iter.hasNext() )
        {
            result += iter.next();
        }
        return result;
    }
    
    public static void main(String args[])
    {
        System.out.println( "azxxzy" + " --> " + removeDuplicates( "azxxzy") ); // ay
        
        System.out.println( "geeksforgeeg" + " --> " + removeDuplicates( "geeksforgeeg") ); // gksfor
        
        System.out.println( "caaabbbaacdddd" + " --> " + removeDuplicates( "caaabbbaacdddd") ); // Empty String
        
        System.out.println( "acaaabbbacdddd" + " --> " + removeDuplicates( "acaaabbbacdddd") ); // acac
    }
}
