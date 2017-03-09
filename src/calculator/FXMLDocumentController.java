/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author ilana
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label resultsField;
    @FXML
    private Label infixField;
    @FXML
    private Text button0;
    @FXML
    private Text buttonClear;
    @FXML
    private Text buttonDiv;
    @FXML
    private Text buttonMult;
    @FXML
    private Text buttonMinus;
    @FXML
    private Text button9;
    @FXML
    private Text button6;
    @FXML
    private Text button3;
    @FXML
    private Text button8;
    @FXML
    private Text button5;
    @FXML
    private Text button7;
    @FXML
    private Text button4;
    @FXML
    private Text button2;
    @FXML
    private Text button1;
    @FXML
    private Text buttonPlus;
    @FXML
    private Text buttonEquals;
    
    public String currentNum = "";
    public Stack postFix = new Stack();
    public Stack operatorsStack = new Stack();
    public Stack resultStack = new Stack();
    
    public String infix = "";
    
    public Object processPostfix() {
        
        System.out.print("Postfix: ");
        for(Object i : postFix) {
            System.out.print(i + "  ");
        }
        System.out.println();
        
        for(Object i : postFix) {
            if(i instanceof String) {
                
                Double a = (Double) resultStack.pop();
                Double b = (Double) resultStack.pop();
                
                switch((char) ((String) i).charAt(0)) {
                    case('+'):
                        resultStack.push(a+b);
                        break;
                    case('-'):
                        resultStack.push(b-a);
                        break;
                    case('*'):
                        resultStack.push(a*b);
                        break;
                    case('/'):
                        resultStack.push(b/a);
                        break;
                }
            } else {
                resultStack.push(i);
            }
        }
        
        
        Object ans = resultStack.pop();
        System.out.println("Ans: " + ans);
        postFix = new Stack();
        currentNum = "";
        postFix.push(ans);
        return ans;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton1Action(MouseEvent event) {
        System.out.println("Pressed 1");
        currentNum += "1";
        infix += "1";
        infixField.setText(infix);
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton0Action(MouseEvent event) {
        System.out.println("Pressed 0");
        infix += "0";
        infixField.setText(infix);
        currentNum += "0";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButtonClearAction(MouseEvent event) {
        System.out.println("Pressed C");
        infix = "";
        infixField.setText(infix);
        currentNum = "";
        operatorsStack = new Stack();
        postFix = new Stack();
        resultStack = new Stack();
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButtonDivAction(MouseEvent event) {
        System.out.println("Pressed /");
        infix += "/";
        infixField.setText(infix);
        if(currentNum != "") { postFix.push(new Double(currentNum)); }
        while(! operatorsStack.isEmpty() && (operatorsStack.peek()=="*" || operatorsStack.peek()=="/")) {
            postFix.push(operatorsStack.pop());
            resultsField.setText(String.valueOf(processPostfix()));
        }
        operatorsStack.push("/");
        currentNum = "";
        //resultsField.setText(currentNum);
    }

    @FXML
    private void handleButtonMultAction(MouseEvent event) {
        System.out.println("Pressed *");
        infix += "*";
        infixField.setText(infix);
        if(currentNum != "") { postFix.push(new Double(currentNum)); }
        while(! operatorsStack.isEmpty() && (operatorsStack.peek()=="*" || operatorsStack.peek()=="/")) {
            postFix.push(operatorsStack.pop());
            resultsField.setText(String.valueOf(processPostfix()));
        }
        operatorsStack.push("*");
        currentNum = "";
    }

    @FXML
    private void handleButtonMinusAction(MouseEvent event) {
        System.out.println("Pressed -");
        infix += "-";
        infixField.setText(infix);
        if(currentNum != "") { postFix.push(new Double(currentNum)); }
        while(! operatorsStack.isEmpty()) {
            postFix.push(operatorsStack.pop());
            resultsField.setText(String.valueOf(processPostfix()));
        }
        operatorsStack.push("-");
        currentNum = "";
    }

    @FXML
    private void handleButton9Action(MouseEvent event) {
        System.out.println("Pressed 9");
        infix += "9";
        infixField.setText(infix);
        currentNum += "9";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton6Action(MouseEvent event) {
        System.out.println("Pressed 6");
        infix += "6";
        infixField.setText(infix);
        currentNum += "6";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton3Action(MouseEvent event) {
        System.out.println("Pressed 3");
        infix += "3";
        infixField.setText(infix);
        currentNum += "3";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton8Action(MouseEvent event) {
        System.out.println("Pressed 8");
        infix += "8";
        infixField.setText(infix);
        currentNum += "8";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton5Action(MouseEvent event) {
        System.out.println("Pressed 5");
        infix += "5";
        infixField.setText(infix);
        currentNum += "5";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton7Action(MouseEvent event) {
        System.out.println("Pressed 7");
        infix += "7";
        infixField.setText(infix);
        currentNum += "7";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton4Action(MouseEvent event) {
        System.out.println("Pressed 4");
        infix += "4";
        infixField.setText(infix);
        currentNum += "4";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButton2Action(MouseEvent event) {
        System.out.println("Pressed 2");
        infix += "2";
        infixField.setText(infix);
        currentNum += "2";
        resultsField.setText(currentNum);
    }

    @FXML
    private void handleButtonPlusAction(MouseEvent event) {
        System.out.println("Pressed +");
        infix += "+";
        infixField.setText(infix);
        if(currentNum != "") { postFix.push(new Double(currentNum)); }
        while(! operatorsStack.isEmpty()) {
            postFix.push(operatorsStack.pop());
            resultsField.setText(String.valueOf(processPostfix()));
        }
        operatorsStack.push("+");
        currentNum = "";
    }

    @FXML
    private void handleButtonEqualsAction(MouseEvent event) {
        System.out.println("Pressed =");
        infix = "";
        infixField.setText(infix);
        if(currentNum != "") { postFix.push(new Double(currentNum)); }
        while(! operatorsStack.isEmpty()) {
            postFix.push(operatorsStack.pop());
        }
        resultsField.setText(String.valueOf(processPostfix()));
    }
    
}
