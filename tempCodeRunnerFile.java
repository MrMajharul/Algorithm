public class tempCodeRunnerFile {

// Function to find the length of the LCS
public static int findLCSLength(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    // Create a 2D array to store lengths of LCS
    int[][] dp = new int[m + 1][n + 1];

    // Build the dp table in bottom-up fashion
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // If characters match, increment the result from previous subproblem
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                // If not, take the maximum of the previous subproblems
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[m][n]; // The bottom-right cell contains the length of LCS

}

// Optional: Function to reconstruct and return the LCS string itself
public static String getLCS(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    int[][] dp = new int[m + 1][n + 1];

    // Fill dp table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Reconstruct the LCS from the dp table
    StringBuilder lcs = new StringBuilder();
    int i = m, j = n;

    while (i > 0 && j > 0) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            lcs.append(str1.charAt(i - 1));

            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        } else {
                j--;
        }
    }

    return lcs.reverse().toString();
}

// Main method for testing
public static void main(String[] args) {
    String str1 = "AGGTAB";
    String str2 = "GXTXAYB";

    int length = findLCSLength(str1, str2);
    String lcsString = getLCS(str1, str2);

    System.out.println("Length of LCS: " + length);
    System.out.println("LCS: " + lcsString);
}

}