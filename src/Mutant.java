public class Mutant {

    /* Completa matriz con DNA */
    static void completeMatriz (char[][] arr, String[] dna ){
        int lenghMatriz = dna.length;
        for (int i = 0; i < lenghMatriz; i++) {
            arr[i] = dna[i].toCharArray();
        }
    }

    /* Cuenta secuencia Horizontal*/
    static int countSecuenceHoriz (char[][] arr, int lenghMatriz){
        int countSecuenceHoriz=0;
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                if (lenghMatriz-j>=4) {
                    if (arr[i][j] == arr[i][j+ 1] &&
                            arr[i][j] == arr[i][j + 2] &&
                            arr[i][j] == arr[i][j + 3]
                    ) {
                        countSecuenceHoriz++;
                        j = j + 3;
                    }
                }
            }
        }
        System.out.println("Secuencias Horiz: "+  countSecuenceHoriz);
        return countSecuenceHoriz;
    }

    /* Cuenta secuencia Horizontal*/
    static int countSecuenceVert (char[][] arr, int lenghMatriz){
        int countSecuenceVert=0;
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                if (lenghMatriz-i>=4) {
                    if (arr[i][j] == arr[i+1][j] &&
                            arr[i][j] == arr[i+2][j] &&
                            arr[i][j] == arr[i+3][j]
                    ) {
                        countSecuenceVert++;
                        j = j + 3;
                    }
                }
            }
        }
        System.out.println("Secuencias Vertical: "+  countSecuenceVert);
        return countSecuenceVert;
    }

    /* Cuenta secuencia Diag IZQ => DER*/
    static int countSecuenceDiagIzqDer (char[][] arr, int lenghMatriz){
        int i;
        int j;
        int countSecuenceDiagIzqDer=0;

        /* Cuenta secuencia en diagonal superior de matriz*/
        for (int indJ = 0; indJ < lenghMatriz; indJ++) {
            i=0;
            j=indJ;
            if (lenghMatriz-indJ>=4) {
                while (j < lenghMatriz) {
                    if (lenghMatriz-j>=4) {
                        if (arr[i][j] == arr[i+1][j+1] &&
                                arr[i][j] == arr[i+2][j+2] &&
                                arr[i][j] == arr[i+3][j+3]
                        ) {
                            countSecuenceDiagIzqDer++;
                            i = i + 3;
                            j=i;
                        }
                    }
                    i++;
                    j++;
                }
            }
        }

        /* Cuenta secuencia en diagonal inferior de matriz*/
        for (int indI = 1; indI < lenghMatriz; indI++) {
            j=0;
            i=indI;
            if (lenghMatriz-indI>=4) {
                while (i < lenghMatriz ) {
                    if (lenghMatriz-i>=4) {
                        if (arr[i][j] == arr[i+1][j+1] &&
                                arr[i][j] == arr[i+2][j+2] &&
                                arr[i][j] == arr[i+3][j+3]
                        ) {
                            countSecuenceDiagIzqDer++;
                            i = i + 3;
                            j=i;
                        }
                    }
                    i++;
                    j++;
                }
            }
        }
        System.out.println("Secuen Izq der 2: " + countSecuenceDiagIzqDer);
        return countSecuenceDiagIzqDer;
    }

    /* Cuenta secuencia Diag DER => IZQ*/
    static int countSecuenceDiagDerIzq (char[][] arr, int lenghMatriz){
        int i;
        int j;
        int countSecuenceDiagDerIzq=0;

        /* Cuenta secuencia en diagonal superior de matriz*/
        for (int indJ = lenghMatriz-1; indJ >= 0; indJ--) {
            i=0;
            j=indJ;
            System.out.println("Largo: " + (lenghMatriz-indJ));
            if (lenghMatriz-indJ<=3) {
                //while (i > lenghMatriz && j < lenghMatriz) {
                while (j >= 0) {
                    /*
                    if (lenghMatriz-j>=4) {
                        if (arr[i][j] == arr[i+1][j+1] &&
                                arr[i][j] == arr[i+2][j+2] &&
                                arr[i][j] == arr[i+3][j+3]
                        ) {
                            countSecuenceDiagDerIzq++;
                            i = i + 3;
                            j=i;
                        }
                    }
                    */
                    System.out.println("Val: " + arr[i][j] + " - ["+ i +","+j+"]");
                    i++;
                    j--;
                }
                System.out.println("");
            }
        }

        /* Cuenta secuencia en diagonal inferior de matriz*/
        /*
        for (int indI = 1; indI < lenghMatriz; indI++) {
            j=0;
            i=indI;
            if (lenghMatriz-indI>=4) {
                while (i < lenghMatriz && j < lenghMatriz) {
                    if (lenghMatriz-i>=4) {
                        if (arr[i][j] == arr[i+1][j+1] &&
                                arr[i][j] == arr[i+2][j+2] &&
                                arr[i][j] == arr[i+3][j+3]
                        ) {
                            countSecuenceDiagDerIzq++;
                            i = i + 3;
                            j=i;
                        }
                    }
                    //System.out.println("Val: " + arr[i][j]);
                    i++;
                    j++;
                }
            }
            // System.out.println("");
        }*/
        System.out.println("Secuen DER => IZQ 2: " + countSecuenceDiagDerIzq);
        //return countSecuenceDiagDerIzq;
        return 0;
    }

    static boolean isMutant(String[] dna){

        int lenghMatriz = dna.length;
        char arr [][] = new char[lenghMatriz][lenghMatriz];
        completeMatriz(arr,dna);

        /* Imprime matriz  */
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }

        /* Valida secuencia horizontal  */
        int totalSecuenceHoriz=0;
        totalSecuenceHoriz = countSecuenceHoriz(arr, lenghMatriz);
        if (totalSecuenceHoriz>1){
            //return true;
        }

        /* Valida secuencia vertical  */
        int totSecuenceVert=0;
        totSecuenceVert = countSecuenceVert(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert)>1){
            //return true;
        }

        /* Valida secuencia diagonal IZQ => DER */
        int totalSecuenceDiagIzqDer=0;
        totalSecuenceDiagIzqDer = countSecuenceDiagIzqDer(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer)>1){
            //return true;
        }

        /* Valida secuencia diagonal DER = IZQ */
        int totalSecuenceDiagDerIzq=0;
        //totalSecuenceDiagIzqDer = countSecuenceDiagDerIzq(arr, lenghMatriz);


        return false;
    }

    public static void main(String[] args) {
        //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        //String[] dna = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCCTG","TCACTG"};
        //String[] dna = {"ATGAAA","AGGGGC","ATATGG","AGAAGG","CCCCTG","TCACTG"};
        String[] dna = {"ATGAAA","AGGGGC","CTATGG","ACAAGG","CCCCTG","TCACTG"};

        System.out.println ( isMutant(dna) );

    }

}