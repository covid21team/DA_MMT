/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

/**
 *
 * @author xyzsys
 */
public class Ceasar {
    public static char SoSangKiTu (int n){
          char t=' ';
          if(n == 0)
                      t = 'A';
          else if(n == 1)
                      t = 'Ă';
          else if(n == 2)
                t = 'Â';
          else if(n == 3)
                t = 'B';
          else if(n == 4)
                t = 'C';
          else if(n == 5)
                t = 'D';
          else if(n == 6)
                t = 'Đ';
          else if(n == 7)
                t = 'E';
          else if(n == 8)
                t = 'Ê';
          else if(n == 9)
                t = 'G';
          else if(n == 10)
                t = 'H';
          else if(n == 11)
                t = 'I';
          else if(n == 12)
                t = 'K';
          else if(n == 13)
                t = 'L';
          else if(n == 14)
                t = 'M';
          else if(n == 15)
                t = 'N';
          else if(n == 16)
                t = 'O';
          else if(n == 17)
                t = 'Ơ';
          else if(n == 18)
                t = 'Ô';
          else if(n == 19)
                t = 'P';
          else if(n == 20)
                t = 'Q';
          else if(n == 21)
                t = 'R';
          else if(n == 22)
                t = 'S';
          else if(n == 23)
                t = 'T';
          else if(n == 24)
                t = 'U';
          else if(n == 25)
                t = 'Ư';
          else if(n == 26)
                t = 'V';
          else if(n == 27)
                t = 'X';
          else if(n == 28)
                t = 'Y';
          else if(t==29)
                t=' ';
          return t;
    }

    public static int KiTuSangSo (char c){
          int t=0;
          if(c == 'A')
                      t = 0;
          else if(c == 'Ă')
                      t = 1;
          else if(c == 'Â')
                t = 2;
          else if(c == 'B')
                t = 3;
          else if(c == 'C')
                t = 4;
          else if(c == 'D')
                t = 5;
          else if(c == 'Đ')
                t = 6;
          else if(c == 'E')
                t = 7;
          else if(c == 'Ê')
                t = 8;
          else if(c == 'G')
                t = 9;
          else if(c == 'H')
                t = 10;
          else if(c == 'I')
                t = 11;
          else if(c == 'K')
                t = 12;
          else if(c == 'L')
                t = 13;
          else if(c == 'M')
                t = 14;
          else if(c == 'N')
                t = 15;
          else if(c == 'O')
                t = 16;
          else if(c == 'Ơ')
                t = 17;
          else if(c == 'Ô')
                t = 18;
          else if(c == 'P')
                t = 19;
          else if(c == 'Q')
                t = 20;
          else if(c == 'R')
               t = 21;
          else if(c == 'S')
                t = 22;
          else if(c == 'T')
                t = 23;
          else if(c == 'U')
                t = 24;
          else if(c == 'Ư')
                t = 25;
          else if(c == 'V')
                t = 26;
          else if(c == 'X')
                t = 27;
          else if(c == 'Y')
                t = 28;
          else if(c == ' ')
                t = 29;
          return t;

    }

    public static int[] ChuoiThanhMangSo(String str){
        int[] t = new int[str.length()];
        for(int i = 0;i<str.length();i++){
              t[i] = KiTuSangSo(str.charAt(i));
        }
        return t;
    }

    public static String MangSoThanhChuoi(int[]t){
        String str ="";
        for(int i = 0;i<t.length;i++){
              str += SoSangKiTu(t[i]);
        }
        return str;
    }

    public static String MaHoa(int key, String text){
        text = text.toUpperCase();
        
        int[]t = ChuoiThanhMangSo(text);
        //InMangSo(t);    //Mảng số của chuỗi P
        int[] t1 = new int[t.length];
        for(int i = 0;i<t.length;i++)
              t1[i] = (t[i] + key) % 30;
        //InMangSo(t1);   //Ma số của chuỗi C
        String result = MangSoThanhChuoi(t1);
        return result;
    }

    public static String GiaiMa(int key, String text){
        text = text.toUpperCase();
        
        int[] t = ChuoiThanhMangSo(text);
        //InMangSo(t);    //Mảng số của chuỗi C
        int[] t1 = new int[t.length];
        for(int i = 0;i<t.length;i++){
              t1[i] =(t[i]- key) % 30;
              if(t1[i]<0)
                    t1[i] =(t[i] + (30-key) % 30);
        }
        //InMangSo(t1);   //Mảng số của chuỗi Ps
        String  kq = MangSoThanhChuoi(t1);
        return kq;
    }
}
