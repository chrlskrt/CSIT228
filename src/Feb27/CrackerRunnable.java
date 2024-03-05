package Feb27;

public class CrackerRunnable implements Runnable{
    char ch;
    String pass;

    static Boolean isFound = false;
    public CrackerRunnable(char ch, String pass) {
        this.ch = ch;
        this.pass = pass;
    }

    @Override
    public void run() {
        // from ch + "aaaa..." until ch + "zzzzz..."
        // example: pass = cool, ch = j
        // this thread searches jaaa to jzzz

        int len = pass.length();

        String atk = ch + "a".repeat(len-1);
        while(!atk.equals(pass) && !isFound){
            System.out.println(atk);
            int i;

            for (i = len-1; atk.charAt(i) == 'z'; i--);
            String first = atk.substring(1, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len-i-1);
            atk = ch + first + next + after;
        }

        if (!isFound){
            System.out.println("Found: " + atk);
        }

        isFound = true;

    }
}
