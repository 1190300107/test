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
		
//		���Ǿ���
		lline=null;
		FileReader ff3=new FileReader(way);
		BufferedReader bb3 =new BufferedReader(ff3);
		String []ll;
		while((lline=bb3.readLine())!=null) {
			ll=lline.split("\t");
			if(ll.length!=rrow) {
				System.out.println("���Ǿ���");
				bb3.close();
				return false;
			}
			
		}
		
//		��ʽ�Ƿ�
		lline=null;
		FileReader ff4=new FileReader(way);
		BufferedReader bb4 =new BufferedReader(ff4);
		ll=null;
		while((lline=bb4.readLine())!=null) {
			ll=lline.split("\t");
			for(int i=0;i<ll.length;i++) {
				if(ll[i].contains(".")||ll[i].contains("-")) {
					System.out.println("��ʽ���󣬺��з�������");
					bb4.close();
					return false;
				}
					
			}
		}
//		���ڷ�\t�ָ�
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
						System.out.println("����0");
						bb5.close();
						return false;
					}
					aa[k][i]=Integer.valueOf(ll[i]);
					
				}
			
			
			k++;
		}
		bb5.close();
		}catch(Exception e) {
			System.out.println("δʹ��\\t�ָ�");
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
			System.out.println("�У��У��Խ��ߺͲ����1");
			return false;
		}
		for(int i=0;i<rrow;i++) {
			if((ssum1!=rrsum[i])||(ssum1!=ccsum[i])) {
				
				System.out.println("�У��У��Խ��ߺͲ����2");
				return false;
			}
		}
		return true;
	}
	static void generateMagicSquare(int n) throws IOException {
        if(n < 0) {//�ж������n�Ƿ�Ϊ����
            System.out.println("False, please input a positive integer!");
            return;
        }
        else if(n % 2 == 0) {//�ж������n�Ƿ�Ϊż��
            System.out.println("False, please input an odd  number!");
            return;
        }
        else {
            int magic[][] = new int[n][n];//���ڱ������ɵĻ÷�����
            int row = 0, col = n / 2, i, j, square = n * n;//�൱�ڽ�n��n����1��ʼ��������Ȼ������n��n���ո���ȥ
            for (i = 1; i <= square; i++) {//����ԭ�������������Ϸ���д�÷�����
                magic[row][col] = i;//��1���ڵ�0������
                if (i % n == 0)//��ԭ������д��λ���Ѿ�����д�����Ϊ�µ�һ��
                    row++;
                else {
                    if (row == 0)//������Ϊ0�����������Ϊn-1
                        row = n - 1;
                    else//�������������
                        row--;
                    if (col == (n - 1))//�����������������Ϊ0
                        col = 0;
                    else//���򣬼���������
                        col++;
                }
            }
            String filename = "src/P1/txt/6.txt";
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    bw.write(magic[i][j] + "\t");//�������Ļ÷�����д�뵽�ļ�6.txt�У���ע���ʽ��\t
                }
                if(i < n-1) {//�ǵ��������
                bw.write("\n");
                }
            }
            bw.close();
        }
    }
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		
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
	System.out.println("������һ��������:");
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
