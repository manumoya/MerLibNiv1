import java.util.Scanner;

public class Mutant {

    /* Completa matriz con DNA */
    static boolean completeMatriz (char[][] arr, String[] dna ){
        int lenghMatriz = dna.length;
        for (int i = 0; i < lenghMatriz; i++) {
            char [] dnaSimple = dna[i].toCharArray();
            if (dnaSimple.length!=lenghMatriz || lenghMatriz<4){
                System.out.println("Error en matriz DNA!!!! => Debe ser  NxN (N >= 4)");
                return false;
            }
            if (!valideLetter(dnaSimple)){
                System.out.println("Error en  DNA!!!! => Letras no corresponden (deben ser A, T, C o G)");
                return false;
            }
            arr[i] = dnaSimple;
        }
        return true;
    }

    /* Valida que las letras sean las correctas*/
    static boolean valideLetter(char [] dnaSimple){
        int largo = dnaSimple.length;
        for (int i = 0; i < largo; i++) {
            //System.out.println(dnaSimple[i]);
            if (dnaSimple[i]!='A' && dnaSimple[i]!='T' && dnaSimple[i]!='C' && dnaSimple[i]!='G'){
                return false;
            }
            //System.out.println("");
        }
        return true;
    }

    /*
    static void validaMatriz (char[][] arr, int largoMatriz){
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                arr[i] = dna[i].toCharArray();
            }
        }
    }
    */


