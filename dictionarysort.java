import java.util.ArrayList;
import java.util.Scanner;

public class dictionarysort {

	public static void main(String args[]) {
		int[] arr = { 1,2,1,3,1 };
		int[] denom = new int[arr.length];
		int[] numr = new int[arr.length];
		int count = 0;
		int highval = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			while ((temp) > 0) {
				temp = temp / 10;
				count++;
			}
			if (count > highval) {
				highval = count;
			}
			count=0;
		}
		for (int i = 0; i < arr.length; i++) {
			String temp1 = Integer.toString(arr[i]);
			int pow = highval - temp1.length();
			int factor=1;
			while(pow>0){
				factor=factor*10;
				pow--;
			}
			int dnumval = arr[i] * factor;
			denom[i] = dnumval;
			numr[i] = dnumval/arr[i];
		}
		boolean[] isSame=new boolean[denom.length];
		ArrayList<Integer> retval=new ArrayList<>();
		for (int i = 0; i < denom.length; i++) {
			for (int j = i+1; j < denom.length; j++) {
				if(denom[i]==denom[j] && isSame[j]==false && isSame[i]==false){
					isSame[j]=true;
					isSame[i]=true;
					retval.add(denom[i]/numr[i]);
					retval.add(denom[j]/numr[j]);
				}
				else if(denom[i]==denom[j] && isSame[j]!=true){
					isSame[j]=true;
					retval.add(denom[j]/numr[j]);
				}
				else if(j==(denom.length-1)&& isSame[i]==false){
					retval.add(denom[i]/numr[i]);
				}

			}
		}
		for (int i = 0; i < retval.size(); i++) {
			System.out.print(retval.get(i)+",");
		}
	}
}
