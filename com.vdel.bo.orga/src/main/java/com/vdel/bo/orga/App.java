
package com.vdel.bo.orga;

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    static void friseChronologique(final int d, final int n, final int[] frise)
    {
        int i = 0;
        if(frise!=null && frise.length>0) {
            while (d > frise[i] && (i < n || i < frise.length)) {
                i++;
            }
        }
        System.out.println(i+1);
    }

    public static void main(final String args[])
    {
        final int d = Integer.parseInt(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        final int[] frise = read_int_line();
        friseChronologique(d, n, frise);
    }

    static int[] read_int_line()
    {
        final String[] s = scanner.nextLine().split(" ");
        final int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++)
        {
            if (s[i].length() > 0)
            {
                out[i] = Integer.parseInt(s[i]);
            }
        }
        return out;
    }
}