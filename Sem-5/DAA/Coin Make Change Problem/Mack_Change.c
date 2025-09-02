#include<stdio.h>
#include<limits.h>
#define MAX 100
int minCoins(int coins[], int m, int V) {
    int dp[V + 1];
    for (int i = 0; i <= V; i++) dp[i] = INT_MAX;
    dp[0] = 0;
    for (int i = 1; i <= V; i++) {
        for (int j = 0; j < m; j++) {
            if (coins[j] <= i) {
                int sub_res = dp[i - coins[j]];
                if (sub_res != INT_MAX && sub_res + 1 < dp[i])
                    dp[i] = sub_res + 1;
            }
        }
    }
    return dp[V] == INT_MAX ? -1 : dp[V];
}

int main() {
    int coins[] = {1, 3, 4, 5};
    int m = sizeof(coins) / sizeof(coins[0]);
    printf("Enter the value to make change for: ");
    int V = scanf("%d", &V);
    int result = minCoins(coins, m, V);
    if (result != -1)
        printf("Minimum coins required is %d\n", result);
    else
        printf("Not possible to make change for %d with given coins\n", V);
    return 0;
}
