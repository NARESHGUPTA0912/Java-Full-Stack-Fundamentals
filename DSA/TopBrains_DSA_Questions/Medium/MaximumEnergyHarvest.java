package Medium;

public class MaximumEnergyHarvest {
    public static int maxEnergyHarvest(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = 0;
        for (int i = 0; i < n; i++) {
            int currentEnergy = energy[i];
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    currentEnergy += energy[i - j];
                }
                if (i + j < n) {
                    currentEnergy += energy[i + j];
                }
            }
            maxEnergy = Math.max(maxEnergy, currentEnergy);
        }
        return maxEnergy;
    }

    public static int maxEnergyHarvestOptimized(int[] energy, int k) {
        int n = energy.length, currentEnergy = 0;
        // Calculate initial energy for the first window
        for (int i = 0; i <= k && i < n; i++)
            currentEnergy += energy[i];
        int maxEnergy = currentEnergy;
        // Slide the window across the array
        for (int i = 1; i < n; i++) {
            if (i - k - 1 >= 0)
                currentEnergy -= energy[i - k - 1]; // Remove the leftmost element of the previous window
            if (i + k < n)
                currentEnergy += energy[i + k]; // Add the rightmost element of the new window
            maxEnergy = Math.max(maxEnergy, currentEnergy);
        }
        return maxEnergy;
    }

    public static void main(String[] args) {
        int[] energy = {1, 2, 3, 4, 5};
        int k = 1;
        int result = maxEnergyHarvest(energy, k);
        System.out.println("The maximum energy harvest is: " + result);
    }
}
