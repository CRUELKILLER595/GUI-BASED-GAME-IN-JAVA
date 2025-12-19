import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choiceHandler implements ActionListener {
    GUI g;

    public choiceHandler(GUI g) {
        this.g = g;
    }

    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        switch (g.position) {
            case "TownGate":
                switch (yourChoice) {
                    case "c1":
                        if(g.Silverring==1){
                            g.ending();
                            break;
                    }else{
                        g.TalkGuard();
                        break;
                    }
                    case "c2":
                        g.AttackGuard();
                        break;
                    case "c3":
                        g.CrossRoad();
                        break;
                }
                break;
            case "TalkGuard":
                switch (yourChoice) {
                    case "c1":
                        g.TalkGuard();
                        break;
                    case "c2":
                        g.AttackGuard();
                        break;
                    case "c3":
                        g.CrossRoad();
                        break;

                }
                break;
            case "AttackGuard":
                switch (yourChoice) {
                    case "c1":
                        g.TalkGuard();
                        break;
                    case "c2":
                        g.AttackGuard();
                        break;
                    case "c3":
                        g.CrossRoad();
                }
                break;
            case "CrossRoad":
                switch (yourChoice) {
                    case "c1":
                        g.North();
                        break;
                    case "c2":
                        g.TownGate();
                        break;
                    case "c3":
                        g.West();
                        break;
                    case "c4":
                        g.East();
                        break;

                }
                break;
            case "North":
                switch (yourChoice) {
                    case "c1":
                        g.CrossRoad();
                        break;
                    case "c2":
                        g.North();
                        break;

                }
                break;
            case "East":
                switch (yourChoice) {
                    case "c1":
                        g.CrossRoad();
                        break;
                    case "c2":
                        g.East();
                }
                break;
            case "West":
                switch (yourChoice) {
                    case "c1":
                        g.Fight();
                        break;
                    case "c2":
                        g.CrossRoad();
                        break;
                }
                break;
            case "Fight":
                switch (yourChoice) {
                    case "c1":
                        g.Attack();
                        break;
                    case "c2":
                        g.CrossRoad();
                }
                break;
            case "Attack":
                switch (yourChoice) {
                    case "c1":
                        if (g.Monsterhp < 1) {
                            g.WIN();
                        } else {
                            g.MonsterDamage();

                        }
                        break;
                    case "c2":
                        g.CrossRoad();
                        break;
                }


            case "MonsterDamage":
                switch (yourChoice) {
                    case "c1":
                        if (g.playerHp < 1) {
                            g.LOSE();
                            break;
                        } else if (g.Monsterhp < 1) {
                            g.WIN();
                            break;
                        } else {
                            g.Attack();
                            break;
                        }
                    case "c2":
                        g.Fight();
                        break;
                }
                break;
            case "WIN":
                switch (yourChoice) {
                    case "c1":g.CrossRoad();
                    break;
                    case "c2":g.WIN();
                    break;
                }
                break;
                case "LOSE":
                    switch (yourChoice) {
                        case "c1":
                            System.exit(0);
                            break;

                    }
                    break;
            case "ENDING":
                g.ending();
                break;

        }

    }
}
