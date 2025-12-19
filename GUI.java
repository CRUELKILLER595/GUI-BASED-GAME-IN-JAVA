import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GUI {

    JFrame window;
    Container c;
    JPanel titlePanel, buttonPanel, gamePanel, choiceButtonPanel, playerPanel;
    JLabel label, hplabel, hplabelnumber, weaponlabel, weaponlabelnumber;
    JButton button, choice1, choice2, choice3, choice4;
    JTextArea textArea;
    String position;
    Font titleFont = new Font("Times New Roman", Font.BOLD, 60);
    Font normalFont = new Font("Times New Roman", Font.ITALIC, 20);
    int playerHp;
    int Monsterhp;
    int Silverring;
    Random rc = new Random();
    String weapon;

    TitleScreenHandler handler = new TitleScreenHandler();
    choiceHandler ch = new choiceHandler(this);

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        window = new JFrame("ADVENTURE");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        c = window.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        // 🔵 Title Panel
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLUE);
        titlePanel.setBounds(100, 180, 600, 100);

        label = new JLabel("ADVENTURE");
        label.setForeground(Color.WHITE);
        label.setFont(titleFont);
        titlePanel.add(label);
        c.add(titlePanel);

        // 🔘 Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(300, 300, 200, 100);
        buttonPanel.setBackground(Color.DARK_GRAY);

        button = new JButton("Start");
        button.setBounds(40, 30, 120, 40);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(normalFont);
        button.addActionListener(handler);
        button.setFocusPainted(false);
        buttonPanel.add(button);
        c.add(buttonPanel);

        window.setVisible(true);
    }


    public void createGameScreen() {

        titlePanel.setVisible(false);
        buttonPanel.setVisible(false);

        // 🎮 Story panel
        gamePanel = new JPanel();
        gamePanel.setBounds(150, 150, 400, 120);
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(normalFont);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        gamePanel.add(textArea, BorderLayout.CENTER);

        // 🔘 Choice buttons
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 300, 300, 250);
        choiceButtonPanel.setBackground(Color.GRAY);
        choiceButtonPanel.setLayout(null);

        choice1 = new JButton("Choice 1");
        choice1.setBounds(90, 20, 200, 40);
        choice1.setActionCommand("c1");
        choice2 = new JButton("Choice 2");
        choice2.setBounds(90, 70, 200, 40);
        choice2.setActionCommand("c2");
        choice3 = new JButton("Choice 3");
        choice3.setBounds(90, 120, 200, 40);
        choice3.setActionCommand("c3");
        choice4 = new JButton("Choice 4");
        choice4.setBounds(90, 170, 200, 40);
        choice4.setActionCommand("c4");
        JButton[] choices = {choice1, choice2, choice3, choice4};

        for (JButton b : choices) {
            b.setFont(normalFont);
            b.setBackground(Color.WHITE);
            b.setForeground(Color.BLACK);
            b.setFocusPainted(false);
            b.addActionListener(ch);
            choiceButtonPanel.add(b);
        }

        // ❤️ Player info panel
        playerPanel = new JPanel();
        playerPanel.setBounds(70, 80, 600, 40);
        playerPanel.setBackground(Color.BLUE);
        playerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        hplabel = new JLabel("HP:");
        hplabel.setFont(normalFont);
        hplabel.setForeground(Color.WHITE);
        hplabelnumber = new JLabel("100");
        hplabelnumber.setFont(normalFont);
        hplabelnumber.setForeground(Color.WHITE);
        playerPanel.add(hplabel);
        weaponlabel = new JLabel(" Weapon :");
        weaponlabel.setFont(normalFont);
        weaponlabel.setForeground(Color.WHITE);
        weaponlabelnumber = new JLabel();
        weaponlabelnumber.setFont(normalFont);
        weaponlabelnumber.setForeground(Color.WHITE);
        playerPanel.add(hplabelnumber);
        playerPanel.add(weaponlabel);
        playerPanel.add(weaponlabelnumber);
        // Add everything
        c.add(gamePanel);
        c.add(choiceButtonPanel);
        c.add(playerPanel);

        c.revalidate();
        c.repaint();
        playerSetup();
        TownGate();
    }

    public void playerSetup() {
        playerHp = 25;
        weapon = "AXE";
        weaponlabelnumber.setText(weapon);
        hplabelnumber.setText(Integer.toString(playerHp));

    }

    public void TownGate() {
        position = "TownGate";
        textArea.setText("You are at the gate of the town.A guard is standing in front of you.What do you do");
        choice1.setText("Talk to gaurd");
        choice2.setText("Attack the gaurd");
        choice3.setText("Leave");
        choice4.setText(" ");


    }

    public void TalkGuard() {
        position = "TalkGuard";
        textArea.setText("Guard: Hello there, stranger.I have never seen you\nSorry, we cannot let a stranger enter our town.");
        choice1.setText("Talk to gaurd");
        choice2.setText("Attack the gaurd");
        choice3.setText("Leave");
        choice4.setText(" ");


    }

    public void AttackGuard() {
        position = "AttackGuard";
        textArea.setText("Guard: What the hell?! Don't be stupid!\n The guard hits you hard you lose 1 HP");
        playerHp -= 1;
        hplabelnumber.setText(Integer.toString(playerHp));
    }

    public void CrossRoad() {
        position = "CrossRoad";
        textArea.setText("You are at the cross road ,you will reach town on going south\n 1.Go North\n 2. Go South\n 3. Go West \n 4.Go East");
        choice1.setText("1.Go North");
        choice2.setText("2.Go South");
        choice3.setText("3.Go West");
        choice4.setText("4.Go East");
    }

    public void North() {
        position = "North";
        textArea.setText("You find a peaceful river. You rest and drink some water.\n You gained  HP");
        playerHp += 2;
        if (playerHp > 25) playerHp = 25;

        hplabelnumber.setText(Integer.toString(playerHp));
        choice1.setText("1.Go to crossroad");
        choice2.setText("2.Stay here");
        choice3.setText("");
        choice4.setText("");



    }

    public void West() {
        position = "West";
        textArea.setText("You see a goblin");
        choice1.setText("1.Fight");
        choice2.setText("2.Run");




    }

    public void East() {
        position = "East";
        textArea.setText("You walked into a forest and found a Long Sword!");
        weapon = "Long Sword";
        weaponlabelnumber.setText(weapon);
        choice1.setText("1.Go to crossroad");
        choice2.setText("2.Stay here");
        choice3.setText("");
        choice4.setText("");


    }

    public void Fight() {
        position = "Fight";
        if(Monsterhp==0) Monsterhp = rc.nextInt(15, 20);
        textArea.setText("Goblin HP: " + Monsterhp + " \n What do you do?");
        choice1.setText("1.Attack");
        choice2.setText("2.Run");
        choice3.setText("");
        choice4.setText("");



    }

    public void Attack() {
        position = "Attack";
        int playerDamage = 0;
        if (weapon.equals("AXE")) {
            playerDamage = rc.nextInt(1, 6);

        } else {
            playerDamage = rc.nextInt(9, 16);
        }
        Monsterhp-=playerDamage;
textArea.setText("You attacked the monster  and gave " + playerDamage +" damage.\n Monster hp is "+Monsterhp);
if(Monsterhp<=0){
    textArea.setText("YOU WIN");
    WIN();
}
        choice1.setText("1.>");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");


    }
    public void MonsterDamage() {
        position = "MonsterDamage";

        int monsterDamage = rc.nextInt(3, 9);
        playerHp -= monsterDamage;

        if (playerHp <= 0) {
            playerHp = 0;
            hplabelnumber.setText("0");
            LOSE();
            return;
        }

        hplabelnumber.setText(String.valueOf(playerHp));

        textArea.setText(
                "Monster gave you " + monsterDamage +
                        " damage.\nYour HP is " + playerHp
        );

        choice1.setText("1.Attack");
        choice2.setText("2.Run");
       choice3.setText("");
       choice4.setText("");


    }

    public void WIN() {
        position = "WIN";
        textArea.setText("You win!\n The monster dropped a silver ring \n\n You got a silver ring");
Silverring=1;
        choice1.setText("1.Go to crossroad");
        choice2.setText("2.Stay here");
      choice3.setText("");
      choice4.setText("");

    }
    public void LOSE() {
        position = "LOSE";
        textArea.setText("You lose!\n\n(GAME OVER)");
        choice1.setText("1.Exit");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");



    }
    public void ending(){
        position = "ENDING";
        textArea.setText("Guard:You defeated the goblin!\n You are a hero \nWelcome to town\n <THE END >");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        choiceButtonPanel.setVisible(false);
    }
}