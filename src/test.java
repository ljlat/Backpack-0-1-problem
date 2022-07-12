//0-1背包问题的动态规划算法
public class test {
    static int v[]= {0, 3, 2, 1, 4, 5}; //商品的体积
    static int w[]= {0, 25, 20, 15, 40, 50}; //商品的价值
    static int bagV =6; //背包大小
    static int dp[][]=new int[v.length][bagV+1]; //动态规划表
    static int item[]=new int[v.length]; //最优解情况
    static void findMax() { //动态规划
        for (int i = 1; i <= v.length-1; i++) {
            for (int j = 1; j <= bagV; j++) {
                if (j < v[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
            }
        }
    }
    static void findWhat(int i, int j) { //最优解情况
        if (i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                item[i] = 0;
                findWhat(i - 1, j);
            } else if (j - v[i] >= 0 && dp[i][j] == dp[i - 1][j - v[i]] + w[i]) {
                item[i] = 1;
                findWhat(i - 1, j - v[i]);
            }
        }
    }
    static void printF() {
        System.out.println("动态规划表：");
        for (int i = 0; i < dp.length; i++) {            //动态规划表输出
            for (int j = 0; j < dp[i].length; j++) {
                // System.out.print(dp[i][j]+" ");
                System.out.printf("%3d",dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("最优解：");
        for (int i = 1; i < item.length; i++)            //最优解输出
            System.out.print(item[i]+" ");
        System.out.println();
    }
    static void printV(){//背包体积
        System.out.println("背包体积:");
        for(int i =1;i<v.length;i++)
            System.out.print(v[i]+" ");
        System.out.println();
    }
    static void printW(){//背包价值
        System.out.println("背包价值:");
        for(int i =1;i<w.length;i++)
            System.out.print(w[i]+" ");
        System.out.println();
    }
    static void printbagV(){//背包大小
        System.out.println("背包大小：");
        System.out.println(bagV);
    }
    public static void main(String[] args) {
        printV();printW();printbagV();findMax();
        findWhat(dp.length-1, dp[0].length-1);
        printF();
    }
}