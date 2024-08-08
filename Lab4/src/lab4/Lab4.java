
package lab4;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Lab4 extends Application {
    
    String Turno="jugador1";
    int aux=3;
    int contador=0;

    
    @Override
    public void start(Stage primaryStage) {
        
        Group group = new Group();
        Circle[][] lCirculos= new Circle[6][7];
        
         //AGREGANDO ELEMENTOS
         int auxC1=50;
         int auxC2=50;
         int auxC3=50;
         int auxC4=50;
         int auxC5=50;
         int auxC6=50;
         
         for (int i = 0; i < lCirculos.length; ++i) {
             for(int j = 0; j < lCirculos[i].length; ++j) {
                 if(i==0){
                     lCirculos[i][j]= new Circle(auxC1,50,35, Color.BLACK);
                     
                     group.getChildren().add(lCirculos[i][j]);
                     auxC1=auxC1+75;
                 }
                 else if(i==1){
                     lCirculos[i][j]= new Circle(auxC2,125,35, Color.BLACK);
                  group.getChildren().add(lCirculos[i][j]);
                  auxC2=auxC2+75;
                 }
                 else if(i==2){
                     lCirculos[i][j]= new Circle(auxC3,200,35, Color.BLACK);
                  group.getChildren().add(lCirculos[i][j]);
                  auxC3=auxC3+75;
                 }
                 else if(i==3){
                     lCirculos[i][j]= new Circle(auxC4,275,35, Color.BLACK);
                  group.getChildren().add(lCirculos[i][j]);
                  auxC4=auxC4+75;
                 }
                 else if(i==4){
                     lCirculos[i][j]= new Circle(auxC5,350,35, Color.BLACK);
                  group.getChildren().add(lCirculos[i][j]);
                  auxC5=auxC5+75;
                 }
                 else if(i==5){
                     lCirculos[i][j]= new Circle(auxC6,425,35, Color.BLACK);
                  group.getChildren().add(lCirculos[i][j]);
                  auxC6=auxC6+75;
                 }
                 
      }
    }
         int [][] valores= new int[6][7];
         if (aux==3){
             for (int i = 0; i < valores.length; ++i) {
                 for(int j = 0; j < valores[i].length; ++j) {
                     valores[i][j]=aux+1;
                     aux++;
                }
         } 
         }
         
         for (int i = 0; i < lCirculos.length; ++i) {
      for(int j = 0; j < lCirculos[i].length; ++j) {
          
        int fila=i;
        int colu=j;
        lCirculos[fila][colu].setOnMouseClicked(event->{
            if(contador!=41){
            if(Turno.equals("jugador1")) {
                if(valores[fila][colu]!=1 && valores[fila][colu]!=2){
                    lCirculos[fila][colu].setFill(Color.RED);
                    valores[fila][colu]=1;
                    if(checkForIdenticalFour(valores)==true){
                        System.out.println("GANADOR JUGADOR 1 ! (ROJO) ");
                        System.exit(0);
                    }
                    contador++;
                    Turno="jugador2";
                }else
                    System.out.println("CIRCULO YA ELEGIDO, PORFAVOR ELIGA OTRA OPCION");
            }else{
                if(valores[fila][colu]!=1 && valores[fila][colu]!=2){
                    lCirculos[fila][colu].setFill(Color.BLUE);
                    valores[fila][colu]=2;
                    if(checkForIdenticalFour(valores)==true){
                        System.out.println("GANADOR JUGADOR 2 ! (AZUL) ");
                        System.exit(0);
                    }
                    contador++;
                    Turno="jugador1";     
                }else
                    System.out.println("CIRCULO YA ELEGIDO, PORFAVOR ELIGA OTRA OPCION");
            }
        }else{
            System.out.println("EMPATE, NADIE GANO");
            System.exit(0);
            }
            
        });
        

      }
    }
          

    

    
    // crear una nueva scene, conteniendo el pane
    Scene scene = new Scene(group, 550, 475);
    primaryStage.setTitle("Juegito"); // colocar titulo al stage
    primaryStage.setScene(scene); // Poner scene en el stage
    scene.setFill(Color.WHITE);  
    primaryStage.setResizable(false);

    primaryStage.show(); // Display el stage
    }
    
    /**
     * Este metodo devuelve un booleano luego de analizar si en la matriz hay alguna fila que conecta 4 veces con un numero repetido
     * @param matrix Matriz 6x7 requerida para devoolver booleano
     * @return Boolean dependiendo si encontro 4 elementos repetidos en una fila(true) o no (false)
     */
    private static boolean checkRows(int[][] matrix)
{
    for (int row = 0; row < matrix.length; row++)
    {
        for (int col = 0; col < matrix[row].length - 3; col++)
        {
            int element = matrix[row][col];
            if (element == matrix[row][col + 1] && 
                element == matrix[row][col + 2] && 
                element == matrix[row][col + 3])
            {
                return true;
            }
        }
    }
    return false;
}
/**
 * Este metodo devuelve un booleano luego de analizar si en la matriz hay alguna columna que conecta 4 veces con un numero repetido
 * @param matrix Matriz 6x7 requerida para devoolver booleano
 * @return boolean dependiendo si encontro 4 elementos repetidos en una columna(true) o no (false)
 */
private static boolean checkColumns(int[][] matrix)
{
    for (int row = 0; row < matrix.length - 3; row++)
    {
        for (int col = 0; col < matrix[row].length; col++)
        {
            int element = matrix[row][col];
            if (element == matrix[row + 1][col] && 
                element == matrix[row + 2][col] && 
                element == matrix[row + 3][col])
            {
                return true;
            }
        }
    }
    return false;
}
/**
 * Este metodo devuelve un booleano luego de analizar si en la matriz hay alguna diagonal que conecta 4 veces con un numero repetido de forma izquierda
 * @param matrix Matriz 6x7 requerida para devoolver booleano
 * @return boolean dependiendo si encontro 4 elementos repetidos en una diagonal (true) o no (false)
 */
private static boolean checkMainDiagonal(int[][] matrix)
{
    for (int row = 0; row < matrix.length - 3; row++)
    {
        for (int col = 0; col < matrix[row].length - 3; col++)
        {
            int element = matrix[row][col];
            if (element == matrix[row + 1][col + 1] && 
                element == matrix[row + 2][col + 2] && 
                element == matrix[row + 3][col + 3])
            {
                return true;
            }
        }
    }
    return false;
}
/**
 * Este metodo devuelve un booleano luego de analizar si en la matriz hay alguna diagonal que conecta 4 veces con un numero repetido de forma derecha
 * @param matrix  Matriz 6x7 requerida para devoolver booleano
 * @return boolean dependiendo si encontro 4 elementos repetidos en una diagonal(true) o no (false)
 */
private static boolean checkCounterDiagonal(int[][] matrix)
{
    for (int row = 0; row < matrix.length - 3; row++)
    {
        for (int col = 3; col < matrix[row].length; col++)
        {
            int element = matrix[row][col];
            if (element == matrix[row + 1][col - 1] && 
                element == matrix[row + 2][col - 2] && 
                element == matrix[row + 3][col - 3])
            {
                return true;
            }
        }
    }
    return false;
}
/**
 * Este metodo devuelve un booleano llamando a otros 4 metodos que comprueban si hay algun 4 elementos repetidos de forma consecutivas
 * @param matrix Matriz 6x7 requerida para devoolver booleano
 * @return boolean dependiendo si los metodos encontaron 4 elementos repetidos(true) o no(false)
 */
public static boolean checkForIdenticalFour(int[][] matrix)
{
    return checkRows(matrix) ||
        checkColumns(matrix) ||
        checkMainDiagonal(matrix) ||
        checkCounterDiagonal(matrix);
}

    public static void main(String[] args) {
        launch(args);
    }
    
}
