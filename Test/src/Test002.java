import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目二
 * @author IT
 *
 */
public class Test002 {
	public static String[] orginDict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go"};
	public static List<String> dict= new ArrayList<>(Arrays.asList(orginDict));
	
	public static void main(String[] args) {
        Test002 test002 = new Test002();
        System.out.print("Whether Input own dict,If input 'y',Please input your dict any word separated by commas,If you do not want input your own dict please input 'n'：");
		Scanner input = new Scanner(System.in);
        String type = input.next();
        if("y".equals(type)){
        	 System.out.println("Please input your dict any word separated by commas:");
        	 Scanner ownInput = new Scanner(System.in);
        	 String ownString = ownInput.next();
        	 String[] ownDic = ownString.split("\\,");
        	 List<String> newDict= new ArrayList<>(Arrays.asList(ownDic));
        	 test002.outoOupt(newDict);
        }else{
        	test002.outoOupt(dict);
        }
        
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
		Map<String, List<String>> map = new HashMap<>();
		// 如果包含 则直接返回s
		if (map.containsKey(targetStr)) 
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
					// 空的话则""结尾
					list.add(word + (tmp.equals("") ? "" : " ") + tmp);
			}
		}
		// 记录可以拆分的字符串，并且记录拆分的方法
		map.put(targetStr, list);
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
