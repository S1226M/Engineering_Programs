public class pattern_1 {
    public static void main(String[] args) {
        int i,j;
        for(i=0;i<=5;i++)
        {
            for(j=0;j<=5;j++)
            {
                if(i==1&&j==1 || i==2&&j==1 || i==2&&j==2 || i==3&&j==1 || i==3&&j==2 || i==3&&j==3 || i==4&&j==1 || i==4&&j==2 || i==5&&j==1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print("");
                }
            }
            System.out.println("");
        }
    }
}
