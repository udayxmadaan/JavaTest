package src;

import java.util.HashSet;
import java.util.Set;

public class DNA {
    String NucleotideSeq = new String();

    DNA(String NucleotideSeq) {
    this.NucleotideSeq = NucleotideSeq;
    }

    double totalMass(String NucleotideSeq){

        int length = NucleotideSeq.length();
        double mass=0;

        for(int i=0; i<length; i++){
            if(NucleotideSeq.charAt(i) == 'A'){
                mass += 135.128;
            }
            else if(NucleotideSeq.charAt(i) == 'C'){
                mass += 111.103;
            }
            else if(NucleotideSeq.charAt(i) == 'G'){
                mass += 151.128;
            }
            else if(NucleotideSeq.charAt(i) == 'T'){
                mass += 125.107;
            }
            else{
                mass+= 100.000;
            }

        }


        return mass;
    }
    //fix mutate codon
    String mutateCodon(String NucleotideSeq, String originalCodon, String newCodon){
        NucleotideSeq.replace(originalCodon, newCodon);

        return NucleotideSeq; //change this
    }

    int nucleotideCount(String NucleotideSeq, char c){
        int count=0;

        for(int i=0; i<NucleotideSeq.length(); i++) {

            if ((NucleotideSeq.charAt(i) == c)) {
                count += 1;
            }
            else{}

        }
        return count;
    }

    boolean isProtein(String NucleotideSeq){

        int Checker=0;

        for(int i=0; i<2; i++) {
            if (NucleotideSeq.charAt(i) == 'A') {
                Checker+=1;
                if (NucleotideSeq.charAt(i) == 'T') {
                    Checker+=1;
                    if (NucleotideSeq.charAt(i) == 'G') {
                        Checker+=1;
                    }
                    else{}
                }
                else{}
            }
            else if(NucleotideSeq.charAt(i) == 'T'){}
            else if(NucleotideSeq.charAt(i) == 'G'){}
            else if(NucleotideSeq.charAt(i) == 'C'){}
            else{
                i--;
            }

        }

        for(int i=NucleotideSeq.length()-1; i>NucleotideSeq.length()-1-2; i--) {

            if (NucleotideSeq.charAt(i) == 'T') {
                Checker+=1;
                if (NucleotideSeq.charAt(i) == 'G') {
                    Checker+=1;

                    if (NucleotideSeq.charAt(i) == 'A') {
                        Checker+=1;
                    }
                    else{}
                }
                else if(NucleotideSeq.charAt(i) == 'A'){
                    Checker+=1;
                    if (NucleotideSeq.charAt(i) == 'A') {
                        Checker+=1;
                    }
                    else{}
                }
                else{}
            }
            else if (NucleotideSeq.charAt(i) == 'A'){}
            else if (NucleotideSeq.charAt(i) == 'G'){}
            else if (NucleotideSeq.charAt(i) == 'C'){}
            else{
                i++;
            }
        }

        double CG_Percent = ( nucleotideCount(NucleotideSeq,'C') + nucleotideCount(NucleotideSeq,'G') ) / NucleotideSeq.length();

        boolean valid= (Checker==6) && (CG_Percent>=0.30) && (NucleotideSeq.length()>=0);


        return valid;
    }

    String sequence(String NucleotideSeq) {
        String NucleotideSeq2 = "";
        for (int i=0; i<NucleotideSeq.length(); i++) {

            if(NucleotideSeq.charAt(i) == 'A'){
                NucleotideSeq2+='A';
            }
            else if (NucleotideSeq.charAt(i) == 'T') {
                NucleotideSeq2+='T';
            }
            else if (NucleotideSeq.charAt(i) == 'G') {
                NucleotideSeq2+='G';
            }
            else if (NucleotideSeq.charAt(i) == 'C') {
                NucleotideSeq2+='C';
            }
            else{
            }
        }
        return NucleotideSeq2;
    }


}
