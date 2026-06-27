import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Sherlock {
    public static String isValid(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        int lowest = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        int lowestCount = 0;
        int highestCount = 0;

        for (char c : s.toCharArray()){
            frequencies.put(c, frequencies.getOrDefault(c, 0) +1);
        }

        for(Integer frequency : frequencies.values()){
            frequencyCount.put(frequency, frequencyCount.getOrDefault(frequency, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            int freq = entry.getKey();
            int qty = entry.getValue();

            if(freq < lowest){
                lowest = freq;
                lowestCount = qty;
            }

            if(freq > highest){
                highest = freq;
                highestCount = qty;
            }
        }

        if (frequencyCount.size()==1){
            return "YES";
        };

        if (frequencyCount.size()>2){
            return "NO";
        };

        if(highest - lowest == 1 && highestCount == 1){
            return "YES";
        }

        if(lowest == 1 && lowestCount ==1){
            return "YES";
        }

        return "NO";

    }
}

class MaxMin {

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int lowestUnfairness = Integer.MAX_VALUE;

        for(int i = 0; i <= arr.size()-k; i++){
            int unfairness = arr.get(i+k-1) - arr.get(i);

            if (unfairness < lowestUnfairness){
                lowestUnfairness = unfairness;
            }
        }

        return lowestUnfairness;
    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("== Ejercicios de HackerRank ==");
        System.out.println("1. Sherlock and the Valid String");
        System.out.println("2. Max Min");
        System.out.println("Seleccione una opcion: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Sherlock and the Valid String");
                System.out.println("Ingrese la cadena: ");
                sc.nextLine();
                String s = sc.nextLine();

                System.out.println("Resultado: " + Sherlock.isValid(s));
                break;

            case 2:
                System.out.println("Max Min");
                System.out.println("Ingrese el tamaño de la lista: ");
                int n = sc.nextInt();

                System.out.println("Ingrese el valor de k: ");
                int k = sc.nextInt();

                List<Integer> arr = new ArrayList<>();

                System.out.println("Ingrese los elementos: ");

                for (int i = 0; i < n; i++) {
                    arr.add(sc.nextInt());
                }

                System.out.println("Resultado: " + MaxMin.maxMin(k, arr));
                break;

            default:
                System.out.println("Opcion no permitida");
        }
    }
}