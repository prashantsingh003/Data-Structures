public class ExceptionHandeling
{
    public static void main(String argv[])
    {
        int balance=5000;
        int withdrawl=3000;
        try {
            if(withdrawl>balance)
                throw new ArithmeticException("InsufficiantBalance");
            balance=balance-withdrawl;
            System.out.println("The remaining Balance = ");
        } catch (ArithmeticException e) {
            System.out.println("Exception = "+e.getMessage());
        }
        System.out.println("Programm Continues");
    }
}