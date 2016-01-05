import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class T9 {

	//Gets a character and returns what key should be pressed
	public static char charToNumber(char ch){
			if (ch=='1'){return '1';}			
			if ((ch>='a'&&ch<='c')||(ch=='2')){return '2';}
			if ((ch>='d'&&ch<='f')||(ch=='3')){return '3';}
			if ((ch>='g'&&ch<='i')||(ch=='4')){return '4';}
			if ((ch>='j'&&ch<='l')||(ch=='5')){return '5';}
			if ((ch>='m'&&ch<='o')||(ch=='6')){return '6';}
			if ((ch>='p'&&ch<='s')||(ch=='7')){return '7';}
			if ((ch>='t'&&ch<='v')||(ch=='8')){return '8';}
			if ((ch>='w'&&ch<='z')||(ch=='9')){return '9';}
			if ((ch=='0')){return '0';}
		return '-';
	}
	
	public static String wordToNumber(String str){
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<str.length();i++){
			sb.append(charToNumber(str.charAt(i)));
		}
		return sb.toString();
	}
	public static HashMap<String,LinkedList<String>> convertWordsToNumbers(String[] dict){
		HashMap<String,LinkedList<String>> map = new HashMap<String,LinkedList<String>>();
		for (int i=0;i<dict.length;i++){
			String number = wordToNumber(dict[i]);
			if (map.containsKey(number)){
				LinkedList<String> list =map.get(number);
				list.add(dict[i]);
			}else{
				LinkedList<String> list = new LinkedList<String>();
				list.add(dict[i]);
				map.put(number, list);
			}
		}
		
		return map;
	}
	
	public static void findWordsCreatedUsingNumber(String number,HashMap<String,LinkedList<String>> map){
		if (map.containsKey(number)){
			LinkedList<String> list =map.get(number);
			System.out.print(number+" ");
			printList(list);
		}else{
			System.out.println("No words can be created using number "+number);
		}
	}
	
	public static void printList(LinkedList<String> list){
		if (list==null){return;}
		for (String word:list){
			System.out.print(word+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String[] dict = createDict();
		HashMap<String,LinkedList<String>> map = convertWordsToNumbers(dict);
		findWordsCreatedUsingNumber("8733",map);
	}
	
	
	public static String[] createDict(){
		// The name of the file to open.
        String fileName = "C:\\Users\\751909\\workspace\\T9\\src\\words.txt";
        ArrayList<String> dict = fileReader(fileName);
        return dict.toArray(new String[dict.size()]);
	}
	public static ArrayList<String> fileReader(String fileName){
		ArrayList<String> dict = new ArrayList<String>();
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	dict.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return dict;
	}

}
