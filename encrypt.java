// Question: Write an encrypt function given an input string, and shift value s
// Time Complexity : O(n), where n=length of string
// Space Complexity : O(1)
import java.io.*;

class CaesarCipher
{
    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int s)
    {
        //Your Code
        StringBuffer sb = new StringBuffer();
        if (text == null || text.length() == 0) return sb;

        for (int i=0; i<text.length(); i++) {
            char c = text.charAt(i);    //T
            int in = (int)c+s;
            if (in > ((int)'A'+25)) {
                in = in-26;
            }
            sb.append((char)in);
        }
        return sb;
    }

    // Driver code
    public static void main(String[] args)
    {
        String text = "ZTEJASWI";
        int s = 1;
        System.out.println("Text :" + text);
        System.out.println("Shift :"  + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }
}