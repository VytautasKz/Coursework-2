package com.company;

class Bug {
    static void hello() throws InterruptedException {
        if (Main.tick == 0 || Main.t == 0) {
            System.out.println("                     Created by:");
            System.out.println();
            System.out.println("  #####   #####   #####  #       #######   ###     ###   ");
            System.out.println(" #     # #     # #     # #    #  #    #   #   #   #   #  ");
            System.out.println(" #     # #       #     # #    #      #   #     # #     # ");
            System.out.println("  #####  ######   ###### #    #     #    #     # #     # ");
            System.out.println(" #     # #     #       # #######   #     #     # #     # ");
            System.out.println(" #     # #     # #     #      #    #      #   #   #   #  ");
            System.out.println("  #####   #####   #####       #    #       ###     ###   ");
            System.out.println();
            System.out.println("                     Vytautas Kuzma");
            Main.t++;
        } else {
            System.out.println("Bad input");
        }

        Main.menuText();
    }

}
