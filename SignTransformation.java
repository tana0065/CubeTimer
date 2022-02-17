package com.newtana.rubikscube;

public class SignTransformation {
    public short num[] = {
            0,0,0,0,0,0,0,0,0,//0~8
            1,1,1,1,1,1,1,1,1,//9~17
            2,2,2,2,2,2,2,2,2,//18~26
            3,3,3,3,3,3,3,3,3,//27~35
            4,4,4,4,4,4,4,4,4,//36~44
            5,5,5,5,5,5,5,5,5//45~53
    };

    SignTransformation(String str){
        String[] data = str.split(" ");

        for(String s : data) {
            //ここから配列を利用して入れ替える
            if(s.equals("R")) { //回転記号がRのとき
                short a = num[0];short b = num[3];short c = num[6];
                num[0] = num[36]; num[3] = num[39]; num[6] = num[42];
                num[36] = num[26]; num[39] = num[23]; num[42] = num[20];
                num[26] = num[53]; num[23] = num[50]; num[20] = num[47];
                num[53] = a; num[50] = b; num[47] = c;

                short aa = num[27]; short bb = num[30];
                num[27] = num[33]; num[33] = num[35]; num[35] = num[29]; num[29] = aa;//コーナー入れ替え
                num[30] = num[34]; num[34] = num[32]; num[32] = num[28]; num[28] = bb;//エッジ入れ替え

            }else if(s.equals("R2")) {//回転記号がR2のとき
                short a = num[0];short b = num[3];short c = num[6];
                short d = num[36];short e = num[39];short f = num[42];
                num[0] = num[26]; num[3] = num[23]; num[6] = num[20];
                num[26] = a; num[23] = b; num[20] = c;
                num[36] = num[53]; num[39] = num[50]; num[42] = num[47];
                num[53] = d; num[50] = e; num[47] = f;

                short aa = num[27]; short bb = num[30]; short cc = num[33] ;short dd = num[34];
                num[27] = num[35]; num[35] = aa; num[33] = num[29]; num[29] = cc;//コーナー入れ替え
                num[30] = num[32]; num[32] = bb; num[34] = num[28]; num[28] = dd;//エッジ入れ替え

            }else if(s.equals("R'")) {//回転記号がR'のとき
                short a = num[0];short b = num[3];short c = num[6];
                num[0] = num[53]; num[3] = num[50]; num[6] = num[47];
                num[53] = num[26]; num[50] = num[23]; num[47] = num[20];
                num[26] = num[36]; num[23] = num[39]; num[20] = num[42];
                num[36] = a; num[39] = b; num[42] = c;

                short aa = num[27]; short bb = num[30];
                num[27] = num[29]; num[29] = num[35]; num[35] = num[33]; num[33] = aa;//コーナー入れ替え
                num[30] = num[28]; num[28] = num[32]; num[32] = num[34]; num[34] = bb;//エッジ入れ替え

            }else if(s.equals("L")) {//回転記号がLのとき
                short a = num[2];short b = num[5];short c = num[8];
                num[2] = num[51]; num[5] = num[48]; num[8] = num[45];
                num[51] = num[24]; num[48] = num[21]; num[45] = num[18];
                num[24] = num[38]; num[21] = num[41]; num[18] = num[44];
                num[38] = a; num[41] = b; num[44] = c;

                short aa = num[9]; short bb = num[12];
                num[9] = num[15]; num[15] = num[17]; num[17] = num[11]; num[11] = aa;//コーナー入れ替え
                num[12] = num[16]; num[16] = num[14]; num[14] = num[10]; num[10] = bb;//エッジ入れ替え

            }else if(s.equals("L2")) {//回転記号がL2のとき
                short a = num[2];short b = num[5];short c = num[8];
                short d = num[38];short e = num[41];short f = num[44];
                num[2] = num[24]; num[5] = num[21]; num[8] = num[18];
                num[24] = a; num[21] = b; num[18] = c;
                num[38] = num[51]; num[41] = num[48]; num[44] = num[45];
                num[51] = d; num[48] = e; num[45] = f;

                short aa = num[9]; short bb = num[12]; short cc = num[15] ;short dd = num[16];
                num[9] = num[17]; num[17] = aa; num[15] = num[11]; num[11] = cc;//コーナー入れ替え
                num[12] = num[14]; num[14] = bb; num[16] = num[10]; num[10] = dd;//エッジ入れ替え

            }else if(s.equals("L'")) {//回転記号がL'のとき
                short a = num[2];short b = num[5];short c = num[8];
                num[2] = num[38]; num[5] = num[41]; num[8] = num[44];
                num[38] = num[24]; num[41] = num[21]; num[44] = num[18];
                num[24] = num[51]; num[21] = num[48]; num[18] = num[45];
                num[51] = a; num[48] = b; num[45] = c;

                short aa = num[9]; short bb = num[12];
                num[9] = num[11]; num[11] = num[17]; num[17] = num[15]; num[15] = aa;//コーナー入れ替え
                num[12] = num[10]; num[10] = num[14]; num[14] = num[16]; num[16] = bb;//エッジ入れ替え

           }else if(s.equals("U")) {//回転記号がUのとき
                short a = num[42];short b = num[43];short c = num[44];
                num[42] = num[35]; num[43] = num[32]; num[44] = num[29];
                num[35] = num[51]; num[32] = num[52]; num[29] = num[53];
                num[51] = num[9]; num[52] = num[12]; num[53] = num[15];
                num[9] = a; num[12] = b; num[15] = c;

                short aa = num[0]; short bb = num[3];
                num[0] = num[6]; num[6] = num[8]; num[8] = num[2]; num[2] = aa;//コーナー入れ替え
                num[3] = num[7]; num[7] = num[5]; num[5] = num[1]; num[1] = bb;//エッジ入れ替え

           }else if(s.equals("U2")) {//回転記号がU2のとき
                short a = num[42];short b = num[43];short c = num[44];
                short d = num[9];short e = num[12];short f = num[15];
                num[42] = num[51]; num[43] = num[52]; num[44] = num[53];
                num[51] = a; num[52] = b; num[53] = c;
                num[9] = num[35]; num[12] = num[32]; num[15] = num[29];
                num[35] = d; num[32] = e; num[29] = f;

                short aa = num[0]; short bb = num[3]; short cc = num[6] ;short dd = num[7];
                num[0] = num[8]; num[8] = aa; num[6] = num[2]; num[2] = cc;//コーナー入れ替え
                num[3] = num[5]; num[5] = bb; num[7] = num[1]; num[1] = dd;//エッジ入れ替え

           }else if(s.equals("U'")) {//回転記号がU'のとき
                short a = num[42];short b = num[43];short c = num[44];
                num[42] = num[9]; num[43] = num[12]; num[44] = num[15];
                num[9] = num[51]; num[12] = num[52]; num[15] = num[53];
                num[51] = num[35]; num[52] = num[32]; num[53] = num[29];
                num[35] = a; num[32] = b; num[29] = c;

                short aa = num[0]; short bb = num[3];
                num[0] = num[2]; num[2] = num[8]; num[8] = num[6]; num[6] = aa;//コーナー入れ替え
                num[3] = num[1]; num[1] = num[5]; num[5] = num[7]; num[7] = bb;//エッジ入れ替え

           }else if(s.equals("D")) {//回転記号がDのとき
                short a = num[36];short b = num[37];short c = num[38];
                num[36] = num[11]; num[37] = num[14]; num[38] = num[17];
                num[11] = num[45]; num[14] = num[46]; num[17] = num[47];
                num[45] = num[33]; num[46] = num[30]; num[47] = num[27];
                num[33] = a; num[30] = b; num[27] = c;

                short aa = num[18]; short bb = num[21];
                num[18] = num[24]; num[24] = num[26]; num[26] = num[20]; num[20] = aa;//コーナー入れ替え
                num[21] = num[25]; num[25] = num[23]; num[23] = num[19]; num[19] = bb;//エッジ入れ替え

           }else if(s.equals("D2")) {//回転記号がD2のとき
                short a = num[36];short b = num[37];short c = num[38];
                short d = num[11];short e = num[14];short f = num[17];
                num[36] = num[45]; num[37] = num[46]; num[38] = num[47];
                num[45] = a; num[46] = b; num[47] = c;
                num[11] = num[33]; num[14] = num[30]; num[17] = num[27];
                num[33] = d; num[30] = e; num[27] = f;

                short aa = num[18]; short bb = num[21]; short cc = num[24] ;short dd = num[25];
                num[18] = num[26]; num[26] = aa; num[24] = num[20]; num[20] = cc;//コーナー入れ替え
                num[21] = num[23]; num[23] = bb; num[25] = num[19]; num[19] = dd;//エッジ入れ替え

           }else if(s.equals("D'")) {//回転記号がD'のとき
                short a = num[36];short b = num[37];short c = num[38];
                num[36] = num[33]; num[37] = num[30]; num[38] = num[27];
                num[33] = num[45]; num[30] = num[46]; num[27] = num[47];
                num[45] = num[11]; num[46] = num[14]; num[47] = num[17];
                num[11] = a; num[14] = b; num[17] = c;

                short aa = num[18]; short bb = num[21];
                num[18] = num[20]; num[20] = num[26]; num[26] = num[24]; num[24] = aa;//コーナー入れ替え
                num[21] = num[19]; num[19] = num[23]; num[23] = num[25]; num[25] = bb;//エッジ入れ替え

           }else if(s.equals("F")) {//回転記号がFのとき
                short a = num[0];short b = num[1];short c = num[2];
                num[0] = num[9]; num[1] = num[10]; num[2] = num[11];
                num[9] = num[18]; num[10] = num[19]; num[11] = num[20];
                num[18] = num[27]; num[19] = num[28]; num[20] = num[29];
                num[27] = a; num[28] = b; num[29] = c;

                short aa = num[36]; short bb = num[39];
                num[36] = num[42]; num[42] = num[44]; num[44] = num[38]; num[38] = aa;//コーナー入れ替え
                num[39] = num[43]; num[43] = num[41]; num[41] = num[37]; num[37] = bb;//エッジ入れ替え

           }else if(s.equals("F2")) {//回転記号がF2のとき
                short a = num[0];short b = num[1];short c = num[2];
                short d = num[9];short e = num[10];short f = num[11];
                num[0] = num[18]; num[1] = num[19]; num[2] = num[20];
                num[18] = a; num[19] = b; num[20] = c;
                num[9] = num[27]; num[10] = num[28]; num[11] = num[29];
                num[27] = d; num[28] = e; num[29] = f;

                short aa = num[36]; short bb = num[39]; short cc = num[42] ;short dd = num[43];
                num[36] = num[44]; num[44] = aa; num[42] = num[38]; num[38] = cc;//コーナー入れ替え
                num[39] = num[41]; num[41] = bb; num[43] = num[37]; num[37] = dd;//エッジ入れ替え

           }else if(s.equals("F'")) {//回転記号がF'のとき
                short a = num[0];short b = num[1];short c = num[2];
                num[0] = num[27]; num[1] = num[28]; num[2] = num[29];
                num[27] = num[18]; num[28] = num[19]; num[29] = num[20];
                num[18] = num[9]; num[19] = num[10]; num[20] = num[11];
                num[9] = a; num[10] = b; num[11] = c;

                short aa = num[36]; short bb = num[39];
                num[36] = num[38]; num[38] = num[44]; num[44] = num[42]; num[42] = aa;//コーナー入れ替え
                num[39] = num[37]; num[37] = num[41]; num[41] = num[43]; num[43] = bb;//エッジ入れ替え

           }else if(s.equals("B")) {//回転記号がBのとき
                short a = num[6];short b = num[7];short c = num[8];
                num[6] = num[33]; num[7] = num[34]; num[8] = num[35];
                num[33] = num[24]; num[34] = num[25]; num[35] = num[26];
                num[24] = num[15]; num[25] = num[16]; num[26] = num[17];
                num[15] = a; num[16] = b; num[17] = c;

                short aa = num[45]; short bb = num[48];
                num[45] = num[51]; num[51] = num[53]; num[53] = num[47]; num[47] = aa;//コーナー入れ替え
                num[48] = num[52]; num[52] = num[50]; num[50] = num[46]; num[46] = bb;//エッジ入れ替え

           }else if(s.equals("B2")) {//回転記号がB2のとき
                short a = num[6];short b = num[7];short c = num[8];
                short d = num[15];short e = num[16];short f = num[17];
                num[6] = num[24]; num[7] = num[25]; num[8] = num[26];
                num[24] = a; num[25] = b; num[26] = c;
                num[15] = num[33]; num[16] = num[34]; num[17] = num[35];
                num[33] = d; num[34] = e; num[35] = f;

                short aa = num[45]; short bb = num[48]; short cc = num[51] ;short dd = num[52];
                num[45] = num[53]; num[53] = aa; num[51] = num[47]; num[47] = cc;//コーナー入れ替え
                num[48] = num[50]; num[50] = bb; num[52] = num[46]; num[46] = dd;//エッジ入れ替え

           }else if(s.equals("B'")) {//回転記号がB'のとき
                short a = num[6];short b = num[7];short c = num[8];
                num[6] = num[15]; num[7] = num[16]; num[8] = num[17];
                num[15] = num[24]; num[16] = num[25]; num[17] = num[26];
                num[24] = num[33]; num[25] = num[34]; num[26] = num[35];
                num[33] = a; num[34] = b; num[35] = c;

                short aa = num[45]; short bb = num[48];
                num[45] = num[47]; num[47] = num[53]; num[53] = num[51]; num[51] = aa;//コーナー入れ替え
                num[48] = num[46]; num[46] = num[50]; num[50] = num[52]; num[52] = bb;//エッジ入れ替え

            }

        }
    }


}
