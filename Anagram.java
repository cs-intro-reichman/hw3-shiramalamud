/** Functions for checking if a given string is an anagram. */
public class Anagram 
{
	public static void main(String args[])
	 {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}



		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) 
	{
		int count=0;
		str1=preProcess(str1);
		str2=preProcess(str2);
		
        String str1n="";
        String str2n="";
        for(int i=0;i<str1.length();i++)
        {
            if((str1.charAt(i)>='a'&& str1.charAt(i)<='z'))
            {
                str1n=str1n+str1.charAt(i);
            }
        }
        for(int i=0;i<str2.length();i++)
        {
            if((str2.charAt(i)>='a'&& str2.charAt(i)<='z'))
            {
                str2n=str2n+str2.charAt(i);
            }
        }
        if(str1n.length()!=str2n.length())
        {
            return false;
        }
        else
        {
            int i=0;
            while(str2n.length()>0 && i<str2.length())
        {
            if(str2n.indexOf(str1n.charAt(i))==-1)
            {
                return false;
            }
            else{
                str2= str2.substring(0,i)+str2n.substring(i+1);
            }
            i++;
        }
    }
        return true;
}

	//returns the number of the char in strןng
	public static int countChar(String str, char ch)
	 {
        int count = 0;
        for (int i = 0; i < str.length(); i++) 
		{
            if (str.charAt(i) == ch)
			 {
                count++;
             }
        }
        return count;
    }

	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str)
	 {
		String str2="";
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
            if ((ch == ' ') || ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) 
			{
				str2+=str.charAt(i);
			}
		}
		String str2new="";
		for(int j=0; j<str2.length(); j++)
		{
			char ch=str2.charAt(j);
			if(ch>='A'&&ch<='Z')
			{
				str2new+=(char)(ch+32);
			}
			else
			{
				str2new+= ch;
			}

		}
		return str2new;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
		String newstr="";
		String temp=str;
		int length=str.length();
		while(length>0)
		{
			int random=(int)(Math.random()*length);
			if(length>0)
			{
				newstr+=temp.charAt(random);
			    temp = removeChar(temp, random);
				length = temp.length();
			}
			if(length==0)
			{
				break;
			}
		}
		return newstr;
	}


	public static String removeChar(String str, int n) {
		String newstring = "";
		for (int i = 0; i < str.length(); i++) {
			if (i != n) 
			{ 
				newstring += str.charAt(i); 
			}
		}
		return newstring;
	}
}
