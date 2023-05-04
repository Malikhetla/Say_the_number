// This program converts numbers into words
// Range is 0 - 999 999 999 999

import java.util.Scanner;

public class say_number{
	public static String digit (String num){ //array for numbers 0 - 9 in words 
		int n = Integer.parseInt(num);
		String[] dig = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		return dig[n];
	}
	
	public static String teens (String num){ //array for numbers 10 - 19 in words 
		int n = Integer.parseInt(num);
		String[] dig2 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		return dig2[n];
	}
	
	public static String tens (String num){ //array for numbers 20 - 90 in words ie 20, 30, 40 ...
		int n = Integer.parseInt(num);
		String[] t = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		return t[n-2]; // there is no zeroty or tenty so must shift two places

	}
	
	public static String removeDig (String num){ //strips the leading number so the rest of the digits can be processed
		String dig = "";
		for(int i = 1; i < num.length(); i++){
			dig += num.charAt(i);
		}
		return dig;
	}
	
	public static String twoDig (String num){ //handles double digit numbers 
		if(num.charAt(0) == '1'){
			char c = num.charAt(1);
			return teens(String.valueOf(c));
		}
		else{
			char c = num.charAt(0);
			return tens(String.valueOf(c));
		}
	}
	
	public static String hundreds (String num){ // handles three digit numbers 
		if(num.charAt(1) == '0' && num.charAt(2) == '0'){
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " hundred";
		}
		else{
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " hundred and"; // if the tens digit is zero "and" is added
		}
	}

    public static String thousands (String num){
		if(num.charAt(1) == '0' && num.charAt(2) == '0' && num.charAt(3) == '0'){   // handles four digit numbers 
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " thousand";
		}
	
        else{
            if(num.charAt(1) == '0'){
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " thousand and"; // if the hundreds digit is zero "and" is added
            }

            else{
                char c = num.charAt(0);
                return digit(String.valueOf(c)) + " thousand";
            }	
		}
	}
    
    public static String ten_thousands (String num){   // handles five digit numbers 
		if(num.charAt(1) == '0' && num.charAt(2) == '0'){ 
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " thousand";
		}


        else if(num.charAt(0) != '1' && num.charAt(1) == '0'){
            char c = num.charAt(0);
            
            return tens(String.valueOf(c)) + " thousand,";

        }


        else{
                char c = num.charAt(0);
                char d = num.charAt(1);
                return tens(String.valueOf(c)) + " " + digit(String.valueOf(d)) + " thousand,";
        }
    }
	
       

    public static String hundred_thousands (String num){   // handles six digit numbers 
		if(num.charAt(1) == '0' && num.charAt(2) == '0' && num.charAt(3) == '0'){ 
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " hundred thousand";
		}
	
        else{
           
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " hundred ";
        
		}
	}


    public static String millions (String num){   // handles seven digit numbers 
		 
        if(num.charAt(1) == '0' && num.charAt(2) == '0'){
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " million";
		}
		else{
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " million,";
		}
		
	}

    public static String ten_millions (String num){   // handles eight digit numbers 
		
        if(num.charAt(1) == '0' && num.charAt(2) == '0' && num.charAt(3) == '0' && num.charAt(4) == '0'){ //may need a loop to go through all the digits
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " million";
		}

        else if(num.charAt(0) != '1' && num.charAt(1) == '0'){
            char c = num.charAt(0);
            
            return tens(String.valueOf(c)) + " million,";
        }
        else{
                char c = num.charAt(0);
                char d = num.charAt(1);
                return tens(String.valueOf(c)) + " " + digit(String.valueOf(d)) + " million,";
        }
	}
    
    public static String hundred_million (String num){ //   // handles nine digit numbers 
		if(num.charAt(1) == '0' && num.charAt(2) == '0'){
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " hundred";
		}
        else if(num.charAt(1) == '1'){
            char c = num.charAt(0);
			return teens(String.valueOf(c)) + " hundred";
        }
		else{
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " hundred ";
		}
	}

    public static String billions (String num){   // handles ten digit numbers 
		if(num.charAt(1) == '0' && num.charAt(2) == '0'){
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " billion";
		}
		else{
			char c = num.charAt(0);
			return digit(String.valueOf(c)) + " billion,";
		}
	}

    public static String ten_billions (String num){   // handles eleven digit numbers 
        if(num.charAt(1) == '0' && num.charAt(2) == '0'){
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " billion";
        }
        else{
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " billion,";
        }
	}

     public static String hundred_billions (String num){   // handles twelve digit numbers 
        if(num.charAt(1) == '0' && num.charAt(2) == '0'){
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " billion";
        }
        else{
            char c = num.charAt(0);
            return digit(String.valueOf(c)) + " billion,";
        }
	}







	



	public static String say (String num){
		String ans = "";

        if(num.length() > 2) {
            switch (num.length()) {
                case 3:
                    if(num.charAt(0) == '0'){// removes leading zeros, but will leave the last zero
                                                            // so that "0" is a valid number
                         = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += hundreds(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 4:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += thousands(num);
                    String s = "";
                    for(int i = 1; i < num.length(); i++){
                        s += num.charAt(i);
                    }
                    num = num.replace(num, removeDig(s));
                    break;
                case 5:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += ten_thousands(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 6:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += hundred_thousands(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 7:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += millions(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 8:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += ten_millions(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 9:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += hundred_million(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 10:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += billions(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 11:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += ten_billions(num);
                    num = num.replace(num, removeDig(num));
                    break;
                case 12:
                    if(num.charAt(0) == '0'){
                        num = num.replace(num, removeDig(num));
                    }
                    if(ans.length() > 0){
                        ans += " ";
                    }
                    ans += hundred_billions(num);
                    num = num.replace(num, removeDig(num));
                    break;
                default:
                    break;

            }
        }
        //handles numbers 10 - 99
		if(num.length() == 2 && num.charAt(0) == '0'){
			num = num.replace(num, removeDig(num));
		}
		else if (num.length() == 2){
			if(ans.length() > 0){
				ans += " "; //add a space if the answer already contains words
			}
			if(num.charAt(0) != '0'){
				ans += twoDig(num);
			}
			if(num.charAt(0) == '1'){  //ten through nineteen have different rules to twenty through ninety
				String s = "";
				for(int i = 2; i < num.length(); i++){
					s += num.charAt(i);
				}
				num = num.replace(num, s);
			}
			else{
				num = num.replace(num, removeDig(num));
			}
		}
		
		if(num.length() == 1 && num.charAt(0) == '0'){
			if(ans == ""){
				ans = digit(num);
			}
		}
		else if(num.length() == 1){
			if(ans.length() > 0){
				ans += " ";
			}
			ans += digit(num);
			num = num.replace(num, removeDig(num));
		}

		
		return ans;
	}
	
	public static void main(String[] args){
		String number = args[0];
		String words = say(number);
		System.out.println(words);
	}
}