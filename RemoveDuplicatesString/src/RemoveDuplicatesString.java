import java.util.Iterator;
import java.util.Vector;

/**
 * Given a string, recursively remove adjacent duplicate characters from string. The output string should not have any adjacent duplicates
 * @author sabman
 *
 */
public class RemoveDuplicatesString {

    /**
     * Checks the character in the Character Vector at the given index
     * and if duplicates are present next to it, removes the character and its duplicates  
     * @param vector Character Vector to test
     * @param index index of the character to test and remove
     * @return true if any character was removed else false
     */
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
    
    /**
     * Initializes a Character Vector containing the elements from a given string
     * @param input The given string 
     * @return Character Vector
     */
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
    
    /**
     * Process the string for adjacent duplicates and removes it from the string
     * @param input The string to process
     * @return A string with duplicates removed
     */
    private static String processString(String input)
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
    
    /**
     * A string representation of the characters in the vector
     * @param vector A vector of Characters
     * @return A string with the characters in the vector concatenated
     */
    private static String vectorToString (Vector<Character> vector)
    {
        StringBuffer result = new StringBuffer();
        
        Iterator<Character> iter = vector.iterator();
        while( iter.hasNext() )
        {
            result.append(iter.next());
        }
        return result.toString();
    }
    
    public static void main(String args[])
    {
        System.out.println( "azxxzy" + " --> " + processString( "azxxzy") ); // ay
        
        System.out.println( "geeksforgeeg" + " --> " + processString( "geeksforgeeg") ); // gksfor
        
        System.out.println( "caaabbbaacdddd" + " --> " + processString( "caaabbbaacdddd") ); // Empty String
        
        System.out.println( "acaaabbbacdddd" + " --> " + processString( "acaaabbbacdddd") ); // acac
    }
}
