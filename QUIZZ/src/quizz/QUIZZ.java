/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 * @author Mathieu 'Triboulet' RONDOT
 */
public class QUIZZ
{


    static public QuizzScreenQuestionCreation questionCreationScreen;
    static public QuizzScreenCreation quizzCreationScreen;
    static public QuizzScreenQuestionCorrection questionCorrectionScreen;
    static public QuizzScreenAnswer quizzScreenAnswer;
    
    static public PlayerScreenHome playerScreenHome;
    static public PlayerScreenRankQuizz playerRankQuizzScreen;
    static public PlayerScreenStat playerScreenStat; 
    
    static public AdminScreenHome accueilAdminScreen;
    static public AdminScreenAddAdmin adminScreenAddAdmin;
    
    static public ConnectionScreenAddUser connectionAddUser;
    static public ConnectionScreen connectionScreen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {



        //questionCreationScreen = new QuestionCreationScreen();
        //questionCreationScreen.setVisible(true);

        //quizzCreationScreen = new QuizzCreationScreen();
        //quizzCreationScreen.setVisible(true);
        

        connectionScreen = new ConnectionScreen();
        //connectionScreen.setVisible(true);
        
        
        playerScreenHome = new PlayerScreenHome();
        playerScreenHome.setVisible(true);
         

        
        //accueilAdminScreen = new AccueilAdminScreen();
        //accueilAdminScreen.setVisible(true);

        //questionCorrectionScreen = new QuestionCorrectionScreen();
        //questionCorrectionScreen.setVisible(true);

        //connectionScreen = new AnswerQuizzScreen();
        //connectionScreen.setVisible(true);
        
        playerRankQuizzScreen = new PlayerScreenRankQuizz();
        //playerRankQuizzScreen.setVisible(true);
        
        playerScreenStat = new PlayerScreenStat();
        //quizzStatPlayerScreen.setVisible(true);
        
        connectionAddUser = new ConnectionScreenAddUser();
        //connectionAddUser.setVisible(true);
        
        connectionScreen = new ConnectionScreen();
        //connectionScreen.setVisible(true);
        
        adminScreenAddAdmin = new AdminScreenAddAdmin();
        //adminScreenAddAdmin.setVisible(true);

    }
}
