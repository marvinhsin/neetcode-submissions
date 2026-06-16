class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int l = 0;
        int r = people.length - 1;
        int total = 0;
        
        while (l <= r) {
            // If there's only one person left, they take their own boat
            if (l == r) {
                total++;
                break;
            }
            
            // Can the heaviest and lightest share?
            if (people[l] + people[r] <= limit) {
                l++; // Lightest gets on board
            }
            
            // Heaviest always gets on board
            r--; 
            total++;
        }
        
        return total;
    }
}