package P1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Magicsquare {

	@SuppressWarnings("resource")
	public static boolean ism(String file) throws IOException {
		String way =new String(file);
		FileReader ff1=new FileReader(way);
		BufferedReader bb1=new BufferedReader(ff1);
		int rrow=0;
		while(bb1.readLine()!=null) {
			rrow++;
		}
		bb1.close();
		FileReader ff2=new FileReader(way);
		BufferedReader bb2=new BufferedReader(ff2);
		String lline;
		
//		并非矩阵
		lline=null;
		FileReader ff3=new FileReader(way);
		BufferedReader bb3 =new BufferedReader(ff3);
		String []ll;
		while((lline=bb3.readLine())!=null) {
			ll=lline.split("\t");
			if(ll.length!=rrow) {
				System.out.println("不是矩阵");
				bb3.close();
				return false;
			}
			
		}
		
//		格式非法
		lline=null;
		FileReader ff4=new FileReader(way);
		BufferedReader bb4 =new BufferedReader(ff4);
		ll=null;
		while((lline=bb4.readLine())!=null) {
			ll=lline.split("\t");
			for(int i=0;i<ll.length;i++) {
				if(ll[i].contains(".")||ll[i].contains("-")) {
					System.out.println("格式错误，含有非正整数");
					bb4.close();
					return false;
				}
					
			}
		}
//		存在非\t分隔
		int [][]aa=new int [rrow][rrow];
		lline=null;
		FileReader ff5=new FileReader(way);
		BufferedReader bb5=new BufferedReader(ff5);
		ll=null;
		int k=0;
		try {
		while((lline=bb5.readLine())!=null) {
			ll=lline.split("\t");
			
				for(int i=0;i<ll.length;i++) {
					if(Integer.valueOf(ll[i])==0) {
						System.out.println("含有0");
						bb5.close();
						return false;
					}
					aa[k][i]=Integer.valueOf(ll[i]);
					
				}
			
			
			k++;
		}
		bb5.close();
		}catch(Exception e) {
			System.out.println("未使用\\t分隔");
			bb5.close();
			return false;
		}
		int []rrsum=new int [rrow];
		int []ccsum=new int [rrow];
		int ssum1=0;int ssum2=0;
		for(int i=0;i<rrow;i++) {
			for(int j=0;j<rrow;j++) {
				rrsum[i]+=aa[i][j];
				ccsum[j]+=aa[i][j];
			}
		}
		for(int i=0;i<rrow;i++) {
			ssum1+=aa[i][i];
			ssum2+=aa[i][rrow-1-i];
		}
		if(ssum1!=ssum2) {
			System.out.println("行，列，对角线和不相等1");
			return false;
		}
		for(int i=0;i<rrow;i++) {
			if((ssum1!=rrsum[i])||(ssum1!=ccsum[i])) {
				
				System.out.println("行，列，对角线和不相等2");
				return false;
			}
		}
		return true;
	}
	static void generateMagicSquare(int n) throws IOException {
        if(n < 0) {//判断输入的n是否为负数
            System.out.println("False, please input a positive integer!");
            return;
        }
        else if(n % 2 == 0) {//判断输入的n是否为偶数
            System.out.println("False, please input an odd  number!");
            return;
        }
        else {
            int magic[][] = new int[n][n];//用于保存生成的幻方数据
            int row = 0, col = n / 2, i, j, square = n * n;//相当于将n×n个从1开始的连续自然数填入n×n个空格中去
            for (i = 1; i <= square; i++) {//基本原则是依次向右上方填写幻方数据
                magic[row][col] = i;//将1放在第0行中央
                if (i % n == 0)//若原本待填写的位置已经被填写，则变为新的一行
                    row++;
                else {
                    if (row == 0)//若行数为0，则更新行数为n-1
                        row = n - 1;
                    else//否则继续向上填
                        row--;
                    if (col == (n - 1))//若列数已满，则更新为0
                        col = 0;
                    else//否则，继续向右填
                        col++;
                }
            }
            String filename = "src/P1/txt/6.txt";
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    bw.write(magic[i][j] + "\t");//将产生的幻方数据写入到文件6.txt中，并注意格式＋\t
                }
                if(i < n-1) {//记得输出换行
                bw.write("\n");
                }
            }
            bw.close();
        }
    }
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		
	String file1=new String("src/P1/txt/1.txt");
	System.out.println(ism(file1));
	String file2=new String("src/P1/txt/2.txt");
	System.out.println(ism(file2));
	String file3=new String("src/P1/txt/3.txt");
	System.out.println(ism(file3));
	String file4=new String("src/P1/txt/4.txt");
	System.out.println(ism(file4));
	String file5=new String("src/P1/txt/5.txt");
	System.out.println(ism(file5));
	System.out.println("请输入一个正奇数:");
	Scanner input =new Scanner(System.in);
	int n=input.nextInt();
	input.close();
	generateMagicSquare(n);
	if((n%2==1)&&n>0) {
	String file6=new String("src/P1/txt/6.txt");
	System.out.println(ism(file6));
	}
	}

}
