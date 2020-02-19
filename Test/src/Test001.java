import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * ��Ŀһ
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
	 * �ַ����,����ֵ䵥�� ��̬�滮
	 * 
	 * @param targetStr
	 *            Ŀ���ַ���
	 * @param dict
	 *            �ֵ�
	 * @return
	 */
	public List<String> wordDecompose(String targetStr, List<String> dict) {
		/*
		 * int len = targetStr.length();
		 * //Ĭ��ֵ��Ϊfalse����Ҫ�������ж�ǰi���ַ��Ƿ�������һ�����ʣ���true/false��ʾ boolean[]
		 * weatherWord = new boolean[len + 1]; //ֻ��һ����ĸʱ���϶�Ϊtrue weatherWord[0]
		 * = true; List<String> workList = new ArrayList<>(); int k = 0; for(int
		 * i = 1; i <= len; i++){ for(int j = 0; j < i; j++){ if(weatherWord[j]
		 * && dict.contains(targetStr.substring(j,i))){ weatherWord[i] = true;
		 * workList.add(targetStr.substring(j,i)); } } } return workList; }
		 */

		Map<String, List<String>> map = new HashMap<>();
		if (map.containsKey(targetStr)) // ������� ��ֱ�ӷ���s
			return map.get(targetStr);
		List<String> list = new ArrayList<>();
		if (targetStr.length() == 0) {
			list.add("");
			return list;
		}
		for (String word : dict) {
			if (targetStr.startsWith(word)) {
				// �ж�s�Ƿ���word��ǰ׺
				List<String> tmpList = wordDecompose(targetStr.substring(word.length()), dict);
				for (String tmp : tmpList)
					list.add(word + (tmp.equals("") ? "" : " ") + tmp);// �յĻ���""��β
			}
		}
		map.put(targetStr, list);// ��¼���Բ�ֵ��ַ��������Ҽ�¼��ֵķ���
		return list;
	}

	public void outoOupt(List<String> dict) {
		System.out.print("Input��");
		Scanner input = new Scanner(System.in);
		String targetStr = input.next();
		List<String> result = this.wordDecompose(targetStr, dict);
		System.out.println("OutPut:" + result);
	}

}
