import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ��Ŀ��
 * 
 * @author IT
 *
 */
public class Test003 {
	public static String[] orginDict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go" };
	public static List<String> dict = new ArrayList<>(Arrays.asList(orginDict));

	public static void main(String[] args) {
		Test003 test003 = new Test003();
        System.out.print("Whether Input own dict,If input 'y',Please input your dict any word separated by commas,If you do not want input your own dict please input 'n'��");
		Scanner input = new Scanner(System.in);
        String type = input.next();
        if("y".equals(type)){
        	 System.out.println("Please input your dict any word separated by commas:");
        	 Scanner ownInput = new Scanner(System.in);
        	 String ownString = ownInput.nextLine();
        	 String[] ownDic = ownString.split("\\,");
        	 List<String> newDict= new ArrayList<>(Arrays.asList(ownDic));
        	 /**�Ƚ�2���ֵ�ϲ���һ�������ظ���*/
        	 dict.parallelStream().collect(Collectors.toList());
        	 newDict.parallelStream().collect(Collectors.toList());
        	 dict.addAll(newDict);
        	 List<String> listAllDict = dict.stream().distinct().collect(Collectors.toList());
        	 test003.outoOupt(listAllDict);
        }else{
        	test003.outoOupt(dict);
        }
		

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
	public List<String> wordDecompose(String targetStr, List<String> dictList) {
		Map<String, List<String>> map = new HashMap<>();
		// ������� ��ֱ�ӷ���s
		if (map.containsKey(targetStr))
			return map.get(targetStr);
		List<String> list = new ArrayList<>();
		if (targetStr.length() == 0) {
			list.add("");
			return list;
		}
		for (String word : dictList) {
			if (targetStr.startsWith(word)) {
				// �ж�targetStr�Ƿ���word��ǰ׺
				List<String> tmpList = wordDecompose(targetStr.substring(word.length()), dictList);
				for (String tmp : tmpList)
					// �յĻ���""��β
					list.add(word + (tmp.equals("") ? "" : " ") + tmp);
			}
		}
		// ��¼���Բ�ֵ��ַ��������Ҽ�¼��ֵķ���
		map.put(targetStr, list);
		return list;
	}

	public void outoOupt(List<String> dict) {
		System.out.println("Input��");
		Scanner input = new Scanner(System.in);
		String targetStr = input.next();
		List<String> result = this.wordDecompose(targetStr, dict);
		System.out.println("OutPut:" + result);
	}
}
