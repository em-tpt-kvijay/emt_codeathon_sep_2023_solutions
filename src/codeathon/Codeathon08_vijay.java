package codeathon;

import java.util.Date;

public class Codeathon08_vijay {
    public static void main(String arg[])  {
        String team1[] = {"Rohit Sharma", "Shubman Gill", "Virat Kohli", "KL Rahul", "Ishan Kishan",
                "Hardik Pandya", "Ravindra Jadeja", "Washington Sundar", "Kuldeep Yadav",
                "Mohammed Siraj", "Jasprit Bumrah"};
        String team2[] = {"Pathum Nissanka", "Kusal Perera", "Kusal Mendis", "Sadeera Samarawickrama",
                "Charith Asalanka", "Dhananjaya de Silva", "Dasun Shanaka", "Dunith Wellalage",
                "Dushan Hemantha", "Pramod Madushan", "Matheesha Pathirana"};
        Team india = new Team("India", team1);
        Team sriLanka = new Team("Sri Lanka", team2);
        Thread team1Thread = new Thread(india);
        Thread team2Thread = new Thread(sriLanka);
        double random = Math.random() * 10;
        double toss = random % 2;
        for(int i = 0; i < 2; i++) {
            if(toss > 0 && toss < 1) {
                if(i == 0) {
                    System.out.println("India Batting first");
                } else {
                    System.out.println("\nIndia Batting Second");
                }
                team1Thread.start();
                try {
                    team1Thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                toss = 1.5;
            } else {
                if(i == 0) {
                    System.out.println("Sri Lanka Batting first");
                } else {
                    System.out.println("\nSri Lanka Batting Second");
                }
                team2Thread.start();
                try {
                    team2Thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                toss = 0.5;
            }
        }
        if(india.totalScore > sriLanka.totalScore) {
            System.out.println("India Won By " + (india.totalScore - sriLanka.totalScore));
            System.out.println("Today date: = " + new Date());
        }
        if(sriLanka.totalScore > india.totalScore) {
            System.out.println("Sri Lanka Won By " + (sriLanka.totalScore - india.totalScore));
            System.out.println("Today date: = " + new Date());
        }
    }
}

class Team implements Runnable {
    String teamName;
    String playerName[];
    int totalScore = 0;
    int runsPerBall[];
    play players[];

    Team(String team, String player[]) {
        teamName = team;
        playerName = player;
        runsPerBall = new int[60];
        players = new play[11];
    }

    @Override
    public void run() {
        int ballsBowled = 0;
        int extras = 0;
        int totalRuns = 0;

        for (int i = 0; i < 11; i++) {
            players[i] = new play(teamName, playerName[i]);
            totalRuns = 0;
            int ballLength = 0;
            extras = 0;
            for (int j = 0; ballsBowled < 60; j++) {
                double random = Math.random() * 10;
                int runs = (int) random % 8;
                ballsBowled++;
                ballLength++;
                totalRuns += runs;
                if (runs == 7) {
                    extras++;
                    runs = 6;
                }
                runsPerBall[j] = runs;
                if (runs == 0) {
                    break;
                }
            }
            if (ballLength == 0) {
                players[i].count = new int[]{0, 0, 0};
            } else {
                players[i].count = runsPerBall;
            }
            players[i].ballsBowled = ballLength;
            players[i].extras = extras;
            players[i].totalRuns = totalRuns;
            m1(players[i]);
        }
        for (int i = 0; i < 10; i++) {
            totalScore = totalScore + players[i].totalRuns;
        }
        double overs = (double) ballsBowled / 6;
        System.out.println("\nTotal Score = " + totalScore + " total Overs = " + (int) (Math.round(overs * 10)) / 10.0);
    }

    void m1(play player) {
        System.out.print(player.playerName + " " + player.ballsBowled + "(");
        for (int i = 0; i < 60; i++) {
            System.out.print(player.count[i]);
            if (player.count[i] == 0) {
                break;
            } else {
                System.out.print(",");
            }
        }
        System.out.print(") = " + player.totalRuns + "  (total extra = " + player.extras + ")");
        System.out.println();
    }
}

class play {
    String teamName;
    String playerName;
    int ballsBowled;
    int extras;
    int[] count;
    int totalRuns;

    play(String team, String player) {
        teamName = team;
        playerName = player;
        count = new int[60];
    }
}
