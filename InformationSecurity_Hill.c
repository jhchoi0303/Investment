#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <math.h>
#include <string.h>



int main() {



    float f[26] = { 0.082, 0.015, 0.028, 0.043, 0.127, 0.022, 0.020, 0.061, 0.070, 0.002, 0.008, 0.004, 0.024, 0.067, 0.015, 0.019, 0.001, 0.060, 0.063, 0.091, 0.028, 0.010, 0.024, 0.002, 0.020, 0.001 };
    char ciphertext[1300] = "HRDKHUBHAAMAEQMTMZSHGBAKFUBHAASYRXUNKYUAATQCTLUTOGEWVAJGVEIIYTKIOTQRXXQVSQLISVVOCNGCUXPKPIUBOHTVKCFKWNJSEZYSSUTUOESIXKAPVFXNZHAOQTLCGYJVAEHLNNKEESQMKSHKKDFCNZSRHRDKHSDKFXVPTGMKRUPZBIKEVNYEKXMFXKFYMWYUDZDENEWNKDAOUXGPCXZDLCSNFGCMCSNUAOJDBLQTAHEWYZCHQJYKSNUWOKQKONZGOKDXGUXKEMWQMCFGUEAVKHDIIATCHVTGYMGKJMLNPCNAYKMIRWEETIYQKELEGLQOVKISFNUDAJQIQYBXQTMZSHGBAKFZRCNWRSODAFKKXWGAZGDBIUDDHCUDFRFOVSZXADSHYSGLTQBMNEMKDCFSOZSRDYLIHIAXCMGMFEIDNZKOVJEOIEFNWWQEDRLZYZIZXADSHYSGLJYFWDUAKSIOGOZOXWYPBUFEPNBIRJUJNDZJJYMURKNCIKPWLRMRIAGVSXTYNIWPROHLDHQOMBEKZURQCLQOVKISFNUAFQBHGPCLHZTPJVPXIZKLQSNVKIJAEITTNVSVWNFYVATDEMKDCTGIHKZTVGZYXTYQEDBACFMNCAHRDKHSDKFXZXXGMJOSLPSZBMOILMMWRALAFFMNXXDYFBIYQVVOHSWKGBIRJGTBYQLKIJAEQBTAXGFGAVUIJADHQKLFWRJXYFVIGGQZNBHSUIYOZALSKIABLWQNXNXKOAJAIKHXODXWORVDOGBMHOPLQJZALQJZALIKTKLENZHQAVYUEUFEVLUXHGOWNMGWXUIAHGQOMNCKFQLIPBNKVWDLNGMJCOBFKIGBYWPAHMMPQLUTOGECXITZVVAJEOIDCNWMFNLOBGQXCYFWQFWVXWRKWYGBFHJVLBAWBOUQEKHZHSZZIZARYITDCLQFPGBTJMQVSQLIHPEJONCYMZWTVJVZOBOMOHPSXMPUKVAGXIPOQUQUQBCKXZJSZAHEWYHAEMKOJCCCFBEUKVNCAWANSNXISVVOWHQGQFBGWKQEGBIFRGIZUJQWIMFANTGBHWGVAGXIPOQUQTTRMWDHDGRFENKYPZVCLNQAUBTZSRYGVGOWSVROENABMZTOHZRQFUEVPLLIODEYRYLUTOGPYAFHJFIVOSFMPBSHLEKWYWJYTFYETAZQCRFTFHOMACOQVTWKLKYMGIMQDSYNWMFNIEITWMBVVWANBQFVUSKZOTLCCWABAGHWZBZHRDKHDTUOMUUUGQICHNUUQFJYUCQUO";
    int cipher[1300];


    for (int i = 0; i < 1285; i++) {
        cipher[i] = (int)(ciphertext[i] - 65);
    }



    int m = 257;
    int d = 5;

    int C[260][5];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < d; j++) {
            C[i][j] = cipher[i * 5 + j];
        }
    }


    int dit[260][5];
    for (int i = 0; i < m; i++) {
        int sum = 0;
        for (int j = 0; j < d; j++) {
            sum += C[i][j];
            sum %= 26;
            dit[i][j] = sum;
        }
    }










    int inverseK[5][5] = { 1, };
    float I[5] = { -9999,-9999,-9999,-9999,-9999 };
    int p[260] = { 0, };

    float iml = -log2f(f[0]);

    printf("Loading....\n");
    for (int x4 = 0; x4 < 26; x4++) {
        printf("Loading...%f\n", (float)x4/26);
;        for (int x3 = 0; x3 < 26; x3++) {
            for (int x2 = 0; x2 < 26; x2++) {
                for (int x1 = 0; x1 < 26; x1++) {
                    for (int x0 = 0; x0 < 26; x0++) {
                        int xmembers[5] = { x0, x1, x2, x3, x4 };

                        int t = 0;
                        for (t = 0; t < 5; t++) {
                            if (xmembers[t] != 0)
                                break;
                        }

                        if (t != 5) {
                            for (int i = 0; i < m; i++) {
                                iml -= log2f(f[p[i]]) / m;
                                p[i] = (p[i] + dit[i][t]) % 26;
                                iml += log2f(f[p[i]]) / m;
                            }
                        }


                        if ((x0 % 2 != 0 && x0 % 13 != 0) || (x1 % 2 != 0 && x1 % 13 != 0) || (x2 % 2 != 0 && x2 % 13 != 0) || (x3 % 2 != 0 && x3 % 13 != 0) || (x4 % 2 != 0 && x4 % 13 != 0))
                        {
                            int minindex = 0;
                            for (int i = 1; i < d; i++)
                                if (I[i] < I[minindex])
                                    minindex = i;

                            if (I[minindex] < iml) {
                                I[minindex] = iml;
                                for (int j = 0; j < 5; j++)
                                    inverseK[j][minindex] = xmembers[j];
                            }
                        }
                    }
                }
            }
        }
    }



    printf("====Inverse K=====\n");

    for (int i = 0; i < d; i++) {
        for (int j = 0; j < d; j++) {
            printf("%d ", inverseK[i][j]);
        }
        printf("\n");
    }






    
    int P[260][10] = { 0, };

    for (int p = 0; p < m; p++) {
        for (int q = 0; q < d; q++) {
            int ksum = 0;
            for (int r = 0; r < d; r++) {
                ksum = ksum + (C[p][r] * inverseK[r][q]);
            }
            P[p][q] = ksum % 26;
        }
    }


    printf("====The Plaintext(without correct permutation)=====\n");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < d; j++)
            printf("%c", (char)(P[i][j] + 65));
        printf("\n");
    }

    printf("====The final Plaintext=====\n");
    for (int i = 0; i < m; i++) {
            printf("%c", (char)(P[i][4] + 65));
            printf("%c", (char)(P[i][3] + 65));
            printf("%c", (char)(P[i][0] + 65));
            printf("%c", (char)(P[i][1] + 65));
            printf("%c", (char)(P[i][2] + 65));
            printf("\n");
    }
}
