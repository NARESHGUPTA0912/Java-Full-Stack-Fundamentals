package Q49_To_Q68;

public class OddFrequency {
    public static void main(String[] args) {

        int[] arr = {10,20,10,30,20,20,30,30};

        boolean[] visited = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {

            if(visited[i])
                continue;

            int count = 1;

            for(int j=i+1; j<arr.length; j++) {

                if(arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            if(count % 2 != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