    /* Print matriz con DNA */
    static void printMatriz (char[][] arr, int largoMatriz){
        //int lenghMatriz = dna.length;
        for (int i = 0; i < largoMatriz; i++) {
            for (int j = 0; j < largoMatriz; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
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
                        /* Acelera la busqueda de la solución*/
                        if (countSecuenceHoriz>1){
                            //System.out.println("Secuencias Horiz Acel: "+  countSecuenceHoriz);
                            return (countSecuenceHoriz);
                        }
                    }
                }
            }
        }
        //System.out.println("Secuencias Horiz: "+  countSecuenceHoriz);
        return countSecuenceHoriz;
    }

    /* Cuenta secuencia de forma Vertical*/
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
                        /* Acelera la busqueda de la solución*/
                        if (countSecuenceVert>1){
                            //System.out.println("Secuencias Vertical Acel: "+  countSecuenceVert);
                            return (countSecuenceVert);
                        }
                    }
                }
            }
        }
        //System.out.println("Secuencias Vertical: "+  countSecuenceVert);
        return countSecuenceVert;
    }

    /* Busca secuancia diagonal de IZQ a DER*/
    static int searchDiagIzqDer(char[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j<=lenghMatriz-1){
            if (indLimit == "J"){
                limit=lenghMatriz-j;
            }else{
                limit=lenghMatriz-i;
            }
            if (limit>=4) {
                //System.out.println("Val=  " + arr[i][j] + " [" + i + "][" + j + "] = " + (limit));
                if (arr[i][j] == arr[i+1][j+1] &&
                        arr[i][j] == arr[i+2][j+2] &&
                        arr[i][j] == arr[i+3][j+3]
                ) {
                    contSecuencia++;
                }
            }
            i++;
            j++;
        }
        //System.out.println("total Sec 2= "+ contSecuencia);
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Izquierda a Derecha */
    static int countSecuenceDiagIzqDer (char[][] arr, int lenghMatriz){
        int i=0;
        int j=0;
        int countSecuence=0;
        for (int indI = lenghMatriz-1; indI >= 0; indI--) {
            //i=indI;
            if (indI==0){
                for (int indJ = 0; indJ < lenghMatriz; indJ++) { // busca desde [0,n]
                    i=indI;
                    j=indJ;
                    int cont = searchDiagIzqDer(arr, lenghMatriz, i, j, "J");
                    //System.out.println("Busca 1 desde ["+i+"]["+j+"] = " + cont );
                    countSecuence = countSecuence + cont;

                }
            }else{ // busca desde [n,0]
                i=indI;
                int cont = searchDiagIzqDer(arr, lenghMatriz, i, j, "I");
                //System.out.println("Busca 2 desde ["+i+"]["+j+"] = "+ cont);
                countSecuence = countSecuence + cont;
            }
            // Acelera busqueda de solución
            if (countSecuence>1){
                //System.out.println("Cont Sec IZQ a DER 2 Acel = "+ countSecuence);
                return countSecuence;
            }
        }
        //System.out.println("Cont Sec IZQ a DER 2= "+ countSecuence);
        return countSecuence;
    }

    /* Busca secuencia diagonal de DER a IZq*/
    static int searchDiagDerIzq(char[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j>=0){
            if (indLimit == "J"){
                limit=j;
            }else{
                limit=lenghMatriz-i-1;
            }
            //System.out.println("Val=  " + arr[i][j] + " [" + i + "][" + j + "] = " + limit );
            if (limit>=3) {
                if (arr[i][j] == arr[i+1][j-1] &&
                        arr[i][j] == arr[i+2][j-2] &&
                        arr[i][j] == arr[i+3][j-3]
                ) {
                    contSecuencia++;
                }
            }
            i++;
            j--;
        }
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Derecha a Izquierda */
    static int countSecuenceDiagDerIzq (char[][] arr, int lenghMatriz){
        int i=0;
        int j=0;
        int countSecuence=0;
        for (int indJ = 0; indJ <= lenghMatriz-1; indJ++) {
            //i=indI;
            if (indJ==lenghMatriz-1){
                for (int indI = 0; indI <= lenghMatriz-1 ; indI++) { // busca desde [n,n]
                    i=indI;
                    j=indJ;
                    int cont = searchDiagDerIzq(arr, lenghMatriz, i, j, "I");
                    //System.out.println("Busca 1 desde ["+i+"]["+j+"] = " + cont );
                    countSecuence = countSecuence + cont;
                }
            }else{ // busca desde [0,n]
                j=indJ;
                int cont = searchDiagDerIzq(arr, lenghMatriz, i, j, "J");
                //System.out.println("Busca 2 desde ["+i+"]["+j+"] = " + cont);
                countSecuence = countSecuence + cont;
            }

            // Acelera busqueda de solución
            if (countSecuence>1){
                // System.out.println("Cont Sec DER a IZQ 2 Acel = "+ countSecuence);
                return countSecuence;
            }

        }
        //System.out.println("Cont Sec DER a IZQ 2= "+ countSecuence);
        return countSecuence;
    }

    /* Evalua si es mutante o no */
    static boolean isMutant(String[] dna){
        int lenghMatriz = dna.length;
        char[][] arr = new char[lenghMatriz][lenghMatriz];
        if (!completeMatriz(arr,dna)){
            return false;
        }

        /* Imprime matriz  */
        printMatriz(arr, lenghMatriz);

        /* ***************************************************
        * EVALUA RESULTADOS PARA DETERMINAR SI ES MUTANTE O NO
        * *****************************************************/

        /* Evalúa secuencia horizontal  */
        int totalSecuenceHoriz=0;
        totalSecuenceHoriz = countSecuenceHoriz(arr, lenghMatriz);
        if (totalSecuenceHoriz>1){
            return true;
        }

        /* Evalúa secuencia vertical + horizontal  */
        int totSecuenceVert=0;
        totSecuenceVert = countSecuenceVert(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert)>1){
            return true;
        }

        /* Evalúa secuencia horizontal + vertical + diagonal IZQ => DER */
        int totalSecuenceDiagIzqDer=0;
        totalSecuenceDiagIzqDer = countSecuenceDiagIzqDer(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer)>1){
            return true;
        }

        /* Evalúa secuencia horizontal + vertical + diagonal IZQ => DER + diagonal DER => IZQ */
        int totalSecuenceDiagDerIzq=0;
        totalSecuenceDiagDerIzq = countSecuenceDiagDerIzq(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer+totalSecuenceDiagIzqDer)>1){
            return true;
        }

        // Si noencuntra secuencia mutante
        return false;
    }

    public static void main(String[] args) {

        //String[] dna = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCCTG","TCACTG"}; // 1
        //String[] dna = {"ATGAAA","AGGGGC","CTATGG","ACAAGG","CCCCTG","TCACTG"}; // 2
        //String[] dna = {"ATGAAA","AGAAAG","CAGATG","ACATGA","CCTGCC","TTGATA"}; // 3
        //String[] dna = {"ATAAAA","AGGGGC","ATATGG","AGAAGG","CCCGTG","TCGATG"}; // 4
        //String[] dna = {"AAAA","AAAT","AAAG","ACCA"}; // 5
        //String[] dna = {"ATAAA","AGGGG","ATGGG","AGGGG","CGCTG"}; // 6
        //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; // 7
        //String[] dna = {"AAAA","AAAT","AAAG"}; // 8
        //String[] dna = {"ATAAR","AGGGG","ATGGG","AGGGG","CGCGG"}; // 9
        //String[] dna = {"ATA","AGG","ATG"}; // 10
        //String[] dna = {"CTGATG","ACATTC","CAGTCT","CGAAGA","AGTTAG","TCGCAC"}; // 11
        String[] dna = {"TAAATCGG","AAAATTTT","TCAGTAGT","GAATTGAT","CCCCGGTT","AAAGTGAG","GAAAAGGG","TCTTTTAG"}; //12


        System.out.println ( isMutant(dna) );

        /*
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();
        // ejemplo inputString = "ATAAA,AGGGG,ATGGG,AGGGG,CGCGG";
        String[] dna = inputString.split(",");
        System.out.println ( isMutant(dna) );
        */

    }
}