package Ib;

import java.util.*;

public class IBRunnable {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(ladderLength("a", "c", Arrays.asList("a","b","c")));
    }

/*    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    }*/

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(wordList.isEmpty())return 0;

		if(beginWord.equals(endWord)){
			return 1;
		}

		Queue<String> q = new LinkedList<>();

		Set<String> set = new HashSet<>(wordList);

		if(!set.contains(endWord)){
			return 0;
		}

		int result =1;

		q.add(beginWord);
		q.add(null);


		while(!q.isEmpty()){

			String str = q.poll();

			if(str!=null){
				char[] array = str.toCharArray();

				for(int i=0;i<str.length();i++){

					char temp = array[i];

					for(char ch='a';ch<='z';ch++){

						if(ch==temp)continue;

						array[i]=ch;

						String s = String.valueOf(array);

						if(s.equals(endWord))return result+1;

						if(set.contains(s)){
							q.add(s);
							set.remove(s);
						}

					}
					array[i]=temp;
				}
			}
			else{

				result++;

				if(!q.isEmpty()) {
				   q.add(null);
				}


			}



		}

		return 0;
	}





}
