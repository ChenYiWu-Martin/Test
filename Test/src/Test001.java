import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目一
 * 
 * @author IT
 *
 */
public class Test001 {

	public static void main(String[] args) {
		String[] str = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go" };
		List<String> dict = new ArrayList<>(Arrays.asList(str));
		Test001 test001 = new Test001();
		test001.outoOupt(dict);
		/*
		 * String outPut = ""; for (String s : result) { outPut += s + " "; }
		 * System.out.println("OutPut:" + outPut);
		 */
	}

	/***
	 * 字符拆分,组成字典单词 动态规划
	 * 
	 * @param targetStr
	 *            目标字符串
	 * @param dict
	 *            字典
	 * @return
	 */
	public List<String> wordDecompose(String targetStr, List<String> dict) {
		/*
		 * int len = targetStr.length();
		 * //默认值均为false，主要是用于判断前i个字符是否可以组成一个单词，用true/false表示 boolean[]
		 * weatherWord = new boolean[len + 1]; //只有一个字母时，肯定为true weatherWord[0]
		 * = true; List<String> workList = new ArrayList<>(); int k = 0; for(int
		 * i = 1; i <= len; i++){ for(int j = 0; j < i; j++){ if(weatherWord[j]
		 * && dict.contains(targetStr.substring(j,i))){ weatherWord[i] = true;
		 * workList.add(targetStr.substring(j,i)); } } } return workList; }
		 */

		Map<String, List<String>> map = new HashMap<>();
		if (map.containsKey(targetStr)) // 如果包含 则直接返回s
			return map.get(targetStr);
		List<String> list = new ArrayList<>();
		if (targetStr.length() == 0) {
			list.add("");
			return list;
		}
		for (String word : dict) {
			if (targetStr.startsWith(word)) {
				// 判断s是否含有word的前缀
				List<String> tmpList = wordDecompose(targetStr.substring(word.length()), dict);
				for (String tmp : tmpList)
					list.add(word + (tmp.equals("") ? "" : " ") + tmp);// 空的话则""结尾
			}
		}
		map.put(targetStr, list);// 记录可以拆分的字符串，并且记录拆分的方法
		return list;
	}

	public void outoOupt(List<String> dict) {
		System.out.print("Input：");
		Scanner input = new Scanner(System.in);
		String targetStr = input.next();
		List<String> result = this.wordDecompose(targetStr, dict);
		System.out.println("OutPut:" + result);
	}

}
