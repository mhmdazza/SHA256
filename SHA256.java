// SHA-256 Code compilation by Muhammad Azza Ulin Nuha

package sha256;

import java.io.PrintStream;
import java.security.*;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thinkpad
 */
public class SHA256 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "abc";
        System.out.printf("Input : ");
        System.out.println(input);   
        byte[] inputhash = input.getBytes();
        //final byte[] password2 = this.password.getText().toString().getBytes();
        MessageDigest sha256 = null;
        try {
            sha256 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        sha256.update(inputhash);
        byte[] hasil = sha256.digest();
        StringBuffer hexhasil = new StringBuffer();
        for (int i=0; i<hasil.length; i++)
            hexhasil.append(Integer.toString((hasil[i]&0xff)+0x100,16).substring(1));
        String out = hexhasil.toString();
        System.out.println("Output : "+out);
        String out_2 = out.substring(0,15);
        System.out.println(out_2);
        out_2 = "azza";
        String out5 = xorString(out,out_2);   
    }
    
    static String xorString(String output, String output_2)
    {
        int panjang1 = output.length();
        int panjang2 = output_2.length();
        if (panjang1>panjang2){
            for(int j=0; j<(panjang1-panjang2);j++){
                output_2 = output_2+'0';
            }
            System.out.println("output : " + output_2);
        }
        char[] char_output = output.toCharArray();
        char[] char_output_2 = output_2.toCharArray();
        
        String output4 = "";
        for(int i=0; i<panjang1; i++){
            int b = Character.getNumericValue(char_output[i]);
//            System.out.print(b);
            int b_2 = Character.getNumericValue(char_output_2[i]);
            System.out.print(b_2);
            int b_hasil = b^b_2;
            String output3 = String.valueOf(b_hasil);
            if(output3.equals("10")){
                output3 = "a";
            }else if(output3.equals("11")){
                output3 = "b";
            }else if(output3.equals("12")){
                output3 = "c";
            }else if(output3.equals("13")){
                output3 = "d";
            }else if(output3.equals("14")){
                output3 = "e";
            }else if(output3.equals("15")){
                output3 = "f";
            }
            output4 += output3;
        }
        System.out.println();
        System.out.println("output4 :"+output4);
        return output4;
    }   
    
    static String strToBinary(String s) 
    { 
        int n = s.length(); 
        String output = "";
        for (int i = 0; i < n; i++)  
        { 
            // convert each char to 
            // ASCII value 
            int val = Integer.valueOf(s.charAt(i)); 
  
            // Convert ASCII value to binary 
            String bin = ""; 
            while (val > 0)  
            { 
                if (val % 2 == 1) 
                { 
                    bin += '1'; 
                } 
                else
                    bin += '0'; 
                val /= 2; 
            } 
            bin = reverse(bin);
            output += bin;
            System.out.print(bin); 
        } 
        return output;
    } 
  
    static String reverse(String input)  
    { 
        char[] a = input.toCharArray(); 
        int l, r = 0; 
        r = a.length - 1; 
  
        for (l = 0; l < r; l++, r--) 
        { 
            // Swap values of l and r  
            char temp = a[l]; 
            a[l] = a[r]; 
            a[r] = temp; 
        } 
        return String.valueOf(a); 
    }
    
        static void decToHexa(int n) 
    {    
        // char array to store hexadecimal number 
        char[] hexaDeciNum = new char[100]; 
       
        // counter for hexadecimal number array 
        int i = 0; 
        while(n!=0) 
        {    
            // temporary variable to store remainder 
            int temp  = 0; 
           
            // storing remainder in temp variable. 
            temp = n % 16; 
           
            // check if temp < 10 
            if(temp < 10) 
            { 
                hexaDeciNum[i] = (char)(temp + 48); 
                i++; 
            } 
            else
            { 
                hexaDeciNum[i] = (char)(temp + 55); 
                i++; 
            } 
           
            n = n/16; 
        } 
       
        // printing hexadecimal number array in reverse order 
        for(int j=i-1; j>=0; j--) 
            System.out.print(hexaDeciNum[j]); 
    }
    } 
    
    